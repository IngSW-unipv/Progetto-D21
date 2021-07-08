package JUnit.TestRunner;

import JUnit.Test.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ServerMemoryTest.class,
        GridTest.class
})
public class JunitTestSuite {
}  	