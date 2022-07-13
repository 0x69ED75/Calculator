package com.example.calculator;

/*
The conversion class is a utility class that handles any conversion operations to binary, hexadecimal, octal and denary(decimal) values.
 */

public class Conversions {
    // This method converts the value currently set as the total to binary, hexadecimal, decimal and octal. It is only called when the total changes.
    public static void conversionUpdate(){
        Controller.binaryOut_Static.setText((Integer.toBinaryString((int) Controller.total)));
        Controller.hexOut_Static.setText((Integer.toHexString((int) Controller.total)));
        Controller.octOut_Static.setText((Integer.toOctalString((int) Controller.total)));

        /*
        The following try except statement converts any binary value into hexadecimal.
        The try statement will run successfully if the value entered is a binary value, and therefore return a hexadecimal value
        The catch will run if the entered value isn't a binary value, and the value returned will just be the same value entered.
         */
        try {
            Controller.denaryOut_Static.setText(String.valueOf(Integer.parseInt(String.valueOf((int) Controller.total), 2)));
        }
        catch(Exception e){
            Controller.denaryOut_Static.setText(modifyDisplay.getDisplayText());
        }
    }
    // This method clears the conversion table.
    public static void conversionClear(){
        Controller.binaryOut_Static.setText(" ");
        Controller.hexOut_Static.setText(" ");
        Controller.octOut_Static.setText(" ");
        Controller.denaryOut_Static.setText(" ");

    }

}
