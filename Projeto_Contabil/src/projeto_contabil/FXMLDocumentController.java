/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author daniel
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public AnchorPane painel0, painel1, painel2;

    @FXML
    public ScrollPane painel3;

    @FXML
    Label label, nome_usuario, horasis, datasis;

    @FXML
    Button financeiro, cliente, entradas_saidas, patrimonio, integra_banc, register_button;

    @FXML
    ComboBox<Ferramenta> ferramentas;

    @FXML
    TextFlow text_lembretes;

    private ObservableList<Ferramenta> mytoolsData;

    @FXML
    private void finance_button(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Financeiro.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.setTitle("Financeiro");
            stage1.show();
        } catch (IOException ex) {
            System.err.println("Erro ao abrir janela!");
            ex.printStackTrace();
        }
    }

    String clientes[];

    @FXML
    private void client_button(ActionEvent e) throws FileNotFoundException {
//        ArrayList<String> linhas = Auxiliar.ler_arquivo("C:\\Users\\danie\\OneDrive\\Área de Trabalho\\Projeto_Contabil\\Projeto_Contabil\\text\\Cliente.txt");
//        
//        for (String linha : linhas) {
//            String [] v = linha.split(";");
//            
//            for (String sv : v) {
//                System.out.print(sv + " ");
//            }
//        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.setTitle("Clientes");
            stage1.show();
        } catch (IOException ex) {
            System.err.println("Erro ao abrir janela!");
            ex.printStackTrace();
        }
    }

    @FXML
    private void in_out_button(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("In_out.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.setTitle("Saídas");
            stage1.show();
        } catch (IOException ex) {
            System.err.println("Erro ao abrir janela!");
            ex.printStackTrace();
        }

    }

    @FXML
    private void int_button(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Integracao_bancaria.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.setTitle("Integração Bancária");
            stage1.show();
        } catch (IOException ex) {
            System.err.println("Erro ao abrir janela!");
            ex.printStackTrace();
        }
    }

    @FXML
    private void patrimonio_button(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Patrimonio.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.setTitle("Patrimônio");
            stage1.show();
        } catch (IOException ex) {
            System.err.println("Erro ao abrir janela!");
            ex.printStackTrace();
        }
    }

    @FXML
    private void ferramentas_menu(ActionEvent e) {
        Ferramenta selecionada = ferramentas.getSelectionModel().getSelectedItem();

        System.out.println(selecionada.getTool());
        if (selecionada.getTool().equals("Calculadora")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage1 = new Stage();
                stage1.setScene(scene);
                stage1.setResizable(false);
                stage1.setTitle("Calculadora");
                stage1.show();
            } catch (IOException ex) {
                System.err.println("Erro ao abrir janela!");
                ex.printStackTrace();
            }
        }
        if (selecionada.getTool().equals("Calendário")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Date.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage1 = new Stage();
                stage1.setScene(scene);
                stage1.setResizable(false);
                stage1.setTitle("Calendário");
                stage1.show();
            } catch (IOException ex) {
                System.err.println("Erro ao abrir janela!");
                ex.printStackTrace();
            }
        }
    }

    @FXML
    public void act_register(ActionEvent e) {
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.close();
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLRegisterIn.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setOnCloseRequest(ee -> {
                stage.hide();
            });
            stage.setScene(scene);
            stage.setResizable(false);
            stage1.setTitle("Register In");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Task<Void> relogio = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() -> {
                        datasis.setText(String.format("%1$td/%1$tm/%1$tY", LocalDate.now()));
                        if (LocalDate.now().getDayOfMonth() == 5) {
                            try {
                                File f = new File("Cliente.txt");
                                ArrayList<Cliente> nome = Auxiliar.ler_clientes(f);
                                
                                f.delete();
                                f.createNewFile();
                                for (Cliente cli : nome) {
                                    cli.atualizaSaldo();
                                    Auxiliar.escrever_arquivo(cli.proArquivo(), "Cliente.txt", true);

                                }
                            } catch (IOException ex) {
                                System.out.println("erro 101");
                            }

                        }
                        LocalTime now = LocalTime.now();
                        horasis.setText(now.getHour() + ":" + now.getMinute() + ":" + now.getSecond());
                    });
                }
            }

        };
        Platform.runLater(() -> {
            Thread t = new Thread(relogio);

            t.setDaemon(true);
            t.start();
        });
        // text_lembretes=new TextFlow(new Text("" + line ));
        // text_lembretes.getChildren().add(new Text("" + line));
        mytoolsData = FXCollections.observableArrayList();
        mytoolsData.add(new Ferramenta("Calculadora"));
        mytoolsData.add(new Ferramenta("Calendário"));

        ferramentas.setItems(mytoolsData);
    }

    void setUser(String b) {
        nome_usuario.setText(b);
    }

}
