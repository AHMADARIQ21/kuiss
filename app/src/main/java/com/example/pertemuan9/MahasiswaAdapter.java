package com.example.pertemuan9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pertemuan9.R;
import com.example.pertemuan9.database.entitas.Mahasiswa;

import java.util.List;
import java.util.zip.Inflater;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
    private List<Mahasiswa> mahasiswaList;
    private Context context;

    public MahasiswaAdapter(List<Mahasiswa> mahasiswaList, Context context) {
        this.mahasiswaList = mahasiswaList;
        this.context = context;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        return new MahasiswaAdapter.MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.MahasiswaViewHolder holder, int position) {
        holder.tvNama.setText(mahasiswaList.get(position).fullName);
        holder.tvHP.setText(mahasiswaList.get(position).hp);
    }

    @Override
    public int getItemCount() {return mahasiswaList.size();}

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHP;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super((itemView));
            tvNama = itemView.findViewById(R.id.tvNama);
            tvHP = itemView.findViewById(R.id.tvHP);
        }
    }
}
