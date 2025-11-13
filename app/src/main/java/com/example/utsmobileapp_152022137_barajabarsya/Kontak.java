package com.example.utsmobileapp_152022137_barajabarsya;

public class Kontak {
    private String nama;
    private String telepon;
    private int imageResource;

    public Kontak(String nama, String telepon, int imageResource) {
        this.nama = nama;
        this.telepon = telepon;
        this.imageResource = imageResource;
    }

    public String getNama() {
        return nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public int getImageResource() {
        return imageResource;
    }
}