package com.mobilesolutionworks.android.app.test.nested;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yunarta on 9/3/17.
 */

public class RootWorksFragment extends EmptyWorksFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction()
                    .add(new ChildWorksFragment(), "child")
                    .commit();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView id = (TextView) view.findViewById(com.mobilesolutionworks.android.app.test.R.id.textView);
        id.setText("child");
    }

}