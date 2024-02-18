package com.example.bikeraceapplication.view.Competitor.registration;

public interface RaceRegistrationView {

    void showSearchDialog(String raceName, String racePlace, String raceDate, String raceType, String raceDistance);

    void showStatus(String statusMsg);

    void showError(String errorMsg);
}
