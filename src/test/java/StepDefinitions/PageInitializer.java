package StepDefinitions;


import Pages.AddEmployeePage;
import Pages.LoginPage;

//this class will manage the object creation of different page Objects in our Framework
//instead of calling the page objects again and again, this class will take good care of that step
public class PageInitializer {

    public static LoginPage login;
    public static AddEmployeePage addEmployeePage;
    public static void initializePageObject(){ // method
        login = new LoginPage();
        addEmployeePage = new AddEmployeePage();
    }
}
