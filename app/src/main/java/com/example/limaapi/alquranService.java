package com.example.limaapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface alquranService {
    @GET("data.json")
    Call<List<alquran>> getalquran();
}
