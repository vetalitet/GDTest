package com.greendot.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.greendot.greendotmobilesdk.*

class MainActivity : AppCompatActivity(), GDMobileClientDelegate {

    private var session: GDClientSession? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GDMobileClient.client(
            configuration = GDConfiguration(
                appId = "id",
                accessKey = "key",
                properties = HashMap()
            ),
            delegate = this,
            completion = object : GreenDotMobileClientCompletion {
                override fun invoke(result: GDResult, mobileClient: GDMobileClient?) {

                }
            }
        )

        findViewById<Button>(R.id.btnRunSdk).setOnClickListener {
            val activity = session?.createRootActivityWithOptions()
            activity?.let {
                startActivity(Intent(this, activity::class.java))
            }
        }
    }

    override fun mobileClient(client: GDMobileClient, error: Exception) {

    }

    override fun mobileClient(client: GDMobileClient, stateUpdated: GDState) {

    }

    override fun mobileClient(client: GDMobileClient, session: GDClientSession) {
        this.session = session
    }

}
