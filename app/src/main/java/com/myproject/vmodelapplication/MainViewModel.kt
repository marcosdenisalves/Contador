package com.myproject.vmodelapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var mainCount = MutableLiveData<String>().apply { value = count.toString() }
    private var count: Int = 0

    private fun setMainCount() {
        mainCount.value = count.toString()
    }

    private fun validateCount() {
        count++
        if (count > 10)
            count = 0

        setMainCount()
    }

    fun count() {
        validateCount()
    }
}