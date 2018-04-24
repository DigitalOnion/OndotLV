package com.outerspace.ondotlv.view;

import java.util.HashMap;

import com.outerspace.ondotlv.R;
import com.outerspace.ondotlv.api.Pixabay;
import com.outerspace.ondotlv.presenter.MainPresenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeViewElements();

        presenter = new MainPresenter(this);
    }

    private void storeViewElements() {
        ViewStore.store(findViewById(R.id.btn_search));
        ViewStore.store(findViewById(R.id.edit_query));
        ViewStore.store(findViewById(R.id.recycler));
    }

    public void onClickButtonSearch(View view) {
        String query = ViewStore.getTextValue(R.id.edit_query);
        presenter.requestPixabay(query);
    }

    @Override
    public void onResponseReceived(Pixabay pixabay) {
        //RecyclerView recycler = (RecyclerView) ViewStore.get(R.id.recycler);
        Toast.makeText(this, "Test:" + pixabay.hits, Toast.LENGTH_SHORT).show();
    }

}
