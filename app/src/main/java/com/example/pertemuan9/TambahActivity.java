package com.example.pertemuan9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pertemuan9.database.AppDatabase;
import com.example.pertemuan9.database.entitas.Mahasiswa;

public class TambahActivity extends AppCompatActivity {

    EditText etNama, etHP;
    Button btnSimpan;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.etNama);
        etHP = findViewById(R.id.etHP);
        btnSimpan = findViewById(R.id.btnSimpan);
        database = AppDatabase.getInstance(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.fullName = etNama.getText().toString();
                mahasiswa.hp = etHP.getText().toString();
                database.mahasiswaDao().insertAll(mahasiswa);
                finish();
            }
        });

    }
}