package com.example.pertemuan9.database.entitas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mahasiswa {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String hp;

    @ColumnInfo(name = "full_name")
    public String fullName;
}
