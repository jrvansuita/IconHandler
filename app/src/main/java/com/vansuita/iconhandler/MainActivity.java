package com.vansuita.iconhandler;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.vansuita.library.Icon;

public class MainActivity extends AppCompatActivity {

    private View yourView;
    private ImageView yourImageView;
    private TextView yourTextView;
    private Bitmap yourBitmap;
    private EditText yourEditText;
    private ImageButton yourImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        yourView = findViewById(R.id.first_view);
        //Setting up a icon on background of a View.
        Icon.put(yourView, R.mipmap.your_icon);


        yourImageView = (ImageView) findViewById(R.id.first_image_view);
        //Setting up a icon on the ImageView.
        Icon.put(yourImageView, R.mipmap.your_icon);


        yourTextView = (TextView) findViewById(R.id.first_text_view);
        //Setting up a icon on the left of the TextView. Also can use right(), top() and bottom() methods.
        Icon.left(yourTextView, R.mipmap.your_icon);


        yourImageView = (ImageView) findViewById(R.id.second_image_view);
        yourTextView = (TextView) findViewById(R.id.second_text_view);
        //Setting up a icon to the ImageView and converting it to blue.
        Icon.on(yourImageView).blue(R.mipmap.your_icon).put();
        Icon.top(yourTextView).gray(R.mipmap.your_icon).put();


        yourTextView = (TextView) findViewById(R.id.third_text_view);
        yourBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.your_icon);
        //Setting up a bitmap as a icon.
        Icon.right(yourTextView).white(yourBitmap).put();


        yourImageView = (ImageView) findViewById(R.id.fourth_image_view);
        //You can combine the usage with colors transformations. You can also modify the class to create your own colors.
        Icon.on(yourImageView).black(R.mipmap.your_icon).put();


        yourImageView = (ImageView) findViewById(R.id.fifth_image_view);
        //Setting up a icon to the ImageView and applying alpha. (0-255)
        Icon.on(yourImageView).blue(R.mipmap.your_icon).alpha(130).put();


        yourEditText = (EditText) findViewById(R.id.sixth_edit_text);
        //Will make the icon appears weak. Receiving focus will reveals the real color of icon.
        Icon.focus(yourEditText, R.mipmap.your_icon, Gravity.RIGHT);


        yourEditText = (EditText) findViewById(R.id.seventh_edit_text);
        //Just another edit text to lose the focus of the first.
        Icon.focus(yourEditText, R.mipmap.your_icon, Gravity.RIGHT);


        yourImageButton = (ImageButton) findViewById(R.id.eighth_image_button);
        yourImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Clearing all icons of the View.
                Icon.clear(yourImageButton);
                yourEditText.clearFocus();
                yourImageButton.requestFocus();
            }
        });

    }
}
