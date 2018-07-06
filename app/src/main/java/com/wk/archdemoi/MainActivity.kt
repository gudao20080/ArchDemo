package com.wk.archdemoi

import android.arch.lifecycle.*
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebView
import com.wk.archdemoi.beans.User

class MainActivity : AppCompatActivity() {

    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val userViewModel = ViewModelProviders.of(this).get(User::class.java)
        val lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        val s = MutableLiveData<String>()
        s.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.d("way", "onCreate")
            }
        })

        Thread(Runnable {
            while (true) {
                i ++
                s.postValue(i.toString())
                Thread.sleep(500)
            }
        }).run()


//        lifecycle.addObserver(
//                object : DefaultLifecycleObserver {
//                    override fun onCreate(owner: LifecycleOwner) {
//                        Log.d("way", "onCreate")
//                    }
//
//                    override fun onResume(owner: LifecycleOwner) {
//                        Log.d("way", "onResume")
//                    }
//
//                    override fun onPause(owner: LifecycleOwner) {
//                        Log.d("way", "onPause")
//                    }
//
//                    override fun onStart(owner: LifecycleOwner) {
//                         Log.d("way", "onStart")
//                    }
//
//                    override fun onStop(owner: LifecycleOwner) {
//                         Log.d("way", "onStop")
//                    }
//
//                    override fun onDestroy(owner: LifecycleOwner) {
//                         Log.d("way", "onDestroy")
//                    }
//                })


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}
