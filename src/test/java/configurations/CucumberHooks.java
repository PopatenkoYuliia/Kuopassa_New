package configurations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
    @After(order = 0)
    public void afterScenario() {
        System.out.println("Tsis will run after the Scenario");
    }

    @Before(order = 0)
    public void beforeScenario() {
        System.out.println("This will run before the Scenario");
    }
}
