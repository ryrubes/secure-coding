// XXE occurs when XML parsers process external entities from untrusted XML input. This can lead to reading arbitrary files or initiating HTTP requests to internal services.


import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import java.io.*;

public class XXEVulnerableExample {
    public static void main(String[] args) throws Exception {
        String xmlData = "<!DOCTYPE foo [ <!ENTITY xxe SYSTEM \"file:///etc/passwd\"> ]><foo>&xxe;</foo>";
        
        // Vulnerable: Not disabling external entities
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false); // Dangerous
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inputSource = new InputSource(new StringReader(xmlData));
        builder.parse(inputSource);  // Parse untrusted XML
    }
}
