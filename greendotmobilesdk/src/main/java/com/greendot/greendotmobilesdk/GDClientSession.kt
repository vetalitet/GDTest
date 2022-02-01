package com.greendot.greendotmobilesdk

import android.app.Activity
import androidx.fragment.app.Fragment
import com.greendot.greendotmobilesdk.ui.GDSdkActivity
import com.greendot.greendotmobilesdk.ui.GDSdkFragment

class GDClientSession(var state: GDSessionState = GDSessionState.UNKNOWN) {

    fun createRootFragmentWithOptions(): Fragment {
        return GDSdkFragment()
    }
    fun createRootActivityWithOptions(): Activity {
        return GDSdkActivity()
    }

}
