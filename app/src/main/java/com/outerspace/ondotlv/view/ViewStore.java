package com.outerspace.ondotlv.view;

import java.util.HashMap;

import android.view.View;
import android.widget.EditText;

public class ViewStore {
    private static final ViewStore instance = new ViewStore();
    private static HashMap<Integer, View> viewMap = new HashMap<>();

    private ViewStore() { }

    public static ViewStore getInstance() {
        return instance;
    }

    public static void store(View view) {
        Integer resourceId = view.getId();
        viewMap.put(resourceId, view);
    }

    public static View get(Integer resourceId) {
        return viewMap.get(resourceId);
    }

    public static String getTextValue(Integer resourceId) {
        View view = get(resourceId);
        if(view instanceof EditText) {   // you can add other classes here (The ones with getText)
            EditText et = (EditText) view;
            return et.getText().toString();
        }
        return null;
    }
}
