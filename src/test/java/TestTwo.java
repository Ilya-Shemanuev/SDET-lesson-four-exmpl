import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Severity;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.Test;
import ru.x5.entities.Student;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestTwo {

    private Student std;

    @Before
    public void setUp() throws URISyntaxException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File(this.getClass().getClassLoader()
                        .getResource("Student.json").toURI()),
                new Student("vas", "danze"));

    }

    @Test
    public void testOne() {ResponseSpecification responseSpec = RestAssured.expect();


        JsonPath jsonPath = RestAssured.given()
                .baseUri("dfgd")
                .expect().spec(responseSpec)
                .when().get().jsonPath();

        Student student = RestAssured.given()
        .when().get("/getStudent")
                .as(Student.class);

        student.getFullName();
    }
}
