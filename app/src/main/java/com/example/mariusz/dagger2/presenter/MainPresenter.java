package com.example.mariusz.dagger2.presenter;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.mariusz.dagger2.BaseApplication;
import com.example.mariusz.dagger2.api.GitHubService;
import com.example.mariusz.dagger2.api.model.User;
import com.example.mariusz.dagger2.view.MainActivityView;

import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mariusz on 18.05.16
 */
public class MainPresenter {
    MainActivityView _mainActivityView;

    @Inject
    GitHubService gitHubService;

    public MainPresenter(MainActivityView mainActivityView) {
        this._mainActivityView = mainActivityView;
        BaseApplication.appComponent().inject(this);
    }

    public void requestdata() {
        gitHubService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                            _mainActivityView.onDataLoaded(mapData(users));
                        }
                        , throwable -> {
                            _mainActivityView.onError(throwable.getMessage());
                        }
                );
    }

    private String mapData(List<User> users) {
        List<User> filtered = Stream.of(users)
                .filter(user -> user.getId() % 2 == 0)
                .collect(Collectors.toList());
        return toString(filtered);
    }

    public String toString(List<User> users) {
        StringBuilder builder = new StringBuilder();
        for (User user : users) {
            builder.append(user.getId())
                   .append(": ")
                   .append(user.getLogin())
                   .append("\n");
        }
        return builder.toString();
    }
}
