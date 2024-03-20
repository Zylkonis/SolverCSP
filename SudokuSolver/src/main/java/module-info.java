module org.example.sudokusolver {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.sudokusolver to javafx.fxml;
    exports org.example.sudokusolver;
    opens org.example.sudokusolver.Controller;
}