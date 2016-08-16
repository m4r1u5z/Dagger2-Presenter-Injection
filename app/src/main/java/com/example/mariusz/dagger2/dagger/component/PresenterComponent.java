package com.example.mariusz.dagger2.dagger.component;

import com.example.mariusz.dagger2.dagger.module.PresenterModule;
import com.example.mariusz.dagger2.dagger.scope.PerActivity;
import com.example.mariusz.dagger2.view.MainActivityView;
import com.example.mariusz.dagger2.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mariusz on 18.05.16
 */

@PerActivity
@Component(modules = {PresenterModule.class})
public interface PresenterComponent {
    void inject(MainActivity mainActivity);

    final class Initializer {
        public static PresenterComponent init(MainActivityView mainActivityView) {
            return DaggerPresenterComponent.builder()
                    .presenterModule(new PresenterModule(mainActivityView))
                    .build();
        }
    }
}