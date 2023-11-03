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

public class kodePosShow extends AppCompatActivity {

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
                loadkodePosData();
            }
        });
    }

    private void loadkodePosData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kodePos-2d475.firebaseio.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        kodePosService service = retrofit.create(kodePosService.class);
        Call<List<kodePos>> call = service.getkodePos();
        call.enqueue(new Callback<List<kodePos>>() {
            @Override
            public void onResponse(Call<List<kodePos>>call, Response<List<kodePos> >response) {
                if (response.isSuccessful()) {
                    List<kodePos> kodePosList = response.body();
                    adapter = new kodePosAdapter(kodePosList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(kodePosShow.this, "Gagal mengambil data Kode Pos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<kodePos>> call, Throwable t) {
                Toast.makeText(kodePosShow.this, "Kesalahan jaringan", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    
}