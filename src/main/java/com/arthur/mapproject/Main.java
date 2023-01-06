package com.arthur.mapproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Image backgroundImage;

    @Override public void init() {
        backgroundImage = new Image("https://cdn.discordapp.com/attachments/1023305105241546783/1049149996227899412/black-and-white-world-map.jpg");
    }

    @Override public void start(Stage stage) {
        stage.setTitle("Drag mouse to move around");
        StackPane layout = new StackPane();
        layout.getChildren().setAll(
                new ImageView(backgroundImage),
                createAButton()
        );

        // wrap the scene contents in a pannable scroll pane.
        ScrollPane scroll = createScrollablePane(layout);

        // show the scene.
        Scene scene = new Scene(scroll);
        stage.setScene(scene);
        stage.show();

        // bind the preferred size of the scroll area to the size of the scene.
        scroll.prefWidthProperty().bind(scene.widthProperty());
        scroll.prefHeightProperty().bind(scene.widthProperty());

        // center the scroll contents.
        scroll.setHvalue(scroll.getHmin() + (scroll.getHmax() - scroll.getHmin()) / 2);
        scroll.setVvalue(scroll.getVmin() + (scroll.getVmax() - scroll.getVmin()) / 2);


    }

    private Button createAButton() {
        final Button killButton = new Button("Click me for something");
        killButton.setStyle("-fx-base: firebrick;");
        killButton.setTranslateX(65);
        killButton.setTranslateY(-130);
        killButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
                killButton.setStyle("-fx-base: forestgreen;");
                killButton.setText("Open panel blah blah!");
            }
        });
        return killButton;
    }
    private ScrollPane createScrollablePane(Pane layout) {
        ScrollPane scroll = new ScrollPane();
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setPannable(true);
        scroll.setPrefSize(1280, 720);
        scroll.setContent(layout);
        return scroll;
    }



    public static void main(String[] args) {
        launch();
    }
}

