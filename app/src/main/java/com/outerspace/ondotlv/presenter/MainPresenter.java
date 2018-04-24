package com.outerspace.ondotlv.presenter;

import com.outerspace.ondotlv.api.Pixabay;
import com.outerspace.ondotlv.model.DataCompletion;
import com.outerspace.ondotlv.model.PixabayDataModel;
import com.outerspace.ondotlv.model.DataModel;
import com.outerspace.ondotlv.view.MainView;

public class MainPresenter implements DataCompletion {
    MainView view;
    DataModel model;

    public MainPresenter(MainView view) {
        this.view = view;
        model = new PixabayDataModel(this);
    }

    public void requestPixabay(String query) {
        model.requestPixabay(query);
    }

    @Override
    public void onSuccess(Pixabay pixabay) {
        view.onResponseReceived(pixabay);
    }

    @Override
    public void onFailure(String message) {

    }
}
