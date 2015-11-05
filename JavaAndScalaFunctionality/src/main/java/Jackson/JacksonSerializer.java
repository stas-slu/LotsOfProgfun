package Jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Building nice JSON from one main POJO (Contact) that looks like:
 *
 *  {"properties": [
 *      {"property": "email", "value": "test@test.com"},
 *      {"property": "firstName", "value": "testName"}
 *  ]}
 *
 *  Based on:
 *  http://stackoverflow.com/questions/22871845/how-to-use-jackson-annotation-to-do-a-mapping
 */
public class JacksonSerializer {

    public static class Contact {
        final public String email;
        final public String firstname;
        @JsonIgnore
        public String ignoreMe = "abc";

        public Contact(String email, String firstname) {
            this.email = email;
            this.firstname = firstname;
        }
    }

    public static class Property {
        final public String property;
        final public Object value;

        public Property(String property, Object value) {
            this.property = property;
            this.value = value;
        }
    }

    public static class Container {
        final public List<Property> properties;

        public Container(List<Property> properties) {
            this.properties = properties;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        Contact contact = new Contact("abc@gmail.com", "John");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(contact, JsonNode.class); //convert your bean instance to a JsonNode
        Iterator<String> fieldNames = node.fieldNames();
        List<Property> list = new ArrayList<>();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            list.add(new Property(fieldName, node.get(fieldName))); // manually map the JsonNode fields to your "property-object" model
        }
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Container(list)));
    }
}