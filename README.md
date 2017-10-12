WebView bug - `onPageFinished` sometimes not called
---------------------------------------------------

For some reason `onPageFinished` is not always called when loading an HTML file from file system via

    webView.loadUrl("file:///android_asset/test.html");

(See the full code [here](https://github.com/jakub-g/webview-bug-onPageFinished-sometimes-not-called/tree/master/app/src/main/java/org/example/webviewcallbacktest))

Expected output:

    10-12 15:44:54.704 12106-12106/org.example.webviewcallbacktest D/WebViewTest: Loading the HTML file...
    10-12 15:44:54.762 12106-12106/org.example.webviewcallbacktest D/WebViewTest: onProgressChanged: 10
    10-12 15:44:54.954 12106-12106/org.example.webviewcallbacktest D/WebViewTest: onProgressChanged: 10
    10-12 15:44:55.020 12106-12106/org.example.webviewcallbacktest D/WebViewTest: onProgressChanged: 100
    10-12 15:44:55.020 12106-12106/org.example.webviewcallbacktest D/WebViewTest: onProgressChanged: 100
    10-12 15:44:55.020 12106-12106/org.example.webviewcallbacktest D/WebViewTest: onPageFinished

But sometimes the output is:

    10-12 15:38:27.524 31408-31408/org.example.webviewcallbacktest D/WebViewTest: Loading the HTML file...
    10-12 15:38:27.592 31408-31408/org.example.webviewcallbacktest D/WebViewTest: onProgressChanged: 10
    10-12 15:38:27.721 31408-31408/org.example.webviewcallbacktest D/WebViewTest: onProgressChanged: 10
    10-12 15:38:27.721 31408-31408/org.example.webviewcallbacktest D/WebViewTest: onProgressChanged: 10

The bug is reproducible both for debuggable and non-debuggable app / WebView.

When app and WebView are made debuggable, when the bug is reproduced, the page does not appear on the list
of debug targets of `chrome://inspect/#devices` page.

Reproduced on Android 8.0 Nexus 6P, WebView Stable 61.0.3163.98 / WebView Canary 63.0.3238.0.
Also reproduced on other Android versions and vendors.