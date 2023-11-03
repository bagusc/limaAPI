package com.example.limaapi;

import com.example.limaapi.kodePos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface kodePosService {
    @GET("kota_kab/k69.json")
    Call<List<kodePos>> getkodePos();
}
