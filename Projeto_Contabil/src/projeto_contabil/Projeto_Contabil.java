package projeto_contabil;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author daniel reis
 */
public class Projeto_Contabil extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        FXMLDocumentController control = loader.getController();

        scene.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
            control.painel0.setPrefWidth(newSceneWidth.doubleValue());
            control.painel1.setPrefWidth(newSceneWidth.doubleValue());
            control.painel2.setPrefWidth(newSceneWidth.doubleValue());
            control.painel3.setPrefWidth(newSceneWidth.doubleValue());
            System.out.println("Width: " + newSceneWidth);
        });
        scene.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
            System.out.println("Height: " + newSceneHeight);
            control.painel0.setPrefHeight(newSceneHeight.doubleValue());
            control.painel1.setPrefHeight(newSceneHeight.doubleValue());
            control.painel2.setPrefHeight(newSceneHeight.doubleValue());
            control.painel3.setPrefHeight(newSceneHeight.doubleValue());
        });

        stage.setScene(scene);

        stage.setScene(scene);

        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
