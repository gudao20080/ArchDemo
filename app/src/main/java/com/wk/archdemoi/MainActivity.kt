package com.wk.archdemoi

import android.arch.core.util.Function
import android.arch.lifecycle.*
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebView
import com.wk.archdemoi.beans.User
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_go_second.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
//        val userViewModel = ViewModelProviders.of(this).get(User::class.java)
//        val lifecycleRegistry = LifecycleRegistry(this)
//        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        val s = MutableLiveData<String>()

        val mapLiveData = Transformations.map(s) { input -> "transform $input" }
//        s.value = "kai"
        s.value = null
        mapLiveData.observe(this, Observer {
            Log.d("way", "observeForever $it")
        })

//        s.observe(this, object : Observer<String> {
//            override fun onChanged(t: String?) {
//                Log.d("way", "onCreate, $t")
//
//            }
//        } )


//        s.value = "wangkai"
//        lifecycle.addObserver()

        Thread(Runnable {
            while (true) {
                i++
                s.postValue(i.toString())
//                Log.d("way", "Thread, $i")
                Thread.sleep(1000)
            }
        }).start()


//        Thread(object : Runnable {
//            override fun run() {
//
//            }
//        }).run()


//        val timerTask = object : TimerTask() {
//            override fun run() {
//                s.postValue(i.toString())
//                i ++
//            }
//        }
//
//        Timer().schedule(timerTask, 1000, 1000)


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
