package maxmudov.farrux.roundup.Dialog

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri


import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import coil.load
import maxmudov.farrux.roundup.Model.cache.SaveDb
import maxmudov.farrux.roundup.utils.Constants
import maxmudov.frarux.roundup.R


class Dialog(context: Context?) : AlertDialog(context) {

     fun loadDialog(context: Context, image: String) {
        val dialogBinding = layoutInflater.inflate(R.layout.dialog_item, null)

        val myDialog = Dialog(context)
        myDialog.setView(dialogBinding)
        myDialog.setCancelable(true)
        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog.show()


        val close_btn = dialogBinding.findViewById<ImageView>(R.id.close_btn)
        val toxtash: TextView = dialogBinding.findViewById(R.id.toxtatish_btn)
        val putvidio: LinearLayout = dialogBinding.findViewById(R.id.putvidio)
        val image_dialog = dialogBinding.findViewById<ImageView>(R.id.image_dialog)

        putvidio.setOnClickListener {
            val vidio = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(Constants.URL_VIDIO)
            );
            context.startActivity(vidio);
        }

        image_dialog.load(image)




        close_btn.setOnClickListener {
            myDialog.dismiss()
        }


        toxtash.setOnClickListener {

            SaveDb.getDb().saveSaveDb()
            myDialog.dismiss()


        }



    }


}