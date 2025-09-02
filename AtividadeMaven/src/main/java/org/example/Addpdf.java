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

public class Addpdf {

    // Métod0 de leitura do arquivo base txt
    public String readTxt(String Path) throws IOException {
        return FileUtils.readFileToString(new File(Path), StandardCharsets.UTF_8);
    }

    // Adiciona parágrafo no documento
    public void adicionarParagrafo(Document document, String conteudo) throws DocumentException {
        document.add(new Paragraph(conteudo));
    }

    // Cria um novo documento PDF
    public Document criarDocumentoPdf(String caminhoPdf) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(caminhoPdf));
        document.open();
        return document;
    }

    // Fecha o documento
    public void fecharDocumento(Document document) {
        document.close();
    }

    // Gera PDF diretamente com conteúdo
    public void gerarPdf(String conteudo, String caminhoPdf) throws DocumentException, IOException {
        Document document = criarDocumentoPdf(caminhoPdf);
        adicionarParagrafo(document, conteudo);
        fecharDocumento(document);
    }

    // Verifica se o PDF existe e não está vazio
    public boolean pdfExiste(String caminhoPdf) {
        File pdf = new File(caminhoPdf);
        return pdf.exists() && pdf.length() > 0;
    }

}
