package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * App: Catamount Characters (Screen 3)
 * This screen provides users interface to enter their choice of
 * alphanumeric character that they want to display on the device screen
 * Author: Gajjan Jasani
 * version: 1.0
 */
public class Screen3 extends Activity implements View.OnClickListener {

    /** Button to go to screen 6 */
    Button btn1;

    /**
     * Method: onCreate
     * This method sets up the screen 3 on the device and
     * connect the xml screen 3's button element with code
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        btn1 = (Button) findViewById(R.id.scr3_btn1);
        btn1.setOnClickListener(this);
    }

    /**
     * Method: onClick
     * This method loads screen6 and calls helper method chooseImage
     * @param v - the clickable view (button) element that has been clicked/touched
     */
    @Override
    public void onClick(View v) {

        // casting the clicked view element to a button
        Button b = (Button) v;

        // Intent to navigate to the screen6
        Intent selected_screen = new Intent(this, Screen6.class);
        if(b.getId() == R.id.scr3_btn1){
            chooseImage(selected_screen);
        }
    }

    /**
     * Helper Method: chooseImage
     * This method takes the alphanumeric character entered by the user from
     * the editText element and creates a string name same as the associated image
     * name in the drawable and pass that string name to screen provided in argument
     * @param i intent with the next screen
     */
    private void chooseImage(Intent i){

        /** field to connect xml editText element with the code */
        EditText userInput = (EditText) this.findViewById(R.id.scr3_edTxt1);
        /** string to hold the user input */
        String input = userInput.getText().toString();

        // Making sure that the user input is a single character that is either
        // a number, or a letter , or a space
        if(input.length() == 1 && (Character.isDigit(input.charAt(0)) ||
                                    Character.isLetter(input.charAt(0)) ||
                                    Character.isSpaceChar(input.charAt(0)))){

            // modifying user input to associate it with related image resource
            input+="_bl";
            if(Character.isDigit(input.charAt(0))){
                input = "n"+input;
            }
            if(Character.isSpaceChar(input.charAt(0))){
                input = "space_bl";
            }
            //putting the modified resource string name in the bundle to pass it
            // to the next screen
            i.putExtra("image", input.toLowerCase());
            this.startActivity(i); //starting the activity provided in the argument

        // if the user input is not appropriate, make a toast to suggest user a
        // proper input and stay on the same screen until user provides proper input
        } else {
            Toast.makeText(this.getApplicationContext(), "Please enter only one " +
                    "alphanumeric character", Toast.LENGTH_LONG).show();
        }
    }
}
