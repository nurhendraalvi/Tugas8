package com.example.project.Presenter;

import android.content.Context;

import com.example.project.connection.BaseApp;
import com.example.project.model.InstitutionResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private Context context;
    private MainView mainView;

    public MainPresenter(Context context, MainView mainView) {
        this.context = context;
        this.mainView = mainView;
    }
    public void loadInstitusi(String source){
        BaseApp.service.getInstitusi(source).enqueue(new Callback<InstitutionResponse>() {
            @Override
            public void onResponse(Call<InstitutionResponse> call, Response<InstitutionResponse> response) {
                if (response.isSuccessful()){
                    mainView.onSucces(response.body().getInstansi());
                } else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<InstitutionResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }
}
