package edu.wcu.cs.catamountcharacters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * App: Catamount Characters (Screen 4)
 * This screen provides users interface to enter their choice of two
 * alphanumeric characters which they want to display on the device screen
 * Author: Gajjan Jasani
 * version: 1.0
 */
public class Screen4 extends Activity implements View.OnClickListener {

    /** Button to go to screen 7 */
    Button btn1;

    /**
     * Method: onCreate
     * This method sets up the screen 4 on the device and
     * connect the xml screen 4's button element with code
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        btn1 = (Button) findViewById(R.id.scr4_btn1);
        btn1.setOnClickListener(this);
    }

    /**
     * Method: onClick
     * This method loads screen7 and calls helper method chooseImage
     * @param v - the clickable view (button) element that has been clicked/touched
     */
    @Override
    public void onClick(View v) {

        // casting the clicked view element to a button
        Button b = (Button) v;

        // Intent to navigate to the screen7
        Intent selected_screen = new Intent(this, Screen7.class);
        if(b.getId() == R.id.scr4_btn1){
            chooseImage(selected_screen);
        }
    }

    /**
     * Helper Method: chooseImage
     * This method takes the alphanumeric characters entered by the user from
     * the editText elements and creates two string names same as the associated image
     * names in the drawable and pass those string names to screen provided in argument
     * @param i intent with the next screen
     */
    private void chooseImage(Intent i){

        /** fields to connect xml editText elements with the code */
        EditText userInput1 = (EditText) this.findViewById(R.id.scr4_edTxt1);
        EditText userInput2 = (EditText) this.findViewById(R.id.scr4_edTxt2);
        /** strings to hold the user input */
        String input1 = userInput1.getText().toString();
        String input2 = userInput2.getText().toString();

        // Making sure that the user inputs are single characters which are either
        // a number, or a letter , or a space
        if(input1.length() == 1 && input2.length() == 1 &&
                (Character.isDigit(input1.charAt(0)) ||
                Character.isLetter(input1.charAt(0)) ||
                Character.isSpaceChar(input1.charAt(0)))
                && (Character.isDigit(input2.charAt(0)) ||
                Character.isLetter(input2.charAt(0)) ||
                Character.isSpaceChar(input2.charAt(0)))){

            // modifying user inputs to associate it with related image resources
            input1+="_bl";
            input2+="_bl";
            if(Character.isDigit(input1.charAt(0))){
                input1 = "n"+input1;
            }
            if(Character.isSpaceChar(input1.charAt(0))){
                input1 = "space_bl";
            }

            if(Character.isDigit(input2.charAt(0))){
                input2 = "n"+input2;
            }
            if(Character.isSpaceChar(input2.charAt(0))){
                input2 = "space_bl";
            }
            //putting the modified resource string names in the bundle to pass them
            // to the next screen
            i.putExtra("image1", input1.toLowerCase());
            i.putExtra("image2", input2.toLowerCase());
            this.startActivity(i); //starting the activity provided in the argument

        // else if the user inputs are not appropriate, make a toast to suggest user a
        // proper input and stay on the same screen until user provides proper input
        } else {
            Toast.makeText(this.getApplicationContext(), "Please enter only one " +
                    "alphanumeric character in each box", Toast.LENGTH_LONG).show();
        }
    }
}
