package com.example.calculator;
import java.text.DecimalFormat;

/*
The modifyDisplay class stores any method which interacts with the total amount display.
For example, appending to the display or removing the last digit in the display.
 */
public class modifyDisplay {
    static DecimalFormat roundTo3 = new DecimalFormat("0.###"); // Rounding output to 3 decimal places.

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

    // This method removes the last digit currently stored in the total display as well as removing the last digit stored in the calculations box
    public static void removeLast(){
        StringBuilder x = new StringBuilder(getDisplayText());
        if(x.length() > 0){
            Controller.Display_Static.setText(x.deleteCharAt(x.length()-1).toString());
        }
    }

    // This method is very similar to appendchar, except, instead of appending, we are completely replacing any existing text.
    public static void replaceTextSymbol(char x){
        Controller.Display_Static.setText(String.valueOf(x));
    }

    // This method completely clears the value stored in the total display. It must be an empty string, as not to be set to null and cause errors elsewhere.
    public static void clearDisplay(){
        Controller.Display_Static.setText(" ");
    }

    // This method sets the total display to the value currently stored in public variable 'total'.
    public static void setTotal(){
        Controller.Display_Static.setText(String.valueOf(roundTo3.format(Controller.total)));
        Controller.Display_Static.setText(" " + getDisplayText());
    }

    // This method gets the length of the display.
    public static int getDisplayLength(){
        return getDisplayText().length();
    }

    // This method prints an error message to the display.
    public static void errorDisplay()  {
        Controller.Display_Static.setText("Error");
    }

    // This method appends any numbers to the calculations box, rounded to 3dp.
    public static void calculationsBoxAppend(double num){
        Controller.calculationsBox_Static.setText(getCalculationsBoxText() + String.valueOf((roundTo3.format(num))));
    }

    // This method appends any symbols to the calculations box.
    public static void calculationsBoxAppendChar(char x){
        if(x != '='){ // appending any symbol except for the equals symbol, as I will need to append this after calculations are complete. manually..
            Controller.calculationsBox_Static.setText(getCalculationsBoxText() + String.valueOf(x));
        }
    }

    // This method gets the calculations box text.
    public static String getCalculationsBoxText(){
        return Controller.calculationsBox_Static.getText();
    }

   // This method clears the calculation box text.
    public static void clearCalculationBox(){
        Controller.calculationsBox_Static.setText("");
    }

    // This method removes the last char in the calculations box.
    public static void calculationsBoxRemoveLast(){
        StringBuilder x = new StringBuilder(getCalculationsBoxText());
        if(x.length() > 0){
            Controller.calculationsBox_Static.setText(x.deleteCharAt(x.length()-1).toString());
        }
    }

    }
