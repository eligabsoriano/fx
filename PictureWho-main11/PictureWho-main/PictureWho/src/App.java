import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Optional;

public class App extends Application {
    private ImageView imageView;
    private int currentLevel = 1;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Picture Who");

        // Top Panel
        Label pictureWhoLabel = new Label("PICTURE WHO?");
        pictureWhoLabel.setStyle("-fx-font-size: 33; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #5E4580");
        BorderPane.setAlignment(pictureWhoLabel, Pos.TOP_CENTER);

        imageView = new ImageView(new Image("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png"));
        imageView.setFitWidth(600);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        VBox imageContainer = new VBox();
        imageContainer.getChildren().add(imageView);
        VBox.setMargin(imageView, new Insets(170, 0, 50, 390)); // Adjusted top margin to move image down

        BorderPane topPanel = new BorderPane();
        topPanel.setBackground(new Background(new BackgroundFill(Color.rgb(131, 101, 172), CornerRadii.EMPTY, Insets.EMPTY)));
        topPanel.setTop(pictureWhoLabel);
        topPanel.setCenter(imageContainer);

        // Play Button
        Button playButton = new Button("Play");
        playButton.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-text-fill: #5E4580; -fx-background-color: white;");
        playButton.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Starting");
            alert.setHeaderText(null);
            alert.setContentText("The game is starting...");
            alert.showAndWait();

            openGameWindow(primaryStage);
        });

        // Exit Button
        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-text-fill: #5E4580; -fx-background-color: white;");
        exitButton.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to exit?");

            ButtonType yesButton = new ButtonType("Yes");
            ButtonType noButton = new ButtonType("No");
            alert.getButtonTypes().setAll(yesButton, noButton);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == yesButton) {
                primaryStage.close();
            }
        });

        HBox buttonPanel = new HBox(210, playButton, exitButton);
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setPadding(new Insets(10));

        BorderPane mainPane = new BorderPane();
        mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(131, 101, 172), CornerRadii.EMPTY, Insets.EMPTY)));
        mainPane.setCenter(topPanel);
        mainPane.setBottom(buttonPanel);

        Scene scene = new Scene(mainPane, 1000, 650);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void openGameWindow(Stage primaryStage) {
        primaryStage.setTitle("Game Window");

        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(10));

        mainPane.setStyle("-fx-background-color: #5E4580");

        GridPane imagePanel = new GridPane();
        imagePanel.setAlignment(Pos.CENTER);
        imagePanel.setHgap(10);
        imagePanel.setVgap(10);

        // Load images
        Image image1 = new Image("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(200);
        imageView1.setFitHeight(200);
        imageView1.setPreserveRatio(true);
        imageView1.setSmooth(true);
        imageView1.setCache(true);

        Image image2 = new Image("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(200);
        imageView2.setPreserveRatio(true);
        imageView2.setSmooth(true);
        imageView2.setCache(true);

        Image image3 = new Image("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(200);
        imageView3.setFitHeight(200);
        imageView3.setPreserveRatio(true);
        imageView3.setSmooth(true);
        imageView3.setCache(true);

        Image image4 = new Image("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(200);
        imageView4.setFitHeight(200);
        imageView4.setPreserveRatio(true);
        imageView4.setSmooth(true);
        imageView4.setCache(true);

        // Add images to the grid
        imagePanel.add(imageView1, 0, 0);
        imagePanel.add(imageView2, 1, 0);
        imagePanel.add(imageView3, 0, 1);
        imagePanel.add(imageView4, 1, 1);

        mainPane.setCenter(imagePanel);

        // Answer Panel
        HBox answerPanel = new HBox(10);
        answerPanel.setAlignment(Pos.CENTER);
        TextField answerField = new TextField();
        answerField.setPromptText("Enter your answer");
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String enteredAnswer = answerField.getText().trim().toLowerCase();
            String correctAnswer = "missing person";

            if (enteredAnswer.equals(correctAnswer)) {
                showAlert("Correct!", "MATALINO KANG BATA KA!");
                openNextLevel(primaryStage);
            } else {
                showAlert("Incorrect!", "BOBO MALI");
            }

            answerField.clear();
        });
        answerPanel.getChildren().addAll(answerField, submitButton);
        mainPane.setBottom(answerPanel);

        Scene scene = new Scene(mainPane, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void openNextLevel(Stage primaryStage) {
        currentLevel++;
        showAlert("Next Level", "Proceed to next level bro bro");
        primaryStage.close();
        LaunchPage launchPage = new LaunchPage();
        launchPage.start(new Stage());
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
