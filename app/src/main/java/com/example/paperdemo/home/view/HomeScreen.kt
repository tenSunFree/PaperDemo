package com.example.paperdemo.home.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.paperdemo.home.viewModel.HomeViewModel
import org.koin.androidx.compose.inject

@ExperimentalMaterialApi
@Composable
fun HomeScreen(scrollState: LazyListState) {
    val viewModel by inject<HomeViewModel>()
    val viewStateFlow by viewModel.viewStateFlow.collectAsState()
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding(),
        topBar = {
            Spacer(modifier = Modifier.statusBarsPadding())
        },
        content = { paddingValues ->
            HomeContentComponent(
                viewStateFlow,
                scrollState,
                paddingValues,
            )
        },
    )
}