package com.mobilesolutionworks.android.controller.test.util

import com.mobilesolutionworks.android.app.controller.WorksController
import com.mobilesolutionworks.android.controller.test.GetController

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull

/**
 * Created by yunarta on 12/3/17.
 */

class HostAndController<C : WorksController> @JvmOverloads constructor(private val mChangeHost: Boolean = true) {

    var controller: C? = null
        private set

    private var mHostHash: Int = 0

    private var mControllerHash: Int = 0

    fun set(host: GetController<C>) {
        assertNotNull(host)

        controller = host.controller
        assertNotNull(controller)

        mHostHash = System.identityHashCode(host)
        mControllerHash = System.identityHashCode(controller)
    }

    fun validate(host: GetController<C>) {
        assertNotNull(host)
        assertNotNull(host.controller)

        if (mChangeHost) {
            assertNotEquals("Host changed after rotation", mHostHash.toLong(), System.identityHashCode(host).toLong())
        } else {
            assertEquals("Host didn't changed after rotation", mHostHash.toLong(), System.identityHashCode(host).toLong())
        }

        assertEquals("Controller is not retain during rotation", mControllerHash.toLong(), System.identityHashCode(host.controller).toLong())
    }
}
