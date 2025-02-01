// Disable external entities when parsing XML to prevent XXE attacks.



DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);  // Disable DOCTYPE
factory.setFeature("http://xml.org/sax/features/external-general-entities", false);  // Disable external entities
factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);  // Disable external parameter entities
DocumentBuilder builder = factory.newDocumentBuilder();
