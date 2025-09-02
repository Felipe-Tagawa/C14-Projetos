package org.example;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws DocumentException, IOException {
        Addpdf adicionar = new Addpdf();
        adicionar.gerarPdf("Oi Roberta e Zeca","mensagem.txt");
    }
}