import java.io.*;

public class PathTraversalExample {
    public static void main(String[] args) throws IOException {
        String userInput = "../etc/passwd"; // Malicious input from attacker
        
        // Vulnerable: Using untrusted input directly in file path
        File file = new File("/usr/local/data/" + userInput);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
