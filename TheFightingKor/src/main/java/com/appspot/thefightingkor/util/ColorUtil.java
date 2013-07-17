package com.appspot.thefightingkor.util;

import android.graphics.Color;

import com.appspot.thefightingkor.R;

/**
 * Created by mc2e on 13. 7. 17..
 */
public class ColorUtil {

    private static final String RUNNING = "running";

    public static int getBgColor(String isRunning) {

        int bgColor = Color.GRAY;

        if(isRunning != null) {

            if(isRunning.equalsIgnoreCase(RUNNING)) {

                bgColor = Color.GRAY;
            }else {
                bgColor = Color.DKGRAY;
            }
        }

        return bgColor;
    }
}
