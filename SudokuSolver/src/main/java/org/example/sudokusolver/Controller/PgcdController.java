package org.example.sudokusolver.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.sudokusolver.Model.ValueField;
import solver.solvercsp.Contraintes.Binaire.XequalsY;
import solver.solvercsp.IntDomaine;
import solver.solvercsp.SolverCSP;
import solver.solvercsp.Variable;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;

public class PgcdController {
    @FXML
    VBox allValues;
    @FXML
    TextField value1;
    @FXML
    TextField value2;
    @FXML
    Button addValue;
    @FXML
    Button solve;
    @FXML
    Button reset;
    @FXML
    Label result;
    SolverCSP solver;

    public void initialize(){
        this.solver = new SolverCSP();

    }

    public void deleteValue(ValueField val){
        val.deleteValue();
        allValues.getChildren().remove(val);
        solver = new SolverCSP();
    }

    @FXML
    public void addValueAction(){
        ValueField valueField = new ValueField();
        allValues.getChildren().add(valueField);
        valueField.getDelVal().setOnAction(e->{
            deleteValue(valueField);
        });
    }

    public void createVars(){
//        ArrayList<Integer> domaine = new ArrayList<>();
//        int val = this.value1.getText();
//        for (int div = 1; div <= vf.getTFvalue(); div++){     //ajouter value1 et value2 et arnaud verif si c'est du int
//            if (vf.getTFvalue() % div == 0){
//                domaine.add(div, div);
//            }
//        }
//        solver.addVariable(new Variable("var" + (i + 2), new IntDomaine(domaine)));
        for (int i = 0; i < ValueField.valuesList.size(); i++){
            ArrayList<Integer> domaine = new ArrayList<>();
            ValueField vf = ValueField.valuesList.get(i);
            for (int div = 1; div <= vf.getTFvalue(); div++){
                if (vf.getTFvalue() % div == 0){
                    domaine.add(div, div);
                }
            }
            solver.addVariable(new Variable("var" + (i + 2), new IntDomaine(domaine)));
        }
    }
    public void createConts(){
        for (int var1 = 1; var1 < solver.getCompteurVar() - 1; var1++){
            for (int var2 = 2; var2 < solver.getCompteurVar(); var2++){
                XequalsY cont = new XequalsY(solver.getVar(var1), solver.getVar(var2));
                solver.addContrainte(cont);
            }
        }
    }
    @FXML
    public void solveAction(){
        createVars();
        createConts();
        solver.evaluate();
    }
    @FXML
    public void resetAction(){
        value1.clear();
        value1.setPromptText("Enter a value...");
        value2.clear();
        value2.setPromptText("Enter a value...");
        for(int i = 0; i < ValueField.valuesList.size(); i++){
            ValueField.valuesList.get(i).resetTF();
        }
    }
}
