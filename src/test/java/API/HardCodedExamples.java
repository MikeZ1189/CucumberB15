package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5NzEyMzMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTAxNDQzMywidXNlcklkIjoiNTIyOSJ9.NOh0llPpNUzH6PsZexXR0nwLleOD413Z26QKB2hYQQg";
    static String employee_id;

    @Test
    public void bgetCreatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);

        //hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        //verify the response
        response.then().assertThat().statusCode(200);

        String tempEmpId = response.jsonPath().getString("employee.employee_id");

        //we have 2 emp id, one is global and second is local
        Assert.assertEquals(employee_id, tempEmpId);
    }


    @Test
    public void acreateEmployee() {
        //prepare the request
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"Steven\",\n" +
                        "  \"emp_lastname\": \"Smith\",\n" +
                        "  \"emp_middle_name\": \"Jon\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1988-05-20\",\n" +
                        "  \"emp_status\": \"Fired\",\n" +
                        "  \"emp_job_title\": \"SDET\"\n" +
                        "}");

        //hitting the endpoint/send the request
        Response response = preparedRequest.when().post("/createEmployee.php");

        //it will print the output in the console
        response.prettyPrint();

        //verifying the assertions/get response
        response.then().assertThat().statusCode(201);

        //we are capturing employee id from the response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println("Employee id is: " + employee_id);

        //verifying the firstname in the response body
        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("Steven"));
        response.then().assertThat().
                body("Employee.emp_lastname", equalTo("Smith"));

        //verify the response headers
        response.then().assertThat().header("Content-Type", "application/json");

        System.out.println("My test case is passed");

    }

    //in homework, create a method to get all employee status and job title

    @Test
    public void cupdateEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Adam\",\n" +
                        "  \"emp_lastname\": \"Tyson\",\n" +
                        "  \"emp_middle_name\": \"Bourne\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2000-05-20\",\n" +
                        "  \"emp_status\": \"Engineer\",\n" +
                        "  \"emp_job_title\": \"CEO\"\n" +
                        "}");

        //hitting the endpoint
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        //verify status code
        response.then().assertThat().statusCode(200);

        //verify body message
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }

    @Test
    public void dgetUpdatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/jason").
                header("Authorization", token).queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //if you want to verify the body of the response.
        //you can do that using hamcrest matchers
    }

}
