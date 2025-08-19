package org.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try {

            String conteudo = FileUtils.readFileToString(
                    new File("mensagem.txt"),
                    StandardCharsets.UTF_8
            );
            System.out.println("Conteúdo lido do TXT:\n" + conteudo);

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("mensagem.pdf"));
            document.open();

            document.add(new Paragraph(conteudo));

            document.close();

            System.out.println("PDF gerado com sucesso: mensagem.pdf");

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}