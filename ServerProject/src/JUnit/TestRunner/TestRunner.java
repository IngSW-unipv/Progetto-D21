package JUnit.TestRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {

        System.out.println("Running JUnit tests.");

        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        System.out.println("Results:");
       for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());


    }
}  