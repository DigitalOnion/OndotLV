package com.outerspace.ondotlv.view;

import com.outerspace.ondotlv.R;
import com.outerspace.ondotlv.api.Pixabay;
import com.outerspace.ondotlv.presenter.MainPresenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
    }

    public void onClickButtonSearch(View view) {
        String query;
        EditText editQuery = (EditText) findViewById(R.id.edit_query);
        query = editQuery.getText().toString();
        presenter.requestPixabay(query);
    }

    @Override
    public void onResponseReceived(Pixabay pixabay) {

    }
}