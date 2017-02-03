package com.vansuita.library;

import android.annotation.TargetApi;
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


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void background(View v, Drawable d) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            v.setBackgroundDrawable(d);
        } else {
            v.setBackground(d);
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
