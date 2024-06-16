package com.example.myapplication.ui.onboarding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.myapplication.ui.onboarding.listfragment.List1Fragment;
import com.example.myapplication.ui.onboarding.listfragment.List2Fragment;
import com.example.myapplication.ui.onboarding.listfragment.List3Fragment;
import com.example.myapplication.ui.onboarding.listfragment.List4Fragment;

public class OnBoardingPagerAdapter extends FragmentStateAdapter {

    public OnBoardingPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public int getItemCount() {
        return 4; // Number of your fragments
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new List1Fragment();
            case 1:
                return new List2Fragment();
            case 2:
                return new List3Fragment();
            case 3:
                return new List4Fragment();
            default:
                throw new IllegalArgumentException("Invalid position");
        }
    }
}
