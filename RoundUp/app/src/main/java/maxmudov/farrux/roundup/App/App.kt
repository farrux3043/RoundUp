package maxmudov.farrux.roundup.App

import android.app.Application
import maxmudov.farrux.roundup.Model.cache.SaveDb

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        SaveDb.init(this)
    }

}