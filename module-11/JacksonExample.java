// Jacob Achenbach
// 7/27/2025

// Converts a Java object into JSON then reads JSON back into a Java object using the Jackson library


import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
    public String name;
    public int age;
    
    // Constructor for Jackson
    public Student() {}
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JacksonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Serialize Java object to JSON
            Student student = new Student("Alice", 22);
            String json = mapper.writeValueAsString(student);
            System.out.println("Serialized JSON: " + json);

            // Deserialize JSON to Java object
            String jsonInput = "{\"name\":\"Jack\",\"age\":23}";
            Student deserialized = mapper.readValue(jsonInput, Student.class);
            System.out.println("Deserialized Student: " + deserialized.name + ", Age: " + deserialized.age);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
