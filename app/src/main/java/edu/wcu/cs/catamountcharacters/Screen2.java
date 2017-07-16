package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * App: Catamount Characters (Screen 2)
 * This screen provides users opportunity to choose if they want to display
 * one character, two characters, an image or application information
 * Author: Gajjan Jasani
 * version: 1.0
 */
public class Screen2 extends Activity implements View.OnClickListener {

    /** Buttons to handle user input */
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    /**
     * Method: onCreate
     * This method sets up the screen 2 on the device
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
    }

    /**
     * Method: onStart
     * makes all 4 buttons clickable to get the user input
     */
    @Override
    protected void onStart(){
        super.onStart();
        // Connecting the xml screen 2's button elements with code
        btn1 = (Button) findViewById(R.id.scr2_btn1);
        btn2 = (Button) findViewById(R.id.scr2_btn2);
        btn3 = (Button) findViewById(R.id.scr2_btn3);
        btn4 = (Button) findViewById(R.id.scr2_btn4);
        //making those buttons to listen to user click (touch)
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    /**
     * Method: onClick
     * This method loads screen associated to the button clicked by the user
     * @param v - the clickable view (button) element that has been clicked/touched
     */
    @Override
    public void onClick(View v) {

        // casting the clicked view element to a button because we
        // know it is a button
        Button b = (Button) v;

        // Intent to navigate to the screen selected by user
        Intent selected_screen = new Intent(this, Screen5.class);

        if(b.getId() == R.id.scr2_btn1){
            selected_screen = new Intent(this,Screen3.class);
        }else if(b.getId() == R.id.scr2_btn2){
            selected_screen = new Intent(this,Screen4.class);
        }else if(b.getId() == R.id.scr2_btn3){
            selected_screen = new Intent(this, Screen5.class);
        }else  if(b.getId() == R.id.scr2_btn4){
            selected_screen = new Intent(this, Screen8.class);
        }
        this.startActivity(selected_screen); //starting the user selected activity
    }
}
