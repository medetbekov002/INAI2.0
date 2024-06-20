package com.example.myapplication.ui.library;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentLibBinding;

public class LibFragment extends Fragment {

    private FragmentLibBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLibBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ivArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LibFragment.this).navigate(R.id.menuFragment);
            }
        });

        binding.bk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LibFragment.this).navigate(R.id.detailsFragment);
            }
        });

        binding.bk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LibFragment.this).navigate(R.id.detailForEdgeFragment);
            }
        });

        binding.bk33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LibFragment.this).navigate(R.id.detailDuneFragment);
            }
        });

        binding.bk22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LibFragment.this).navigate(R.id.detailPorosyataFragment);
            }
        });

    }
}

