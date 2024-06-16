package com.example.myapplication.ui.verification;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.NavController;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentVerificationBinding;

public class VerificationFragment extends Fragment {

    private FragmentVerificationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVerificationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cardGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToChooseAccountFragment();
            }
        });

        binding.cardVk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToChooseAccountFragment();
            }
        });

        binding.cardApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToChooseAccountFragment();
            }
        });
    }

    private void navigateToChooseAccountFragment() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.chooseAccountFragment);
    }
}
