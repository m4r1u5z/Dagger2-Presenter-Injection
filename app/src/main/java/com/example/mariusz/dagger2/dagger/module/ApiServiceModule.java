package com.example.mariusz.dagger2.dagger.module;

import com.example.mariusz.dagger2.api.GitHubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by mariusz on 18.05.16
 */

@Module(includes = {ApiConfigurationModule.class})
public class ApiServiceModule {
    @Provides
    @Singleton
    public GitHubService provideGitHubService(Retrofit retrofit) {
        return retrofit.create(GitHubService.class);
    }
}