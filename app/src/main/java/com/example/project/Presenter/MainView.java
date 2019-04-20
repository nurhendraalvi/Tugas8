package com.example.project.Presenter;

import com.example.project.model.InstansiItem;

import java.util.List;

public interface MainView {
    void onSucces(List<InstansiItem> instansiItems);

    void onError(String errorMessage);

    void onFailure(String failureMessage);
}
