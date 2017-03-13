package com.vansuita.iconhandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by jrvansuita on 03/02/17.
 */

public class Util {

    public static void background(View v, Drawable d) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            v.setBackground(d);
        } else {
            v.setBackgroundDrawable(d);
        }
    }


    public static Bitmap alpha(Bitmap input, int alpha) {
        Bitmap output = Bitmap.createBitmap(input.getWidth(), input.getHeight(), input.getConfig());

        Paint transparentPaint = new Paint();
        transparentPaint.setAlpha(alpha);

        Canvas canvas = new Canvas(output);
        canvas.drawBitmap(input, 0, 0, transparentPaint);


        return output;
    }

    public static Context getMenuItemContext(MenuItem menuItem) {
        MenuItemImpl menuItemImpl = ((MenuItemImpl) menuItem);
        try {
            Field f = menuItemImpl.getClass().getDeclaredField("mMenu");
            f.setAccessible(true);

            return ((MenuBuilder) f.get(menuItemImpl)).getContext();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isColorDark(int color) {
        double darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
        if (darkness < 0.5 || color == 0) {
            return false; // It's a light color
        } else {
            return true; // It's a dark color
        }
    }

    public static int darker(int color) {
        int r = Color.red(color);
        int b = Color.blue(color);
        int g = Color.green(color);

        return Color.rgb((int) (r * .9), (int) (g * .9), (int) (b * .9));
    }

}
