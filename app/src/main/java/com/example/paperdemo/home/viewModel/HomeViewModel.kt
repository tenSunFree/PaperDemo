package com.example.paperdemo.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paperdemo.home.model.HomeRepository
import com.example.paperdemo.home.model.HomeItem
import com.example.paperdemo.home.model.HomeViewState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _viewStateFlow = MutableStateFlow(HomeViewState(loading = true))
    val viewStateFlow: StateFlow<HomeViewState> = _viewStateFlow.asStateFlow()

    private var isInitData = false

    init {
        viewModelScope.launch {
            homeRepository.observeAll().collect { homeItemList ->
                _viewStateFlow.update { it.copy(homeItems = homeItemList, loading = false) }
                initData(homeItemList)
            }
        }
    }

    private suspend fun initData(homeItemList: List<HomeItem>) {
        if (homeItemList.isEmpty() && !isInitData) {
            isInitData = true
            delay(2_000)
            val list = initData()
            list.forEach {
                homeRepository.insert(it)
            }
        }
    }

    private fun initData(): MutableList<HomeItem> {
        val list = mutableListOf<HomeItem>()
        list.add(
            HomeItem(
                id = "0",
                description = "力學如力耕，勤惰爾自知；但使書種多，會有歲稔時。",
                time = 1654431549476
            )
        )
        list.add(
            HomeItem(
                id = "1",
                description = "我從書上抬起眼，已毫無陌生之感，一切都偉大。",
                time = 1653431549476
            )
        )
        list.add(
            HomeItem(
                id = "2",
                description = "讀書欲精不欲博，用心欲能不欲雜。",
                time = 1652431549476
            )
        )
        list.add(
            HomeItem(
                id = "3",
                description = "有田不耕倉廩虛，有書不教子孫愚。",
                time = 1651431549476
            )
        )
        list.add(
            HomeItem(
                id = "4",
                description = "內在的開悟，要比外在的教育更重要。",
                time = 1650431549476
            )
        )
        list.add(
            HomeItem(
                id = "5",
                description = "讀書之法，在循序而漸進，熟讀而精思。",
                time = 1648431549476
            )
        )
        list.add(
            HomeItem(
                id = "6",
                description = "讀書每得一義，如獲一真珠船。",
                time = 1645431549476
            )
        )
        list.add(
            HomeItem(
                id = "7",
                description = "讀書者不賤，守田者不飢，積德者不傾，擇交者不敗。",
                time = 1641431549476
            )
        )
        list.add(
            HomeItem(
                id = "8",
                description = "讀不在三更五鼓，功只怕一曝十寒。",
                time = 1636431549476
            )
        )
        list.add(
            HomeItem(
                id = "9",
                description = "書山有路勤為徑，學海無涯苦作舟。",
                time = 1635431549476
            )
        )
        list.add(
            HomeItem(
                id = "10",
                description = "學問勤中得，螢窗萬卷書。",
                time = 1633431549476
            )
        )
        return list
    }
}
