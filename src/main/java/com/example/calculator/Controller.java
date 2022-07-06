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
    /* Appending the button's text to Display.
    Usually, to successfully pass the correct number to the modifyDisplay class, I  would need a different method for each button, with each method calling the modifyDisplay method with the integer of the button pressed as parameter.
    However, I have shortened this down to a single method by grabbing the eventsource, which gives a set of information about where the event was called from.
    In this case, it would return The Button ID, the buttons' 'Styleclass' and finally, the text contained within the button.
    If I parse this as a string, and take only the penultimate character, I can successfully extract the text from the button, effectively grabbing the buttons' integer value.
     */
    void appendChosen(ActionEvent event) {
        String x = event.getSource().toString(); // getting the source of the event, in this case, the button's ID, style class and the button's text.
        int buttonValue = (Character.getNumericValue((x.charAt(x.length()-2)))); // I only want the penultimate character in the button's source, which is the Button's text.
        Display_Static = Display;
        modifyDisplay.append(buttonValue);
    }

    // This method runs similarly to appendChosen, but is capable of appending characters, not Integers.
    @FXML
    void appendDecimal(ActionEvent event) {
        String x = event.getSource().toString();
        char buttonValue = (x.charAt(x.length()-2));
        Display_Static = Display;
        modifyDisplay.appendChar(buttonValue);
    }

    @FXML
    // This method runs when the Delete button is pressed, to remove a single digit.
    void deleteAction(ActionEvent event) {
        Display_Static = Display;
        modifyDisplay.removeLast();
    }

    @FXML
    // This method runs when an operator is pressed.
    void operatorSolve(ActionEvent event) {
        String x = event.getSource().toString();
        char operator = x.charAt(x.length()-2);
        operators.chooseOperator(operator);

    }

    @FXML
    // This runs when the clear button is pressed. It runs the clear display methods, as well as sets total to 0.
    void clearAction(ActionEvent event) {
        modifyDisplay.clearDisplay();
        total = 0;
    }


}
