package com.example.calculator;

public class Conversions {
    public static void solveConversion(String x){
        operators.equals(); // carrying out any outstanding operations before attempting to convert values.

        switch(x){
            case "Binary":
                Controller.total = Double.parseDouble((Integer.toBinaryString((int) Controller.total)));
                modifyDisplay.setTotal();
                Controller.calculationsBox_Static.setText("bin(" + modifyDisplay.getCalculationsBoxText() + ")=" + modifyDisplay.roundTo3.format(Controller.total));

                case "Hexadecimal":
                System.out.println("Soon");
        }
    }

}
