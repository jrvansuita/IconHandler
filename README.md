
 <!-- Library Logo -->
 <img src="app/src/main/res/mipmap-xxhdpi/ic_launcher.png?raw=true" align="left" width='220' hspace="1" vspace="1">

 <!-- Buy me a cup of coffe -->
 <a href='https://ko-fi.com/A406JCM' style='margin:13px;' target='_blank' align="right"><img align="right" height='36' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=f' alt='Buy Me a Coffee at ko-fi.com' /></a>
 <a href='https://play.google.com/store/apps/details?id=com.vansuita.iconhandler.sample&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1' target='_blank' align="right"><img align="right" height='45' src='https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png' alt='Get it on Google Play' /></a>

# Icon Handler


 This is an [**Android**](https://developer.android.com) project. This library handle the drawable customization and position on View, EditText, ImageView, TextView, Button and etc. You can do a lot with a few lines of code, like change the icon color, alpha or even the size. This library has a lot more customization and features than is able to show here. Please check the sample app and feel free to help with a pull request.

<br/>

[![](https://jitpack.io/v/jrvansuita/IconHandler.svg)](https://jitpack.io/#jrvansuita/IconHandler)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-IconHandler-green.svg?style=true)](https://android-arsenal.com/details/1/4525) [![MaterialUp](https://img.shields.io/badge/MaterialUp-IconHandler-6ad0d9.svg?)](https://www.uplabs.com/posts/iconhandler) 

 <img src="images/mockups/heart_framed.jpg" height='auto' width='160'/><img src="images/mockups/motorcycle_framed.jpg" height='auto' width='160'/><img src="images/mockups/paper-airplane_framed.jpg" height='auto' width='160'/><img src="images/mockups/picture_framed.jpg" height='auto' width='160'/><img src="images/mockups/vane_framed.jpg" height='auto' width='160'/>

 [![Appetize.io](https://img.shields.io/badge/Apptize.io-Run%20Now-brightgreen.svg?)](https://appetize.io/embed/hz5ywza6nxqr2urz9tewb9er8c?device=nexus7&scale=50&autoplay=true&orientation=portrait&deviceColor=black) [![Demo](https://img.shields.io/badge/Demo-Download-blue.svg)](http://apk-dl.com/dl/com.vansuita.iconhandler.sample)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c2c7d2b5674d481cb631b09b033972a4)](https://www.codacy.com/app/jrvansuita/IconHandler?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jrvansuita/IconHandler&amp;utm_campaign=Badge_Grade)
  <a target="_blank" href="https://developer.android.com/reference/android/os/Build.VERSION_CODES.html#GINGERBREAD"><img src="https://img.shields.io/badge/API-9%2B-blue.svg?style=flat" alt="API" /></a>


# Setup

#### Step #1. Add the JitPack repository to your build file:

```gradle
allprojects {
    repositories {
	...
	maven { url "https://jitpack.io" }
    }
}
```

#### Step #2. Add the dependency ([See latest release](https://jitpack.io/#jrvansuita/IconHandler)).

```groovy
dependencies {
       compile 'com.github.jrvansuita:IconHandler:+'
}
```

# Implamentation
```java
//Setting up a icon on background of a View.
Icon.put(yourView, R.mipmap.your_icon);

//Setting up a icon on the ImageView.
Icon.put(yourImageView, R.mipmap.your_icon);

//Setting up a icon on the left of the TextView. Also can use right(), top() and bottom() methods.
Icon.left(yourTextView, R.mipmap.your_icon);

//Setting up a icon on MenuItem
Icon.on(yourMenuItem).icon(R.mipmap.your_icon).put();

//Setting up a icon to the ImageView and converting it to blue.
Icon.top(yourTextView).gray(R.mipmap.your_icon).put();

//Setting up a icon to the ImageView and converting it to your custom color.
Icon.on(yourImageView).color(R.color.your_color).icon(R.mipmap.your_icon).put();

//Setting up a bitmap as a icon.
Icon.right(yourTextView).bitmap(yourBitmap).put();

//Setting up a icon on dynamic position
Icon.on(yourTextView).icon(R.mipmap.your_icon).position(Gravity.LEFT).put();

//You can merge the usage with colors transformations.
Icon.on(yourImageView).black(R.mipmap.your_icon).put();

//Setting up a icon to the ImageView and applying alpha. (0-255)
Icon.on(yourImageView).white(R.mipmap.your_icon).alpha(130).put();

//Will make the icon appears weak. Receiving focus will reveals the real color of icon.
Icon.focusable(yourEditText, R.mipmap.your_icon, Gravity.RIGHT);

//Just another edit text to lose the focus of the first.
Icon.focusable(yourEditText).position(Gravity.RIGHT).icon(R.mipmap.your_icon).put();

yourImageButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
         //Clearing all icons of the View.
         Icon.clear(yourImageButton);
      }
    });
```

#
<a href="https://www.instagram.com/jnrvans/" target="_blank">
  <img src="https://camo.githubusercontent.com/c9dacf0f25a1489fdbc6c0d2b41cda58b77fa210a13a886d6f99e027adfbd358/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f696e7374616772616d2e737667" alt="Instagram" witdh="44" height="44" hspace="10">
</a>
<a href="https://github.com/jrvansuita" target="_blank">
  <img src="https://camo.githubusercontent.com/b079fe922f00c4b86f1b724fbc2e8141c468794ce8adbc9b7456e5e1ad09c622/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f6769746875622e737667" alt="Github" witdh="44" height="44" hspace="10">
</a>
<a href="https://play.google.com/store/apps/dev?id=8002078663318221363" target="_blank">
  <img src="https://camo.githubusercontent.com/8ce12185c778e13eed2073e7a6aba042ce5092d4d41744e7052e0fc16363c386/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f676f6f676c655f706c61792e737667" alt="Google Play Store" witdh="44" height="44" hspace="10">
</a>
<a href="mailto:vansuita.jr@gmail.com" target="_blank" >
  <img src="https://camo.githubusercontent.com/4a3dd8d10a27c272fd04b2ce8ed1a130606f95ea6a76b5e19ce8b642faa18c27/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f676d61696c2e737667" alt="E-mail" witdh="44" height="44" hspace="10">
</a>
