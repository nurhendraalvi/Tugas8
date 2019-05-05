package com.example.project.Presenter;

import com.example.project.connection.Login.LoginBaseApp;
import com.example.project.model.login.getUser.GetUserResponse;
import com.example.project.model.login.login_user.LoginResponse;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private LoginMainView loginMainView;

    public LoginPresenter(LoginMainView loginMainView) {
        this.loginMainView = loginMainView;
    }

    public void login(String email, String password) {
        LoginBaseApp.service.PostUserResponse(email, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response2) {
                if (response2.isSuccessful())
                    loginMainView.getSuccess2(response2.body());
                else
                    loginMainView.onError(response2.message());
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginMainView.onFailure(t.getMessage());
            }
        });
    }
    public void createAccount(String name, String email, String password) {
        LoginBaseApp.service.PostCreate(name,email, password).enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if (response.isSuccessful())
                    loginMainView.setToast(response.message());
                else
                    loginMainView.onError(response.message());
            }
            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                loginMainView.onFailure(t.getMessage());
            }
        });
    }
    /*public void updateItems(String id, String name, String description) {
        LoginBaseApp.service.updateDataItems(id,name,description).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful())
                    mainView.setToast(response.message());
                else
                    mainView.onError(response.message());
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }*/

}
