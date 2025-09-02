package br.inatel.test;

import org.apache.commons.io.FileUtils;
import org.example.Addpdf;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class addPDFTest {
    @Test
    public void testeEscreverArquivoPositivo() throws IOException {
        String nomeArquivo = "arquivo_teste.txt";
        String conteudo = "Olá, Roberta";
        File arquivo = new File(nomeArquivo);
        FileUtils.writeStringToFile(arquivo, conteudo, StandardCharsets.UTF_8);

        Addpdf addpdf = new Addpdf();
        String conteudoLido = addpdf.escreverArquivo(nomeArquivo);

        assertEquals(conteudo, conteudoLido);
    }
    @Test
    public void testeEscreverArquivoNegativo() throws IOException {
        String nomeArquivo = "arquivo_teste.txt";
        String conteudo = "Olá, Roberta";
        File arquivo = new File(nomeArquivo);
        FileUtils.writeStringToFile(arquivo, conteudo, StandardCharsets.UTF_8);

        Addpdf addpdf = new Addpdf();
        String conteudoLido = addpdf.escreverArquivo(nomeArquivo);

        assertEquals("Olá, Zeca", conteudoLido);
    }
    @Test
    public void testeArquivoExistePositivo() throws IOException {
        Addpdf addpdf = new Addpdf();
        assertTrue(addpdf.arquivoExiste("mensagem.txt"));
    }

    @Test
    public void testeArquivoExisteNegativo() throws IOException {
        Addpdf addpdf = new Addpdf();
        assertTrue(addpdf.arquivoExiste("roberta.txt"));
    }

    @Test
    public void testeContarPalavrasPositivo() throws IOException {
        Addpdf addpdf = new Addpdf();
        int total = addpdf.contarPalavras("mensagem.txt");
        assertEquals(4, total);
    }

    @Test
    public void testeContarPalavrasNegativo() throws IOException {
        Addpdf addpdf = new Addpdf();
        int total = addpdf.contarPalavras("mensagem.txt");
        assertEquals(6, total);
    }

    @Test
    public void testeContemPalavraPositivo() throws IOException {
        Addpdf addpdf = new Addpdf();
        assertTrue(addpdf.contemPalavra("mensagem.txt", "Roberta"));
    }

    @Test
    public void testeContemPalavraNegativo() throws IOException {
        Addpdf addpdf = new Addpdf();
        assertTrue(addpdf.contemPalavra("mensagem.txt", "Pietra"));
    }
    @Test
    public void testeContarOcorrenciasPalavra() throws IOException {
        String nomeArquivo = "testeOcorrencias.txt";
        String conteudo = "Roberta gosta de café. Roberta também gosta de chá.";
        File arquivo = new File(nomeArquivo);
        org.apache.commons.io.FileUtils.writeStringToFile(arquivo, conteudo, StandardCharsets.UTF_8);

        Addpdf addpdf = new Addpdf();
        int ocorrencias = addpdf.contarOcorrenciasPalavra(nomeArquivo, "Roberta");

        assertEquals(2, ocorrencias);

        arquivo.delete();
    }


}
