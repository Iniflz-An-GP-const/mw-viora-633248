package vivacasa.mwviora.hubapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import vivacasa.mwviora.hubapp.ui.composable.approot.AppRoot
import vivacasa.mwviora.hubapp.ui.theme.VAVHPAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VAVHPAppTheme {
                AppRoot()
            }
        }
    }
}
