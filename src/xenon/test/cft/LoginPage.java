package xenon.test.cft;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(id="ru.nsk.ftc.bender:screen_card_ean_enter/button_enter")
	private WebElement enterButton;
	@FindBy(id="ru.nsk.ftc.bender:screen_card_ean_enter/edit_text_ean")
	private WebElement barcodeInput;
	@FindBy(id="ru.nsk.ftc.bender:screen_card_ean_enter/edit_text_password")
	private WebElement passwordInput;
	
	//ru.nsk.ftc.bender:screen_card_exchange/label_password
	
	private TestDriver driver;
	
	public LoginPage(TestDriver driver) {
		this.driver = driver;
		driver.initElements(this);
	}
	
	public void login(String barcode, String password) {
		barcodeInput.sendKeys(barcode);
		//enterButton.click();
		
		//List<WebElement> elements = driver.getDriver().findElements(By.className("android.widget.TextView"));
		
		/*File file = new File("d:\\test.txt");
        try {
        	file.delete();
        	file.createNewFile();
        	FileWriter fileWriter = new FileWriter(file);
        	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        	
        	bufferedWriter.write(
        			driver.getDriver().getPageSource()); 
        	bufferedWriter.newLine();
        	
        	bufferedWriter.flush();
        	bufferedWriter.close();
        	fileWriter.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }*/
		/*passwordInput.sendKeys(password);
		enterButton.click();*/
		
		//System.out.println(elements.size());
	}
}
