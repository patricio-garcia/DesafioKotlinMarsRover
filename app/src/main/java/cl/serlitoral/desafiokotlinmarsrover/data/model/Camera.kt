package cl.serlitoral.desafiokotlinmarsrover.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Camera (
    val id: Int,
    val name: String,
    val rover_id: Int,
    val full_name: String
): Parcelable

@Parcelize
data class Cameras (
    val name: String,
    val full_name: String
): Parcelable