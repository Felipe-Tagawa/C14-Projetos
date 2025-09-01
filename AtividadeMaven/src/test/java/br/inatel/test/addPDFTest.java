package br.inatel.test;

import org.example.Addpdf;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class addPDFTest {
    @Test
    public void testeEscreverArquivoPositivo() throws IOException {
        String nomeArquivo = "arquivo_teste.txt";
        String conteudo = "Olá, Roberta";
        File arquivo = new File(nomeArquivo);
        org.apache.commons.io.FileUtils.writeStringToFile(arquivo, conteudo, StandardCharsets.UTF_8);

        Addpdf addpdf = new Addpdf();
        String conteudoLido = addpdf.escreverArquivo(nomeArquivo);

        assertEquals(conteudo, conteudoLido);
    }
    @Test
    public void testeEscreverArquivoNegativo() throws IOException {
        String nomeArquivo = "arquivo_teste.txt";
        String conteudo = "Olá, Roberta";
        File arquivo = new File(nomeArquivo);
        org.apache.commons.io.FileUtils.writeStringToFile(arquivo, conteudo, StandardCharsets.UTF_8);

        Addpdf addpdf = new Addpdf();
        String conteudoLido = addpdf.escreverArquivo(nomeArquivo);

        assertEquals("Olá, Zeca", conteudoLido);
    }
    
}
