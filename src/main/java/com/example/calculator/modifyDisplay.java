package com.example.calculator;

public class modifyDisplay {

    public static void append(int num){
        Controller.Display_Static.setText(getDisplayText() + String.valueOf(num));
    }

    public static String getDisplayText(){
        return Controller.Display_Static.getText();
    }

    public static void removeLast(){
        StringBuilder x = new StringBuilder(getDisplayText());
        if(x.length() > 0){
            Controller.Display_Static.setText(x.deleteCharAt(x.length()-1).toString());
        }

    }

    public static void clearDisplay(){
        Controller.Display_Static.setText("");
    }

    public static void setTextOperation(){
        Controller.Display_Static.setText(String.valueOf(Controller.total));
    }



}
