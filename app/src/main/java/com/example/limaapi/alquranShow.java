package com.example.limaapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class alquranShow extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bader_show);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadalquranData();
            }
        });
    }


    private void loadalquranData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://al-quran-8d642.firebaseio.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        alquranService service = retrofit.create(alquranService.class);
        Call<List<alquran>> call = service.getalquran();
        call.enqueue(new Callback<List<alquran>>() {
            @Override
            public void onResponse(Call<List<alquran>> call, Response<List<alquran>>response) {
                if (response.isSuccessful()) {
                    List<alquran> alquranList = response.body();
                    adapter = new alquranAdapter(alquranList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(alquranShow.this, "Gagal mengambil data Ayat Al-Qur'an", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<alquran>> call, Throwable t) {
                Toast.makeText(alquranShow.this, "Kesalahan jaringan", Toast.LENGTH_SHORT).show();
            }
        });
    }

}