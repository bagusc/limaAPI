package com.example.limaapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface doaService {
    @GET("api/")
    Call<List<doa>> getdoadoa();
}
