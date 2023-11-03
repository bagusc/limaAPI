package com.example.limaapi;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class beritaIndo extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvLink;
    private TextView tvImage;
    private LinearLayout postLayout; // Tambahkan layout untuk menampilkan data post

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_indo);

//        tvTitle = findViewById(R.id.tvTitle);
//        tvDescription = findViewById(R.id.tvDescription);
//        tvLink = findViewById(R.id.tvLink);
//        tvImage = findViewById(R.id.tvImage);
        postLayout = findViewById(R.id.postLayout); // Inisialisasi layout untuk menampilkan data post

        // Panggil metode untuk mengambil data dari API
        Button button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ambilDataDariAPI();
            }
        });
    }

    private void ambilDataDariAPI() {
        // Buat instance RequestQueue menggunakan Volley
        RequestQueue queue = Volley.newRequestQueue(this);

        // URL API yang akan diambil datanya
        String url = "https://api-berita-indonesia.vercel.app/cnn/terbaru";

        // Buat permintaan GET JSON menggunakan JsonObjectRequest
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Tangani respons JSON di sini
                        try {
                            // Misalnya, Anda dapat mengambil data dari respons JSON
                            JSONObject data = response.getJSONObject("data");
//                            String title = data.getString("title");
//                            String description = data.getString("description");
//                            String link = data.getString("link");
//                            // Tampilkan data di TextView
//                            tvTitle.setText("Judul: " + title);
//                            tvDescription.setText("Deskripsi: " + description);
//                            tvLink.setText("Link: " + link);

                            // Mengambil array "posts" dari objek "data"
                            JSONArray postsArray = data.getJSONArray("posts");
                            for (int i = 0; i < postsArray.length(); i++) {
                                JSONObject post = postsArray.getJSONObject(i);
                                String postTitle = post.getString("title");
//                                String postPubDate = post.getString("pubDate");
                                String postDescription = post.getString("description");

                                // Buat TextView baru untuk menampilkan data post
                                TextView tvPostTitle = new TextView(beritaIndo.this);
//                                TextView tvPostPubDate = new TextView(berita.this);
                                TextView tvPostDescription = new TextView(beritaIndo.this);

                                // Atur teks untuk TextView data post
                                tvPostTitle.setText(postTitle);
                                // Atur jenis huruf bold
                                tvPostTitle.setTypeface(null, Typeface.BOLD);

//                                tvPostPubDate.setText("Tanggal Publikasi: " + postPubDate);
                                tvPostDescription.setText(postDescription);

                                // Tambahkan TextView ke layout postLayout
                                TextView newLine = new TextView(beritaIndo.this);
                                newLine.setText("\n");
                                postLayout.addView(tvPostTitle);
//                                postLayout.addView(tvPostPubDate);
                                postLayout.addView(tvPostDescription);
                                postLayout.addView(newLine);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Tangani kesalahan di sini
                        Toast.makeText(beritaIndo.this, "Kesalahan jaringan", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // Tambahkan permintaan ke antrian
        queue.add(jsonObjectRequest);
    }
}
