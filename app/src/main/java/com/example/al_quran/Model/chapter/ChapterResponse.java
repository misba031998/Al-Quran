package com.example.al_quran.Model.chapter;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ChapterResponse{

	@SerializedName("chapters")
	private List<ChaptersItem> chapters;

	public List<ChaptersItem> getChapters(){
		return chapters;
	}
}