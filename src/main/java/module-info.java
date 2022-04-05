module com.eddanp.sabelotodogame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.eddanp.sabelotodogame to javafx.fxml;
    exports com.eddanp.sabelotodogame;
    exports com.eddanp.sabelotodogame.controller;
    opens com.eddanp.sabelotodogame.controller to javafx.fxml;
}