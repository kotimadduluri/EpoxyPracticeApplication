package com.koti.epoxypracticeapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.koti.epoxypracticeapplication.R
import com.koti.epoxypracticeapplication.dto.CarouselItem
import com.koti.epoxypracticeapplication.dto.Task

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val tasks = listOf(
        Task("id1", "Audio & Video", 4, R.drawable.bg_badge),
        Task("id2", "Updating", 8,R.drawable.bg_badge2),
        Task("id3", "Drink and food", 2,R.drawable.bg_badge3),
        Task("id4", "Security", 4,R.drawable.bg_badge),
        Task("id5", "Dark theme     ", 6,R.drawable.bg_badge2),
    )

    val carouselItems = listOf(
        CarouselItem("id11", "Event problems", "Call issue center"),
        CarouselItem("id21", "Emergency", "Call policy"),
        CarouselItem("id31", "Tassk 4", "Call google"),
    )

}