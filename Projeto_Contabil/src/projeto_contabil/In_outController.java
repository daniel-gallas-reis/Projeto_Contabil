/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class In_outController implements Initializable {

    private ArrayList<Saida> saidas = new ArrayList();

    @FXML
    TextField desc_aliment, val_aliment, diver_desc, diver_val, edu_desc, edu_val, fun_desc, fun_val, h_desc, h_val, sec_desc, sec_val, vest_desc, vest_val, trip_desc, trip_val;

    @FXML
    DatePicker date_aliment, date_diverse, edu_date, fun_date, h_date, sec_date, vest_date, trip_date;

    @FXML
    Button save_aliment, save_desc, save_edu, fun_save, h_save, sec_save, vest_save, trip_save;

    @FXML
    private ComboBox<Cliente> box_alimentacao, box_diversos, box_educacao, box_ent, box_saude, box_seguro, box_vest, box_trip;
    private ObservableList<Cliente> cliente_box = FXCollections.observableArrayList();
    String que = "Clientes";

    @FXML
    private void aliment_save(ActionEvent e) throws IOException {
        if (box_alimentacao.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            String desc = desc_aliment.getText();
            String date = date_aliment.getEditor().getText();
            double val = Double.parseDouble(val_aliment.getText().replaceAll(",", "."));
            Cliente cli = box_alimentacao.getSelectionModel().getSelectedItem();

            saidas.add(new Saida("Alimentação", cli, desc, date, val));
            Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);
            
            String pat = val_aliment.getText(); 

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(box_alimentacao.getSelectionModel().getSelectedItem())) {
                    cliente.setSaldo(String.valueOf(Float.parseFloat(cliente.getSaldo()) - Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }

            

            if (Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false) && erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                desc_aliment.setText("");
                val_aliment.setText("");
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída não cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                desc_aliment.setText("");
                val_aliment.setText("");
            }            
        }
    }

    @FXML
    private void desc_save(ActionEvent e) throws IOException {
        if (box_diversos.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            String desc = diver_desc.getText();
            String date = date_diverse.getEditor().getText();
            double val = Double.parseDouble(diver_val.getText().replaceAll(",", "."));
            Cliente cli = box_diversos.getSelectionModel().getSelectedItem();

            saidas.add(new Saida("Diversos", cli, desc, date, val));
            Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);
            
            String pat = diver_val.getText(); 

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(box_diversos.getSelectionModel().getSelectedItem())) {
                    cliente.setSaldo(String.valueOf(Float.parseFloat(cliente.getSaldo()) - Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }

            if (Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false) && erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                diver_desc.setText("");
                diver_val.setText("");
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída não cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                diver_desc.setText("");
                diver_val.setText("");
            }
        }

    }

    @FXML
    private void edu_save(ActionEvent e) throws IOException {
        if (box_educacao.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            String desc = edu_desc.getText();
            String date = edu_date.getEditor().getText();
            double val = Double.parseDouble(edu_val.getText().replaceAll(",", "."));
            Cliente cli = box_educacao.getSelectionModel().getSelectedItem();

            saidas.add(new Saida("Educação", cli, desc, date, val));
            Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);
            
            String pat = edu_val.getText(); 

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(box_educacao.getSelectionModel().getSelectedItem())) {
                    cliente.setSaldo(String.valueOf(Float.parseFloat(cliente.getSaldo()) - Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }
            
            if (Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false) && erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                edu_desc.setText("");
                edu_val.setText("");
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída não cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                edu_desc.setText("");
                edu_val.setText("");
            }
        }
    }

    @FXML
    private void save_fun(ActionEvent e) throws IOException {
        if (box_ent.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            String desc = fun_desc.getText();
            String date = fun_date.getEditor().getText();
            double val = Double.parseDouble(fun_val.getText().replaceAll(",", "."));
            Cliente cli = box_ent.getSelectionModel().getSelectedItem();

            saidas.add(new Saida("Entretenimento", cli, desc, date, val));
            Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);
            
            String pat = fun_val.getText(); 

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(box_ent.getSelectionModel().getSelectedItem())) {
                    cliente.setSaldo(String.valueOf(Float.parseFloat(cliente.getSaldo()) - Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }
            
            if (Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false) && erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                fun_desc.setText("");
                fun_val.setText("");
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída não cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                fun_desc.setText("");
                fun_val.setText("");
            }
        }
    }

    @FXML
    private void save_h(ActionEvent e) throws IOException {
        if (box_saude.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            String desc = h_desc.getText();
            String date = h_date.getEditor().getText();
            double val = Double.parseDouble(h_val.getText().replaceAll(",", "."));
            Cliente cli = box_saude.getSelectionModel().getSelectedItem();

            saidas.add(new Saida("Saúde", cli, desc, date, val));
            Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);
            
            String pat = h_val.getText(); 

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(box_saude.getSelectionModel().getSelectedItem())) {
                    cliente.setSaldo(String.valueOf(Float.parseFloat(cliente.getSaldo()) - Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }
            
            if (Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false) && erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                h_desc.setText("");
                h_val.setText("");
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída não cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                h_desc.setText("");
                h_val.setText("");
            }
        }
    }

    @FXML
    private void save_sec(ActionEvent e) throws IOException {
        if (box_seguro.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            String desc = sec_desc.getText();
            String date = sec_date.getEditor().getText();
            double val = Double.parseDouble(sec_val.getText().replaceAll(",", "."));
            Cliente cli = box_seguro.getSelectionModel().getSelectedItem();

            saidas.add(new Saida("Seguro", cli, desc, date, val));
            Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);
            
            String pat = sec_val.getText(); 

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(box_seguro.getSelectionModel().getSelectedItem())) {
                    cliente.setSaldo(String.valueOf(Float.parseFloat(cliente.getSaldo()) - Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }
            
            if (Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false) && erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                sec_desc.setText("");
                sec_val.setText("");
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída não cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                sec_desc.setText("");
                sec_val.setText("");
            }
        }
    }

    @FXML
    private void save_vest(ActionEvent e) throws IOException {
        if (box_vest.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            String desc = vest_desc.getText();
            String date = vest_date.getEditor().getText();
            double val = Double.parseDouble(vest_val.getText().replaceAll(",", "."));
            Cliente cli = box_vest.getSelectionModel().getSelectedItem();

            saidas.add(new Saida("Vestuário", cli, desc, date, val));
            Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);
            
            String pat = vest_val.getText(); 

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(box_vest.getSelectionModel().getSelectedItem())) {
                    cliente.setSaldo(String.valueOf(Float.parseFloat(cliente.getSaldo()) - Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }
            
            if (Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false) && erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                vest_desc.setText("");
                vest_val.setText("");
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída não cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                vest_desc.setText("");
                vest_val.setText("");
            }
        }
    }

    @FXML
    private void save_trip(ActionEvent e) throws IOException {
        if (box_trip.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            String desc = trip_desc.getText();
            String date = trip_date.getEditor().getText();
            double val = Double.parseDouble(trip_val.getText().replaceAll(",", "."));
            Cliente cli = box_trip.getSelectionModel().getSelectedItem();

            saidas.add(new Saida("Viagens", cli, desc, date, val));
            Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);
            
            String pat = trip_val.getText(); 

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(box_trip.getSelectionModel().getSelectedItem())) {
                    cliente.setSaldo(String.valueOf(Float.parseFloat(cliente.getSaldo()) - Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }
            
            if (Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false) && erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                trip_desc.setText("");
                trip_val.setText("");
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Cadastro");
                dialogoInfo.setContentText("Saída não cadastrada com sucesso!");
                dialogoInfo.showAndWait();
                trip_desc.setText("");
                trip_val.setText("");
            }
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saidas = Auxiliar.ler_arquivo_binario("saidas.bin");

        ArrayList<String> linhas = Auxiliar.ler_arquivo("Cliente.txt");

        for (String linha : linhas) {
            String[] v = linha.split(";");

            Cliente c = new Cliente(v[0], v[1], v[2], v[3], v[4]);

            cliente_box.add(c);
        }

        box_alimentacao.setItems(cliente_box);
        box_diversos.setItems(cliente_box);
        box_educacao.setItems(cliente_box);
        box_ent.setItems(cliente_box);
        box_saude.setItems(cliente_box);
        box_seguro.setItems(cliente_box);
        box_vest.setItems(cliente_box);
        box_trip.setItems(cliente_box);

        saidas = Auxiliar.ler_arquivo_binario("saidas.bin");
    }

}
