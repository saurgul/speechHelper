package testcases;

import java.util.HashMap;

import org.junit.Test;

import com.speechhelper.parsetext.FillerWordsUtility;

public class FillerWordsUtilityTest {
	String path = getClass().getClassLoader().getResource("fillerWords.txt").getPath();
	HashMap<String, Integer> newMap = new HashMap<>();
	//newMap.put("Speech", 4);
	@Test
	public void test() {
		FillerWordsUtility filler = new FillerWordsUtility();
		filler.getFillersFrequency(newMap);
		filler.getFillerWordsPercentage(10);
		
	}

}
