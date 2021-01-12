package cl.serlitoral.desafiokotlinmarsrover.data.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val id: Int,
    val sol: Int,
    val camera: Camera,
    val img_src: String,
    val earth_date: String,
    val rover: Rover
): Parcelable

@Parcelize
data class Photos(
        val photos: List<Photo>
): Parcelable
