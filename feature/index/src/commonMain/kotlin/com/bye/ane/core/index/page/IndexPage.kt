package com.bye.ane.core.index.page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bye.ane.core.index.widget.BottomNavigationBar
import com.bye.ane.core.index.widget.BottomNavigationTab
import com.bye.ane.core.network.Colors
import com.bye.ane.core.network.PngImages
import kotlinx.coroutines.launch

private val bottomNavigationItems = listOf(
    BottomNavigationTab(
        "home",
        Colors.col_ff333333,
        Colors.col_ff9013fe,
        PngImages.bottom_tab_home
    ),
    BottomNavigationTab(
        "news",
        Color.Black,
        Colors.col_ff9013fe,
        PngImages.bottom_tab_newspaper,
    ),
    BottomNavigationTab(
        "mall",
        Color.Black,
        Colors.col_ff9013fe,
        PngImages.bottom_tab_mall,
    ),
    BottomNavigationTab(
        "mine",
        Color.Black,
        Colors.col_ff9013fe,
        PngImages.bottom_tab_user,
    ),
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IndexPage(modifier: Modifier) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 4 },
    )
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavigationItems,
                pagerState = pagerState,
                onItemSelected = {
                    scope.launch {
                        pagerState.scrollToPage(it, 0f)
                    }
                },
            )
        },
        content = { paddingValues ->
            HorizontalPager(
                state = pagerState,
                userScrollEnabled = false,
                modifier = modifier.padding(paddingValues),
                beyondBoundsPageCount = 5
            ) { pagePosition ->
                when (pagePosition) {
//                    0 -> NewsIndexRoute()
//                    1 -> MallIndexRoute()
//                    2 -> MineScreen()
                }
            }
        }
    )
}