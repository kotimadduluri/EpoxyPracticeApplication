package com.koti.epoxypracticeapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.carousel
import com.koti.epoxypracticeapplication.TaskCarouselBindingModel_
import com.koti.epoxypracticeapplication.databinding.FragmentHomeBinding
import com.koti.epoxypracticeapplication.task
import com.koti.epoxypracticeapplication.title

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var homeViewModel:HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupPage()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupPage() {
        binding.rvTask.withModels {
            //first title
            title {
                id("title-id")
                title("First Title")
            }

            //carousel item
            val carouselItemModels = homeViewModel.carouselItems.map {
                TaskCarouselBindingModel_()
                    .id(it.id)
                    .carouselItem(it)
                    .clickListener { _ ->

                    }
            }

            //carousel
            // This extension function come with epoxy
            carousel {
                id("car")
                models(carouselItemModels)
            }

            // Task title
            // item_title.xml
            title {
                id("title-id")
                title("Second Title")
            }

            // Tasks
            homeViewModel.tasks.forEach { currentTask ->
                // item_task.xml
                task {
                    id(currentTask.id)
                    task(currentTask)
                    clickListener { v ->

                    }

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}