package br.com.keeggo.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static String getTime() {
		return new SimpleDateFormat("dd_MM_yyyy HH.mm.ss").format(new Date());
	}
	
	public static String gerarScreenShot(WebDriver driver, String cenario){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String caminho = System.getProperty("user.dir") + "/target/reportScreenshot/"+ cenario + "-"+ getTime() +".png";
		
		try {
			FileUtils.copyFile(file, new File(caminho));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return caminho;
	}
}
