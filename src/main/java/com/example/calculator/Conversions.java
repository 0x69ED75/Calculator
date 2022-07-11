package com.example.calculator;

public class Conversions {
    public static void solveConversion(String x){
        operators.equals(); // carrying out any outstanding operations before attempting to convert values.
        if(Controller.total < 0){modifyDisplay.errorDisplay(); return;}

        switch (x) {
            case "Binary" -> {
                Controller.total = Double.parseDouble((Integer.toBinaryString((int) Controller.total)));
                modifyDisplay.setTotal();
                Controller.calculationsBox_Static.setText("bin(" + modifyDisplay.getCalculationsBoxText() + ")=" + modifyDisplay.roundTo3.format(Controller.total));
            }
            case "Hex" -> {
                try {
                    Controller.total = Double.parseDouble((Integer.toHexString((int) Controller.total)));
                    modifyDisplay.setTotal();
                    Controller.calculationsBox_Static.setText("hex(" + modifyDisplay.getCalculationsBoxText() + ")=" + modifyDisplay.roundTo3.format(Controller.total));

                }
                catch (Exception e){ // In the case that the hexadecimal result contains letters, this will run, since, modifyDisplay.setTotal cannot support characters.
                    modifyDisplay.setString(Integer.toHexString((int) Controller.total));
                    Controller.calculationsBox_Static.setText("hex(" + modifyDisplay.getCalculationsBoxText() + ")=" +(Integer.toHexString((int) Controller.total)));
                }
            }
        }
    }

}
