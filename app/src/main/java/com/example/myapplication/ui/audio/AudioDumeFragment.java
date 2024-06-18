package com.example.myapplication.ui.audio;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAudioDumeBinding;

public class AudioDumeFragment extends Fragment {

    private FragmentAudioDumeBinding binding;
    private MediaPlayer mediaPlayer;
    private Handler handler;
    private boolean isPlaying = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAudioDumeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.sobachkaleya);
        binding.seekBar.setMax(mediaPlayer.getDuration());
        binding.durationText.setText(getTimeString(mediaPlayer.getDuration()));

        handler = new Handler();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    binding.seekBar.setProgress(currentPosition);
                    binding.progressText.setText(getTimeString(currentPosition));
                }
                handler.postDelayed(this, 1000);
            }
        });

        binding.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    mediaPlayer.start();
                    isPlaying = true;
                    binding.playButton.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.pause();
                    isPlaying = false;
                    binding.playButton.setImageResource(R.drawable.polygon_3);
                }
            }
        });

        binding.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                binding.progressText.setText("00:00");
                binding.seekBar.setProgress(0);
                mediaPlayer.start();
                binding.playButton.setImageResource(R.drawable.play);
            }
        });

        binding.ivArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(AudioDumeFragment.this)
                        .navigate(R.id.detailDuneFragment);
            }
        });

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                    binding.progressText.setText(getTimeString(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                binding.stopButton.performClick();
            }
        });
    }

    private String getTimeString(int duration) {
        int minutes = duration / 1000 / 60;
        int seconds = duration / 1000 % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
        mediaPlayer.release();
    }
}
