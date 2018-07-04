package com.wk.archdemoi

import android.arch.lifecycle.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.wk.archdemoi.beans.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val liveData = MutableLiveData<User>()
//        val userObserver = Observer<User> { t -> Log.d("way", t.toString()) }


        val userViewModel = ViewModelProviders.of(this).get(User::class.java)
        LifecycleRegistry(this).addObserver(userViewModel)

    }
}
