package com.example.retrofitcallapi.uploadAPI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.retrofitcallapi.R;

public class MainUpLoad extends AppCompatActivity {

    private EditText txtUL_id, txtUL_noiDung, txtUL_ngayThang, txtUL_linkAnh;
    private Button btnUL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_up_load);

        txtUL_id = findViewById(R.id.txtUL_id);
        txtUL_ngayThang = findViewById(R.id.txtUL_ngayThang);
        txtUL_noiDung = findViewById(R.id.txtUL_noiDung);
        txtUL_linkAnh = findViewById(R.id.txtUL_linkAnh);
        btnUL = findViewById(R.id.btnUL);
    }
}