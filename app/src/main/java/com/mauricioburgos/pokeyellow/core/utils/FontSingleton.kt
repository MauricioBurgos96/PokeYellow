package com.mauricioburgos.pokeyellow.core.utils

import android.app.Activity
import android.graphics.Typeface
import com.mauricioburgos.pokeyellow.AppController

class FontSingleton {

    init {
        fontBold = Typeface.createFromAsset(
            AppController.applicationContext().assets,
            "fonts/trade_gothic_bold.ttf"
        )
        fontRegular = Typeface.createFromAsset(
            AppController.applicationContext().assets,
            "fonts/trade_gothic_regular.ttf"
        )


    }

    companion object {

        var fontBold: Typeface? = null
        var fontRegular: Typeface? = null
        private var mInstance: FontSingleton? = null

        fun getInstance(): FontSingleton {
            if (mInstance == null) {
                mInstance = FontSingleton()
            }
            return mInstance as FontSingleton
        }



        fun getmInstance(): FontSingleton? {
            return mInstance
        }




    }






}