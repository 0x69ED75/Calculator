package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    public static int total = 0;


    @FXML
    private Label Display;

    static Label Display_Static;

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
    private Button additionButton;

    @FXML
    private Button subtractionButton;

    @FXML
    private Button equalsButton;

    @FXML
    private Button ZeroSelect;

    @FXML
    /* Appending the button's text to Display.
    Usually, this would need a different method for each button, each method calling the modifyDisplay method with the integer of the button pressed as parameter.
    However, I have shortened this down to a single method by grabbing the eventsource, which gives a set of information about where the event was called from.
    In this case, it would return The Button ID, Styleclass and finally, the text contained within the button.
    If I parse this as a string, and take only the penultimate character, I can successfully extract the text from the button, effectively grabbing the buttons integer value.
     */
    void appendChosen(ActionEvent event) {
        String x = event.getSource().toString(); // getting the source of the event, in this case, the button's ID, style class and the button's text.
        int buttonValue = (Character.getNumericValue((x.charAt(x.length()-2)))); // I only want the penultimate character in the button's source, which is the Button's text.
        Display_Static = Display;
        modifyDisplay.append(buttonValue);
    }
    @FXML
    void deleteAction(ActionEvent event) {
        Display_Static = Display;
        modifyDisplay.removeLast();
    }
    @FXML
    void operandSolve(ActionEvent event) {
        String x = event.getSource().toString();
        char operand = x.charAt(x.length()-2);
        operands.chooseOperand(operand);

    }

    @FXML
    void clearAction(ActionEvent event) {
        modifyDisplay.clearDisplay();
        total = 0;
    }


}
