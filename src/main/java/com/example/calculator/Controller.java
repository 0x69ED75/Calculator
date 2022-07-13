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

    private final operators operation = new operators();

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
    private Label binaryOut;
    static Label binaryOut_Static;
    @FXML
    private Label hexOut;
    static Label hexOut_Static;
    @FXML
    private Label denaryOut;
    static Label denaryOut_Static;
    @FXML
    private Label octOut;
    static Label octOut_Static;

    @FXML
    /* Appending the button's text to Display.
    Usually, to successfully pass the correct number to the modifyDisplay class, I  would need a different method for each button, with each method calling the modifyDisplay method with the integer of the button pressed as parameter.
    However, I have shortened this down to a single method by grabbing the eventsource, which gives a set of information about where the event was called from.
    In this case, it would return The Button ID, the buttons' 'Styleclass' and finally, the text contained within the button.
    I can successfully extract the text from the button using .getText, effectively grabbing the buttons' integer value.
     */
    void appendChosen(ActionEvent event) {
        updateStaticVariables();
        // Getting the source of the event, which is the button the user pressed, then getting the text of this button, which is the number the user pressed. It is therefore parsed as int.
        int buttonValue = Integer.parseInt((((Button)event.getSource()).getText()));
        modifyDisplay.append(buttonValue);
        modifyDisplay.calculationsBoxAppend(buttonValue);
    }

    // This method runs similarly to appendChosen, but is capable of appending characters, not Integers.
    @FXML
    void appendDecimal(ActionEvent event) {
        updateStaticVariables();
        char buttonValue = ((Button)event.getSource()).getText().charAt(0);
        modifyDisplay.appendChar(buttonValue);
        modifyDisplay.calculationsBoxAppendChar(buttonValue);
    }

    @FXML
    // This method runs when the Delete button is pressed, to remove a single digit.
    void deleteAction(ActionEvent event) {
        updateStaticVariables();
        modifyDisplay.removeLast();
        modifyDisplay.calculationsBoxRemoveLast();
    }

    @FXML
    // This method runs when an operator is pressed.
    void operatorSolve(ActionEvent event) {
        updateStaticVariables();
        try { // Try-catch to handle improper uses of operators, such as using operators before an integer has been entered. An exception for denoting negative numbers exists in operators.chooseOperator
            char operator = ((Button)event.getSource()).getText().charAt(0);
            operation.chooseOperator(operator);
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
        updateStaticVariables();
        modifyDisplay.clearDisplay();
        modifyDisplay.clearCalculationBox();
        Conversions.conversionClear();
        operation.flag = 0;
        total = 0;
    }

    @FXML
    // This runs when square root is pressed. It has error handling, as well as running the 'squareRoot' method in 'operators'
    void squareRootAction(ActionEvent event) {
        updateStaticVariables();

        try {
            operation.squareRoot();
            Controller.calculationsBox_Static.setText("sqrt(" + modifyDisplay.getCalculationsBoxText() + ") =" + modifyDisplay.roundTo3.format(Controller.total));
        }
        catch (Exception e){ // catches any improper use of square root, e.g. using square root when no number is entered or when an invalid input is entered.
            System.out.println("Illegal sqrt Operation");
            modifyDisplay.errorDisplay();
        }
    }

    // This initialises all the static labels created above, by putting them in a method I don't have to keep typing them out.
    // However, in an ideal world I would not use static variables at all...
     void updateStaticVariables(){
        Display_Static = Display;
        calculationsBox_Static = calculationsBox;
        binaryOut_Static = binaryOut;
        hexOut_Static = hexOut;
        denaryOut_Static = denaryOut;
        octOut_Static = octOut;
    }

}
