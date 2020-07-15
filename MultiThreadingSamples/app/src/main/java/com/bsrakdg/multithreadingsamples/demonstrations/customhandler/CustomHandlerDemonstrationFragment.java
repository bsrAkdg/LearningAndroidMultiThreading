package com.bsrakdg.multithreadingsamples.demonstrations.customhandler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bsrakdg.multithreadingsamples.R;
import com.bsrakdg.multithreadingsamples.common.BaseFragment;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


@SuppressLint("SetTextI18n")
public class CustomHandlerDemonstrationFragment extends BaseFragment {

    private static final int SECONDS_TO_COUNT = 5;

    public static Fragment newInstance() {
        return new CustomHandlerDemonstrationFragment();
    }

    private CustomHandler mCustomHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_looper_demonstration, container, false);

        Button mBtnSendJob = view.findViewById(R.id.btn_send_job);
        mBtnSendJob.setOnClickListener(v -> sendJob());

        return view;
    }

    @Override
    protected String getScreenTitle() {
        return "";
    }

    @Override
    public void onStart() {
        super.onStart();
        mCustomHandler = new CustomHandler();
    }

    @Override
    public void onStop() {
        super.onStop();
        mCustomHandler.stop();
    }

    // User clicks on send job button multiple times We want to send multiple jobs.
    // Execute all of them one by one. Execute on same thread sequentially
    private void sendJob() {
        mCustomHandler.post(() -> {
            for (int i=0; i < SECONDS_TO_COUNT; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                Log.d("CustomHandler", "iteration: " + i);
            }
        });
    }

    private class CustomHandler {

        private final Runnable POISON = new Runnable() {
            @Override
            public void run() {}
        };

        private final BlockingQueue<Runnable> mQueue = new LinkedBlockingQueue<>();

        CustomHandler() {
            initWorkerThread();
        }

        private void initWorkerThread() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.d("CustomHandler", "worker (looper) thread initialized");
                    while (true) {
                        Runnable runnable;
                        try {
                            runnable = mQueue.take();
                        } catch (InterruptedException e) {
                            return;
                        }
                        if (runnable == POISON) {
                            Log.d("CustomHandler", "poison data detected; stopping working thread");
                            return;
                        }
                        runnable.run();
                    }
                }
            }).start();
        }

        void stop() {
            Log.d("CustomHandler", "injecting poison data into the queue");
            mQueue.clear(); //  threads that not worked yet
            mQueue.add(POISON);
        }

        void post(Runnable job) {
            mQueue.add(job);
        }
    }
}
