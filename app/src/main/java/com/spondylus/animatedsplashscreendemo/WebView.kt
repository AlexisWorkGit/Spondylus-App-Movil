package com.spondylus.animatedsplashscreendemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView


class WebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        // WebView
        val visor = findViewById<WebView>(R.id.web)

        visor.webChromeClient = object : WebChromeClient(){

        }
        visor.webViewClient = object : WebViewClient(){

        }
        val settings:WebSettings = visor.settings
        settings.javaScriptEnabled = true

        visor.loadUrl("http://www.spondylus.com.ec/login")
    }
}