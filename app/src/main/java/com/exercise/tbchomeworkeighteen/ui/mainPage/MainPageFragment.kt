package com.exercise.tbchomeworkeighteen.ui.mainPage

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.exercise.tbchomeworkeighteen.ui.baseFragment.BaseFragment
import com.exercise.tbchomeworkeighteen.data.adapter.MainPageAdapter
import com.exercise.tbchomeworkeighteen.databinding.FragmentMainPageBinding
import kotlinx.coroutines.launch

class MainPageFragment : BaseFragment<FragmentMainPageBinding>(FragmentMainPageBinding::inflate) {
    private lateinit var mainPageAdapter: MainPageAdapter
    private val viewModel: MainPageViewModel by viewModels()

    override fun setUp() {
        prepareRecyclerView()
        observeData()
    }

    private fun prepareRecyclerView() {
        mainPageAdapter = MainPageAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = mainPageAdapter
        }
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.users.collect { pagingData ->
                mainPageAdapter.submitData(pagingData)
            }
        }
    }
}