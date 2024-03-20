package org.example.sudokusolver.Controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class ResultSudokuController {
    @FXML
    GridPane sudokuGrid;

    public static ArrayList<Integer> theresults = new ArrayList<>();

    public void initialize() {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                Label lab = new Label(String.valueOf(theresults.get(0)));
                lab.setStyle("-fx-font-size: 12pt");
                GridPane.setHalignment(lab, javafx.geometry.HPos.CENTER);
                GridPane.setValignment(lab, javafx.geometry.VPos.CENTER);
                theresults.remove(0);
                this.sudokuGrid.add(lab, j, i);
                //this.sudokuGrid.setAlignment(Pos.CENTER);
            }
        }
    }

    @FXML
    public void thenewgrid()
    {

    }
}
