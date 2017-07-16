package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
/**
 * App: Catamount Characters (Screen 6)
 * This screen display the image according to the user input from screen 3 or screen 5
 * Author: Gajjan Jasani
 * version: 1.0
 */
public class Screen6 extends Activity {

    /**
     * Method: onCreate
     * This method sets up the screen 6 on the device, extracts the image name from
     * the bundle provided with the intent from the previous screen, and sets up the image
     * on the screen related to the image name extracted from the bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);

        // Connecting the xml screen 6's imageView elements with code
        ImageView image = (ImageView) findViewById(R.id.scr6_imageView);
        String value = "GJ";

        // extracting the extras from the bundle
        Bundle extras = getIntent().getExtras();

        if(extras != null){
            // extracting the string from the extras
            value = extras.getString("image");
        }

        // setting up the image according to the string extracted from the bundle
        image.setImageResource(getResources().
                getIdentifier(value, "drawable", "edu.wcu.cs.catamountcharacters"));

    }
}
