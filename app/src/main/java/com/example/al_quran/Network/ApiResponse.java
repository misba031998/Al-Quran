package com.example.al_quran.Network;

public interface ApiResponse {
    void onResponse(String response , int apiRequest);
    void onError(String errorResponse,int apiRequest);
}
