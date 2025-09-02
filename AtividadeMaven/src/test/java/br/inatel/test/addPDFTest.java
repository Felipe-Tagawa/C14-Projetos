package br.inatel.test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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
    Addpdf addpdf = new Addpdf();
    
    // Teste de leitura de txt correto
    @Test
    public void readTxtTestCorrect() throws IOException {
        Addpdf readtxt = new Addpdf();
        String conteudo = readtxt.readTxt("mensagem.txt");
        assertEquals("Oi Roberta Oi Zeca", conteudo);
    }

    @Test
    public void readTxtTestIncorrect() throws IOException {
        Addpdf readtxt = new Addpdf();
        String conteudo = readtxt.readTxt("mensagem.txt");
        assertEquals("Oi Roberta", conteudo);
    }

    // Teste de criação de documento PDF (sem conteudo)

    @Test
    public void createPDFDocumentTest() throws DocumentException, IOException {
        String caminho = "testeCriar.pdf";

        // Criar documento PDF (sem nada)
        Document doc = addpdf.criarDocumentoPdf(caminho);

        // Adicionar conteúdo mínimo - erro se não houver nada
        addpdf.adicionarParagrafo(doc, "Parágrafo de teste");

        // Fechar documento
        addpdf.fecharDocumento(doc);

        // Verificação de criação do PDF
        File pdf = new File(caminho);
        assertTrue(pdf.length() > 0);
    }

    // Teste de gerar PDF diretamente
    @Test
    public void gerarPdfTest() throws Exception {
        String caminho = "testeGerar.pdf";
        addpdf.gerarPdf("Conteúdo novo para teste de criação direta de PDF", caminho);

        File pdf = new File(caminho);
        assertTrue(pdf.exists());
        assertTrue(pdf.length() > 0);
    }

    // Teste de existência do PDF

    @Test
    public void pdfExisteTest() throws DocumentException, IOException {
        String caminho = "testePdfExiste.pdf";

        // Garantir que o PDF não existe antes do teste
        File pdfAntigo = new File(caminho);
        if (pdfAntigo.exists()) {
            pdfAntigo.delete();
        }

        // PDF ainda não existe - deve retornar false
        assertFalse(addpdf.pdfExiste(caminho));

        // Gerar PDF
        addpdf.gerarPdf("Conteúdo de teste", caminho);

        // PDF existe - deve retornar true
        assertTrue(addpdf.pdfExiste(caminho));

        // Limpar arquivo gerado para não acumular
        assertTrue(new File(caminho).delete());
    }
}
