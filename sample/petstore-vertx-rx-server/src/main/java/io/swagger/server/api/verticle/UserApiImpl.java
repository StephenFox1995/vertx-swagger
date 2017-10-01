package io.swagger.server.api.verticle;

import java.util.List;
import java.util.UUID;

import io.swagger.server.api.model.InlineResponseDefault;
import io.swagger.server.api.model.ModelUser;
import io.swagger.server.api.util.MainApiHeader;
import io.swagger.server.api.util.ResourceResponse;
import rx.Completable;
import rx.Single;

public class UserApiImpl implements UserApi {

    @Override
    public Single<ResourceResponse<Void>> createUser(ModelUser body) {
        ResourceResponse<Void> response = new ResourceResponse<>();
        response.addHeader(MainApiHeader.CONTENT_TYPE_JSON);
        return Single.just(response);
    }

    @Override
    public Single<ResourceResponse<Void>> createUsersWithArrayInput(List<ModelUser> body) {
        ResourceResponse<Void> response = new ResourceResponse<>();
        response.addHeader(MainApiHeader.CONTENT_TYPE_JSON);
        return Single.just(response);
    }

    @Override
    public Single<ResourceResponse<Void>> createUsersWithListInput(List<ModelUser> body) {
        ResourceResponse<Void> response = new ResourceResponse<>();
        response.addHeader(MainApiHeader.CONTENT_TYPE_JSON);
        return Single.just(response);
    }

    @Override
    public Single<ResourceResponse<Void>> deleteUser(String username) {
        ResourceResponse<Void> response = new ResourceResponse<>();
        response.addHeader(MainApiHeader.CONTENT_TYPE_JSON);
        return Single.just(response);
    }

    @Override
    public Single<ResourceResponse<ModelUser>> getUserByName(String username) {
        ResourceResponse<ModelUser> response = new ResourceResponse<>();
        response.addHeader(MainApiHeader.CONTENT_TYPE_JSON);
        response.setResponse(new ModelUser());
        return Single.just(response);
    }

    @Override
    public Single<ResourceResponse<String>> loginUser(String username, String password) {
        ResourceResponse<String> response = new ResourceResponse<>();
        response.addHeader(MainApiHeader.CONTENT_TYPE_JSON);
        response.setResponse("");
        return Single.just(response);
    }

    @Override
    public Single<ResourceResponse<Void>> logoutUser() {
        ResourceResponse<Void> response = new ResourceResponse<>();
        response.addHeader(MainApiHeader.CONTENT_TYPE_JSON);
        return Single.just(response);
    }

    @Override
    public Single<ResourceResponse<Void>> updateUser(String username, ModelUser body) {
        ResourceResponse<Void> response = new ResourceResponse<>();
        response.addHeader(MainApiHeader.CONTENT_TYPE_JSON);
        return Single.just(response);
    }

    @Override
    public Single<ResourceResponse<InlineResponseDefault>> uuid(UUID uuidParam) {
        ResourceResponse<InlineResponseDefault> response = new ResourceResponse<>();
        response.addHeader(UserApiHeader.CONTENT_TYPE_JSON);
        response.setResponse(new InlineResponseDefault(uuidParam));
        
        return Single.just(response);
    }

}
