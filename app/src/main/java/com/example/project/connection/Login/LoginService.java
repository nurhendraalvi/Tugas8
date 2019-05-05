package com.example.project.connection.Login;

import com.example.project.model.InstitutionResponse;
import com.example.project.model.login.getUser.GetUserResponse;
import com.example.project.model.login.login_user.LoginResponse;
import com.example.project.model.login.update_user.UpdateResponse;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LoginService {
    @POST("/users/login")
    Call<LoginResponse> PostUserResponse(@Field("email") String email,
                                         @Field("password")  String password);
    @POST("/user")
    Call<JSONObject> PostCreate(@Field("name") String name,
                               @Field("email") String email,
                               @Field("password") String password);
    @GET("/users/")
    Call<GetUserResponse> getUsers(@Path("id") String id);

    @PUT("/users/{id}")
    Call<UpdateResponse> UpdateAkun(@Path("id") String id);

}
