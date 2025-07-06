// Jacob Achenbach
// 7/6/2025

// Creates four styled circles using the external CSS file to get their colors, borders, and layout in an HBox and VBox.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DisplayCircle extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create circles
        Circle circle1 = new Circle(30);
        circle1.getStyleClass().add("plaincircle"); // White fill with black stroke

        Circle circle2 = new Circle(30);
        circle2.getStyleClass().add("plaincircle"); // White fill with black stroke

        Circle circle3 = new Circle(30);
        circle3.setId("redcircle"); // Red fill with red stroke

        Circle circle4 = new Circle(30);
        circle4.setId("greencircle"); // Green fill with green stroke

        // VBox with the border for the first circle
        VBox borderedBox = new VBox(circle1);
        borderedBox.getStyleClass().add("border"); // Black border

        // HBox for the other three circles
        HBox rightCircles = new HBox(10, circle2, circle3, circle4);

        // Main HBox to arrange everything
        HBox root = new HBox(10, borderedBox, rightCircles);

        // The Scene
        Scene scene = new Scene(root, 300, 150);

        // Load the external CSS properly
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        primaryStage.setTitle("DisplayCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
