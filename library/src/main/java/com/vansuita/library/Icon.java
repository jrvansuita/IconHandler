package com.vansuita.library;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.StateSet;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jrvansuita on 30/07/15.
 */
public class Icon {

    private int alpha = 66;
    private int color = 0;
    private int icon = 0;
    private boolean reverseAlpha = false;
    private boolean focus = false;
    private boolean pressedEffect = true;
    private Bitmap bitmap;

    private MenuItem mi;

    Icon(MenuItem mi) {
        this.mi = mi;
    }

    public static Icon on(MenuItem mi) {
        return new Icon(mi);
    }

    public static void put(MenuItem mi, int icon) {
        new Icon(mi).icon(icon).put();
    }


    Icon(ImageView iv) {
        this.iv = iv;
    }


    private ImageView iv;

    public static Icon on(ImageView iv) {
        return new Icon(iv);
    }

    public static void put(ImageView iv, int icon) {
        new Icon(iv).icon(icon).put();
    }

    Icon(View v) {
        this.v = v;
    }

    private View v;

    public static void put(View v, int icon) {
        new Icon(v).icon(icon).put();
    }

    public static Icon on(View iv) {
        return new Icon(iv);
    }

    Icon(TextView tv, int pos) {
        this.tv = tv;
        this.pos = pos;
    }

    private TextView tv;
    private int pos;



    public static Icon left(TextView tv) {
        return new Icon(tv, Gravity.LEFT);
    }

    public static void left(TextView tv, int icon) {
        put(tv, icon, Gravity.LEFT);
    }

    public static Icon right(TextView tv) {
        return new Icon(tv, Gravity.RIGHT);
    }

    public static void right(TextView tv, int icon) {
        put(tv, icon, Gravity.RIGHT);
    }

    public static Icon top(TextView tv) {
        return new Icon(tv, Gravity.TOP);
    }

    public static void top(TextView tv, int icon) {
        put(tv, icon, Gravity.TOP);
    }

    public static Icon bottom(TextView tv) {
        return new Icon(tv, Gravity.BOTTOM);
    }

    public static void bottom(TextView tv, int icon) {
        put(tv, icon, Gravity.BOTTOM);
    }

    private static void put(TextView tv, int icon, int pos) {
        new Icon(tv, pos).icon(icon).put();
    }

    public Icon pressedEffect(boolean pressedEffect) {
        this.pressedEffect = pressedEffect;
        return this;
    }

    public Icon alpha(int a) {
        this.alpha = a;
        return this;
    }

    public Icon color(int color) {
        this.color = color;
        return this;
    }

    public Icon icon(int res) {
        this.icon = res;
        return this;
    }

    public Icon bitmap(Bitmap b) {
        this.bitmap = b;
        return this;
    }

    public Icon white(Bitmap bitmap) {
        return bitmap(bitmap).color(android.R.color.white);
    }

    public Icon white(int icon) {
        return icon(icon).color(android.R.color.white);
    }

    public Icon blue(Bitmap bitmap) {
        return bitmap(bitmap).color(android.R.color.holo_blue_dark);
    }

    public Icon blue(int icon) {
        return icon(icon).color(android.R.color.holo_blue_dark);
    }

    public Icon black(int icon) {
        return icon(icon).color(android.R.color.black);
    }

    public Icon gray(int icon) {
        return icon(icon).color(android.R.color.darker_gray);
    }

    public static void clear(TextView tv) {
        tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    public static void clear(ImageView i) {
        i.setImageBitmap(null);
    }

    public void put() {
        if (icon == 0 && bitmap == null)
            throw new Error("You must provide an icon resource id or a bitmap!");

        if (v != null) {
            Util.background(v, new SelectorDrawable(v.getContext()));
        } else if (iv != null) {
            iv.setImageDrawable(new SelectorDrawable(iv.getContext()));
        } else if (tv != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                tv.setCompoundDrawablesRelativeWithIntrinsicBounds(getForPosition(Gravity.LEFT), getForPosition(Gravity.TOP), getForPosition(Gravity.RIGHT), getForPosition(Gravity.BOTTOM));
            } else {
                tv.setCompoundDrawablesWithIntrinsicBounds(getForPosition(Gravity.LEFT), getForPosition(Gravity.TOP), getForPosition(Gravity.RIGHT), getForPosition(Gravity.BOTTOM));
            }
        } else if (mi != null) {
            Context context = Util.getMenuItemContext(mi);
            if (context != null)
                mi.setIcon(new SelectorDrawable(context));
        }
    }

    private Drawable getForPosition(int i) {
        return pos == i ? new SelectorDrawable(tv.getContext()) : null;
    }

    public Icon reverse(int icon) {
        this.reverseAlpha = !reverseAlpha;
        return this.icon(icon);
    }

    public static void focus(TextView tv, int icon) {
        focus(tv, icon, Gravity.LEFT);
    }


    public static void focus(TextView tv, int icon, int pos) {
        Icon i = new Icon(tv, pos);
        i.focus = true;
        i.icon(icon).put();
    }

    public class SelectorDrawable extends StateListDrawable {
        private Context context;
        private int paintColor = 0;

        public SelectorDrawable(Context context) {
            super();
            this.context = context;

            if (focus) {
                addState(new int[]{android.R.attr.state_focused}, get(reverseAlpha));
                addState(StateSet.WILD_CARD, get(!reverseAlpha));
            } else if (pressedEffect) {
                addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, get(!reverseAlpha));
                addState(new int[]{-android.R.attr.state_enabled}, get(!reverseAlpha));
                addState(StateSet.WILD_CARD, get(reverseAlpha));
            } else {
                addState(StateSet.WILD_CARD, get(reverseAlpha));
            }
        }

        public int getPaintColor() {
            if (paintColor == 0) {
                try {
                    paintColor = ContextCompat.getColor(context, color);
                } catch (Resources.NotFoundException e) {
                    paintColor = color;
                }
            }

            return paintColor;
        }

        @Override
        protected boolean onStateChange(int[] states) {
            if (context != null && color != 0) {
                setColorFilter(getPaintColor(), PorterDuff.Mode.SRC_IN);
            }

            return super.onStateChange(states);
        }

        private Drawable get(boolean putAlpha) {
            Drawable d;

            if (bitmap != null) {
                d = new BitmapDrawable(context.getResources(), bitmap);
            } else {
                d = ContextCompat.getDrawable(context, icon);
            }

            return new BitmapDrawable(context.getResources(), Util.alpha(((BitmapDrawable) d).getBitmap(), putAlpha ? alpha : 255));
        }
    }


}
