package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myfirstapplication.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    Random random;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        random = new java.util.Random();

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int count = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();
        String countText = getString(R.string.random_heading, count);
        TextView headerView = binding.textviewHeader;
        headerView.setText(countText);

        TextView randomView = binding.textviewRandom;

        setRandomNumber(randomView, count);

        binding.regenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomNumber(randomView, count);
            }
        });
    }

    private void setRandomNumber(TextView randomView, int count) {
        randomView.setText(Integer.toString(getRandomNumber(count)));
    }

    private int getRandomNumber(int count) {
        int randomNumber = 0;
        if (count > 0) {
            randomNumber = random.nextInt(count + 1);
        }
        return randomNumber;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}