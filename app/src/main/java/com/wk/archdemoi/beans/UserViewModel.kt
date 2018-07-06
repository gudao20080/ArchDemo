package com.wk.archdemoi.beans

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    var name: String? = null
    var age: Int? = null

    val liveData: MutableLiveData<User>? = null
    override fun toString(): String {
        return "UserViewModel(name=$name, age=$age)"
    }


}