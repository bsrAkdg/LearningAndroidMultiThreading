package com.bsrakdg.multithreadingsamples.common;

import com.bsrakdg.multithreadingsamples.home.HomeFragment;
import com.techyourchance.fragmenthelper.FragmentHelper;

public class ScreensNavigator {

    private final FragmentHelper mFragmentHelper;

    public ScreensNavigator(FragmentHelper fragmentHelper) {
        mFragmentHelper = fragmentHelper;
    }

    public void navigateBack() {
        mFragmentHelper.navigateBack();
    }

    public void navigateUp() {
        mFragmentHelper.navigateUp();
    }

    public void toAtomicityDemonstration() {
        //mFragmentHelper.replaceFragment(AtomicityDemonstrationFragment.newInstance());
    }

    public void toCustomHandlerDemonstration() {
        //mFragmentHelper.replaceFragment(CustomHandlerDemonstrationFragment.newInstance());
    }

    public void toDesignWithAsyncTaskDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithAsyncTaskDemonstrationFragment.newInstance());
    }

    public void toDesignWithCoroutinesDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithCoroutinesDemonstrationFragment.Companion
        // .newInstance());
    }

    public void toDesignWithRxJavaDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithRxJavaDemonstrationFragment.newInstance());
    }

    public void toDesignWithThreadPoolDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithThreadPoolDemonstrationFragment.newInstance());
    }

    public void toDesignWithThreadsDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithThreadsDemonstrationFragment.newInstance());
    }

    public void toExercise10Screen() {
        //mFragmentHelper.replaceFragment(Exercise10Fragment.Companion.newInstance());
    }

    public void toExercise1Screen() {
       // mFragmentHelper.replaceFragment(Exercise1Fragment.newInstance());
    }

    public void toExercise2Screen() {
        //mFragmentHelper.replaceFragment(Exercise2Fragment.newInstance());
    }

    public void toExercise3Screen() {
        //mFragmentHelper.replaceFragment(Exercise3Fragment.newInstance());
    }

    public void toExercise4Screen() {
        //mFragmentHelper.replaceFragment(Exercise4Fragment.newInstance());
    }

    public void toExercise5Screen() {
        //mFragmentHelper.replaceFragment(Exercise5Fragment.newInstance());
    }

    public void toExercise6Screen() {
        //mFragmentHelper.replaceFragment(Exercise6Fragment.newInstance());
    }

    public void toExercise7Screen() {
        //mFragmentHelper.replaceFragment(Exercise7Fragment.newInstance());
    }

    public void toExercise8Screen() {
        //mFragmentHelper.replaceFragment(Exercise8Fragment.newInstance());
    }

    public void toExercise9Screen() {
        //mFragmentHelper.replaceFragment(Exercise9Fragment.newInstance());
    }

    public void toHomeScreen() {
        mFragmentHelper.replaceFragmentAndClearHistory(HomeFragment.newInstance());
    }

    public void toThreadPosterDemonstration() {
        //mFragmentHelper.replaceFragment(DesignWithThreadPosterDemonstrationFragment.newInstance
        // ());
    }

    public void toThreadWaitDemonstration() {
        //mFragmentHelper.replaceFragment(ThreadWaitDemonstrationFragment.newInstance());
    }

    public void toUiHandlerDemonstration() {
        //mFragmentHelper.replaceFragment(UiHandlerDemonstrationFragment.newInstance());
    }

    public void toUiThreadDemonstration() {
        //mFragmentHelper.replaceFragment(UiThreadDemonstrationFragment.newInstance());
    }
}
