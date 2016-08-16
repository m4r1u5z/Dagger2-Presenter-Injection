package com.example.mariusz.dagger2.dagger.component;

import com.example.mariusz.dagger2.dagger.module.ApiServiceModule;
import com.example.mariusz.dagger2.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mariusz on 18.05.16
 */

@Singleton
@Component(modules = {ApiServiceModule.class})
public interface AppComponent {
    void inject(MainPresenter presenter);

    final class Initializer {
        public static AppComponent init() {
            return DaggerAppComponent.builder()
                    .build();
        }
    }
}