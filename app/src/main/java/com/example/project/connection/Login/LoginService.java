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
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LoginService {
    @FormUrlEncoded
    @POST("/users/login")
    Call<LoginResponse> PostUserResponse(@Field("email") String email,
                                         @Field("password") String password);
    @FormUrlEncoded
    @POST("/user")
    Call<JSONObject> PostCreate(@Field("name") String name,
                               @Field("email") String email,
                               @Field("password") String password);
    @GET("/users")
    Call<GetUserResponse> getUsers(@Path("name") String name);

    @FormUrlEncoded
    @PUT("/users/{user}")
   Call<UpdateResponse> UpdateAkun(@Path("name") String name);

}
