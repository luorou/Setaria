package com.bye.ane.feature.computing.present.slice

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bye.ane.core.resources.Colors
import com.bye.ane.feature.computing.data.resp.ComputingConfigPO
import com.bye.ane.feature.computing.present.vm.ComputingChildVM
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun ComputingChildSlice(
    label: ComputingConfigPO,
    viewModel: ComputingChildVM
) {


    val state = viewModel.collectAsState()
    val powers = label.power
    val periods = label.period
    //
    //

    Column {
        if (!powers.isNullOrEmpty()) {
            LazyRow {
                items(powers) {
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Colors.col_ff9013fe,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
                    ) {
                        Text("${it}张")
                    }
                }
            }
        }
        if (!periods.isNullOrEmpty()) {
            LazyRow {
                items(periods) {
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Colors.col_ff9013fe,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
                    ) {
                        Text("${it}天")
                    }

                }
            }
        }
        //
        if (state.value.products.isNotEmpty()) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(state.value.products) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = Colors.col_ff9013fe,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)

                    ) {
                        Column {
                            Text("${it.name}")
                            Text(buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 16.sp
                                    )
                                ) {
                                    append("等效为")
                                }
                                withStyle(style = SpanStyle(color = Color.Blue, fontSize = 12.sp)) {
                                    append(it.power.toString())
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                ) {
                                    append("张")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                ) {
                                    append(it.powerUnit)
                                }
                            })
                        }
                    }
                }
            }
        }

    }

}