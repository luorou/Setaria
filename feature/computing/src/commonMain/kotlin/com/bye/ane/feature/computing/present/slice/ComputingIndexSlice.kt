package com.bye.ane.feature.computing.present.slice

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bye.ane.core.network.Colors
import com.bye.ane.feature.computing.data.resp.ComputingConfigPO
import com.bye.ane.feature.computing.present.ComputingChildSliceRoute
import com.bye.ane.feature.computing.present.vm.ComputingIndexVM
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.compose.collectAsState


@Composable
fun ComputingIndexSlice(
    navController: NavHostController,
    viewModel: ComputingIndexVM,
    calculateTopPadding: Dp
) {


    Column() {
        Box(modifier = Modifier.height(calculateTopPadding.value.dp))
        TopBar()
        Banner()
        TabAndContent(viewModel)
    }
}


@Composable
private fun TopBar() {

}

@Composable
private fun Banner() {

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TabAndContent(viewModel: ComputingIndexVM) {
    val state = viewModel.collectAsState()
    if (state.value.tabs.isEmpty()) {
        return
    }
    //
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { state.value.tabs.size },
    )
    //
    Column(Modifier.fillMaxWidth()) {
        ScrollableTabLayout(state.value.tabs, pagerState)
        HorizontalPager(
            beyondBoundsPageCount = state.value.tabs.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
        ) { pagePosition ->
            val label = state.value.tabs[pagePosition]
            ComputingChildSliceRoute(label)
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollableTabLayout(tabs: List<ComputingConfigPO>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        containerColor = Color.Transparent,
        selectedTabIndex = pagerState.currentPage,
        modifier = Modifier.fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        divider = { HorizontalDivider(thickness = 0.dp) },
    ) {
        tabs.forEachIndexed { index, item ->
            Tab(
                selected = pagerState.currentPage == index,
                selectedContentColor = Color.Blue,
                unselectedContentColor = Colors.col_ff333333,
                onClick = {
                    scope.launch {
                        pagerState.scrollToPage(index, 0f)
                    }
                },
                text = { Text(text = item.coinTypeLabel.toString()) })
        }
    }
}