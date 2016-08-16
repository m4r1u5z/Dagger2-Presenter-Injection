package com.example.mariusz.dagger2;

import android.app.Application;

import com.example.mariusz.dagger2.dagger.component.AppComponent;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by mariusz on 18.05.16
 */
public class BaseApplication extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildAppComponent();
        LeakCanary.install(this);
    }

    public static AppComponent appComponent() {
        return appComponent;
    }

    private static void buildAppComponent() {
        appComponent = AppComponent.Initializer.init();
    }
}
