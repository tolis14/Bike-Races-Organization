package com.example.bikeraceapplication.view.approveSponsorship;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.model.Sponsorship;
import com.example.bikeraceapplication.model.SponsorshipApplication;
import com.example.bikeraceapplication.view.Race.Search.RaceRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SponsorshipApplicationRecyclerViewAdapter extends RecyclerView.Adapter<SponsorshipApplicationRecyclerViewAdapter.ViewHolder> {

    private List<SponsorshipApplication> mValues;
    private ItemSelectionListener listener;


    public SponsorshipApplicationRecyclerViewAdapter(List<SponsorshipApplication> applications, ItemSelectionListener listener){
        this.mValues = applications;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SponsorshipApplicationRecyclerViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.approve_sponsorship_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.applicationID.setText(mValues.get(position).getId());
        holder.application = mValues.get(position);
        holder.application = mValues.get(position);
        holder.infoButton.setOnClickListener(v->showInfo(position));
        holder.approveButton.setOnClickListener(v->addApprove(position));
        holder.rejectButton.setOnClickListener(v->addRejected(position));
    }

    @Override
    public int getItemCount() { return mValues.size(); }


    private void showInfo(int position){

        SponsorshipApplication application = mValues.get(position);
        String date = application.getDate().toString();
        String amount = String.valueOf(application.getAmount().getAmount());
        String firstName = application.getSponsor().getFirstName();
        String lastName = application.getSponsor().getLastName();
        String company = application.getSponsor().getCompany();
        listener.showInfo(date,amount,firstName,lastName,company);
    }

    private void addApprove(int position){

        SponsorshipApplication application = mValues.get(position);
        listener.addApproved(application); // polymorphism call in the ItemSelectionListener.addApproved()
        this.mValues.remove(application);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mValues.size());

    }

    private void addRejected(int position){

        SponsorshipApplication application = mValues.get(position);
        listener.addRejected(application); // polymorphism call in the ItemSelectionListener.addRejected()
        this.mValues.remove(application);
        this.mValues.remove(application);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mValues.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView applicationID;
        public final Button infoButton;
        public final Button approveButton;
        public final Button rejectButton;
        public SponsorshipApplication application;

        public ViewHolder(@NonNull View view) {
            super(view);
            applicationID = view.findViewById(R.id.application_id);
            infoButton = view.findViewById(R.id.application_info);
            approveButton = view.findViewById(R.id.approve_application_button);
            rejectButton = view.findViewById(R.id.reject_application_button);
        }

    }

    public interface ItemSelectionListener{

        /*this method will be called once the user presses the submit button*/
        void addApproved(SponsorshipApplication application);
        void addRejected(SponsorshipApplication application);
        void showInfo(String date, String amount, String firstName, String lastName, String company);

    }

}
