package br.inatel.test;

import org.example.Addpdf;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class addPDFTest {
    Addpdf readtxt = new Addpdf();
    
    // Teste de leitura de txt
    @Test
    public void readTxtTest() throws IOException {
        String valor = readtxt.readTxt("mensagem.txt");
        assertEquals("Oi Roberta Oi Zeca", valor);
    }

}
