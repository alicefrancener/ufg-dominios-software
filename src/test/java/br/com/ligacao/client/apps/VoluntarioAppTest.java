package br.com.ligacao.client.apps;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class VoluntarioAppTest {

	private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void interfaceOpcao0() {
       provideInput("0");
       assertThrows(NoSuchElementException.class, VoluntarioApp::simuladorInterface);
    }

    @Test
    public void interfaceOpcao1() {
        provideInput("1");
        assertThrows(NoSuchElementException.class, VoluntarioApp::simuladorInterface);
    }
}