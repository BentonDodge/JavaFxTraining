package com.example.javafxtraining;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

public class Main extends Application {
    public int a;
    public int b;

    public String equation = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX without FXML");


        // Create UI components
        Button button0 = new Button("0");
        button0.setOnAction(e -> equation = equation + "0");

        Button button1 = new Button("1");
        button1.setOnAction(e -> equation = equation + "1");

        Button button2 = new Button("2");
        button2.setOnAction(e -> equation = equation + "2");

        Button button3 = new Button("3");
        button3.setOnAction(e -> equation = equation + "3");

        Button button4 = new Button("4");
        button4.setOnAction(e -> equation = equation + "4");

        Button button5 = new Button("5");
        button5.setOnAction(e -> equation = equation + "5");

        Button button6 = new Button("6");
        button6.setOnAction(e -> equation = equation + "6");

        Button button7 = new Button("7");
        button7.setOnAction(e -> equation = equation + "7");

        Button button8 = new Button("8");
        button8.setOnAction(e -> equation = equation + "8");

        Button button9 = new Button("9");
        button9.setOnAction(e -> equation = equation + "9");





        Button buttonPlus = new Button("+");
        buttonPlus.setOnAction(e -> equation = equation + "+");

        Button buttonMinus = new Button("-");
        buttonMinus.setOnAction(e -> equation = equation + "-");

        Button buttonMultiply = new Button("*");
        buttonMultiply.setOnAction(e -> equation = equation + "*");

        Button buttonDivide = new Button("/");
        buttonDivide.setOnAction(e -> equation = equation + "/");



        Button buttonEnter = new Button("Enter");
        buttonEnter.setOnAction(e -> out(equation));



        HBox vbox = new HBox(button0,button1,button2,button3,button4,button5,
                button6,button7,button8,button9,
                buttonPlus,buttonMinus,buttonMultiply,buttonDivide,buttonEnter);
        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void out(String equation){
        System.out.println(equation);
        String[] splitEq = equation.split("[+*/-]");
        System.out.println(splitEq[0] + "  " + splitEq[1]);
        String opr = "";
        if(equation.contains("+")){
            opr = "+";
        } else if(equation.contains("-")){
            opr = "-";
        }else if(equation.contains("*")){
            opr = "*";
        }else if(equation.contains("/")){
            opr = "/";
        }
        System.out.println(Calculator(
                parseInt(splitEq[0]),
                parseInt(splitEq[1]),
                opr));

    }
    public double Calculator(int a, int b,String operator){
        double fin = 0;
        switch (operator){
            case("+") -> fin = a+b;
            case("-") -> fin = a-b;
            case("*") -> fin = a*b;
            case("/") -> fin = (double) a/b;
            default -> fin = 6.9;
        }
        return fin;
    }
}







