package org.example

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject


class TikTokLinkParser {
    companion object {
        fun isTikTokUrl(text: String): Boolean {
            return text.startsWith("https://www.tiktok.com/") || text.startsWith("https://vm.tiktok.com/")
        }
        fun getMediaUrl(url: String): String {
            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://tiktok-full-info-without-watermark.p.rapidapi.com/vid/index?url=$url")
                .get()
                .addHeader("X-RapidAPI-Key", Configuration.getProperty("X-RapidAPI-Key"))
                .addHeader("X-RapidAPI-Host", Configuration.getProperty("X-RapidAPI-Host"))
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    return "Big Brother didn't approve this video so it has been vaporized.\n" +
                           "From now on it's never existed!"
                }
                else if (response.isRedirect) {
                    return "You have been moved to the room 101!"
                }
                val tmpStr = JSONObject(response.body.string())["video"].toString()
                val resultVideoUrl = tmpStr.substring(2, tmpStr.length-2)
                return resultVideoUrl
            }
        }
    }
}