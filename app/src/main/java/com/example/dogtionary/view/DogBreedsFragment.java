package com.example.dogtionary.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogtionary.controller.DogRestAPI;
import com.example.dogtionary.R;
import com.example.dogtionary.controller.BreedsController;

import java.util.List;


public class DogBreedsFragment extends Fragment {
    private BreedsController breedsController;
    private List<String> breedsList;
    private View view;

    public DogBreedsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dog_breeds, container, false);

        breedsController = new BreedsController(this, DogRestAPI.getInstance());
        breedsController.getBreeds();

        return view;
    }

    //Put list into RecyclerView
    public void showList(List<String> message) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        DogAdapter adapter = new DogAdapter(message);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }
}