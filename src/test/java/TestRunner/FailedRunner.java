package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed.txt" ,
        glue = "StepDefinitions" ,
        //dryRun = false,
        //tags ="@testcase2",
        plugin = {"pretty"}
)

public class FailedRunner {

}
