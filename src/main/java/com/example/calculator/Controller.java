package com.example.calculator;
/*
Controller stores the GUI elements and also stores the methods which buttons will call.
The methods which each button calls as well as more information about the GUI elements can be read in Calculator-view.fxml
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    public static double total = 0;
    @FXML
    private Label Display;
    static Label Display_Static; // making a static version of Display to be accessed outside of Controller, errors occur when trying to use setters / getters in this class.
    @FXML
    private Label calculationsBox;
    static Label calculationsBox_Static; // making a static version of calculationsBox to be accessed outside of Controller, errors occur when trying to use setters / getters in this class.
    @FXML
    private Button EightSelect;
    @FXML
    private Button FiveSelect;
    @FXML
    private Button FourSelect;
    @FXML
    private Button NineSelect;
    @FXML
    private Button OneSelect;
    @FXML
    private Button SevenSelect;
    @FXML
    private Button SixSelect;
    @FXML
    private Button ThreeSelect;
    @FXML
    private Button TwoSelect;
    @FXML
    private Button deleteButton;
    @FXML
    private Button divisionButton;
    @FXML
    private Button additionButton;
    @FXML
    private Button multiplicationButton;
    @FXML
    private Button subtractionButton;
    @FXML
    private Button equalsButton;
    @FXML
    private Button ZeroSelect;
    @FXML
    private Button decimalSelect;
    @FXML
    private Button sqrtSelect;
    @FXML
    private Button binarySelect;
    @FXML
    private Button hexSelect;
    @FXML
    /* Appending the button's text to Display.
    Usually, to successfully pass the correct number to the modifyDisplay class, I  would need a different method for each button, with each method calling the modifyDisplay method with the integer of the button pressed as parameter.
    However, I have shortened this down to a single method by grabbing the eventsource, which gives a set of information about where the event was called from.
    In this case, it would return The Button ID, the buttons' 'Styleclass' and finally, the text contained within the button.
    I can successfully extract the text from the button using .getText, effectively grabbing the buttons' integer value.
     */
    void appendChosen(ActionEvent event) {
        // Getting the source of the event, which is the button the user pressed, then getting the text of this button, which is the number the user pressed. It is therefore parsed as int.
        int buttonValue = Integer.parseInt((((Button)event.getSource()).getText()));
        Display_Static = Display;
        calculationsBox_Static = calculationsBox;
        modifyDisplay.append(buttonValue);
        modifyDisplay.calculationsBoxAppend(buttonValue);
    }

    // This method runs similarly to appendChosen, but is capable of appending characters, not Integers.
    @FXML
    void appendDecimal(ActionEvent event) {
        char buttonValue = ((Button)event.getSource()).getText().charAt(0);
        Display_Static = Display;
        calculationsBox_Static = calculationsBox;
        modifyDisplay.appendChar(buttonValue);
        modifyDisplay.calculationsBoxAppendChar(buttonValue);
    }

    @FXML
    // This method runs when the Delete button is pressed, to remove a single digit.
    void deleteAction(ActionEvent event) {
        Display_Static = Display;
        modifyDisplay.removeLast();
        modifyDisplay.calculationsBoxRemoveLast();
    }

    @FXML
    // This method runs when an operator is pressed.
    void operatorSolve(ActionEvent event) {

        try { // Try-catch to handle improper uses of operators, such as using operators before an integer has been entered. An exception for denoting negative numbers exists in operators.chooseOperator
            Display_Static = Display;
            calculationsBox_Static = calculationsBox;
            char operator = ((Button)event.getSource()).getText().charAt(0);
            operators.chooseOperator(operator);
            modifyDisplay.calculationsBoxAppendChar(operator);
        }
        catch(Exception e){
            modifyDisplay.errorDisplay();
            System.out.println("Illegal use of operators");
        }
    }

    @FXML
    // This runs when the clear button is pressed. It runs the clear display methods, as well as sets total to 0.
    void clearAction(ActionEvent event) {
        Display_Static = Display;
        calculationsBox_Static = calculationsBox;
        modifyDisplay.clearDisplay();
        modifyDisplay.clearCalculationBox();
        operators.flag = 0;
        total = 0;
    }

    @FXML
    // This runs when square root is pressed. It has error handling, as well as running the 'squareRoot' method in 'operators'
    void squareRootAction(ActionEvent event) {
        Display_Static = Display;
        calculationsBox_Static = calculationsBox;

        try {
            operators.squareRoot();
            Controller.calculationsBox_Static.setText("sqrt(" + modifyDisplay.getCalculationsBoxText() + ") =" + modifyDisplay.roundTo3.format(Controller.total));
        }
        catch (Exception e){ // catches any improper use of square root, e.g. using square root when no number is entered or when an invalid input is entered.
            System.out.println("Illegal sqrt Operation");
            modifyDisplay.errorDisplay();
        }
    }

    @FXML
    // This method is responsible for resolving the conversion the user wishes to complete, then carrying out this conversion through the 'Conversions' class.
    void conversionSolve(ActionEvent event) {
        Display_Static = Display;
        calculationsBox_Static = calculationsBox;

        // Getting the text of the button that was clicked. This will be used to understand which button the user pressed.
        String x = (((Button)event.getSource()).getText());  // i.e. if the user presses the binary button, the value of x is "Binary"

       try {
            Conversions.solveConversion(x);
        }
       catch (Exception e){
           System.out.println("Illegal Conversion");
           modifyDisplay.errorDisplay();
        }

    }


}
