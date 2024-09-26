package com.bye.ane.feature.login.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bye.ane.core.resources.Colors
import com.bye.ane.core.resources.TextStrings
import org.jetbrains.compose.resources.stringResource


@Composable
fun LoginPage(modifier: Modifier) {
    var email by mutableStateOf("")
    //

    Scaffold(
        modifier = modifier,
        content = { _ ->
            Column() {
                Spacer(modifier.height(100.dp))
                Text(
                    stringResource(TextStrings.login),
                    modifier = modifier.padding(start = 20.dp),
                    color = Colors.col_ff333333,
                    fontSize = 20.sp
                )
                Spacer(modifier.height(20.dp))
                Text(
                    stringResource(TextStrings.email_account_number),
                    modifier = modifier.padding(start = 20.dp),
                    color = Colors.col_ff333333,
                )
                Spacer(modifier.height(20.dp))
                TextField(
                    modifier = modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    placeholder = { Text(stringResource(TextStrings.email_password_hint)) },
                    singleLine = true,
                )
                Spacer(modifier.height(20.dp))
                Button(modifier = modifier
                    .padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
                    .height(40.dp),
                    onClick = {},
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Colors.col_800000ff),
                    content = { Text(stringResource(TextStrings.login)) })
            }

        }
    )
}