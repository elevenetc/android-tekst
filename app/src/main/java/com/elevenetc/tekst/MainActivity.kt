package com.elevenetc.tekst

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elevenetc.tekst.browser.BrowserFragment
import com.elevenetc.tekst.flags.FlagsManager
import com.elevenetc.tekst.flags.FlagsManager.Feature.Login
import com.elevenetc.tekst.login.ui.login.LoginFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val flagsManager: FlagsManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {

            if (flagsManager.isEnabled(Login::class.java)) {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.root_container, LoginFragment())
                    .commit()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.root_container, BrowserFragment.newInstance())
                    .commit()
            }


        }
    }
}