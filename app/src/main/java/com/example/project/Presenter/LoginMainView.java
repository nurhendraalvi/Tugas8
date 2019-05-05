package com.example.project.Presenter;

import com.example.project.model.login.getAll.GetAllUserResponse;
import com.example.project.model.login.getUser.GetUserResponse;
import com.example.project.model.login.login_user.LoginResponse;

public interface LoginMainView {
    void getSuccess(GetAllUserResponse list);
    void setToast(String message);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
    void getSuccess2(LoginResponse listItem);
}
