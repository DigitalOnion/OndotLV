package com.outerspace.ondotlv.model;

import com.outerspace.ondotlv.api.Pixabay;

public interface DataCompletion {

    public void onSuccess(Pixabay pixabay);

    public void onFailure(String message);

}
