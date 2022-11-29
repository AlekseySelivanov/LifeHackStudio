package com.example.lifehack

import android.app.Application
import com.example.lifehack.di.component.AppComponent
import com.example.lifehack.di.component.DaggerAppComponent
import com.example.lifehack.di.module.ContextModule

class LifeHackApp : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component =
            DaggerAppComponent.builder().contextModule(ContextModule(this.applicationContext))
                .build()
    }
}
