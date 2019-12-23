package com.example.dogtionary.controller;

import com.example.dogtionary.model.Breeds;
import com.example.dogtionary.model.BreedsRandom;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogAPI {
    @GET("breeds/list")
    Call<Breeds> loadBreeds();

    @GET("breeds/image/random")
    Call<BreedsRandom> loadRandomImg();
}
