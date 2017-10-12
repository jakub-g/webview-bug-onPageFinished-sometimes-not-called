WebView bug


For some reason `onPageFinished` is not always called when loading an HTML file from file system via

    webView.loadUrl("file:///android_asset/test.html");
