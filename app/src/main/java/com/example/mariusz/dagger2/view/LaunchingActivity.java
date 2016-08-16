package com.example.mariusz.dagger2.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mariusz.dagger2.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LaunchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.go)
    public void onGoClick() {
        Intent intent = new Intent(LaunchingActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
