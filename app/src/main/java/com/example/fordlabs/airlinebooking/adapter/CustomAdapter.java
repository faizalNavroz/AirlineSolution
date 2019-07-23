package com.example.fordlabs.airlinebooking.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fordlabs.airlinebooking.R;
import com.example.fordlabs.airlinebooking.databinding.ListItemBinding;
import com.example.fordlabs.airlinebooking.viewmodel.AirlineItemViewModel;
import com.example.fordlabs.airlinebooking.viewmodel.AirlineViewModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<AirlineItemViewModel>itemViewModels = new ArrayList<AirlineItemViewModel>();

    public void setItemViewModels(ArrayList<AirlineItemViewModel> itemViewModels) {
        this.itemViewModels = itemViewModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ListItemBinding listItemBinding = ListItemBinding.inflate(inflater,viewGroup,false);

        return new MyViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if(!itemViewModels.isEmpty()){
            AirlineItemViewModel  airlineViewModel = itemViewModels.get(i);
            myViewHolder.listItemBinding.setViewModel(airlineViewModel);
            myViewHolder.listItemBinding.executePendingBindings();
        }



    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ListItemBinding listItemBinding;


        public MyViewHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;

        }
    }


}
