package com.example.bikeraceapplication.view.Race.Search;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.model.Race;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class RaceRecyclerViewAdapter extends RecyclerView.Adapter<RaceRecyclerViewAdapter.ViewHolder>{

    private final List<Race> mValues;
    private final ItemSelectionListener listener;


    public RaceRecyclerViewAdapter(List<Race> races, ItemSelectionListener listener){
        this.mValues = races;
        this.listener = listener;
    }

    @Override
    public RaceRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.race_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RaceRecyclerViewAdapter.ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).getName());

        /*We need to display the races accordingly to which called the method.*/
        if(RaceSearchActivity.roleCalledSearch.equals("Competitor"))
            holder.mContentView.setText(mValues.get(position).toString()); //here we need to display the race according to the role called us.
        else if(RaceSearchActivity.roleCalledSearch.equals("Sponsor")){
            String raceName = mValues.get(position).getName();
            String raceMinAmount = String.valueOf(mValues.get(position).getMinGatheredAmount().getAmount());
            holder.mContentView.setText(raceName+ " " + "minimum required amount: "+raceMinAmount);
        }



        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.selectRace(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mNameView;
        public final TextView mContentView;
        public Race mItem;

        public ViewHolder(@NonNull View view) {
            super(view);
            mNameView = view.findViewById(R.id.item_name);
            mContentView = view.findViewById(R.id.content);
        }

    }

    public interface ItemSelectionListener{
        void selectRace(Race race);
    }
}
