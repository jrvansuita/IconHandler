
 <a href='https://ko-fi.com/A406JCM' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=f' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>


[![](https://jitpack.io/v/jrvansuita/IconHandler.svg)](https://jitpack.io/#jrvansuita/IconHandler)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-IconHandler-green.svg?style=true)](https://android-arsenal.com/details/1/4525)

# IconHandler
This project was created to use in Android projects.

# Porpouse
Handles the drawable binding and position on View, EditText, ImageView or TextView. Also can change the icon color, alpha and size using a SelectorDrawable. 


# Usage

#### Step 1. Add the JitPack repository to your build file:

    allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}

#### Step 2. Add the dependency

    dependencies {
	        compile 'com.github.jrvansuita:IconHandler:v1.0.2'
	}

# Samples
 You can take a look at the sample app [located on this project](/app/).


# Implamentation

    //Setting up a icon on backgrond of a View.
    Icon.put(yourView, R.mipmap.your_icon);

    //Setting up a icon on the ImageView.
    Icon.put(yourImageView, R.mipmap.your_icon);

    //Setting up a icon on the left of the TextView. Also can use right(), top() and bottom() methods.
    Icon.left(yourTextView, R.mipmap.your_icon);

    //Setting up a icon to the ImageView and converting it to blue.
    Icon.on(yourImageView).blue(R.mipmap.your_icon).put();
    Icon.top(yourTextView).gray(R.mipmap.your_icon).put();

    //Setting up a icon to the ImageView and converting it to your custom color.
    Icon.on(yourImageView).color(R.color.your_color).icon(R.mipmap.your_icon).put();
    
    //Setting up a bitmap as a icon.
    Icon.right(yourTextView).white(yourBitmap).put();

    //You can combine the usage with colors transformations. You can also modify the class to create your own colors.
    Icon.on(yourImageView).black(R.mipmap.your_icon).put();

    //Setting up a icon to the ImageView and applying alpha. (0-255)
    Icon.on(yourImageView).blue(R.mipmap.your_icon).alpha(130).put();

    //Will make the icon appears weak. Receiving focus will reveals the real color of icon.
    Icon.focus(yourEditText, R.mipmap.your_icon, Gravity.RIGHT);

    //Just another edit text to lose the focus of the first.
    Icon.focus(yourEditText, R.mipmap.your_icon, Gravity.RIGHT);

    yourImageButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Clearing all icons of the View.
            Icon.clear(yourImageButton);
            yourEditText.clearFocus();
            yourImageButton.requestFocus();
        }
    });
