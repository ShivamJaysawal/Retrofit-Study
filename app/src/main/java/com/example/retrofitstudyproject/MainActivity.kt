package com.example.retrofitstudyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofitstudyproject.RestAPIs.QMS_APIs
import com.example.retrofitstudyproject.RetrofitHelper.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Credentials

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val qmsApis = RetrofitHelper.getInstance().create(QMS_APIs::class.java)

        GlobalScope.launch {
            val UserName = "QoBbyWkSFmSI87hFDHTlgs6v6T8a"
            val Password = "cxm36wflZ8V0CetUU9HhqKRx4fwa"
// Below code will create correct Base64 encoded Basic Auth credentials
            val credentials = Credentials.basic(UserName, Password)
            val result=qmsApis.getToken(credentials,"client_credentials")
           val ss= result.body()?.access_token
            Log.d("QUOTERESULT",result.body().toString())
        }
    }
}