package com.zt.Utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by zt on 2017/7/4.
 */
public class XmlUtils {

    private static String filePath="//Users/user/Desktop/MyShop/src/users.xml";
     static {
    //   filePath= XmlUtils.class.getClassLoader().getResource("src/users.xml").getPath();
         filePath="/Users/user/Desktop/MyShop/src/users.xml";
        System.out.println("filepath:"+filePath);
     }

    public static Document getDocument() throws MalformedURLException, DocumentException {
        Document document = null;
        SAXReader reader=new SAXReader();
        document=reader.read(new File(filePath));

        return document;
    }

    public static void write2Xml(Document document) throws IOException {

        OutputFormat format=OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer=new XMLWriter(new FileOutputStream(filePath),format);
        writer.write(document);

        writer.close();

    }
}
