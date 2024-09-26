package com.bye.ane.feature.index.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationTab>,
    pagerState: PagerState,
    onItemSelected: ((selectedIndex: Int) -> Unit)
) {

    BottomNavigation(backgroundColor = Color.White) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    BottomNavigationBarItemIcon(
                        item.selectIcon,
                        if (pagerState.currentPage == index) item.selectLabelColor else item.unSelectLabelColor
                    )
                },
                label = {
                    BottomNavigationBarItemLabel(
                        item.title,
                        if (pagerState.currentPage == index) item.selectLabelColor else item.unSelectLabelColor
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    onItemSelected.invoke(index)
                },
                alwaysShowLabel = true
            )
        }
    }

}


@Composable
fun BottomNavigationBarItemIcon(resource: DrawableResource, tint: Color) {
    Icon(
        imageResource(resource),
        null,
        modifier = Modifier.size(22.dp),
        tint = tint
    )
}

@Composable
fun BottomNavigationBarItemLabel(text: String, color: Color) {
    Text(
        text,
        color = color,
        fontSize = 12.sp
    )
}

data class BottomNavigationTab(
    val title: String,
    val unSelectLabelColor: Color,
    val selectLabelColor: Color,
    val selectIcon: DrawableResource,
)

