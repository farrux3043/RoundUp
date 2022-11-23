package maxmudov.farrux.roundup.Repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver

import io.reactivex.rxjava3.schedulers.Schedulers
import maxmudov.farrux.roundup.Model.model

import maxmudov.farrux.roundup.Model.modelItem
import maxmudov.farrux.roundup.Network.NetworkConnection
import maxmudov.frarux.roundup.R



class Repository() {

    fun getUrls(sucses:MutableLiveData<List<modelItem>>, error: MutableLiveData<String>, context: Context) {
        NetworkConnection.getApi(context).getPhotos(context.getString(R.string.API_KEY))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<model>() {
                override fun onNext(t: model) {
                   sucses.value=t
                }

                override fun onError(e: Throwable) {
                    error.value=e.localizedMessage
                }

                override fun onComplete() {

                }
            })

    }
}


