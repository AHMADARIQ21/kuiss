package com.example.pertemuan9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pertemuan9.MahasiswaAdapter;
import com.example.pertemuan9.database.AppDatabase;

public class HomeActivity extends AppCompatActivity {

    Button btnLogout;
    RecyclerView rvMahasiswa;
    Button btnTambah;
    AppDatabase database;
    MahasiswaAdapter mahasiswaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        rvMahasiswa = findViewById(R.id.rvMahasiswa);
        btnTambah = findViewById(R.id.btnTambah);
        database = AppDatabase.getInstance(getApplicationContext());
        mahasiswaAdapter = new MahasiswaAdapter(database.mahasiswaDao().getAll(), getApplicationContext());

        rvMahasiswa.setHasFixedSize(true);
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));
        rvMahasiswa.setAdapter(mahasiswaAdapter);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, TambahActivity.class);
                startActivity(i);
            }
        });


        final SharedPrefManager sharedPrefManager = new SharedPrefManager(this);

        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                sharedPrefManager.saveIsLogin(false);
                finishAffinity();
                startActivity(i);
            }
        });
    }
}