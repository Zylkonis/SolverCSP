package org.example.sudokusolver.Model;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ValueField extends HBox {
    public static ArrayList<ValueField> valuesList = new ArrayList<>();
    private int index;
    private Label labVal = new Label();
    private TextField tfVal = new TextField();
    private Button delVal = new Button("Delete Value");

    public ValueField(){
        super();
        this.index = valuesList.size();
        this.labVal.setText("Value n°" + (this.index + 3) + ": ");
        this.tfVal.setPromptText("Enter a value...");
        this.getChildren().addAll(this.labVal, this.tfVal, this.delVal);
        valuesList.add(this);
    }

    public void setLabVal(int index){
        this.labVal.setText("Value n°" + (index + 3));
    }

    public int getTFvalue(){
        int val = -1;
        try {
            val = Integer.parseInt(this.tfVal.getText());
        }
        catch (NumberFormatException e){
            System.out.println("erreur: la valeur n'est pas un entier");
        }
        return val;
    }

    public Button getDelVal(){
        return this.delVal;
    }

    public void deleteValue(){
        for (int i = this.index + 1; i < valuesList.size(); i++){
            valuesList.get(i).setLabVal(i);
        }
        valuesList.remove(this);
    }

    public void resetTF(){
        this.tfVal.clear();
        this.tfVal.setPromptText("Enter a value...");
    }

}
