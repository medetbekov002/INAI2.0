package com.example.myapplication.ui.menu;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.NavController;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tvMainSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateUp();
            }
        });
        
        binding.tvMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToProfileFragment();
            }
        });

        binding.tvPodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLibFragment();
            }
        });

        binding.tvFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFavFragment();
            }
        });

        binding.tvInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToAboutAppFragment();
            }
        });

        binding.tvConnectWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToContactsFragment();
            }
        });
    }

    private void navigateUp() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigateUp();
    }

    private void navigateToProfileFragment() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.profileFragment);
    }

    private void navigateToLibFragment() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.libFragment);
    }

    private void navigateToFavFragment() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.favFragment);
    }

    private void navigateToAboutAppFragment() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.aboutAppFragment);
    }

    private void navigateToContactsFragment() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.contactsFragment);
    }
}
