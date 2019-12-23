package com.example.dogtionary.controller;

import com.example.dogtionary.view.DogRandomFragment;
import com.example.dogtionary.model.BreedsRandom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreedsRandomController {

    private DogAPI dogAPI;
    private DogRandomFragment view;

    public BreedsRandomController(DogRandomFragment view, DogAPI dogAPI) {
        this.view = view;
        this.dogAPI = dogAPI;
    }

    //Callback for random picture
    public void getRandom() {
        Call<BreedsRandom> call = dogAPI.loadRandomImg();
        call.enqueue(
                new Callback<BreedsRandom>() {
                    @Override
                    public void onResponse(Call<BreedsRandom> call, Response<BreedsRandom> response) {
                        if(response.isSuccessful()) {
                            BreedsRandom responseAPI = response.body();
                            view.showRandomPicture(responseAPI.getMessage());
                        } else {
                            System.out.println(response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<BreedsRandom> call, Throwable t) {
                        t.printStackTrace();
                    }
                }
        );
    }
}
