package com.mobilesolutionworks.android.app.test.works;

import com.mobilesolutionworks.android.app.controller.WorksController;

/**
 * Created by yunarta on 12/3/17.
 */

public interface GetController<C extends WorksController> {

    C getController();
}