package com.example.paperdemo.home.model

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

data class HomeViewState(
    val homeItems: List<HomeItem> = emptyList(),
    val loading: Boolean = true
) {
    val isEmpty = !loading && homeItems.isEmpty()
}

@Parcelize
@Entity(tableName = "home_model_table", indices = [Index(value = ["id"], unique = true)])
data class HomeItem(
    @PrimaryKey
    var id: String,
    var description: String,
    var time: Long,
) : Parcelable
