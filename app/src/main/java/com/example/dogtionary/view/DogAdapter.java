package com.example.dogtionary.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dogtionary.R;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder>{
    List<String> breedsList;

    // Viewholder class
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView dogNameView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dogNameView = itemView.findViewById(R.id.breeds_name);
        }
    }

    // Constructor
    public DogAdapter (List<String> breeds) {
        breedsList = breeds;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_dog_breeds, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, int position) {
        String nameBreed = breedsList.get(position);

        TextView textView = holder.dogNameView;
        textView.setText(nameBreed.substring(0,1).toUpperCase() + nameBreed.substring(1));
    }

    @Override
    public int getItemCount() {
        return breedsList.size();
    }
}

