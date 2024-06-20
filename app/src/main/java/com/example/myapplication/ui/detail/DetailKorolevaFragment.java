package com.example.myapplication.ui.detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDetailKorolevaBinding;



public class DetailKorolevaFragment extends Fragment {

    private FragmentDetailKorolevaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetailKorolevaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ivArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DetailKorolevaFragment.this).navigate(R.id.libFragment);
            }
        });

        binding.btnNtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Uncomment and set the correct navigation action
                NavHostFragment.findNavController(DetailKorolevaFragment.this).navigate(R.id.testForKorolevaFragment);
            }
        });

        binding.tvCon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DetailKorolevaFragment.this).navigate(R.id.audioKorolevaFragment);
            }
        });
    }
}