package com.example.limaapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface baderService {
    @GET("bahasa-daerah")
    Call<List<bader>> getbader();
}

