package br.com.thiengo.introapitests.data

import android.content.Context


class SPInfo(val context: Context) {

    fun updateIntroStatus(status : Boolean){
        context
            .getSharedPreferences("PREF", Context.MODE_PRIVATE)
            .edit()
            .putBoolean("status", status)
            .apply()
    }

    fun isIntroShown() = context
            .getSharedPreferences("PREF", Context.MODE_PRIVATE)
            .getBoolean("status", false)
}