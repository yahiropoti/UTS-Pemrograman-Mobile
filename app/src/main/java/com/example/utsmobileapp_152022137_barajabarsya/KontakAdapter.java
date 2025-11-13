package com.example.utsmobileapp_152022137_barajabarsya;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.KontakViewHolder> {

    private List<Kontak> kontakList;

    public KontakAdapter(List<Kontak> kontakList) {
        this.kontakList = kontakList;
    }

    @NonNull
    @Override
    public KontakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kontak, parent, false);
        return new KontakViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KontakViewHolder holder, int position) {
        Kontak kontak = kontakList.get(position);
        holder.textNama.setText(kontak.getNama());
        holder.textTelepon.setText(kontak.getTelepon());
        holder.imageKontak.setImageResource(kontak.getImageResource());
    }

    @Override
    public int getItemCount() {
        return kontakList.size();
    }

    public static class KontakViewHolder extends RecyclerView.ViewHolder {
        ImageView imageKontak;
        TextView textNama, textTelepon;

        public KontakViewHolder(@NonNull View itemView) {
            super(itemView);
            imageKontak = itemView.findViewById(R.id.imageKontak);
            textNama = itemView.findViewById(R.id.textNama);
            textTelepon = itemView.findViewById(R.id.textTelepon);
        }
    }
}