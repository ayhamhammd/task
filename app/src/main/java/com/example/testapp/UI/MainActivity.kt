package com.example.testapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.R
import com.example.testapp.repository.ApiRepository

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository=ApiRepository()
        val viewModelProviderFactory=ViewModelProviderFactory(repository)
        viewModel=ViewModelProvider(this,viewModelProviderFactory)
            .get(MainActivityViewModel::class.java)
    }
}