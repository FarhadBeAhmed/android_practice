package com.example.android_practice.services.repository;

import com.example.android_practice.services.model.requestBody.LoginRequestBody;
import com.example.android_practice.services.model.responseBody.LoginResponse;
import com.example.android_practice.services.network.ApiService;
import com.example.android_practice.services.network.RetrofitClientInstance;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {

    @Inject
    ApiService apiService;

    public void loginRemote(LoginRequestBody loginRequestBody, ILoginResponse iLoginResponse){
         apiService= RetrofitClientInstance.getRetroInstance().create(ApiService.class);
        Call<LoginResponse> initiateLogin=apiService.login(loginRequestBody);
        initiateLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    iLoginResponse.onResponse(response.body());
                }else{
                    iLoginResponse.onFailure(new Throwable(response.message()));

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                iLoginResponse.onFailure(t);
            }
        });

    }
}
