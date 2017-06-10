package com.mobilesolutionworks.android.controller.test.nested

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mobilesolutionworks.android.controller.test.R

/**
 * Created by yunarta on 9/3/17.
 */

class RetainWorksControllerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_host_activity)
        findViewById(R.id.button).setOnClickListener {
            supportFragmentManager.beginTransaction()
                  .addToBackStack("back-stack")
                  .replace(R.id.fragment_container, EmptyWorksFragment(), "stack")
                  .commit()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                  .replace(R.id.fragment_container, RootWorksFragment(), "root")
                  .commitNow()
        }
    }
}
