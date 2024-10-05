package com.example.javafxtraining;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Main extends Application {
    public static HashMap<String, String> loginMap = new HashMap<>();

    public static HashMap<String,Integer> finalMap = new HashMap<>();
    public static void main(String[] args) {
        loginMap.put("Ben","Dodge");
        finalMap.put("Ben",1000000000);
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Silly Snowbank");
        TextField userName = new TextField("");
        userName.setPromptText("Username");
        TextField password = new TextField("");
        password.setPromptText("Password");
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> login(userName.getText(),password.getText(),primaryStage));
        
        Button newAccount = new Button("New to Silly SnowBank?");


        HBox hBox = new HBox(loginButton,newAccount);
        VBox vBox = new VBox(userName,password,hBox);
        Scene scene = new Scene(vBox,400, 500);
        newAccount.setOnAction(e-> newAccount(primaryStage,scene));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void newAccount(Stage primaryStage, Scene oldScene){
        TextField newUserName = new TextField("");
        newUserName.setPromptText("Username");
        TextField newPassword = new TextField("");
        newPassword.setPromptText("Password");
        Button submitButton = new Button("submit to Me");
        VBox vBox = new VBox(newUserName,newPassword,submitButton);
        Scene newAccountScene = new Scene(vBox);
        primaryStage.setScene(newAccountScene);
        primaryStage.show();
        submitButton.setOnAction(e-> {
            System.out.println("howdy");
            loginMap.put(newUserName.getText(), newPassword.getText());
            finalMap.put(newUserName.getText(),0);
            primaryStage.setScene(oldScene);
            primaryStage.show();
        });
    }
    public static void login(String username, String password, Stage primaryStage){
         if(Objects.equals(loginMap.get(username), password)){
             Text money = new Text();
             money.setText("$" + String.valueOf(finalMap.get(username)));
             VBox CashDisplay = new VBox(money);
             TextField Deposit = new TextField("");
             Deposit.setPromptText("Money");
             Button DepositButton = new Button("Deposit");
             DepositButton.setOnAction(e -> {
                 finalMap.replace(username,finalMap.get(username)+parseInt(Deposit.getText()));
                 money.setText("$" + String.valueOf(finalMap.get(username)));
             });

             TextField Withdraw = new TextField("");
             Withdraw.setPromptText("Money");
             Button WithdrawButton = new Button("Withdraw");
             WithdrawButton.setOnAction(e -> {
                 finalMap.replace(username,finalMap.get(username)-(parseInt(Withdraw.getText())));
                 money.setText("$" + String.valueOf(finalMap.get(username)));
             });

             HBox DepositCash = new HBox(Deposit,DepositButton);
             HBox WithDrawCash = new HBox(Withdraw,WithdrawButton);

             VBox Cash = new VBox(DepositCash,WithDrawCash);
             SplitPane bankPane = new SplitPane(CashDisplay,Cash);
             Scene bankScene = new Scene(bankPane,450,200);
             primaryStage.setScene(bankScene);
         }
    }

}