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

public class BeritaFragment extends Fragment {

    private RecyclerView recyclerView;
    private BeritaAdapter adapter;
    private List<Berita> beritaList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_berita, container, false);

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewBerita);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Data berita statis (5 berita seru)
        beritaList = new ArrayList<>();
        tambahDataBerita();

        // Setup adapter
        adapter = new BeritaAdapter(beritaList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void tambahDataBerita() {
        // 5 data berita statis yang seru
        beritaList.add(new Berita(
                "EVOS Legends Juara MPL ID Season 12!",
                "14 Nov 2024",
                "Esport",
                "EVOS Legends berhasil menjadi juara MPL ID Season 12 setelah mengalahkan RRQ Hoshi dengan skrip 4-3 di final yang sangat menegangkan...",
                R.drawable.default_news,
                "📖 3 min read",
                "👁️ 15.2k"
        ));

        beritaList.add(new Berita(
                "Valorant Champions Tour 2024 Dimulai",
                "13 Nov 2024",
                "Esport",
                "Turnamen Valorant Champions Tour 2024 resmi dimulai dengan 16 tim terbaik dunia. Team Secret jadi wakil Indonesia di grup death...",
                R.drawable.default_news,
                "📖 4 min read",
                "👁️ 8.7k"
        ));

        beritaList.add(new Berita(
                "Ferrari SF-24 Dominasi F1 Opening Race",
                "12 Nov 2024",
                "Olahraga",
                "Ferrari memulai musim F1 2024 dengan gemilang. Charles Leclerc finish pertama di Bahrain GP, mengalahkan Red Bull dan Mercedes...",
                R.drawable.default_news,
                "📖 5 min read",
                "👁️ 12.5k"
        ));

        beritaList.add(new Berita(
                "Teknologi AI Ubah Game Mobile Masa Depan",
                "11 Nov 2024",
                "Teknologi",
                "Pengembang game mulai integrasikan AI untuk NPC yang lebih realistis. Mobile Legends dan Free Fire akan gunakan teknologi ini di update berikutnya...",
                R.drawable.default_news,
                "📖 6 min read",
                "👁️ 9.8k"
        ));

        beritaList.add(new Berita(
                "Free Fire World Series 2024 di Brasil",
                "10 Nov 2024",
                "Esport",
                "Turnamen Free Fire World Series 2024 akan digelar di Rio de Janeiro, Brasil. Tim Indonesia siap rebut gelar juara dunia...",
                R.drawable.default_news,
                "📖 4 min read",
                "👁️ 7.3k"
        ));

        beritaList.add(new Berita(
                "Lamborghini Revuelto: Hypercar Hybrid Terbaru",
                "9 Nov 2024",
                "Otomotif",
                "Lamborghini meluncurkan Revuelto, hypercar hybrid dengan tenaga 1.001 HP. Mobil ini gabungkan mesin V12 dengan tiga motor listrik...",
                R.drawable.default_news,
                "📖 5 min read",
                "👁️ 11.4k"
        ));

        beritaList.add(new Berita(
                "MLBB Rilis Hero Baru 'Ling' yang OP",
                "8 Nov 2024",
                "Game",
                "Mobile Legends rilis hero assassin baru 'Ling' dengan kemampuan wall-jump yang membuatnya sangat mobile di map. Player pro bilang ini hero ter-OP...",
                R.drawable.default_news,
                "📖 3 min read",
                "👁️ 20.1k"
        ));

        beritaList.add(new Berita(
                "Esports Akan Masuk Olimpiade 2028",
                "7 Nov 2024",
                "Esport",
                "Komite Olimpiade Internasional resmi akui esports sebagai cabang olahraga. Valorant dan Mobile Legends jadi game yang dipertandingkan...",
                R.drawable.default_news,
                "📖 4 min read",
                "👁️ 18.6k"
        ));

        beritaList.add(new Berita(
                "Porsche 911 GT3 RS Track Monster",
                "6 Nov 2024",
                "Otomotif",
                "Porsche 911 GT3 RS edisi khusus dirilis untuk track enthusiast. Dengan aerodynamics ekstrem dan mesin 4.0L flat-six yang menyemburkan 525 HP...",
                R.drawable.default_news,
                "📖 5 min read",
                "👁️ 9.2k"
        ));

        beritaList.add(new Berita(
                "Turnamen PUBG Mobile Nasional 2024",
                "5 Nov 2024",
                "Esport",
                "Turnamen PUBG Mobile Nasional 2024 akan digelar di Jakarta dengan total hadiah 2 Milyar Rupiah. 32 tim terbaik Indonesia akan bertanding...",
                R.drawable.default_news,
                "📖 3 min read",
                "👁️ 13.7k"
        ));
    }
}