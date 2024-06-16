package com.example.myapplication.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.databinding.ItemBooksBinding;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

    private List<Integer> list;

    public BooksAdapter(List<Integer> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBooksBinding binding = ItemBooksBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new BooksViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        int bookImage = list.get(position);
        holder.imageView.setImageResource(bookImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class BooksViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public BooksViewHolder(ItemBooksBinding binding) {
            super(binding.getRoot());
            imageView = binding.ivBooooks;
        }
    }
}
