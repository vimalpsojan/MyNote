import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.vimal.apihelper.di.HttpModule.httpModule
import com.vimal.mynote.common.App
import com.vimal.mynote.common.di.CommonDI.commonModule
import com.vimal.mynote.di.DesktopDI.desktopModule
import org.koin.core.context.GlobalContext.startKoin

fun main() = application {
    startKoin{
        printLogger()
        modules(desktopModule,commonModule, httpModule)
    }
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}