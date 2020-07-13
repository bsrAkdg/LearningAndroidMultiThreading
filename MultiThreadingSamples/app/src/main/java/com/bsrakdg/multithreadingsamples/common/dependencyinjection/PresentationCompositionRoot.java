package com.bsrakdg.multithreadingsamples.common.dependencyinjection;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.techyourchance.fragmenthelper.FragmentContainerWrapper;
import com.techyourchance.fragmenthelper.FragmentHelper;
import com.bsrakdg.multithreadingsamples.common.ToolbarManipulator;
import com.bsrakdg.multithreadingsamples.common.ScreensNavigator;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import androidx.fragment.app.FragmentActivity;

public class PresentationCompositionRoot {

    private final FragmentActivity mActivity;
    private final ApplicationCompositionRoot mApplicationCompositionRoot;

    public PresentationCompositionRoot(FragmentActivity activity, ApplicationCompositionRoot applicationCompositionRoot) {
        mActivity = activity;
        mApplicationCompositionRoot = applicationCompositionRoot;
    }

    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getFragmentHelper());
    }

    private FragmentHelper getFragmentHelper() {
        return new FragmentHelper(mActivity, getFragmentContainerWrapper(), mActivity.getSupportFragmentManager());
    }

    private FragmentContainerWrapper getFragmentContainerWrapper() {
        return (FragmentContainerWrapper) mActivity;
    }

    public ToolbarManipulator getToolbarManipulator() {
        return (ToolbarManipulator) mActivity;
    }

    public Handler getUiHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public ThreadPoolExecutor getThreadPool() {
        return mApplicationCompositionRoot.getThreadPool();
    }
}
