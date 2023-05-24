package com.example.helloworld;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * 高德地图工具类
 */
public class AMapAppUtils {

     public static void openMap(Context context, double lat, double lon, String name, String mapType, String url) {

          if (checkMapAppsIsExist(context, "com.autonavi.minimap")) {
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setPackage("com.autonavi.minimap");
               intent.addCategory("android.intent.category.DEFAULT");
               intent.setData(Uri.parse(getUriString(lat, lon, name, mapType )));
               context.startActivity(intent);
          } else {
               Log.d("AMapUtils", "高德地图未安装");
               BrowserUtils.openBrowser(context, url);
          }
     }

     @NonNull
     private static String getUriString(double lat, double lon, String name, String mapType) {
          AMapTypes type = AMapTypes.valueOf(mapType);
          switch (type) {
               case marker:
//                    androidamap://viewMap?sourceApplication=appname&poiname=abc&lat=36.2&lon=116.1&dev=0
                    return "androidamap://viewMap?sourceApplication=" + R.string.app_name
                            + "&lat=" + lat
                            + "&lon=" + lon
                            + "&poiname=" + name
                            + "&dev=0";
               case navigation:
//                    androidamap://navi?sourceApplication=appname&poiname=fangheng&lat=36.547901&lon=104.258354&dev=1&style=2
                    return "androidamap://navi?sourceApplication=" + R.string.app_name
                       + "&sname=我的位置&lat=" + lat
                       + "&lon=" + lon
                       + "&poiname=" + name
                       + "&dev=0&style=2";
          }
          return null;


     }


     public static boolean checkMapAppsIsExist(Context context, String pkgName) {
          if (pkgName == null  || pkgName.trim().equalsIgnoreCase("")) {
               return false;
          }
          try {
               context.getPackageManager().getPackageInfo(pkgName, 0);
          } catch (Exception x) {
               return false;
          }
          return true;
     }
}
