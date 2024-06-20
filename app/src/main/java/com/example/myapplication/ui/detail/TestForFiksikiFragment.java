package com.example.myapplication.ui.detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentTestForFiksikiBinding;
import com.example.myapplication.databinding.FragmentTestForPorosyataBinding;


public class TestForFiksikiFragment extends Fragment {

    private FragmentTestForFiksikiBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTestForFiksikiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ivArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(TestForFiksikiFragment.this).navigateUp();
            }
        });
        binding.btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(TestForFiksikiFragment.this).navigateUp();
                Toast.makeText(requireContext(), "У вас 6 правильных ответов", Toast.LENGTH_LONG).show();
            }
        });
    }
}