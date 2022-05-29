package com.example;

import org.apache.logging.log4j.core.util.ArrayUtils;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;

/**
 * @author DechuYe
 */
public class MyIODemo {

    @Test
    public void inputStreamReaderTest() {
        try {
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[1024];
            final InputStreamReader f = new InputStreamReader(new FileInputStream("pom.xml"));
            while (f.read(buf) > 0) {
                sb.append(buf);
            }
            System.out.println(sb.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    public void outputStreamReaderTest() {
        System.out.println(Charset.defaultCharset().name());
        try {
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[1024];

            final InputStreamReader f = new InputStreamReader(new FileInputStream("pom.xml"));
            while (f.read(buf) > 0) {
                sb.append(buf);
                buf = new char[1024];

            }

            final OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("test.xml"), "GBK");
            out.write(sb.toString());
            out.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
