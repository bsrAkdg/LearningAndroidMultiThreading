package com.bsrakdg.multithreadingsamples;

import static kotlinx.coroutines.DispatchersKt.IO_PARALLELISM_PROPERTY_NAME;

import android.app.Application;

import com.bsrakdg.multithreadingsamples.common.dependencyinjection.ApplicationCompositionRoot;

public class MyApplication extends Application {

    private final ApplicationCompositionRoot mApplicationCompositionRoot =
            new ApplicationCompositionRoot();

    public ApplicationCompositionRoot getApplicationCompositionRoot() {
        return mApplicationCompositionRoot;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.setProperty(IO_PARALLELISM_PROPERTY_NAME, String.valueOf(Integer.MAX_VALUE));
    }
}
