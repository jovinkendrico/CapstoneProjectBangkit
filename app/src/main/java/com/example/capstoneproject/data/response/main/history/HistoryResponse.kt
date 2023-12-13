package com.example.capstoneproject.data.response.main.history

import com.google.gson.annotations.SerializedName

data class HistoryResponse(

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null
)

data class ImagesItem(

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
