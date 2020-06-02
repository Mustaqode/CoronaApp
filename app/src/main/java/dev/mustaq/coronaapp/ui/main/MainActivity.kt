package dev.mustaq.coronaapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import dev.mustaq.coronaapp.R
import dev.mustaq.coronaapp.models.CoronaStatsModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getCoronaStat()
        setupUi()
    }

    private fun setupUi() {
        mainViewModel.coronaStats.observe(this, Observer { showCoronaStats })
        mainViewModel.error.observe(this, Observer { showToast })
    }

    private val showCoronaStats: (CoronaStatsModel) -> Unit = { stats ->
        uiTvTotal.text = stats.global.totalConfirmed.toString()
        uiTvCure.text = stats.global.totalRecovered.toString()
        uiTvDeath.text = stats.global.totalDeaths.toString()
    }

    private val showToast: (String) -> Unit = { error ->
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}
