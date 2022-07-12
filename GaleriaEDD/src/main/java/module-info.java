module ec.edu.espol.galeriaedd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.galeriaedd to javafx.fxml;
    exports ec.edu.espol.galeriaedd;
}
