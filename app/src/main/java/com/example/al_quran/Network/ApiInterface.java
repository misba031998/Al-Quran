package com.example.al_quran.Network;


import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface ApiInterface {
    @GET(ApiConstants.CHAPTER)
    Call<ResponseBody> chapters(@Query("language") String ln);

    @GET(ApiConstants.CHAPTER + "/{id}")
    Call<ResponseBody> getChapter(@Path("id") int id,
                                @Query("language") String ln);

    @GET("category")
    Call<ResponseBody> getData();

    @GET(ApiConstants.SHOW_DATA)
    Call<ResponseBody> GetShoWData();

    @GET(ApiConstants.SEARCH_DATA)
    Call<ResponseBody> searcData(@Query("BCODE") String data);

    @GET(ApiConstants.INSERT_DATA)
    Call<ResponseBody> InsertData(@QueryMap HashMap<String, String> dataInsert);

    @GET(ApiConstants.UPDATE_DATA)
    Call<ResponseBody> updateData(@QueryMap HashMap<String, String> mapup);


}
