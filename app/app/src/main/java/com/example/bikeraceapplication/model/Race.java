package com.example.bikeraceapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.bikeraceapplication.util.Money;
import com.example.bikeraceapplication.util.Place;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Race {


    private String id;
    private String name;
    private Place place;
    private Date date;
    private RaceType type;
    private int distance;
    private Date dueTime;
    private Money cost;
    private Money minGatheredAmount;


    Set<Participation> participations;
    Set<SponsorshipApplication> sponsorshipApplications;
    Referee referee;
    Organizer  organizer;

    public Race() {

    }

    public Race(String name, Place place, Date date, RaceType type, int distance,
                 Date dueTime , Organizer organizer, Money cost, Money minGatheredAmount) {

        this.name = name;
        this.place = place;
        this.date = date;
        this.type = type;
        this.distance = distance;
        this.dueTime = dueTime;
        this.cost=cost;
        this.minGatheredAmount=minGatheredAmount;
        this.organizer = organizer;
        this.participations= new HashSet<>();
        this.sponsorshipApplications= new HashSet<>();
    }


    public void setName(String raceName){this.name = raceName;}

    /**
     * checks if a race should be conducted
     *
     * @return true if race should be conducted/ else false
     */
    public boolean shouldRaceBeConducted(){
        return hasMinCostComplete();
    }


    /**
     * checks if the money collected surpasses or is equal the minimum cost
     *
     * @return true if enough money has been collected/ else false
     */

    public boolean hasMinCostComplete(){
        double collectedAmount=0.0;
        collectedAmount += participations.size() * cost.getAmount();

        for(SponsorshipApplication sponsorshipApplication: sponsorshipApplications){
            if(sponsorshipApplication.isApproved()){
                collectedAmount += sponsorshipApplication.getAmount().getAmount();
            }
        }
        return minGatheredAmount.getAmount() <= collectedAmount;
    }

    /**
     * adds sponsorship application to sponsorshipApplications ArrayList
     * (list that has all the sponsorship applications for the race)
     *
     * @param application to be added to sponsorshipApplications
     */
    public void addSponsorshipApplication(SponsorshipApplication application){
        if(application != null)
            sponsorshipApplications.add(application);
    }

    /**
     * removes sponsorship application from sponsorshipApplications ArrayList
     * (list that has all the sponsorship applications for the race)
     *
     * @param application application to be removed from sponsorshipApplications
     */
    public void removeSponsorshipApplication(SponsorshipApplication application){
        sponsorshipApplications.remove(application);
    }

    /**
     * adds participation to participations ArrayList
     * (list that has all the participations for the race)
     *
     * @param participation participation that we want to add to participations
     */
    public void addParticipant(Participation participation) {
        if(participation != null)
            participations.add(participation);
    }

    public int getNumParticipations(){
        return participations.size();
    }


    /*this method is for testing purposes only because true id's are generated randomly*/
    public void setId(String id){
        if(this.id == null)
            this.id = id;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void setType(RaceType type) {
        this.type = type;
    }

    public void setCost(Money cost) {
        this.cost = cost;
    }

    public void setMinGatherAmount(Money minGatheredAmount){
        this.minGatheredAmount = minGatheredAmount;
    }

    public void setReferee(Referee ref){
        this.referee=ref;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Place getPlace() {
        return place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RaceType getType() {
        return type;
    }

    public Money getCost() {
        return cost;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Set<Participation> getParticipations() {
        return new HashSet<>(this.participations);
    }

    public Set<SponsorshipApplication> getSponsorshipApplications() {
        return new HashSet<>(this.sponsorshipApplications);
    }

    public Referee getReferee() {
        return referee;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public Money getMinGatheredAmount() {
        return minGatheredAmount;
    }

    public void setMinGatheredAmount(Money minGatheredAmount) {
        this.minGatheredAmount = minGatheredAmount;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateStr = formatter.format(this.getDate());
        String city = this.getPlace().getCity();
        String location = this.getPlace().getLocation();
        String type = this.getType().toString();
        String distance = String.valueOf(getDistance());
        String cost = String.valueOf(this.getCost().getAmount());
        return dateStr+ " " + city + " " + location + " " + type + " " + distance + " "+ cost+"€";
    }

}
