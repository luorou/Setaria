package com.bye.ane.core.index

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bye.ane.core.index.page.IndexPage

@Composable
fun IndexPageRoute(onBackClick: () -> Unit) {
    IndexPage(modifier = Modifier)
}