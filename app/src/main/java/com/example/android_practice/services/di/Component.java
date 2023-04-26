package com.example.android_practice.services.di;

import com.example.android_practice.services.network.RetrofitClientInstance;

import javax.inject.Singleton;


@Singleton
@dagger.Component(modules = {RetrofitClientInstance.class})
public interface Component {

    public void inject(RetrofitClientInstance retrofitClientInstance);
}
