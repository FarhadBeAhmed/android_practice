package com.example.android_practice.viewModel;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android_practice.services.repository.ILoginResponse;
import com.example.android_practice.services.repository.LoginRepo;
import com.example.android_practice.services.model.requestBody.LoginRequestBody;
import com.example.android_practice.services.model.responseBody.LoginResponse;

public class LoginViewModel extends ViewModel {
    MutableLiveData<Integer>mProgressbarLiveData=new MutableLiveData<>();
    MutableLiveData<String>mLoginLiveData=new MutableLiveData<>();

    LoginRepo loginRepo;

    public LoginViewModel() {
        mLoginLiveData.postValue("not Logged in");
        mProgressbarLiveData.postValue(View.INVISIBLE);
        loginRepo=new LoginRepo();
    }
    public void login(String username,String pass){
        mProgressbarLiveData.postValue(View.VISIBLE);
        mLoginLiveData.postValue("Checking..");
        loginRepo.loginRemote(new LoginRequestBody(username, pass), new ILoginResponse() {
            @Override
            public void onResponse(LoginResponse loginResponse) {
                mProgressbarLiveData.postValue(View.INVISIBLE);
                mLoginLiveData.postValue(loginResponse.getMsg());
            }

            @Override
            public void onFailure(Throwable t) {
                mProgressbarLiveData.postValue(View.INVISIBLE);
                mLoginLiveData.postValue("Login Failed due to "+t.getLocalizedMessage());

            }
        });
    }

    public LiveData<Integer>getProgress(){
        return mProgressbarLiveData;
    }
    public LiveData<String>getLogin(){
        return mLoginLiveData;
    }

}
