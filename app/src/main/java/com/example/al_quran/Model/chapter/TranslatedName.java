package com.example.al_quran.Model.chapter;

import com.google.gson.annotations.SerializedName;

public class TranslatedName{

	@SerializedName("name")
	private String name;

	@SerializedName("language_name")
	private String languageName;

	public String getName(){
		return name;
	}

	public String getLanguageName(){
		return languageName;
	}
}