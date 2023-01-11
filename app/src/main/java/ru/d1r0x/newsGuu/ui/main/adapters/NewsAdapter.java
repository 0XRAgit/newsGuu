package ru.d1r0x.newsGuu.ui.main.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Date;

import ru.d1r0x.newsGuu.R;
import ru.d1r0x.newsGuu.data.models.news.Articles;
import ru.d1r0x.newsGuu.databinding.ItemNewsBinding;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private final Articles[] articles;

    public NewsAdapter(Articles[] articles){
        this.articles=articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding binding =ItemNewsBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new ViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(articles[position].getTitle()!=null && !articles[position].getTitle().isEmpty()){
            holder.binding.textTitle.setVisibility(View.VISIBLE);
            holder.binding.textTitle.setText(articles[position].getTitle());
        }else{
            holder.binding.textTitle.setVisibility(View.GONE);
        }

        if(articles[position].getAuthor()!=null && !articles[position].getAuthor().isEmpty()){
            holder.binding.textAuthor.setVisibility(View.VISIBLE);
            holder.binding.textAuthor.setText(holder.itemView.getContext().getString(R.string.news_item_author).replace("$name",articles[position].getAuthor()));
        }else{
            holder.binding.textAuthor.setVisibility(View.GONE);
        }

        if(articles[position].getSource().getName()!=null && !articles[position].getSource().getName().isEmpty()){
            holder.binding.textResource.setVisibility(View.VISIBLE);
            holder.binding.textResource.setText(holder.itemView.getContext().getString(R.string.news_item_resource).replace("$name",articles[position].getSource().getName()));
        }else{
            holder.binding.textResource.setVisibility(View.GONE);
        }

        if(articles[position].getUrlToImage()!=null && !articles[position].getUrlToImage().isEmpty()){
            holder.binding.imageView.setVisibility(View.VISIBLE);
            Glide.with(holder.itemView.getContext())
                    .load(articles[position].getUrlToImage())
                    .into(holder.binding.imageView);
        }else{
            holder.binding.imageView.setVisibility(View.GONE);
        }

        if(articles[position].getDescription()!=null && !articles[position].getDescription().isEmpty()){
            holder.binding.textDescription.setVisibility(View.VISIBLE);
            holder.binding.textDescription.setText(articles[position].getDescription());
        }else{
            holder.binding.textDescription.setVisibility(View.GONE);
        }

        holder.binding.textDate.setText(new Date().getDay()+"-"+new Date().getMonth()+"-"+new Date().getYear());

        holder.binding.buttonReadAll.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(articles[position].getUrl()));
            holder.itemView.getContext().startActivity(browserIntent);
        });
    }

    @Override
    public int getItemCount() {
        return articles.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemNewsBinding binding;

        public ViewHolder(@NonNull ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
