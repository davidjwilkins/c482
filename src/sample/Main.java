package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    private final String title = "Inventory Manager";
    private Inventory inventory = new Inventory();
    private Scene mainScene, addPartScene, addProductScene;
    private Stage primaryStage;
    @FXML
    protected Button addPartButton, addProductButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader rootLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        FXMLLoader partsLoader = new FXMLLoader(getClass().getResource("addPart.fxml"));
        FXMLLoader productsLoader = new FXMLLoader(getClass().getResource("addProduct.fxml"));
        Parent root = rootLoader.load();
        primaryStage.setTitle(title);
        mainScene = new Scene(root, 800, 640);
        primaryStage.setScene(mainScene);
        primaryStage.show();
        Parent addPart = partsLoader.load();
        PartsController partsController = partsLoader.<PartsController>getController();
        partsController.setRootController(this);
        Parent addProduct = productsLoader.load();
        ProductsController productsController = productsLoader.<ProductsController>getController();
        productsController.setRootController(this);
        addPartScene = new Scene(addPart, 560, 340);

        EventHandler addPartHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(addPartScene);
                primaryStage.show();
            }
        };
        addPartButton = (Button)mainScene.lookup("#addPartButton");
        addPartButton.setOnAction(addPartHandler);

        addProductScene = new Scene(addProduct, 950, 500);

        EventHandler addProductHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(addProductScene);
                primaryStage.show();
            }
        };
        addProductButton = (Button)mainScene.lookup("#addProductButton");
        addProductButton.setOnAction(addProductHandler);

        EventHandler exitHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        };
        Button exitButton = (Button)mainScene.lookup("#exitButton");
        exitButton.setOnAction(exitHandler);
    }

    public void mainScene() {
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
