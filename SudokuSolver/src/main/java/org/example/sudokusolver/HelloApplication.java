package org.example.sudokusolver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("maquette_pgcd.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sudoku.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("PGCD");
        stage.setScene(scene);
        stage.show();
    }

    public static void start2() throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("maquette_pgcd.fxml"));
        closeAllWindows();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("resultsudoku.fxml"));
        Stage newstage = new Stage();
        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            newstage.setTitle("PGCD");
            newstage.setScene(scene);
            newstage.show();
            //Stage stage = (Stage) (nouvellePageParent.getScene().getWindow());
            //stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeAllWindows() {
        for (Window window : Window.getWindows()) {
            if (window instanceof Stage) {
                ((Stage) window).close();
            }
        }
    }


    public static void main(String[] args) {
        launch();
    }
}