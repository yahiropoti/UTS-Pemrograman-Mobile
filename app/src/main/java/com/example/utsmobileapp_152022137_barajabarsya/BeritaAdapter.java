package com.example.utsmobileapp_152022137_barajabarsya;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {

    private List<Berita> beritaList;

    public BeritaAdapter(List<Berita> beritaList) {
        this.beritaList = beritaList;
    }

    @NonNull
    @Override
    public BeritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_berita, parent, false);
        return new BeritaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaViewHolder holder, int position) {
        Berita berita = beritaList.get(position);

        holder.textJudul.setText(berita.getJudul());
        holder.textTanggal.setText(berita.getTanggal());
        holder.textKategori.setText(berita.getKategori());
        holder.textRingkasan.setText(berita.getRingkasan());
        holder.imageBerita.setImageResource(berita.getImageResource());

        // Set waktu baca dan jumlah pembaca
        holder.textWaktuBaca.setText(berita.getWaktuBaca());
        holder.textJumlahPembaca.setText(berita.getJumlahPembaca());
    }

    @Override
    public int getItemCount() {
        return beritaList.size();
    }

    public static class BeritaViewHolder extends RecyclerView.ViewHolder {
        TextView textJudul, textTanggal, textKategori, textRingkasan, textWaktuBaca, textJumlahPembaca;
        ImageView imageBerita;

        public BeritaViewHolder(@NonNull View itemView) {
            super(itemView);

            textJudul = itemView.findViewById(R.id.textJudul);
            textTanggal = itemView.findViewById(R.id.textTanggal);
            textKategori = itemView.findViewById(R.id.textKategori);
            textRingkasan = itemView.findViewById(R.id.textRingkasan);
            imageBerita = itemView.findViewById(R.id.imageBerita);

            // Tambahkan ID untuk waktu baca dan jumlah pembaca di item_berita.xml
            textWaktuBaca = itemView.findViewById(R.id.textWaktuBaca);
            textJumlahPembaca = itemView.findViewById(R.id.textJumlahPembaca);
        }
    }
}