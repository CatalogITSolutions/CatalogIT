package applicationUtilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ApplicationUtilities {

	WebDriver driver;
	WebElement element;
	List<WebElement> elementsList;

	public ApplicationUtilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement returnAnElementFromCollections(String propType, String propValue, String attrType,String attrValue) {
		elementsList = returnCollectionList(propType, propValue);
		System.out.println(elementsList);
		for (int i = 0; i <= elementsList.size(); i++) {
			String text = elementsList.get(i).getAttribute(attrType);

			if (text.equals(attrValue)) {
				element = elementsList.get(i);
				break;
			}

		}
		return element;
	}

	public List<WebElement> returnCollectionList(String propType, String propValue) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (propType.equals("id")) {
			elementsList = driver.findElements(By.id(propValue));
		} else if (propType.equals("name")) {
			elementsList = driver.findElements(By.name(propValue));
		} else if (propType.equals("className")) {
			elementsList = driver.findElements(By.className(propValue));
		} else if (propType.equals("cssSelector")) {
			elementsList = driver.findElements(By.cssSelector(propValue));
		} else if (propType.equals("linkText")) {
			elementsList = driver.findElements(By.linkText(propValue));
		} else if (propType.equals("partialLinkText")) {
			elementsList = driver.findElements(By.partialLinkText(propValue));
		} else if (propType.equals("tagName")) {
			elementsList = driver.findElements(By.tagName(propValue));
		} else if (propType.equals("xpath")) {
			elementsList = driver.findElements(By.xpath(propValue));
		}
		return elementsList;

	}

	public WebElement returnAnElement(String propType, String propValue) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (propType.equals("id")) {
			element = driver.findElement(By.id(propValue));
		} else if (propType.equals("name")) {
			element = driver.findElement(By.name(propValue));
		} else if (propType.equals("className")) {
			element = driver.findElement(By.className(propValue));
		} else if (propType.equals("cssSelector")) {
			element = driver.findElement(By.cssSelector(propValue));
		} else if (propType.equals("linkText")) {
			element = driver.findElement(By.linkText(propValue));
		} else if (propType.equals("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(propValue));
		} else if (propType.equals("tagName")) {
			element = driver.findElement(By.tagName(propValue));
		} else if (propType.equals("xpath")) {
			element = driver.findElement(By.xpath(propValue));
		}

		if(element.isEnabled())
			return element;
		else
			return null;

	}
	
	public void selectAnElementFromDropDown(String propType,String propValue,int index)
	{
		new Select(returnAnElement(propType,propValue)).selectByIndex(index);
	}
	public void selectAnElementFromDropDown(String propType,String propValue,String text)
	{
	 	new Select(returnAnElement(propType,propValue)).selectByVisibleText(text);
	}
	
	public void selectAnElementFromCollection(String propType,String propValue,String attrType,String attrValue)
	{
		elementsList = returnCollectionList(propType,propValue);
		for(int i=0;i<elementsList.size();i++)
		{
			String text = elementsList.get(i).getAttribute(attrType);
			
			if(text.equals(attrValue))
			{
				elementsList.get(i).click();
				break;
			}
		}
	 
}

}	