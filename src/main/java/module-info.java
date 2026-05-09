module ec.edu.uce.proyectocentralfood {
    requires javafx.controls;
    requires javafx.fxml;


    opens ec.edu.uce.proyectocentralfood to javafx.fxml;
    exports ec.edu.uce.proyectocentralfood;
}