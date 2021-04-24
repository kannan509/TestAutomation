package testrunner;

import org.junit.Before;
import org.junit.runner.RunWith;

import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features="", glue= {"stepdefinition","steplibrary"}, tags= {"@shadow"})
 
public class TestRunner {
	@Before
	public void start() {
		System.out.println("happy");
	}

}
