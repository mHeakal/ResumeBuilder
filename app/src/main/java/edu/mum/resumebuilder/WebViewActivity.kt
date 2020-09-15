package edu.mum.resumebuilder

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val spf = getSharedPreferences("visastatus", Context.MODE_PRIVATE)
        var selectedVisaType = spf?.getString("type", "")

        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        webview.loadUrl("https://www.google.com/search?q=%22${selectedVisaType}+US+VISA%22")

    }
}
