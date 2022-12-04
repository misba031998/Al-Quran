package com.example.al_quran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.al_quran.Model.chapter.ChapterResponse;
import com.example.al_quran.Model.chapter.ChaptersItem;
import com.example.al_quran.R;
import com.example.al_quran.databinding.ChapterListDesignBinding;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ChaptersItem> chaptersItems;

    public ChapterAdapter(Context context, ArrayList<ChaptersItem> chaptersItems) {
        this.context = context;
        this.chaptersItems = chaptersItems;
    }

    @NonNull
    @Override
    public ChapterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.chapter_list_design, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterAdapter.ViewHolder holder, int position) {
        holder.binding.tvId.setText(chaptersItems.get(position).getId() + "");
        holder.binding.tvName.setText(chaptersItems.get(position).getTranslatedName().getName());
        holder.binding.tvArbiNm.setText(chaptersItems.get(position).getNameArabic());
    }

    @Override
    public int getItemCount() {
        return chaptersItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ChapterListDesignBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
