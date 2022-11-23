package maxmudov.farrux.roundup.ViewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import maxmudov.farrux.roundup.Model.Urls
import maxmudov.farrux.roundup.Model.modelItem
import maxmudov.farrux.roundup.Repository.Repository

class MainViewModel:ViewModel() {

    val repository=Repository()

    val sucses=MutableLiveData<List<modelItem>>()
    val error=MutableLiveData<String>()


    fun getUrls(context: Context){
        repository.getUrls(sucses, error,context)
    }

}