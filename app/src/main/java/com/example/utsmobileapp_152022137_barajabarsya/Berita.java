package com.example.utsmobileapp_152022137_barajabarsya;

public class Berita {
    private String judul;
    private String tanggal;
    private String kategori;
    private String ringkasan;
    private int imageResource;
    private String waktuBaca;
    private String jumlahPembaca;

    public Berita(String judul, String tanggal, String kategori, String ringkasan,
                  int imageResource, String waktuBaca, String jumlahPembaca) {
        this.judul = judul;
        this.tanggal = tanggal;
        this.kategori = kategori;
        this.ringkasan = ringkasan;
        this.imageResource = imageResource;
        this.waktuBaca = waktuBaca;
        this.jumlahPembaca = jumlahPembaca;
    }

    public String getJudul() { return judul; }
    public String getTanggal() { return tanggal; }
    public String getKategori() { return kategori; }
    public String getRingkasan() { return ringkasan; }
    public int getImageResource() { return imageResource; }
    public String getWaktuBaca() { return waktuBaca; }
    public String getJumlahPembaca() { return jumlahPembaca; }
}