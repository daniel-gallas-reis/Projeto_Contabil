/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coelho
 */
public class Auxiliar {

    public static String hash(String mensagem) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-512");
            byte[] array = md.digest(mensagem.getBytes());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static boolean escrever_arquivo(String texto, String nome_arquivo, boolean append) {
        try {
            File f = new File(nome_arquivo);
            if (!f.exists()) {
                f.createNewFile();
            }
            try (FileWriter fw = new FileWriter(f, append);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw)) {
                pw.println(texto);
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo " + nome_arquivo);
            return false;
        }
        return true;
    }

    public static boolean escrever_arquivo_binario(ArrayList<Saida> saidas, String nome_arquivo, boolean append) {
        try {
            File f = new File(nome_arquivo);
            if (!f.exists()) {
                f.createNewFile();
            }
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));) {
                out.writeObject(saidas);
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo " + nome_arquivo);
            return false;
        }
        return true;
    }

    public static ArrayList<Saida> ler_arquivo_binario(String nome_arquivo) {
        ArrayList<Saida> saidas = new ArrayList();

        File f = new File(nome_arquivo);
        if (f.exists()) {
            try (ObjectInputStream out = new ObjectInputStream(new FileInputStream(f));) {
                saidas = (ArrayList<Saida>) out.readObject();
            } catch (ClassNotFoundException ex) {
                System.err.println("Lista de saidas nao encontrado");
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo " + nome_arquivo);
            }
        }
        return saidas;
    }

    public static ArrayList<String> ler_arquivo(String nome_arquivo) {
        ArrayList<String> texto_lido = new ArrayList();
        try {
            File f = new File(nome_arquivo);
            if (f.exists()) {

                try (FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr)) {
                    String linha_lida = "";

                    do {
                        linha_lida = br.readLine();
                        if (linha_lida != null) {
                            //String []t = linha_lida.split("\t");
                            texto_lido.add(linha_lida);
                        }
                    } while (linha_lida != null);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo arquivo.bin.");
        }
        return texto_lido;
    }

    public static String geraLinha(int i) {
        String r = "-";

        for (int j = 0; j < i; j++) {
            r += "-";
        }
        return r;
    }

    public static ArrayList<String> ler_linhas(File arquivo) throws FileNotFoundException, IOException {
        ArrayList<String> linhas = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            do {
                linha = br.readLine();
                if (linha != null) {
                    linhas.add(linha);
                }
            } while (linha != null);
        }
        return linhas;
    }

    public static void gravar_usuario(File arquivo, Usuario user) throws IOException {
        try (FileWriter fw = new FileWriter(arquivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(user.getLogin() + "\t" + user.getSenha() + System.lineSeparator());
        }
    }

    public static ArrayList<Usuario> ler_usuarios(File arquivo) throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios = new ArrayList();
        ArrayList<String> linhas = ler_linhas(arquivo);

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                usuarios.add(new Usuario(linha.split("\t")[0], linha.split("\t")[1]));
            }
        }
        return usuarios;
    }

    public static ArrayList<Cliente> ler_clientes(File arquivo) throws FileNotFoundException, IOException {
        ArrayList<Cliente> usuarios = new ArrayList();
        ArrayList<String> linhas = ler_linhas(arquivo);

        for (String linha : linhas) {
            //getNome() + ";" + getIdade() + ";" + getSaldo()+ ";" + getSalario() + ";" + getCpf();
            usuarios.add(new Cliente(
                    linha.split(";")[0],
                    linha.split(";")[1],
                    linha.split(";")[2],
                    linha.split(";")[3],
                    linha.split(";")[4]));
        }
        return usuarios;
    }
}
