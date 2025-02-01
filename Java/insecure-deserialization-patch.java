// Use safe deserialization techniques, such as validating or using libraries like Jackson or Gson for JSON deserialization instead of Java serialization.


import com.fasterxml.jackson.databind.ObjectMapper;

public class SafeDeserialization {
    public static void main(String[] args) throws IOException {
        String jsonInput = "{ \"username\": \"user\" }"; // Simulating user input
        ObjectMapper mapper = new ObjectMapper();
        
        // Safely deserializing to a POJO class (User class)
        User user = mapper.readValue(jsonInput, User.class);
        System.out.println(user.getUsername());
    }
}
