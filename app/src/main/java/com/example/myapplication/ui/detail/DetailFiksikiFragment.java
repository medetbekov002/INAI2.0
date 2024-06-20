package com.example.myapplication.ui.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDetailFiksikiBinding;


public class DetailFiksikiFragment extends Fragment {
    private FragmentDetailFiksikiBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailFiksikiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ivArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DetailFiksikiFragment.this)
                        .navigate(R.id.libFragment);
            }
        });

        binding.btnNtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DetailFiksikiFragment.this)
                        .navigate(R.id.testForFiksikiFragment);
            }
        });

        binding.tvCon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DetailFiksikiFragment.this)
                        .navigate(R.id.audioFiksikiFragment);
            }
        });

        binding.ivArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DetailFiksikiFragment.this)
                        .navigate(R.id.libFragment);
            }
        });
    }
}

