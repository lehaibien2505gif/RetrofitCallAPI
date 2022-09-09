package com.example.retrofitcallapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofitcallapi.getAllAPI.GlideApp;
import com.example.retrofitcallapi.getAllAPI.ImagesResponse;

public class ClickedItem extends AppCompatActivity {

    ImagesResponse imagesResponse;
    ImageView img_select;
    TextView tv_id_select, tv_ngayThang_select, tv_noiDung_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        img_select = findViewById(R.id.img_select);
        tv_id_select = findViewById(R.id.tv_id_select);
        tv_ngayThang_select = findViewById(R.id.tv_ngayThang_select);
        tv_noiDung_select = findViewById(R.id.tv_noiDung_select);


        Intent intent = getIntent();

//        day du lieu len view
        if (intent.getExtras() != null) {
            imagesResponse = (ImagesResponse) intent.getSerializableExtra("data");
            String message = "ID: " + imagesResponse.get_id();
            Log.e("data: ", message);

            tv_id_select.setText(imagesResponse.get_id());
            tv_ngayThang_select.setText(imagesResponse.getNgayThang());
            tv_noiDung_select.setText(imagesResponse.getNoiDung());

            GlideApp.with(this).load(imagesResponse.getLinkAnh()).into(img_select);

        }
    }
}