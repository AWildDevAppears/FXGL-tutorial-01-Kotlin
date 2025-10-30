module uk.co.awilddevappears.fxgltutorialproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires com.almasb.fxgl.all;

    opens uk.co.awilddevappears.fxgltutorialproject to javafx.fxml;
    exports uk.co.awilddevappears.fxgltutorialproject;
}