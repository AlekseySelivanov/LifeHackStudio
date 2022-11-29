package com.example.lifehack.di.component

import com.example.lifehack.di.module.ContextModule
import com.example.lifehack.di.module.DataModule
import com.example.lifehack.di.module.DomainModule
import com.example.lifehack.di.module.PresentationModule
import com.example.lifehack.presentation.ui.MainActivity

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, DataModule::class, DomainModule::class, PresentationModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)

}