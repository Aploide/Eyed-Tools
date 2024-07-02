package de.aploi.eyedtools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import de.aploi.eyedtools.ui.theme.EyedToolsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EyedToolsTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ){
                    PWGen()
                }
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun Preview() {
    EyedToolsTheme{
        Surface(
            color = MaterialTheme.colorScheme.background
        ){
            PWGen()
        }
    }
}

