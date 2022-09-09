package com.example.retrofitcallapi.getAllAPI;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Interface {

    @GET("imagees/")
    Call<List<ImagesResponse>> getAllImages();

}
