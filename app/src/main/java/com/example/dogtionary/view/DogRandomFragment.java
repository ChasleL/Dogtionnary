package com.example.dogtionary.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dogtionary.controller.DogRestAPI;
import com.example.dogtionary.R;
import com.example.dogtionary.controller.BreedsRandomController;
import com.squareup.picasso.Picasso;

public class DogRandomFragment extends Fragment {
    private BreedsRandomController breedsRandomController;
    private TextView textView;
    private ImageView imageView;
    private View view;

    public DogRandomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_dog_random_board, container, false);

        breedsRandomController = new BreedsRandomController(this, DogRestAPI.getInstance());
        breedsRandomController.getRandom();

        return view;
    }

    // Put information inside View
    public void showRandomPicture(String message) {
        textView = view.findViewById(R.id.random_name_dog);
        String breed = getRandomBreed(message);
        textView.setText(breed);

        imageView = view.findViewById(R.id.random_picture_dog);
        Picasso.get().load(message).resize(500,500).into(imageView);
    }

    // Get Dog Breed Name from url
    public String getRandomBreed(String url) {
        String[] tokens = url.split("/");
        String breed = tokens[4].substring(0,1).toUpperCase() + tokens[4].substring(1);
        return breed;
    }
}
