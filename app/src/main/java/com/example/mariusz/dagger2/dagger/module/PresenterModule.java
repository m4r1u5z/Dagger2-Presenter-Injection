package com.example.mariusz.dagger2.dagger.module;

import com.example.mariusz.dagger2.dagger.scope.PerActivity;
import com.example.mariusz.dagger2.view.MainActivityView;
import com.example.mariusz.dagger2.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mariusz on 18.05.16
 */

@Module
public class PresenterModule {
    MainActivityView _mainActivityView;

    public PresenterModule(MainActivityView mainActivityView) {
        this._mainActivityView = mainActivityView;
    }

    @Provides
    @PerActivity
    MainPresenter provideMainPresenter() {
        return new MainPresenter(_mainActivityView);
    }

    @Provides
    @PerActivity
    MainActivityView provideMainActivityView() {
        return _mainActivityView;
    }
}