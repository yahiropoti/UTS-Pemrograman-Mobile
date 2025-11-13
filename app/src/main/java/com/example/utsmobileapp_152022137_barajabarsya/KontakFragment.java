package com.example.utsmobileapp_152022137_barajabarsya;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class KontakFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewKontak);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // DATA KONTAK STATIS (15 KONTAK)
        List<Kontak> kontakList = new ArrayList<>();
        kontakList.add(new Kontak("Ahmad Santoso", "0812-3456-7890", R.drawable.default_avatar));
        kontakList.add(new Kontak("Budi Prasetyo", "0812-3456-7891", R.drawable.default_avatar));
        kontakList.add(new Kontak("Citra Lestari", "0812-3456-7892", R.drawable.default_avatar));
        kontakList.add(new Kontak("Dewi Anggraini", "0812-3456-7893", R.drawable.default_avatar));
        kontakList.add(new Kontak("Eko Wijaya", "0812-3456-7894", R.drawable.default_avatar));
        kontakList.add(new Kontak("Fajar Nugroho", "0812-3456-7895", R.drawable.default_avatar));
        kontakList.add(new Kontak("Gita Maharani", "0812-3456-7896", R.drawable.default_avatar));
        kontakList.add(new Kontak("Hendra Setiawan", "0812-3456-7897", R.drawable.default_avatar));
        kontakList.add(new Kontak("Indah Permata", "0812-3456-7898", R.drawable.default_avatar));
        kontakList.add(new Kontak("Joko Susilo", "0812-3456-7899", R.drawable.default_avatar));
        kontakList.add(new Kontak("Kartika Sari", "0812-3456-7800", R.drawable.default_avatar));
        kontakList.add(new Kontak("Lukman Hakim", "0812-3456-7801", R.drawable.default_avatar));
        kontakList.add(new Kontak("Maya Puspita", "0812-3456-7802", R.drawable.default_avatar));
        kontakList.add(new Kontak("Nina Wulandari", "0812-3456-7803", R.drawable.default_avatar));
        kontakList.add(new Kontak("Oki Pratama", "0812-3456-7804", R.drawable.default_avatar));

        // Setup adapter
        KontakAdapter adapter = new KontakAdapter(kontakList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}