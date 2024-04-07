import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LaunchPage extends Application {
        int currentLevel = 1;

    @Override
    public void start(Stage primaryStage) {
        openGameWindow(primaryStage);
    }

    private void openGameWindow(Stage primaryStage) {
        primaryStage.setTitle("Game Window");
    
        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(10));
    
        GridPane imagePanel = new GridPane();
        imagePanel.setAlignment(Pos.CENTER);
        imagePanel.setHgap(10);
        imagePanel.setVgap(10);
    
        // Load images
        Image image1 = new Image("delicious-burguer-isolated-white-background.png");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(200);
        imageView1.setFitHeight(200);
        imageView1.setPreserveRatio(true);
        imageView1.setSmooth(true);
        imageView1.setCache(true);
    
        Image image2 = new Image("delicious-burguer-isolated-white-background.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(200);
        imageView2.setPreserveRatio(true);
        imageView2.setSmooth(true);
        imageView2.setCache(true);
    
        Image image3 = new Image("delicious-burguer-isolated-white-background.png");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(200);
        imageView3.setFitHeight(200);
        imageView3.setPreserveRatio(true);
        imageView3.setSmooth(true);
        imageView3.setCache(true);
    
        Image image4 = new Image("delicious-burguer-isolated-white-background.png");
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
            String correctAnswer = "borger"; 
    
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
