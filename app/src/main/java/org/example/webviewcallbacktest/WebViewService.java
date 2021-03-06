package org.example.webviewcallbacktest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewService {

    private WebView webView;

    public WebViewService(Context context) {
        this.webView = new WebView(context);
    }

    public WebView loadPage() {
        // WebView.setWebContentsDebuggingEnabled(true);

        WebView wv = this.webView;
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                log("onReceivedHttpError");
            }

            @Override
            public void onPageFinished(final WebView wv, final String url) {
                super.onPageFinished(wv, url);
                log("onPageFinished");
            }

            @Override
            @TargetApi(Build.VERSION_CODES.M)
            public void onReceivedError(WebView view, WebResourceRequest request,
                                        WebResourceError error) {
                log("onReceivedError1");
            }

            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                log("onReceivedError2");
            }
        });

        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                log("onProgressChanged: " + newProgress);
            }
        });

        log("Loading the HTML file...");
        wv.loadUrl("file:///android_asset/test.html");

        return wv;
    }

    private void log(String str) {
        Log.d("WebViewTest", str);
    }
}
