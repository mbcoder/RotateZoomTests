/**
 * Copyright 2019 Esri
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.mycompany.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        // set the title and size of the stage and show it
        stage.setTitle("Zoom and rotate test app");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.show();

        // create a JavaFX scene with a stack pane as the root node and add it to the scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);

        // make image
        Image image = new Image(new FileInputStream("screenshot.png"));

        // make image view
        ImageView imageView = new ImageView(image);

        // rotate event handler
        imageView.addEventHandler(RotateEvent.ANY, event -> {
            imageView.setRotate(imageView.getRotate() + event.getAngle());
        });

        // zoom event handler - just console reports for now.
        imageView.addEventHandler(ZoomEvent.ANY , event -> {
            System.out.println("Zoom event fired " + event.getZoomFactor());
        });

        stackPane.getChildren().add(imageView);
    }

    /**
     * Stops and releases all resources used in application.
     */
    @Override
    public void stop() {

    }
}
