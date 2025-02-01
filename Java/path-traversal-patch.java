// Sanitize user input and validate that the path is within the allowed directory.



public class SafeFileAccess {
    public static void main(String[] args) throws IOException {
        String userInput = "../etc/passwd"; // Malicious input
        
        String baseDir = "/usr/local/data/";
        File file = new File(baseDir, userInput);
        
        // Prevent path traversal
        if (!file.getCanonicalPath().startsWith(baseDir)) {
            throw new SecurityException("Path traversal attempt detected!");
        }
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
