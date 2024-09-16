package com.example.servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class PropertiesServlet extends HttpServlet {
    public  void  test() throws IOException {
        Properties properties = new Properties();
        Reader reader = new Reader() {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        };
        properties.load(reader);
    }
}
