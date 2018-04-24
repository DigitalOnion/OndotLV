package com.outerspace.ondotlv.presenter;

import com.outerspace.ondotlv.model.PixabayDataModel;
import com.outerspace.ondotlv.model.DataModel;
import com.outerspace.ondotlv.view.MainView;

public class MainPresenter {
    MainView view;
    DataModel model;

    public void requestPixabay(String query) {
        model.requestPixabay(query);
    }

    public MainPresenter(MainView view) {
        this.view = view;
        model = new PixabayDataModel();
    }




}
