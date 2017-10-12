WebView bug - `onPageFinished` sometimes not called
---------------------------------------------------

For some reason `onPageFinished` is not always called when loading an HTML file from file system via

    webView.loadUrl("file:///android_asset/test.html");

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

When app and WebView are made debuggable, when the bug is reproduced, the page does not appear on the list
of debug targets of `chrome://inspect/#devices` page.

Reproduced on Android 8.0 Nexus 6P, WebView 61.0.3163.98.
