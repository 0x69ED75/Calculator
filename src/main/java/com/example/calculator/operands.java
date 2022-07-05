package com.example.calculator;

public class operands {

    public static char flag = 0;
    public static void chooseOperand(char x){
        switch (x) {
            case '+' -> {
                Controller.total = Integer.parseInt(modifyDisplay.getDisplayText());
                modifyDisplay.clearDisplay();
                flag = '+';
            }
            case '-' -> {
                Controller.total = Integer.parseInt(modifyDisplay.getDisplayText());
                modifyDisplay.clearDisplay();
                flag = '-';
            }
            case '=' -> {
                equals();
            }
        }
    }

    public static void equals(){
        switch(flag){
            case '+' :{
                Controller.total += Integer.parseInt(modifyDisplay.getDisplayText());
                modifyDisplay.setTextOperation();
            }
            case '-' :{
                Controller.total -= Integer.parseInt(modifyDisplay.getDisplayText());
                modifyDisplay.setTextOperation();
            }
        }
    }

}
