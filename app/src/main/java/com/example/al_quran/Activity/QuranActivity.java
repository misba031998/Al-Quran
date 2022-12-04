package com.example.al_quran.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.al_quran.Adapter.ChapterAdapter;
import com.example.al_quran.Model.chapter.ChapterResponse;
import com.example.al_quran.Model.chapter.ChaptersItem;
import com.example.al_quran.Network.ApiClient;
import com.example.al_quran.Network.ApiConstants;
import com.example.al_quran.Network.ApiInterface;
import com.example.al_quran.Network.ApiResponse;
import com.example.al_quran.R;
import com.example.al_quran.Utility.AppPrefarance;
import com.example.al_quran.databinding.QuranActivityBinding;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class QuranActivity extends AppCompatActivity implements ApiResponse {
    private QuranActivityBinding binding;
    private ApiInterface apiInterface;
    private ArrayList<ChaptersItem> chaptersItems = new ArrayList<>();
    private ChapterAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.quran_activity);
        clickMethod();
        adapterSet();
        chapterApi();
        binding.getRoot();
    }

    private void adapterSet() {
        cAdapter = new ChapterAdapter(this, chaptersItems);
        binding.rcChapter.setAdapter(cAdapter);
    }

    private void clickMethod() {

    }

    private void chapterApi() {
        apiInterface = ApiClient.getApiInterFace(this);
        Call<ResponseBody> chapters = apiInterface.chapters(AppPrefarance.getLanguage(this));
        ApiClient.callApi(chapters, this, ApiConstants.apiRequest.CHAPTERS);
    }

    @Override
    public void onResponse(String response, int apiRequest) {
        binding.sheemar.stopShimmer();
        binding.sheemar.setVisibility(View.GONE);
        if (ApiConstants.apiRequest.CHAPTERS==apiRequest){
            ChapterResponse cr = ApiClient.getPayload(ChapterResponse.class, response);
            chaptersItems.addAll(cr.getChapters());
            cAdapter.notifyDataSetChanged();
        }

        Log.e("response", response);
    }

    @Override
    public void onError(String errorResponse, int apiRequest) {
        binding.sheemar.stopShimmer();
        binding.sheemar.setVisibility(View.GONE);
        Log.e("ErrorResponse", errorResponse);
    }

    public void ChapterNext(){
        Intent in = new Intent(this,ReadActivity.class);
    }
}