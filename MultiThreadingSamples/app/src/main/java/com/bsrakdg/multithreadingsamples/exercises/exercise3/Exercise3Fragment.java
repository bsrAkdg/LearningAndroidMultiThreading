package com.bsrakdg.multithreadingsamples.exercises.exercise3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bsrakdg.multithreadingsamples.R;
import com.bsrakdg.multithreadingsamples.common.BaseFragment;

public class Exercise3Fragment extends BaseFragment {

    private static final int SECONDS_TO_COUNT = 3;

    public static Fragment newInstance() {
        return new Exercise3Fragment();
    }

    private Button mBtnCountSeconds;
    private TextView mTxtCount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_3, container, false);

        mBtnCountSeconds = view.findViewById(R.id.btn_count_seconds);
        mTxtCount = view.findViewById(R.id.txt_count);

        mBtnCountSeconds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countIterations();
            }
        });

        return view;
    }

    @Override
    protected String getScreenTitle() {
        return "Exercise 3";
    }

    private void countIterations() {
        /*
            1. Disable button to prevent multiple clicks
            2. Start counting on background thread using loop and Thread.sleep()
            3. Show count in TextView
            4. When count completes, show "done" in TextView and enable the button
        */
        mBtnCountSeconds.setEnabled(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i= 0; i<SECONDS_TO_COUNT; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return;
                    }

                    final int count = i + 1;
                    new Handler(Looper.getMainLooper()).post(() -> mTxtCount.setText("Count : " + count));
                }
                new Handler(Looper.getMainLooper()).post(() -> {
                    mTxtCount.setText("Done!");
                    mBtnCountSeconds.setEnabled(true);
                });
            }
        }).start();

    }
}
