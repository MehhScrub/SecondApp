package com.example.secondapp;


import java.util.List;

public interface MainView {
    void setMainTitle(String title);
    void goNextWindow(int tag);
    void goNextWindow(int tag, String param);
}
