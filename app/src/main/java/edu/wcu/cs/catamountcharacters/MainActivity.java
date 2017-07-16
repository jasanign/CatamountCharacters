package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * App: Catamount Characters (Splash Screen)
 * Author: Gajjan Jasani
 * version: 1.0
 */
public class MainActivity extends Activity {

    /** Constant to define 3 seconds */
    private final int DELAY = 3000;
    /** Handler to apply delay */
    Handler handler;

    /**
     * Method: onCreate
     * This method displays the splash screen when the app is opened
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method: onStart
     * This method loads Screen2 after 3 seconds of splash screen
     */
    protected void onStart(){
        super.onStart();
        handler = new Handler();
        handler.postDelayed(runner, DELAY);
    }

    /**
     * Thread to make the delay possible before loading next screen
     */
    private final  Runnable runner = new Runnable() {
        @Override
        public void run() {
            nextScreen();
        }
    };

    /**
     * Helper method to load next screen
     */
    private void nextScreen(){

        Intent i = new Intent(this, edu.wcu.cs.catamountcharacters.Screen2.class);
        this.startActivity(i);
    }
}
