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

        /*This if statement handles the multiple use cases of the subtraction symbol, such as that to denote a negative integer.
           For example, without this, the code could not handle equations such as 5+-5, as after pressing +, an operand is expected, but an operator was given.
           An exception to this rule is made when the flag is subtraction, as then it is likely the user wishes to do compound subtraction such as 5-10-15 rather than denote negative numbers. */
        if(x == '-' && modifyDisplay.getDisplayText().length()==1 && flag != 0){
            modifyDisplay.replaceTextSymbol('-');
            return;
        }
        /* This next if statement is crucial for completing multiple calculations without pressing equals, (e.g. 5+5+5+1 = 16, without this, we would only get the last two digits, 5+1)
           It does this by calling the equals' method silently between operations, to keep a running sum.
         */
        if(flag != 0 && x != '='){
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
                try { // this try catch statement catches fringe uses of the subtraction symbol, such as that to denote negative numbers before anything else has been entered into the application.
                    Controller.total = Double.parseDouble(modifyDisplay.getDisplayText());
                    modifyDisplay.clearDisplay();
                    flag = '-';
                }
                catch (Exception e){ // The only exception here can be that the user has chosen to begin with a negative number, such as entering "-5"
                    modifyDisplay.replaceTextSymbol('-');
                }
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
            case '=' -> {
                equals();
            }
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
        modifyDisplay.setTextOperation();
        Controller.calculationsBox_Static.setText(modifyDisplay.getCalculationsText() + '=');
        modifyDisplay.appendCalculations(Controller.total);
        flag = 0;
    }

}
