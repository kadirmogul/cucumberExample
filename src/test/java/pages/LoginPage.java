package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement clickButton;

    @FindBy(className = "post-header")
    private WebElement successMessage;

    @FindBy(className = "post-title")
    private WebElement helloWordMessage;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void setUsername(String username){
        usernameInput.sendKeys(username);
    }
    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clikButton(){
        clickButton.click();
    }
    public void AssertToSuccess(){
        Assert.assertTrue(successMessage.isDisplayed());
    }


}
