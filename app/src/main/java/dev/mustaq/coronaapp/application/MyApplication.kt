package dev.mustaq.coronaapp.application

import android.app.Application
import dev.mustaq.coronaapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Mustaq Sameer on 02/06/20
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@MyApplication)
            modules(appModules)
        }
    }

}