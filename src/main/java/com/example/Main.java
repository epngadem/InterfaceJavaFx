package com.example;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Titre du formulaire
        Text title = new Text("Formulaire d'inscription");
        title.setFont(Font.font("Arial", 24));

        // Champs de saisie
        Label nameLabel = new Label("Nom complet :");
        TextField nameField = new TextField();
        nameField.setPromptText("Entrez votre nom complet");

        Label emailLabel = new Label("Email :");
        TextField emailField = new TextField();
        emailField.setPromptText("Entrez votre email");

        Label phoneLabel = new Label("Telephone :");
        TextField phoneField = new TextField();
        phoneField.setPromptText("Entrez votre numero de telephone");

        Label addressLabel = new Label("Adresse :");
        TextField addressField = new TextField();
        addressField.setPromptText("Entrez votre adresse");

        Label genderLabel = new Label("Genre :");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleButton = new RadioButton("Homme");
        maleButton.setToggleGroup(genderGroup);
        RadioButton femaleButton = new RadioButton("Femme");
        femaleButton.setToggleGroup(genderGroup);
        RadioButton otherButton = new RadioButton("Autre");
        otherButton.setToggleGroup(genderGroup);

        Label dobLabel = new Label("Date de naissance :");
        DatePicker dobPicker = new DatePicker();

        // Bouton Soumettre
        Button submitButton = new Button("Soumettre");
        submitButton.setOnAction(event -> {
            // Récupération des valeurs des champs
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();
            String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
            String dob = (dobPicker.getValue() != null) ? dobPicker.getValue().toString() : "Non spécifié";

            System.out.println("Nom : " + name);
            System.out.println("Email : " + email);
            System.out.println("Telephone : " + phone);
            System.out.println("Adresse : " + address);
            System.out.println("Genre : " + gender);
            System.out.println("Date de naissance : " + dob);
        });

        // Mise en page avec GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-background-color: #f9f9f9; -fx-border-color: #0078d7; -fx-border-radius: 10px; -fx-padding: 20;");

        // Ajouter les éléments au GridPane
        grid.add(title, 0, 0, 2, 1); // Sur deux colonnes
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(phoneLabel, 0, 3);
        grid.add(phoneField, 1, 3);
        grid.add(addressLabel, 0, 4);
        grid.add(addressField, 1, 4);
        grid.add(genderLabel, 0, 5);
        grid.add(maleButton, 1, 5);
        grid.add(femaleButton, 1, 6);
        grid.add(otherButton, 1, 7);
        grid.add(dobLabel, 0, 8);
        grid.add(dobPicker, 1, 8);
        grid.add(submitButton, 1, 9);

        // Centrer le bouton et le titre
        GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setHalignment(submitButton, HPos.CENTER);

        // Création de la scène
        Scene scene = new Scene(grid, 500, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm()); // Appliquer le style CSS

        primaryStage.setTitle("Formulaire Inscription Pro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
