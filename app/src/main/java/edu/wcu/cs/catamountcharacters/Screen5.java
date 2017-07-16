package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
/**
 * App: Catamount Characters (Screen 5)
 * This screen provides users opportunity to choose which image they
 * want to display
 * Author: Gajjan Jasani
 * version: 1.0
 */
public class Screen5 extends Activity implements View.OnClickListener{

    /** Buttons to handle user input */
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;

    /**
     * Method: onCreate
     * This method sets up the screen 5 on the device
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen5);
    }

    /**
     * Method: onStart
     * makes all 5 buttons clickable to get the user input
     */
    @Override
    protected void onStart(){
        super.onStart();
        // Connecting the xml screen 5's button elements with code
        btn1 = (Button) findViewById(R.id.scr5_btn1);
        btn2 = (Button) findViewById(R.id.scr5_btn2);
        btn3 = (Button) findViewById(R.id.scr5_btn3);
        btn4 = (Button) findViewById(R.id.scr5_btn4);
        btn5 = (Button) findViewById(R.id.scr5_btn5);
        //making those buttons to listen to user click (touch)
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    /**
     * Method: onClick
     * This method loads screen associated to the button clicked by the user
     * @param v - the clickable view (button) element that has been clicked/touched
     */
    @Override
    public void onClick(View v) {

        // casting the clicked view element to a button
        Button b = (Button) v;
        // Intent to navigate to the screen 6
        Intent selected_screen = new Intent(this, Screen6.class);
        //putting an appropriate resource string names in the bundle to pass them
        // to the next screen depending on the button clicked
        if(b.getId() == R.id.scr5_btn1){
            selected_screen.putExtra("image","cat");
        }else if(b.getId() == R.id.scr5_btn2){
            selected_screen.putExtra("image", "tower");
        }else if(b.getId() == R.id.scr5_btn3){
            selected_screen.putExtra("image", "computer");
        }else  if(b.getId() == R.id.scr5_btn4){
            selected_screen.putExtra("image", "science");
        }else  if(b.getId() == R.id.scr5_btn5){
            selected_screen.putExtra("image", "cs467");
        }
        this.startActivity(selected_screen); //starting the screen 6
    }


}
