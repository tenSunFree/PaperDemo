package com.example.paperdemo.home.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.paperdemo.R
import com.example.paperdemo.common.component.VerticalSpacer
import com.example.paperdemo.home.model.HomeItem
import com.example.paperdemo.common.util.gridTrim
import com.example.paperdemo.common.util.timeAgoInSeconds
import com.example.paperdemo.home.model.HomeViewState

@ExperimentalMaterialApi
@Composable
fun HomeContentComponent(
    homeViewState: HomeViewState,
    scrollState: LazyListState = rememberLazyListState(),
    padding: PaddingValues,
) {
    val modifier = Modifier
        .padding(padding)
    Column {
        LazyColumn(
            modifier = modifier
                .width(600.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally), state = scrollState
        ) {
            itemsIndexed(homeViewState.homeItems) { _, element ->
                HomeColumnItem(element)
            }
        }
        if (homeViewState.isEmpty) {
            Image(
                painter = painterResource(id = R.drawable.ic_not_found),
                contentDescription = stringResource(
                    id = R.string.image_desc
                ),
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(60.dp)
                    .fillMaxSize()
                    .weight(1f, true)
                    .imePadding()
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun HomeColumnItem(item: HomeItem) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp),
        shape = RoundedCornerShape(10),
        elevation = 0.dp,
        onClick = {
            Toast.makeText(context, item.description, Toast.LENGTH_SHORT).show()
        },
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = item.description.trim().gridTrim(),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body1,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            VerticalSpacer(7.dp)
            Text(
                text = item.time.timeAgoInSeconds(),
                color = MaterialTheme.colors.primaryVariant,
                style = MaterialTheme.typography.caption
            )
        }
    }
}