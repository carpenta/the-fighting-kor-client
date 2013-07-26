package com.appspot.thefightingkor.util;

import android.content.Context;

import com.appspot.thefightingkor.R;

/**
 * Created by mc2e on 13. 7. 26..
 */
public class Utils {

    private static int[] imageRes = {
            R.drawable.grade_white, R.drawable.grade_blue,
            R.drawable.grade_purple, R.drawable.grade_brown,
            R.drawable.grade_black
    };

    public static int getImageRes(String[] group , String grade) {

        int result = 0;

        if(grade == null)
            return 0;

        if(grade != null) {

            if(grade.equalsIgnoreCase(group[0])) {

                result = imageRes[0];
            } else if(grade.equalsIgnoreCase(group[1])) {
                result = imageRes[1];

            } else if(grade.equalsIgnoreCase(group[2])) {
                result = imageRes[2];

            } else if(grade.equalsIgnoreCase(group[3])){
                result = imageRes[3];

            } else if(grade.equalsIgnoreCase(group[4])) {
                result = imageRes[4];

            } else {

            }

        }

        return result;
    }
}
