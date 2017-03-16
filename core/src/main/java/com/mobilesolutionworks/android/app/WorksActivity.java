package com.mobilesolutionworks.android.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mobilesolutionworks.android.app.controller.WorksControllerManager;

/**
 * Activity host for WorksController.
 * <p>
 * Created by yunarta on 19/11/15.
 */
public class WorksActivity extends AppCompatActivity implements WorkControllerHost {

    /**
     * Controller manager.
     */
    private WorksControllerManager mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WorksControllerManager.Loader loader = (WorksControllerManager.Loader) getSupportLoaderManager().initLoader(0, null, new WorksControllerManager.LoaderCallbacks(this));
        mController = loader.getController();
    }

    /**
     * Get controller manager to create individual controller.
     *
     * @return controller manager.
     */
    @Override
    @NonNull
    public WorksControllerManager getControllerManager() {
        return mController;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mController.getLifecycleHook().onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mController.getLifecycleHook().onConfigurationChanged(newConfig);
    }

    @Override
    public void onResume() {
        super.onResume();
        mController.getLifecycleHook().dispatchResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mController.getLifecycleHook().dispatchPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mController.getLifecycleHook().dispatchSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }
}
