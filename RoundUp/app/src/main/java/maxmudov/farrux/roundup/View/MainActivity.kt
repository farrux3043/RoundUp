package maxmudov.farrux.roundup.View

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import maxmudov.farrux.roundup.Dialog.Dialog
import maxmudov.farrux.roundup.Model.cache.SaveDb
import maxmudov.farrux.roundup.ViewModel.MainViewModel
import maxmudov.farrux.roundup.utils.Constants
import maxmudov.frarux.roundup.R

import maxmudov.frarux.roundup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]

        viewModel.sucses.observe(this, Observer {
            binding.image.load(it[0].urls.small)

            val boolean=SaveDb.getDb().getsaveSaveDb()
            if(boolean) {
                loadDialog(this, it[0].urls.small)
            }

        })

        loadVidio()
        downloadVidio()
        loadBtnclick5secunt()


    }

    @SuppressLint("ResourceAsColor")
    private fun loadBtnclick5secunt() {


        binding.btnTouch1.setOnLongClickListener{
            binding.touchBtn1.visibility=View.VISIBLE
            binding.btnTouch1.setBackgroundColor(R.color.btnTouch1)

            return@setOnLongClickListener true
        }
        binding.btnTouch2.setOnLongClickListener{
            binding.btnTouch5.setBackgroundColor(R.color.btnTouch2)

            binding.touchBtn2.visibility=View.VISIBLE
            return@setOnLongClickListener true
        }
        binding.btnTouch3.setOnLongClickListener{
            binding.btnTouch3.setBackgroundColor(R.color.btnTouch3)

            binding.touchBtn3.visibility=View.VISIBLE
            return@setOnLongClickListener true
        }
        binding.btnTouch4.setOnLongClickListener{
            binding.touchBtn4.visibility=View.VISIBLE
            binding.btnTouch4.setBackgroundColor(R.color.btnTouch4)

            return@setOnLongClickListener true
        }
        binding.btnTouch5.setOnLongClickListener{
            binding.touchBtn5.visibility=View.VISIBLE
            binding.btnTouch5.setBackgroundColor(R.color.btnTouch5)
            return@setOnLongClickListener true
        }

    }

    private fun downloadVidio() {

        var myDownloaded:Long=0
        binding.yuklashCars.setOnClickListener{
            val request=DownloadManager.Request(Uri.parse(Constants.URL_VIDIO))
                .setTitle("File download.mp4")
                .setDescription("Thanks for download")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setVisibleInDownloadsUi(false)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"fileName")
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            val db=this.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            myDownloaded=db.enqueue(request)
            request.setDestinationInExternalFilesDir(this.applicationContext,"/file","mp4")


        }

        val broadcast=object :BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {

                val id =intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)

                if(id==myDownloaded){
                    Toast.makeText(this@MainActivity,"Vidio is downloading complete... ",Toast.LENGTH_SHORT).show()
                }
            }
        }

        this@MainActivity.registerReceiver(broadcast, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))

        binding.yuklashCars.setCardBackgroundColor(Color.BLUE)

    }

    private fun loadVidio() {

        binding.vidioView.setVideoURI(Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"))
        binding.vidioView.requestFocus()
        binding.vidioView.setMediaController(MediaController(this))
        binding.vidioView.setOnClickListener{
            binding.playVidio.visibility=View.GONE
            binding.vidioView.start()
        }
        loadData(this)
    }



    private fun loadDialog(context: Context, image: String) {
        val dialog=Dialog(context)
        dialog.loadDialog(context,image)

    }

    private fun loadData(context: Context) {
        viewModel.getUrls(context)
    }


}