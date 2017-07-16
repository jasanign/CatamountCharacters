package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
/**
 * App: Catamount Characters (Screen 7)
 * This screen display the image according to the user input from screen 4
 * Author: Gajjan Jasani
 * version: 1.0
 */
public class Screen7 extends Activity {

    /**
     * Method: onCreate
     * This method sets up the screen 7 on the device, extracts the image names from
     * the bundle provided with the intent from the previous screen, and sets up the images
     * on the screen related to the image names extracted from the bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen7);

        // Connecting the xml screen 6's imageView elements with code
        ImageView image1 = (ImageView) findViewById(R.id.scr7_imageView1);
        ImageView image2 = (ImageView) findViewById(R.id.scr7_imageView2);
        String value1 = "GJ";
        String value2 = "GJ";
        // extracting the extras from the bundle
        Bundle extras = getIntent().getExtras();

        if(extras != null){
            // extracting the string from the extras
            value1 = extras.getString("image1");
            value2 = extras.getString("image2");
        }

        // setting up the images according to the strings extracted from the bundle
        image1.setImageResource(getResources().
                getIdentifier(value1, "drawable", "edu.wcu.cs.catamountcharacters"));
        image2.setImageResource(getResources().
                getIdentifier(value2, "drawable", "edu.wcu.cs.catamountcharacters"));

    }
}
