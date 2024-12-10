package com.example;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Création d'un titre pour le formulaire
        Text title = new Text("Formulaire d'inscription");
        title.setFont(Font.font("Arial", 20));

        // Création des éléments du formulaire
        Label nameLabel = new Label("Nom:");
        TextField nameField = new TextField();
        nameField.setPromptText("Entrez votre nom");

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.setPromptText("Entrez votre email");

        Button submitButton = new Button("Soumettre");
        submitButton.setOnAction(event -> {
            // Récupération des valeurs des champs
            String name = nameField.getText();
            String email = emailField.getText();
            System.out.println("Nom: " + name + ", Email: " + email);
        });

        // Organisation dans une grille
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20)); // Espacement autour de la grille
        grid.setHgap(10); // Espacement horizontal entre les colonnes
        grid.setVgap(10); // Espacement vertical entre les lignes
        grid.setStyle("-fx-background-color: #ffffff; -fx-border-color: #0078d7; -fx-border-radius: 10px; -fx-padding: 20;");

        // Ajout des éléments dans la grille
        grid.add(title, 0, 0, 2, 1); // Colonne 0, Ligne 0 (sur 2 colonnes)
        grid.add(nameLabel, 0, 1); // Colonne 0, Ligne 1
        grid.add(nameField, 1, 1); // Colonne 1, Ligne 1
        grid.add(emailLabel, 0, 2); // Colonne 0, Ligne 2
        grid.add(emailField, 1, 2); // Colonne 1, Ligne 2
        grid.add(submitButton, 1, 3); // Colonne 1, Ligne 3

        // Centrer le bouton et le titre
        GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setHalignment(submitButton, HPos.CENTER);

        // Création de la scène
        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm()); // Appliquer le style CSS

        primaryStage.setTitle("Formulaire Amélioré");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
