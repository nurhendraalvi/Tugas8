package com.example.project.Presenter;

import android.content.Context;

import com.example.project.connection.BaseApp;
import com.example.project.connection.Login.LoginBaseApp;
import com.example.project.model.login.login_user.LoginResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private Context context;
    private LoginMainView loginMainView;

    public LoginPresenter(Context context, LoginMainView loginMainView) {
        this.context = context;
        this.loginMainView = loginMainView;
    }

    public void login(String user, String pass) {
        BaseApp.loginService.PostUserResponse(user, pass).enqueue(new Callback<LoginResponse>() {
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
        BaseApp.loginService.PostCreate(name,email, password).enqueue(new Callback<JSONObject>() {
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
