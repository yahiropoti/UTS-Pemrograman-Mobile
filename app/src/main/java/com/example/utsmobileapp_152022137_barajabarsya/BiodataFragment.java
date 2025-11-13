package com.example.utsmobileapp_152022137_barajabarsya;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BiodataFragment extends Fragment {

    private EditText editNama, editNim, editTanggalLahir;
    private RadioGroup radioGender;
    private Spinner spinnerProdi;
    private Button btnSimpan;

    // Untuk menampilkan hasil
    private LinearLayout layoutHasil;
    private TextView tvHasilNama, tvHasilNIM, tvHasilGender, tvHasilProdi, tvHasilTanggalLahir;

    private Calendar calendar;
    private SimpleDateFormat dateFormatter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biodata, container, false);

        initViews(view);
        setupSpinner();
        setupDatePicker();
        setupButtonListeners();

        return view;
    }

    private void initViews(View view) {
        editNama = view.findViewById(R.id.editNama);
        editNim = view.findViewById(R.id.editNim);
        editTanggalLahir = view.findViewById(R.id.editTanggalLahir);
        radioGender = view.findViewById(R.id.radioGender);
        spinnerProdi = view.findViewById(R.id.spinnerProdi);
        btnSimpan = view.findViewById(R.id.btnSimpan);

        // Hasil biodata
        layoutHasil = view.findViewById(R.id.layoutHasil);
        tvHasilNama = view.findViewById(R.id.tvHasilNama);
        tvHasilNIM = view.findViewById(R.id.tvHasilNIM);
        tvHasilGender = view.findViewById(R.id.tvHasilGender);
        tvHasilProdi = view.findViewById(R.id.tvHasilProdi);
        tvHasilTanggalLahir = view.findViewById(R.id.tvHasilTanggalLahir);

        calendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    }

    private void setupSpinner() {
        // DATA PRODI ITENAS YANG ASLI
        String[] prodiList = {
                "Pilih Program Studi",
                "Informatika (S1)",
                "Sistem Informasi (S1)",
                "Teknik Elektro (S1)",
                "Teknik Mesin (S1)",
                "Teknik Industri (S1)",
                "Teknik Kimia (S1)",
                "Teknik Sipil (S1)",
                "Desain Komunikasi Visual (S1)",
                "Teknik Lingkungan (S1)",
                "Teknik Sipil (S1)",
                "Teknik Geodesi (S1)"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                prodiList
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProdi.setAdapter(adapter);
    }

    private void setupDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateLabel();
            }
        };

        editTanggalLahir.setOnClickListener(v -> {
            new DatePickerDialog(
                    getContext(),
                    dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            ).show();
        });
    }

    private void updateDateLabel() {
        editTanggalLahir.setText(dateFormatter.format(calendar.getTime()));
    }

    private void setupButtonListeners() {
        btnSimpan.setOnClickListener(v -> simpanBiodata());
    }

    private void simpanBiodata() {
        String nama = editNama.getText().toString().trim();
        String nim = editNim.getText().toString().trim();
        String tanggalLahir = editTanggalLahir.getText().toString().trim();

        // Validasi input
        if (nama.isEmpty()) {
            Toast.makeText(getContext(), "Nama harus diisi!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (nim.isEmpty()) {
            Toast.makeText(getContext(), "NIM harus diisi!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get selected gender
        String gender = "";
        int selectedGenderId = radioGender.getCheckedRadioButtonId();
        if (selectedGenderId != -1) {
            RadioButton selectedGender = getView().findViewById(selectedGenderId);
            gender = selectedGender.getText().toString();
        } else {
            Toast.makeText(getContext(), "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get selected program studi
        String prodi = spinnerProdi.getSelectedItem().toString();
        if (prodi.equals("Pilih Program Studi")) {
            Toast.makeText(getContext(), "Pilih program studi!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (tanggalLahir.isEmpty()) {
            Toast.makeText(getContext(), "Pilih tanggal lahir!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tampilkan hasil
        tampilkanHasilBiodata(nama, nim, gender, prodi, tanggalLahir);

        Toast.makeText(getContext(), "Biodata berhasil disimpan!", Toast.LENGTH_SHORT).show();
    }

    private void tampilkanHasilBiodata(String nama, String nim, String gender, String prodi, String tanggalLahir) {
        tvHasilNama.setText("Nama: " + nama);
        tvHasilNIM.setText("NIM: " + nim);
        tvHasilGender.setText("Jenis Kelamin: " + gender);
        tvHasilProdi.setText("Program Studi: " + prodi);
        tvHasilTanggalLahir.setText("Tanggal Lahir: " + tanggalLahir);

        // Tampilkan layout hasil
        layoutHasil.setVisibility(View.VISIBLE);
    }
}