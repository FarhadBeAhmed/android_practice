package com.example.android_practice.services.network;

import com.example.android_practice.services.model.requestBody.LoginRequestBody;
import com.example.android_practice.services.model.responseBody.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("app/login_chk.php")
    Call<LoginResponse>login(@Body LoginRequestBody loginRequestBody);
}
