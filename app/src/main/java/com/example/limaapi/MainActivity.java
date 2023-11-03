package com.example.limaapi;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, baderShow.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, beritaIndo.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, kodePosShow.class);
                startActivity(intent);
            }
        });
//
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, doaShow.class);
                startActivity(intent);
            }
        });
//
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, alquranShow.class);
                startActivity(intent);
            }
        });
    }


//    private void loadBeritaIndonesiaData() {
//        // Buat instance Retrofit
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api-berita-indonesia.vercel.app/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        BeritaIndonesiaService service = retrofit.create(BeritaIndonesiaService.class);
//
////        // Mengambil data dari API
//        Call<BeritaIndonesiaResponse> call = service.getBeritaIndonesia();
//        call.enqueue(new Callback<BeritaIndonesiaResponse>() {
//            @Override
//            public void onResponse(Call<BeritaIndonesiaResponse> call, Response<BeritaIndonesiaResponse> response) {
//                if (response.isSuccessful()) {
//                    BeritaIndonesiaResponse beritaResponse = response.body();
//                    List<Post> posts = beritaResponse.getData().getPosts();
//                    adapter.setHasStableIds(posts);
//
//                } else {
//                    Toast.makeText(MainActivity.this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
//                }
//            }

//            @Override
//            public void onFailure(Call<BeritaIndonesiaResponse> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//


}
