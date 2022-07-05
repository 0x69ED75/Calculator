package com.example.calculator;
/*
The modifyDisplay class stores any method which interacts with the total amount display.
For example, appending to the display or removing the last digit in the display.
 */
public class modifyDisplay {

    // This method appends the digit the user has pressed on the GUI onto the total.
    public static void append(int num){
        Controller.Display_Static.setText(getDisplayText() + String.valueOf(num));
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
        Controller.Display_Static.setText(String.valueOf(Controller.total));
    }



}
