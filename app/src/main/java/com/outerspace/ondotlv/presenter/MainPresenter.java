package com.outerspace.ondotlv.presenter;

import java.util.ArrayList;

import com.outerspace.ondotlv.api.Hit;
import com.outerspace.ondotlv.api.Pixabay;
import com.outerspace.ondotlv.model.DataCompletion;
import com.outerspace.ondotlv.model.PixabayDataModel;
import com.outerspace.ondotlv.model.DataModel;
import com.outerspace.ondotlv.model.TwoPictureURL;
import com.outerspace.ondotlv.view.MainView;
import com.outerspace.ondotlv.view.PixabayListAdapter;

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
        ArrayList<TwoPictureURL> twoPicList = new ArrayList<>();
        TwoPictureURL twoPic = null;
        int idx = 0;
        boolean b = false;
        for(Hit hit : pixabay.hits) {
            b = !b;
            if( b ) {
                twoPic = new TwoPictureURL();
                twoPic.LeftPictureURL = hit.previewURL;
                twoPicList.add(twoPic);
            }
            else {
                twoPic.RightPictureURL = hit.previewURL;
            }
        }
        PixabayListAdapter adapter = new PixabayListAdapter(twoPicList);
        view.onResponseReceived(adapter);
    }

    @Override
    public void onFailure(String message) {

    }
}
