package com.outerspace.ondotlv.model;


import com.outerspace.ondotlv.api.Pixabay;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {

    public static final String API_KEY = "8782397-0167754e846f520e8c572b2ab";
    public static final String URL = "https://pixabay.com";
    public static final String ENDPOINT = "api";

    @GET(ENDPOINT)
    Call<Pixabay> call(@Query("q") String query,
                       @Query("key") String key);

}
