package com.example.android_practice.services.repository;

import com.example.android_practice.services.model.responseBody.LoginResponse;

public interface ILoginResponse {
    void onResponse(LoginResponse loginResponse);
    void onFailure(Throwable t);
}
