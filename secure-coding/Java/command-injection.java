// Command injection occurs when user input is included in system commands without proper sanitization, allowing attackers to execute arbitrary commands.


import java.io.*;

public class CommandInjectionExample {
    public static void main(String[] args) throws IOException {
        String userInput = "ls"; // This should be user input
        
        // Vulnerable: Concatenating user input directly into the command
        String command = "bash -c " + userInput;
        
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
