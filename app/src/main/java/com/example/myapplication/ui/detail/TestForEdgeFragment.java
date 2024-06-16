package com.example.myapplication.ui.detail;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myapplication.databinding.FragmentTestForEdgeBinding;

public class TestForEdgeFragment extends Fragment {

    private FragmentTestForEdgeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTestForEdgeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ivArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(TestForEdgeFragment.this).navigateUp();
            }
        });
        binding.btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(TestForEdgeFragment.this).navigateUp();
                Toast.makeText(requireContext(), "У вас 6 правильных ответов", Toast.LENGTH_LONG).show();
            }
        });
    }
}
