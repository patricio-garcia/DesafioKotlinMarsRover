package cl.serlitoral.desafiokotlinmarsrover.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rover(
        val id: Int,
        val name: String,
        val landing_date: String,
        val launch_date: String,
        val status: String
): Parcelable
