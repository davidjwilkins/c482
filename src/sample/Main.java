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
    protected Button addPartButton, addProductButton, editPartButton, editProductButton;

    protected PartsController partsController;
    protected Controller mainController;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader rootLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        FXMLLoader partsLoader = new FXMLLoader(getClass().getResource("addPart.fxml"));
        FXMLLoader productsLoader = new FXMLLoader(getClass().getResource("addProduct.fxml"));
        Parent root = rootLoader.load();
        primaryStage.setTitle(title);
        mainScene = new Scene(root, 1000, 640);
        primaryStage.setScene(mainScene);
        primaryStage.show();
        Controller mainController = rootLoader.getController();
        mainController.setRootController(this);
        mainController.setInventory(inventory);
        Parent addPart = partsLoader.load();
        partsController = partsLoader.<PartsController>getController();
        partsController.setRootController(this);
        partsController.setInventory(inventory);
        Parent addProduct = productsLoader.load();
        ProductsController productsController = productsLoader.<ProductsController>getController();
        productsController.setRootController(this);
        productsController.setInventory(inventory);
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

        EventHandler editPartHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(addPartScene);
                partsController.setPart(mainController.getSelectedPart());
                primaryStage.show();
            }
        };
        editPartButton = (Button)mainScene.lookup("#editPartButton");
        editPartButton.setOnAction(editPartHandler);

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
