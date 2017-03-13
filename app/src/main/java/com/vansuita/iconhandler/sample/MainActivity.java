package com.vansuita.iconhandler.sample;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.vansuita.iconhandler.Icon;
import com.vansuita.iconhandler.Util;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, ColorChooserDialog.ColorCallback {

    private View yourView;
    private TextView yourTextView;
    private EditText yourEditText;
    private Button yourButton;
    private ImageView yourImageView;
    private ImageButton yourImageButton;
    private MenuItem yourMenuItem;

    private CardView cvColorSample;
    private TextView tvColorDescription;
    private int selectedColor;

    private ImageView ivIconSample;
    private List<Integer> icons;
    private int selectedIconPos;

    private List<Integer> gravities;
    private int selectedGravityPos;
    private TextView tvGravitySample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setup();
        bind();
        listeners();

        init();
    }

    private void setup() {
        this.selectedColor = Color.WHITE;
        this.selectedIconPos = -1;
        this.selectedGravityPos = 0;

        icons = new ArrayList();
        icons.add(R.mipmap.ic_account_balance_black_48dp);
        icons.add(R.mipmap.ic_bug_report_black_48dp);
        icons.add(R.mipmap.ic_face_black_48dp);
        icons.add(R.mipmap.ic_favorite_black_48dp);
        icons.add(R.mipmap.ic_insert_photo_black_48dp);
        icons.add(R.mipmap.ic_mail_black_48dp);
        icons.add(R.mipmap.ic_motorcycle_black_48dp);
        icons.add(R.mipmap.ic_send_black_48dp);
        icons.add(R.mipmap.ic_toys_black_48dp);
        icons.add(R.mipmap.ic_weekend_black_48dp);

        gravities = new ArrayList();

        gravities.add(Gravity.RIGHT);
        gravities.add(Gravity.TOP);
        gravities.add(Gravity.LEFT);
        gravities.add(Gravity.BOTTOM);
    }

    private void bind() {
        yourView = findViewById(R.id.view);
        yourTextView = (TextView) findViewById(R.id.textview);
        yourEditText = (EditText) findViewById(R.id.edittext);
        yourButton = (Button) findViewById(R.id.button);
        yourImageView = (ImageView) findViewById(R.id.imageview);
        yourImageButton = (ImageButton) findViewById(R.id.imagebutton);

        cvColorSample = (CardView) findViewById(R.id.card_color);
        tvColorDescription = (TextView) findViewById(R.id.color_description);

        ivIconSample = (ImageView) findViewById(R.id.icon);

        tvGravitySample = (TextView) findViewById(R.id.gravity);
    }

    private void listeners() {
        findViewById(R.id.color_holder).setOnClickListener(this);
        findViewById(R.id.icon_holder).setOnClickListener(this);
        findViewById(R.id.gravity_holder).setOnClickListener(this);
    }


    private void init() {
        selectNewIcon();
        setSelectedColor(Color.WHITE);
        selectNewGravity();

        load();

        yourImageButton.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        yourMenuItem = menu.findItem(R.id.action_icon);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Icon.on(yourMenuItem).icon(icons.get(selectedIconPos)).pressedEffect(false).color(selectedColor).put();

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.color_holder:
                new ColorChooserDialog.Builder(this, R.string.color_palette)
                        .preselect(selectedColor)
                        .allowUserColorInput(false)
                        .customButton(R.string.md_custom_label)
                        .presetsButton(R.string.md_presets_label)
                        .show();
                break;

            case R.id.icon_holder:
                selectNewIcon();
                load();
                break;

            case R.id.gravity_holder:
                selectNewGravity();
                load();
                break;
        }
    }

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {
        this.setSelectedColor(selectedColor);
        loadSelectedIcon();
        load();
    }

    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {

    }

    private void setSelectedColor(int selectedColor) {
        this.selectedColor = selectedColor;

        cvColorSample.setCardBackgroundColor(selectedColor);
        tvColorDescription.setText(String.format("#%06X", (0xFFFFFF & selectedColor)));
        tvColorDescription.setTextColor(ContextCompat.getColor(this, Util.isColorDark(selectedColor) ? android.R.color.white : android.R.color.black));
    }

    private void selectNewIcon() {
        selectedIconPos++;

        if (selectedIconPos >= icons.size())
            selectedIconPos = 0;

        loadSelectedIcon();
    }

    private void loadSelectedIcon() {
        Icon.on(ivIconSample).color(selectedColor).icon(icons.get(selectedIconPos)).put();
    }

    private void selectNewGravity() {
        selectedGravityPos++;

        if (selectedGravityPos >= gravities.size())
            selectedGravityPos = 0;


        switch (gravities.get(selectedGravityPos)) {
            case Gravity.TOP:
                tvGravitySample.setText("Top");
                break;
            case Gravity.BOTTOM:
                tvGravitySample.setText("Bottom");
                break;
            case Gravity.RIGHT:
                tvGravitySample.setText("Right");
                break;
            case Gravity.LEFT:
                tvGravitySample.setText("Left");
                break;
        }
    }

    private void load() {
        int position = gravities.get(selectedGravityPos);
        int iconRes = icons.get(selectedIconPos);

        Icon.on(yourView).color(selectedColor).icon(iconRes).put();
        Icon.on(yourTextView).color(selectedColor).icon(iconRes).position(position).put();
        Icon.focusable(yourEditText).color(selectedColor).icon(iconRes).position(position).put();
        Icon.on(yourButton).color(selectedColor).icon(iconRes).position(position).put();
        Icon.on(yourImageView).color(selectedColor).icon(iconRes).position(position).put();
        Icon.on(yourImageButton).color(selectedColor).icon(iconRes).position(position).put();
        Icon.on(yourMenuItem).icon(iconRes).pressedEffect(false).color(selectedColor).put();
    }
}
