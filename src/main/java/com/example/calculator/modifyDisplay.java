package com.example.calculator;
import java.text.DecimalFormat;

/*
The modifyDisplay class stores any method which interacts with the total amount display.
For example, appending to the display or removing the last digit in the display.
 */
public class modifyDisplay {

    // This method appends the digit the user has pressed on the GUI onto the total.
    public static void append(int num){
        Controller.Display_Static.setText(getDisplayText() + String.valueOf(num));
    }

    // This method appends the character the user has pressed on the GUI onto the total.
    public static void appendChar(char x){
        Controller.Display_Static.setText(getDisplayText() + String.valueOf(x));
    }

    // This method gets the current value stored in the Total label.
    public static String getDisplayText(){
        return Controller.Display_Static.getText();
    }

    // This method removes the last digit currently stored in the total display.
    public static void removeLast(){
        StringBuilder x = new StringBuilder(getDisplayText());
        if(x.length() > 0){
            Controller.Display_Static.setText(x.deleteCharAt(x.length()-1).toString());
        }
    }

    // This method completely clears the value stored in the total display.
    public static void clearDisplay(){
        Controller.Display_Static.setText("");
    }

    // This method sets the total display to the value currently stored in public variable 'total'.
    public static void setTextOperation(){
        DecimalFormat roundTo3 = new DecimalFormat("0.###"); // Rounding output to 3 decimal places.
        Controller.Display_Static.setText(String.valueOf(roundTo3.format(Controller.total)));
    }



}
