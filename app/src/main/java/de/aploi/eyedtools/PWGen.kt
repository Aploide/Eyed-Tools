package de.aploi.eyedtools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.aploi.eyedtools.ui.theme.EyedToolsTheme

@Composable
fun PWGen() {
    val context = LocalContext.current

    Column (
        Modifier
            .fillMaxSize()
            .padding(horizontal = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        var password by remember { mutableStateOf(" ") }
        var length by remember { mutableStateOf(16.0f)}
        var want_numb by remember {mutableStateOf(true)}
        var want_symb by remember {mutableStateOf(true) }

        Text(
            text = password,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 20.sp,
            softWrap = true
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 15.dp)
                .semantics { contentDescription = "Generate password" },
            horizontalArrangement = Arrangement.Center // Center the elements horizontally
        ) {

            Button(onClick = { password = generatePassword(length, want_symb, want_numb) },
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .semantics { contentDescription = "Generate password" }
            ) {
                Text(text = "generate")
            }

            Button(onClick = { copyToClipboard(context, password) },
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .semantics { contentDescription = "Copy password" },
                enabled = (password != " ")
            ) {
                Text(text = "copy")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Complexity:", textAlign = TextAlign.Left, )
            Slider(
                value = length,
                onValueChange = { length = it },
                steps = 40,
                valueRange = 5f..45f,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .semantics {contentDescription = "Password complexity slider"}
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Include symbols:", textAlign = TextAlign.Left, )
            Switch(checked = want_symb,
                onCheckedChange = {want_symb = it},
                modifier = Modifier
                    .semantics { contentDescription = if (want_symb) "Symbols included" else "Symbols not included" }
                )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Include numbers:", textAlign = TextAlign.Left, )
            Switch(checked = want_numb,
                onCheckedChange = {want_numb = it},
                modifier = Modifier
                    .semantics { contentDescription = if (want_numb) "Numbers included" else "Numbers not included" }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ToolPreview() {
    EyedToolsTheme{
        Surface(
            color = MaterialTheme.colorScheme.background
        ){
            PWGen()
        }
    }
}
