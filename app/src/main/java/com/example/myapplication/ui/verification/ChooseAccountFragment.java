package com.example.myapplication.ui.verification;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.NavController;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentChooseAccountBinding;

public class ChooseAccountFragment extends Fragment {

    private FragmentChooseAccountBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChooseAccountBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.constraintAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = requireActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isAuthenticated", true);
                editor.apply();

                NavController navController = NavHostFragment.findNavController(ChooseAccountFragment.this);
                navController.navigate(R.id.welcomeFragment);
            }
        });
    }
}
