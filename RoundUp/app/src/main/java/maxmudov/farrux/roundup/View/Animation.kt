package maxmudov.farrux.roundup.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import maxmudov.frarux.roundup.R
import maxmudov.frarux.roundup.databinding.ActivityAnimationBinding

class Animation : AppCompatActivity() {
    lateinit var binding: ActivityAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.animationView.postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },4000)
    }
}