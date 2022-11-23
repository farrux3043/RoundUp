package maxmudov.farrux.roundup.Model.cache

import android.content.Context
import android.content.SharedPreferences

class SaveDb() {
    companion object {
        private lateinit  var db: SaveDb
        lateinit var sharedPreferences: SharedPreferences



        fun init(context: Context) {
            db=SaveDb()
        sharedPreferences = context.getSharedPreferences("prefs", 0)
    }


       fun getDb():SaveDb{
            return db
        }
    }



    fun saveSaveDb(){
        sharedPreferences.edit().putBoolean("firstStart", false).apply()
    }
    fun getsaveSaveDb(): Boolean {
      return sharedPreferences.getBoolean("firstStart",true)
    }





}