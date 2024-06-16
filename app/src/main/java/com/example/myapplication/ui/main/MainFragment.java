package com.example.myapplication.ui.main;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMainBinding;
import com.example.myapplication.ui.main.adapter.BooksAdapter;
import com.example.myapplication.ui.main.adapter.BooksAdapter2;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private BooksAdapter adapter;
    private BooksAdapter2 adapter2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ivVanGogBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.audioStarFragment);
            }
        });

        binding.ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.menuFragment);
            }
        });

        List<Integer> list = new ArrayList<>();
        adapter = new BooksAdapter(list);
        list.add(R.drawable.rectangle);
        list.add(R.drawable.book_q);
        list.add(R.drawable.book_w);
        list.add(R.drawable.book_e);
        list.add(R.drawable.image_book_van_gog);
        binding.recyclerBooks.setAdapter(adapter);

        List<Integer> list2 = new ArrayList<>();
        adapter2 = new BooksAdapter2(list2);
        list2.add(R.drawable.image_book_van_gog);
        list2.add(R.drawable.book_w);
        list2.add(R.drawable.book_e);
        list2.add(R.drawable.rectangle);
        list2.add(R.drawable.book_q);
        binding.recyclerBooks2.setAdapter(adapter2);
    }
}
