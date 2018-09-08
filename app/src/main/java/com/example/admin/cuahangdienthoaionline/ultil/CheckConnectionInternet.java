package com.example.admin.cuahangdienthoaionline.ultil;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by admin on 9/2/2018.
 */

public class CheckConnectionInternet {
    public static boolean haveNetworkConnection(Context context) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;


        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
//        for (int i=0;i< netInfo.length;i++){
//            if (netInfo[i].getState()== NetworkInfo.State.CONNECTED) {
//                Toast.makeText(context, "Internet is connected", Toast.LENGTH_SHORT).show();
//            }else {
//                Toast.makeText(context, "Internet is not connection", Toast.LENGTH_SHORT).show();
//            }
//        }
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
    public static void showToast_Shot(Context context,String thongBao){
        Toast.makeText(context,thongBao, Toast.LENGTH_SHORT).show();
    }
}
