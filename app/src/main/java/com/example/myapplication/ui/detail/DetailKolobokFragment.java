package com.example.myapplication.ui.detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDetailKolobokBinding;
import com.example.myapplication.databinding.FragmentDetailPorosyataBinding;


public class DetailKolobokFragment extends Fragment {

    private FragmentDetailKolobokBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetailKolobokBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ivArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DetailKolobokFragment.this).navigate(R.id.libFragment);
            }
        });

        binding.btnNtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Uncomment and set the correct navigation action
                NavHostFragment.findNavController(DetailKolobokFragment.this).navigate(R.id.testForKolobokFragment);
            }
        });

        binding.tvCon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DetailKolobokFragment.this).navigate(R.id.audioKolobokFragment);
            }
        });
    }
}
