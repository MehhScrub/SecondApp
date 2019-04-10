package com.example.secondapp;


public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void  viewCreated() {

    }
    //Zone Button function
    public void SarasasButtonClicked() {view.goNextWindow(MainActivity.SARASAS_TAG);}





    }

