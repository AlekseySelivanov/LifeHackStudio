package com.example.lifehack.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifehack.LifeHackApp
import com.example.lifehack.R
import com.example.lifehack.presentation.ui.screens.CompanyListFragment
import com.example.lifehack.presentation.viewmodel.CompanyViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: CompanyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        LifeHackApp.component.injectMainActivity(this)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, CompanyListFragment.newInstance())
                .addToBackStack(CompanyListFragment::class.java.name)
                .commit()
        }
    }
    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if (fragment is CompanyListFragment) {
            finishAffinity()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}