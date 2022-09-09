package com.example.retrofitcallapi.uploadAPI;

import com.example.retrofitcallapi.getAllAPI.ImagesResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    public static final String DOMAIN = "https://asmserverandroidminhdtph13562.herokuapp.com/api/";

    Gson gson = new GsonBuilder().setDateFormat("yyyy MM dd HH:mm:ss").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @Multipart
    @POST("imagees")
    Call<ImagesResponse> callImgRes(
//            @Part(Const.KEY_ID) RequestBody _id,
            @Part(Const.KEY_NGAYTHANG) RequestBody ngayThang,
            @Part(Const.KEY_NOIDUNG) RequestBody noiDung,
            @Part(Const.KEY_LINKANH) RequestBody linkAnh);

}
