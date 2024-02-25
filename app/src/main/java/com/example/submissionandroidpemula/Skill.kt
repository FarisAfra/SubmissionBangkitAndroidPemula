package com.example.submissionandroidpemula

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Skill(
    val name: String,
    val description: String,
    val photo: Int,
    val history: String,
    val year: Int,
    val version: String,
    val website: String
) : Parcelable
