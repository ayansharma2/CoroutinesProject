package com.example.customgallerypicker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.customgallerypicker.databinding.MainActivityBinding
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.attribute.AclEntry.newBuilder


class MainActivity : AppCompatActivity() {
    private val address="https://jsonplaceholder.typicode.com/posts"
    lateinit var binding:MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var data:String
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        lifecycleScope.launch {
            getData()
        }
    }



    private suspend fun getData() {
        //val url=URL(address)
        withContext(Dispatchers.IO){
            val data=URL(address).readText()
            Log.i("Data", data)
            val gson=Gson()
            val Model= gson.fromJson(data,Array<DummyObject>::class.java).toList()
            runOnUiThread {
                binding.recyclerView.adapter=Adapter(Model);
            }
        }
    }
}