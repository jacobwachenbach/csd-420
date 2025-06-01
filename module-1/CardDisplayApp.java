// Jacob Achenbach Module 1 Assignment
//6/1/2025

// Simple displaying 4 random cards


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDisplayApp extends Application {

    private static final int NUM_CARDS = 52;
    private static final int NUM_TO_SHOW = 4;
    private final ImageView[] cardViews = new ImageView[NUM_TO_SHOW];

    @Override
    public void start(Stage primaryStage) {
        // Container for the four card images
        HBox cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);

        // Four empty ImageViews and add to HBox
        for (int i = 0; i < NUM_TO_SHOW; i++) {
            ImageView iv = new ImageView();
            iv.setFitWidth(100);
            iv.setFitHeight(150);
            iv.setPreserveRatio(true);
            cardViews[i] = iv;
            cardBox.getChildren().add(iv);
        }

        // Button to refresh the four cards
        Button refreshButton = new Button("Refresh");
        // Lambda expression for button action:
        refreshButton.setOnAction(e -> showRandomCards());

        // Main layout
        VBox root = new VBox(20, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20;");

        // Load first time
        showRandomCards();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random 4 Cards");
        primaryStage.show();
    }

    /**
     * Picks four distinct random card indices, loads their images,
     * and sets them into the ImageViews.
     */
    private void showRandomCards() {
        // Creates a list
        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i <= NUM_CARDS; i++) {
            indices.add(i);
        }
        // Shuffle and take first four
        Collections.shuffle(indices);
        List<Integer> pick = indices.subList(0, NUM_TO_SHOW);

        // For each of the four load the image
        for (int i = 0; i < NUM_TO_SHOW; i++) {
            String path = "file:cards/" + pick.get(i) + ".png";
            Image img = new Image(path);
            cardViews[i].setImage(img);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
