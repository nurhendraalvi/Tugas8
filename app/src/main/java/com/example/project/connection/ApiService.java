package com.example.project.connection;

import com.example.project.model.InstitutionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/api/instansi/semuainstansi")
    Call<InstitutionResponse> getInstitusi();
}
