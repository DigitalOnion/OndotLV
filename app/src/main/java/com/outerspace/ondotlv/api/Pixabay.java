
package com.outerspace.ondotlv.api;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pixabay {

    @SerializedName("totalHits")
    @Expose
    public Integer totalHits;
    @SerializedName("hits")
    @Expose
    public List<Hit> hits = null;
    @SerializedName("total")
    @Expose
    public Integer total;

}
