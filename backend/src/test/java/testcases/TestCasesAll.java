package testcases;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ControllerTest.class,
	            ModelTest.class,
	            SpeechTest.class,
	            SpeechToTextCommandTest.class,
	            FillerWordsUtilityTest.class
				})

public class TestCasesAll {

}
