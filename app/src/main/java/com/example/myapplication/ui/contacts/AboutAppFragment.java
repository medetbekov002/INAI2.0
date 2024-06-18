package com.example.myapplication.ui.contacts;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAboutAppBinding;

public class AboutAppFragment extends Fragment {

    private FragmentAboutAppBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAboutAppBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = "Детское приложение проекта Arzamas.academy с лекциями, подкастами, сказками и колыбельными";
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.fiol));
        spannableString.setSpan(colorSpan, 27, 43, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.texts.setText(spannableString);

        binding.ivFiol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(AboutAppFragment.this).navigateUp();
            }
        });
    }
}
