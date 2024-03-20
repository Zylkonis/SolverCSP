package org.example.sudokusolver.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.example.sudokusolver.HelloApplication;
import org.example.sudokusolver.Model.SudokuModel;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.Variable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class SudokuController {

    @FXML
    GridPane sudokuGrid;



    @FXML
    GridPane DigitGrid;

    @FXML
    Button NumberOne;
    @FXML
    Button NumberTwo;
    @FXML
    Button NumberThree;
    @FXML
    Button NumberFour;
    @FXML
    Button NumberFive;
    @FXML
    Button NumberSix;
    @FXML
    Button NumberSeven;
    @FXML
    Button NumberEight;
    @FXML
    Button NumberNine;
    @FXML
    Button DeleteButton;
    @FXML
    VBox bottomVbox;

    TextField selectedCase = null;
    String selectedInt;

    private SudokuModel mysudoku = new SudokuModel();

    public void initialize() {

        // Création d'un UnaryOperator pour filtrer les entrées
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[1-9]?")) { // Vérifie si la nouvelle valeur est entre 1 et 9
                return change;
            }
            return null; // Rejette le changement s'il ne correspond pas au modèle
        };

        //action et crétion Textfield Grille sudoku
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextFormatter<String> textFormatter = new TextFormatter<>(filter);
                TextField t1 = new TextField();
                t1.setTextFormatter(textFormatter);
                t1.setStyle("-fx-background-color: transparent");
                sudokuGrid.add(t1, i, j);
                final int x = i;
                final int y = j;
                t1.setOnMouseClicked(event ->{
                    selectedCase = (TextField) event.getSource();
                });

                t1.setOnKeyPressed(event -> {
                    String keyPressed = event.getText();
                    if(keyPressed.matches("[1-9]?")){

                    }
                });


        }
        }
//action boutton pavé numérique
        for (Node child : DigitGrid.getChildren()) {
            child.setOnMouseClicked(event -> {
                Button clickedButton = (Button) event.getSource();

                if (selectedCase != null) {
                    selectedCase.setText(clickedButton.getText());
                    mysudoku.modifVariable(GridPane.getRowIndex(selectedCase), GridPane.getColumnIndex(selectedCase), Integer.parseInt(clickedButton.getText()));
                }

            });
        }
//action boutton delete
        DeleteButton.setOnMouseClicked(event -> {
            if (selectedCase != null) {
                selectedCase.setText("");
                mysudoku.resetCase(GridPane.getRowIndex(selectedCase), GridPane.getColumnIndex(selectedCase));
            }

        });
        }
    @FXML
    public void resetthegrid()
    {

        mysudoku.resetGrid();
        for(Node child : sudokuGrid.getChildren()){
            if (child instanceof TextField)
                ((TextField)child).setText("");
        }
        //aussi tout supprimer dans l'affichage
    }


    @FXML
    public void solvethegrid ()
    {
        ArrayList<Integer> results = mysudoku.lauchSolve();
        if (!results.isEmpty())
        {
            System.out.println("SOLUTION TROUVEE JE LANCE LA PAGE 2");
            ResultSudokuController.theresults = results;
            try
            {
                HelloApplication.start2();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Label failLabel = new Label("THERE IS NO SOLUTION FOR THIS GRID");
            failLabel.setStyle("-fx-text-fill: red; -fx-font-family: fantasy; -fx-font-size: 20pt;");
            this.bottomVbox.getChildren().add(failLabel);
        }
        //Faire l'affichage du solve.
    }

}