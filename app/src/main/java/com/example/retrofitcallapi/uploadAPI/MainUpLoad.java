package com.example.retrofitcallapi.uploadAPI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitcallapi.R;
import com.example.retrofitcallapi.getAllAPI.ImagesResponse;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainUpLoad extends AppCompatActivity {

    private EditText txtUL_id, txtUL_noiDung, txtUL_ngayThang, txtUL_linkAnh;
    private Button btnUL;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_up_load);

        txtUL_id = findViewById(R.id.txtUL_id);
        txtUL_ngayThang = findViewById(R.id.txtUL_ngayThang);
        txtUL_noiDung = findViewById(R.id.txtUL_noiDung);
        txtUL_linkAnh = findViewById(R.id.txtUL_linkAnh);
        btnUL = findViewById(R.id.btnUL);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wai ...");

        btnUL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upLoadAlbum();
            }
        });
    }

    private void upLoadAlbum() {

        progressDialog.show();

        String strnoiDung = txtUL_noiDung.getText().toString().trim();
        String strngayThang = txtUL_ngayThang.getText().toString().trim();
        String strlinkAnh = txtUL_linkAnh.getText().toString().trim();

        RequestBody requestBody_ngayThang = RequestBody.create(MediaType.parse("multipart/form-data"), strngayThang);
        RequestBody requestBody_noiDung = RequestBody.create(MediaType.parse("multipart/form-data"), strnoiDung);
        RequestBody requestBody_linkAnh = RequestBody.create(MediaType.parse("multipart/form-data"), strlinkAnh);

        ApiService.apiService.callImgRes(requestBody_ngayThang, requestBody_noiDung, requestBody_linkAnh).enqueue(new Callback<ImagesResponse>() {
            @Override
            public void onResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
                progressDialog.dismiss();
                Toast.makeText(MainUpLoad.this, "Call API Successful !", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ImagesResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainUpLoad.this, "Call API Fail", Toast.LENGTH_SHORT).show();
            }
        });

    }
}