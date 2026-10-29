package vivacasa.mwviora.hubapp

import android.app.Application
import vivacasa.mwviora.hubapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class VAVHPApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@VAVHPApplication)
            modules(appModules)
        }
    }
}