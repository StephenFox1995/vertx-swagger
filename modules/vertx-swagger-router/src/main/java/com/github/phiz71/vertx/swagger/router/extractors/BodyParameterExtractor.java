package com.github.phiz71.vertx.swagger.router.extractors;

import io.swagger.models.ArrayModel;
import io.swagger.models.Model;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.parameters.Parameter;
import io.swagger.models.properties.Property;
import io.vertx.core.json.DecodeException;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class BodyParameterExtractor implements ParameterExtractor {
    @Override
    public Object extract(String name, Parameter parameter, RoutingContext context) {
        BodyParameter bodyParam = (BodyParameter) parameter;
        if ("".equals(context.getBodyAsString())) {
            if (bodyParam.getRequired())
                throw new IllegalArgumentException("Missing required parameter: " + name);
            else
                return null;
        }

        try {
            if (bodyParam.getSchema() instanceof ArrayModel) {
                return context.getBodyAsJsonArray();
            } else {
                // Go check that for all properties of this parameter find
                // which ones are required and see if their missing.
                final JsonObject jsonObject = context.getBodyAsJson();
                final Model model = bodyParam.getSchema();
                if (model != null && model.getProperties() != null) {
                    for (String propertyName : model.getProperties().keySet()) {
                        final Property property = model.getProperties().get(propertyName);
                        if (property.getRequired() && !jsonObject.containsKey(propertyName)) {
                            throw new IllegalArgumentException("Missing property: " + propertyName + " for parameter: " + name);
                        }
                    }
                }
                return context.getBodyAsJson();
            }
        } catch (DecodeException e) {
            return context.getBodyAsString();
        }
    }
}
