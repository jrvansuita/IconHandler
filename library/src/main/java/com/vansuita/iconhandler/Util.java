package com.vansuita.iconhandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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

}
