package com.example.retrofitcallapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitcallapi.getAllAPI.ApiClient;
import com.example.retrofitcallapi.getAllAPI.CustomAdapter;
import com.example.retrofitcallapi.getAllAPI.ImagesResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<ImagesResponse> imagesResponseList = new ArrayList<>();
    private CustomAdapter customAdapter;

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        getAllImages();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this, ClickedItem.class).putExtra("data", imagesResponseList.get(i)));
            }
        });
    }

    public void getAllImages() {

        Call<List<ImagesResponse>> imagesRespone = ApiClient.getInterface().getAllImages();
        imagesRespone.enqueue(new Callback<List<ImagesResponse>>() {
            @Override
            public void onResponse(Call<List<ImagesResponse>> call, Response<List<ImagesResponse>> response) {

                if (response.isSuccessful()) {

                    String message = " Request successful !";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                    imagesResponseList = response.body();
                    customAdapter = new CustomAdapter(imagesResponseList, MainActivity.this);

                    gridView.setAdapter(customAdapter);


                } else {
                    String message = " An error occurred, try again later !";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ImagesResponse>> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

}