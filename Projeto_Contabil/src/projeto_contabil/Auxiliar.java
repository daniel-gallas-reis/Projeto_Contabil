/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author coelho
 */
public class Auxiliar {

    public String MD5(String mensagem) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
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

    public static boolean escrever_arquivo(String texto, String nome_arquivo) {
        try {
            File f = new File(nome_arquivo);
            if (!f.exists()) {
                f.createNewFile();
            }
            try (FileWriter fw = new FileWriter(f, true);
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
}
