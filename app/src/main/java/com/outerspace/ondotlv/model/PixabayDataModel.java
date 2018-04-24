package com.outerspace.ondotlv.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.outerspace.ondotlv.api.Pixabay;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PixabayDataModel implements DataModel, Callback<Pixabay> {
    private static final String MESSAGE_FAILURE = "Searching for @ yielded no results.";
    private static final String QUERY_PLACEHOLDER = "@";

    DataCompletion completion;
    String query;

    public PixabayDataModel(DataCompletion completion) {
        this.completion = completion;
    }

    @Override
    public void requestPixabay(String query) {
        this.query = query;

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PixabayApi.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PixabayApi api = retrofit.create(PixabayApi.class);

        Call<Pixabay> call = api.call(query, PixabayApi.API_KEY);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Pixabay> call, Response<Pixabay> response) {
        if( response.isSuccessful() ) {
            completion.onSuccess(response.body());
        }
        else {
            completion.onFailure(MESSAGE_FAILURE.replace(QUERY_PLACEHOLDER, query));
        }
    }

    @Override
    public void onFailure(Call<Pixabay> call, Throwable t) {
        completion.onFailure(t.getMessage());
    }
}
