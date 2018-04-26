package com.example.triumph.enunny.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

public class GeneralUtils {

    private GeneralUtils() {
        //Empty because we dont want it to be instansiated
    }




    //Used to load our json file from our assets folder, it wil be called in dataManager
    public static String loadJSON(Context context, String jsonFileName)
            throws IOException {

        AssetManager manager = context.getAssets();
        InputStream is = manager.open(jsonFileName);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, "UTF-8");
    }
}
