package com.example.mariusz.dagger2.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mariusz.dagger2.R;
import com.example.mariusz.dagger2.dagger.component.PresenterComponent;
import com.example.mariusz.dagger2.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mariusz on 18.05.16
 */
public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Inject
    MainPresenter _mainPresenter;

    @BindView(R.id.input)
    TextView input;

    PresenterComponent _presenterComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        _presenterComponent = PresenterComponent
                .Initializer
                .init(this);
        _presenterComponent.inject(this);
    }

    @OnClick(R.id.get)
    public void onGetButtonClick() {
        _mainPresenter.requestdata();
    }

    @Override
    public void onDataLoaded(String event) {
        input.setText(event);
    }

    @Override
    public void onError(String message) {
        input.setText(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _presenterComponent = null;
    }
}
