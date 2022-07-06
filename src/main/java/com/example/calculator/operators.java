package com.example.calculator;
/*
The operators class works pretty abnormally, this is because the actual calculations are calculated when the user presses the equals button, not on press any of the operators. Therefore, it made this class a bit trickier than expected.
This class works by doing the following:
   - Calculating which operator the user has selected.
   - Storing this operator as public variable 'flag'
   - Storing the value currently entered by the user as the running total (stored in public variable total).
   - Clearing the display, awaiting next input.
   - When the equal operator is pressed, only then is the calculation carried out, using the operator stored in the flag on both the value stored in 'total' and the value currently displayed in the display.

   Now, normally, this would mean operations could only be carried out on 2 integers at a time, (i.e. you could not do 5+5+5+1) therefore, I added a check at the start of the method, which will check whether flag is 0.
   If the flag isn't 0, this would mean that an extra operator has been used before the equals has been pressed, and therefore it runs the "equals" method quietly in the background to calculate the running total without displaying it to the user.
 */
public class operators {

    public static char flag = 0;
    public static void chooseOperator(char x){

        if(flag != 0){
            equals();
            flag = 0;
        }

        switch (x) {
            case '+' -> {
                Controller.total = Double.parseDouble(modifyDisplay.getDisplayText());
                modifyDisplay.clearDisplay();
                flag = '+';
            }
            case '-' -> {
                Controller.total = Double.parseDouble(modifyDisplay.getDisplayText());
                modifyDisplay.clearDisplay();
                flag = '-';
            }
            case '/' -> {
                Controller.total = Double.parseDouble(modifyDisplay.getDisplayText());
                modifyDisplay.clearDisplay();
                flag = '/';
            }
            case '*' -> {
                Controller.total = Double.parseDouble(modifyDisplay.getDisplayText());
                modifyDisplay.clearDisplay();
                flag = '*';
            }
            case '=' -> equals();
        }
    }
    public static void equals(){
        switch (flag) {
            case '+' -> {
                Controller.total += Double.parseDouble(modifyDisplay.getDisplayText());
                modifyDisplay.setTextOperation();
            }
            case '-' -> {
                Controller.total -= Double.parseDouble(modifyDisplay.getDisplayText());
                modifyDisplay.setTextOperation();
            }
            case '/' -> {
                Controller.total /= Double.parseDouble(modifyDisplay.getDisplayText());
                modifyDisplay.setTextOperation();
            }
            case '*' -> {
                Controller.total *= Double.parseDouble(modifyDisplay.getDisplayText());
                modifyDisplay.setTextOperation();
            }
        }
        flag = 0;
    }

}
