// Use ProcessBuilder or higher-level libraries to avoid directly executing system commands.
// Validate and sanitize all user input.


import java.io.*;

public class SafeCommandExecution {
    public static void main(String[] args) throws IOException {
        String userInput = "ls"; // Simulate user input
        
        // Use ProcessBuilder to safely run commands
        ProcessBuilder builder = new ProcessBuilder("bash", "-c", userInput);
        builder.start();
    }
}
