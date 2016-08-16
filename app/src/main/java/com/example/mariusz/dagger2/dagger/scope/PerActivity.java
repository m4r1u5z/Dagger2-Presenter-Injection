package com.example.mariusz.dagger2.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by mariusz on 18.05.16
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
