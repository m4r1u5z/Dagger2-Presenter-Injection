package com.example.mariusz.dagger2.api;

import com.example.mariusz.dagger2.api.model.User;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by mariusz on 18.05.16
 */
public interface GitHubService {
    @GET("/users")
    Observable<List<User>> getUsers();
}