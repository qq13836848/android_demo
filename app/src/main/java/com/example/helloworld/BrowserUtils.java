package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class BrowserUtils {

    public static void openBrowser(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        Intent chooserIntent = Intent.createChooser(intent, "选择浏览器: ");
        context.startActivity(chooserIntent);
    }
}
