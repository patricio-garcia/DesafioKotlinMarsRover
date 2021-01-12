package cl.serlitoral.desafiokotlinmarsrover

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import cl.serlitoral.desafiokotlinmarsrover.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var urlList: List<String>
    private lateinit var progessBarList: List<ProgressBar>
    private lateinit var imageViewList: List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageLoad()
        initProgessBar()
        initImageViews()

        binding.btnMessage.setOnClickListener {
            AlertDialog
                .Builder(this)
                .setMessage("Este mensaje demuestra el funcionamiento de las corrutinas en background")
                .setCancelable(true)
                .show()
        }

        CoroutineScope(Dispatchers.Main).launch {
            for (i in urlList.indices) {
                val image = doInBackground(urlList[i], progessBarList[i])
                Log.d("Corutinas", image.toString())

                if (image != null) {
                    updateView(image, progessBarList[i], imageViewList[i])
                }
            }
        }

    }

    private fun imageLoad() {
        urlList = listOf<String>(
            "https://apod.nasa.gov/apod/image/1908/M61-HST-ESO-S1024.jpg",
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/andromeda-galaxy-royalty-free-image-1585682435.jpg",
            "https://media.wired.com/photos/5a593a7ff11e325008172bc2/125:94/w_2393,h_1800,c_limit/pulsar-831502910.jpg",
            "https://scitechdaily.com/images/Illustration-Photons-Galaxy.jpg"
        )
    }

    private fun initProgessBar() {
        progessBarList = listOf(binding.pBarImg1, binding.pBarImg2, binding.pBarImg3, binding.pBarImg4)
    }

    private fun initImageViews() {
        imageViewList = listOf(binding.img1, binding.img2, binding.img3, binding.img4)
    }

    private suspend fun doInBackground(url: String, progressBar: ProgressBar): Bitmap {
        lateinit var bmp: Bitmap
        withContext(Dispatchers.Default) {
            try {
                progressBar.visibility = View.VISIBLE
                val newURL = URL(url)
                val inputStram = newURL.openConnection().getInputStream()

                Log.d("Coruntinas", inputStram.toString())

                bmp = BitmapFactory.decodeStream(inputStram)
            } catch (e: Exception) {
                Log.d("Corutinas", e.message.toString())
                e.printStackTrace()
            }
        }
        return bmp
    }

    private fun updateView(image: Bitmap, progressBar: ProgressBar, imageView: ImageView) {
        Log.d("Corutinas", "Estamos en el updateView ")
        progressBar.visibility = View.GONE
        imageView.setImageBitmap(image)
    }
}