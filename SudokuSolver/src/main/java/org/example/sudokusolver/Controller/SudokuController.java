package org.example.sudokusolver.Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuController {

    @FXML
    GridPane SudokuGrid;

    @FXML
    GridPane DigitGrid;

    TextField selected;

    public void initialize() {
        for (Node child : SudokuGrid.getChildren()) {
            if (child instanceof GridPane) {
                for (Node child2 : ((GridPane) child).getChildren()) {
                    if (child2 instanceof TextField) {
                        ((TextField) child2).setOnAction(event -> {
                            selected = (TextField) event.getTarget();
                            System.out.println(selected.getText());
                        });
                    }
                }
            }
        }


        for (Node child2 : DigitGrid.getChildren()) {
            if (child2 instanceof TextField) {
            child2.setOnMouseClicked(event -> {
                String txt = ((Button)(event.getTarget())).getText();
                selected.setText(txt);
            });
            }
        }
    }
}