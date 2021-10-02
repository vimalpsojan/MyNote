import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.vimal.mynote.common.App
import com.vimal.uiutils.ui.theme.MyNoteTheme

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MyNoteTheme {
            App()
        }
    }
}