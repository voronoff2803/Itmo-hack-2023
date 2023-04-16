package ru.ok.android.itmohack2023.pixels.webview

import android.webkit.WebResourceResponse
import android.webkit.WebView
import com.acsbendi.requestinspectorwebview.RequestInspectorOptions
import com.acsbendi.requestinspectorwebview.RequestInspectorWebViewClient
import com.acsbendi.requestinspectorwebview.WebViewRequest

class PixelsWebViewClient(private val webView: WebView,
                          options: RequestInspectorOptions = RequestInspectorOptions()
): RequestInspectorWebViewClient(webView, options) {
    override fun shouldInterceptRequest(
        view: WebView,
        webViewRequest: WebViewRequest
    ): WebResourceResponse? {
        print(webViewRequest)
        return super.shouldInterceptRequest(view, webViewRequest)
    }
}