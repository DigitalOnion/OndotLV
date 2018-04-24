package com.outerspace.ondotlv.view;

import com.outerspace.ondotlv.R;
import com.outerspace.ondotlv.api.Pixabay;
import com.outerspace.ondotlv.presenter.MainPresenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeViewElements();

        presenter = new MainPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        recycler = (RecyclerView) ViewStore.get(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
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
    public void onResponseReceived(PixabayListAdapter adapter) {
        recycler.setAdapter(adapter);
    }
}
