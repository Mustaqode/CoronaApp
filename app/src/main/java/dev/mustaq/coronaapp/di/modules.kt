package dev.mustaq.coronaapp.di

import dev.mustaq.coronaapp.network.Rest
import dev.mustaq.coronaapp.network.RestService
import dev.mustaq.coronaapp.repository.CoronaRepository
import dev.mustaq.coronaapp.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mustaq Sameer on 02/06/20
 */

val commonModules = module {
    single { RestService(get()) }
    single { Rest.service }
    factory { CoronaRepository(get()) }
}

val viewModelModules = module {
    viewModel { MainViewModel(get()) }
}

val appModules = commonModules + viewModelModules
