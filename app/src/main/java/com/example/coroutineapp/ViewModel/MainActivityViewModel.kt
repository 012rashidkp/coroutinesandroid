package com.example.coroutineapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineapp.Network.RetroInstance
import com.example.coroutineapp.Network.RetroService
import com.example.hiltdagger.Model.RecyclerList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    lateinit var recyclerListLiveData : MutableLiveData<RecyclerList>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<RecyclerList> {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response  = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}