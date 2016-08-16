package com.example.mariusz.dagger2.view;

/**
 * Created by mariusz on 18.05.16
 */
public interface MainActivityView {
    void onDataLoaded(String event);

    void onError(String message);
}
