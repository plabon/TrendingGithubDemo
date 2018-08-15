package com.jukti.trendinggithubdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class Utility {
    public static boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

}
