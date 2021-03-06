package com.bsrakdg.multithreadingsamples.solutions.exercise1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bsrakdg.multithreadingsamples.R;
import com.bsrakdg.multithreadingsamples.common.BaseFragment;

public class SolutionExercise1Fragment extends BaseFragment {

    private static final int ITERATIONS_COUNTER_DURATION_SEC = 10;

    public static Fragment newInstance() {
        return new SolutionExercise1Fragment();
    }

    @Override
    protected String getScreenTitle() {
        return "Exercise 1";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_1, container, false);

        Button mBtnCountIterations = view.findViewById(R.id.btn_count_iterations);
        mBtnCountIterations.setOnClickListener(v -> countIterations());

        return view;
    }

    private void countIterations() {
        new Thread(() -> {
            long startTimestamp = System.currentTimeMillis();
            long endTimestamp = startTimestamp + ITERATIONS_COUNTER_DURATION_SEC * 1000;

            int iterationsCount = 0;
            while (System.currentTimeMillis() <= endTimestamp) {
                iterationsCount++;
            }

            Log.d(
                    "Exercise1",
                    "iterations in " + ITERATIONS_COUNTER_DURATION_SEC + "seconds: "
                            + iterationsCount
            );
        }).start();
    }
}
