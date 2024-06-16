package com.example.myapplication.ui.profile;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;


import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ivArrowBack.setOnClickListener(v -> findNavController(requireView()).navigateUp());

        binding.books.setOnClickListener(v -> findNavController(requireView()).navigate(R.id.libFragment));

        binding.btn001.setOnClickListener(v -> findNavController(requireView()).navigate(R.id.verificationFragment));
    }
}
