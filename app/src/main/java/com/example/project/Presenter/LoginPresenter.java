package com.example.project.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.project.connection.BaseApp;
import com.example.project.connection.Login.LoginBaseApp;
import com.example.project.model.login.getUser.GetUserResponse;
import com.example.project.model.login.login_user.LoginResponse;
import com.example.project.model.login.update_user.UpdateResponse;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
   // private Context context;
    private LoginMainView loginMainView;

    public LoginPresenter(LoginMainView loginMainView) {
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
        BaseApp.loginService.PostCreate(name,email, password).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful())
                    loginMainView.setToast(response.message());
                else
                    loginMainView.onError(response.message());
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                loginMainView.onFailure(t.getMessage());
            }
        });
    }
    public void updateUser(String token,String name) {
        BaseApp.loginService.UpdateAkun(token,name).enqueue(new Callback<UpdateResponse>() {
            @Override
            public void onResponse(Call<UpdateResponse> call, Response<UpdateResponse> response) {
                if (response.isSuccessful())
                    loginMainView.setToast(response.message());
                else
                    loginMainView.onError(response.message());
            }
            @Override
            public void onFailure(Call<UpdateResponse> call, Throwable t) {
                loginMainView.onFailure(t.getMessage());
            }
        });
    }
    public void getUsers(String token) {
        BaseApp.loginService.getUsers(token).enqueue(new Callback<List<GetUserResponse>>() {
            @Override
            public void onResponse(Call<List<GetUserResponse>> call, Response<List<GetUserResponse>> response2) {
                Log.d("isi12345", response2.body().toString());
                if (response2.isSuccessful())
                    loginMainView.getSuccess(response2.body());
                else
                    loginMainView.onError(response2.message());
            }
            @Override
            public void onFailure(Call<List<GetUserResponse>> call, Throwable t) {
                loginMainView.onFailure(t.getMessage());
                Log.d("isi12345", t.getMessage());
            }
        });
    }
}
