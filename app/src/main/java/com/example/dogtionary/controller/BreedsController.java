package com.example.dogtionary.controller;

import android.support.v7.app.AppCompatActivity;

import com.example.dogtionary.view.DogBreedsFragment;
import com.example.dogtionary.model.Breeds;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreedsController extends AppCompatActivity {

    private DogBreedsFragment view;
    private DogAPI dogAPI;

    public BreedsController(DogBreedsFragment view, DogAPI dogAPI) {
        this.view = view;
        this.dogAPI = dogAPI;
    }

    //Callback for all breeds list
    public void getBreeds() {
        Call<Breeds> call = dogAPI.loadBreeds();
        call.enqueue(
            new Callback<Breeds>() {
                @Override
                public void onResponse(Call<Breeds> call, Response<Breeds> response) {
                    if(response.isSuccessful()) {
                        Breeds responseAPI = response.body();
                        view.showList(responseAPI.getMessage());
                    } else {
                        System.out.println(response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<Breeds> call, Throwable t) {
                    t.printStackTrace();
                }
            }
        );
    }

}
