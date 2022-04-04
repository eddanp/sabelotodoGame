module com.eddanp.sabelotodogame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.eddanp.sabelotodogame to javafx.fxml;
    exports com.eddanp.sabelotodogame;
}