package com.mobilesolutionworks.android.app.test.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yunarta on 12/3/17.
 */
public class ResumeLatch implements Application.ActivityLifecycleCallbacks {

    private CountDownLatch mLatch;

    public ResumeLatch() {
        mLatch = new CountDownLatch(1);
    }

    public void await() throws InterruptedException {
        mLatch.await();
        reset();
    }
    public void reset() {
        mLatch = new CountDownLatch(1);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        mLatch.countDown();
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
