package com.example.myapplication.ui.onboarding;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.example.myapplication.databinding.FragmentOnBoardBinding;

public class OnBoardFragment extends Fragment {

    private FragmentOnBoardBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter();
    }

    private void adapter() {
        ViewPager2 viewPager = binding.viewPager;
        OnBoardingPagerAdapter adapter = new OnBoardingPagerAdapter(getChildFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);
    }
}
