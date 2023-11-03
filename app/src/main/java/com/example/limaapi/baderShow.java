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

public class baderShow extends AppCompatActivity {

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
                loadbaderData();
            }
        });
    }

    private void loadbaderData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.codespade.com:4517/codespade/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        baderService service = retrofit.create(baderService.class);
        Call<List<bader>> call = service.getbader();
        call.enqueue(new Callback<List<bader>>() {
            @Override
            public void onResponse(Call<List<bader>> call, Response<List<bader>> response) {
                if (response.isSuccessful()) {
                    List<bader> baderList = response.body();
                    adapter = new baderAdapter(baderList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(baderShow.this, "Gagal mengambil data Bahasa Daerah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<bader>> call, Throwable t) {
                Log.e("Retrofit Error", "Error: " + t.getMessage()); // Add this line for error logging
                Toast.makeText(baderShow.this, "Kesalahan jaringan", Toast.LENGTH_SHORT).show();
            }

        });
    }
}