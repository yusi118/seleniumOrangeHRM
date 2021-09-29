package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;

import driverStrategy.DriverSingleton;

public class Utils {

	public static String decode64(String decodedStr) {
		Base64.Decoder decoder=Base64.getDecoder();
		return new String(decoder.decode(decodedStr.getBytes()));
	}
	
	public static boolean takeScreenshot() {
		File file=((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileCopyUtils.copy(file, new File(Constants.SCREENSHOT_FOLDER+generateRandomString(Constants.LENGTH)+".png"));
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private static String generateRandomString(int length) {
		String seedChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb=new StringBuilder();
		int i=0;
		Random random=new Random();
		while(i<length) {
			sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
			i++;
		}
		return sb.toString();
		
	}
}
