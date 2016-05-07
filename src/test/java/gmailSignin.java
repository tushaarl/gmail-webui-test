import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;

/**
 * Created by etuslik on 10/28/2015.
 */
public class gmailSignin {
    WebDriver driver=new FirefoxDriver();
    @Test
    public void gmailLoginShouldbesuccess(){

        //Go to gmail
        driver.get("http://gmail.com");
        WebElement usernametextbox=driver.findElement(By.id("Email"));
                usernametextbox.sendKeys("tusharlikhar2204@gmail.com");
//Enter username
        WebElement nextButton=driver.findElement(By.id("next"));
        nextButton.click();
//Enter password
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        Assert.assertTrue("password box should present",driver.findElements(By.id("Passwd")).size()>0);

        WebElement passwordTextBox=driver.findElement(By.id("Passwd"));
        passwordTextBox.sendKeys("tushar7387985193");

        WebElement signInButton=driver.findElement(By.id("signIn"));
        signInButton.click();
    //Verify user is Sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should present",driver.findElements(By.partialLinkText("Inbox")).size()>0);
//Go to Signout
        WebElement profileButton=driver.findElement(By.cssSelector("span[class='gb_Wa gbii']"));
        profileButton.click();

        WebElement signOutButton=driver.findElement(By.id("gb_71"));
        signOutButton.click();
//Verify user is sign out
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
        Assert.assertTrue("password box should present",driver.findElements(By.id("signIn")).size()>0);

    }
@Test
    public void sendandreceiveemailsuccessful(){
        driver.get("http://gmail.com");
    //Signin to the mail box
        WebElement usernametextbox=driver.findElement(By.id("Email"));
        usernametextbox.sendKeys("tusharlikhar2204@gmail.com");
//Enter username
        WebElement nextbutton=driver.findElement(By.id("next"));
        nextbutton.click();
//Enter password
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        Assert.assertTrue("password box should present",driver.findElements(By.id("Passwd")).size()>0);


        WebElement passwordtextbox=driver.findElement(By.id("Passwd"));
        passwordtextbox.sendKeys("tushar7387985193");

        WebElement signInbutton=driver.findElement(By.id("signIn"));
        signInbutton.click();
        driver.manage().window().maximize();
        //Verify user is Sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=':i3']")));
        Assert.assertTrue("Inbox should present",driver.findElements(By.xpath(".//*[@id=':i3']")).size()>0);
        WebElement profileButton=driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
        profileButton.click();
//Type the recepient
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
        WebElement totextbox=driver.findElement(By.cssSelector("textarea[name='to']"));
        totextbox.clear();
        totextbox.sendKeys("tusharlikhar2204@gmail.com");
//Enter the Subject
        WebElement subjectbutton=driver.findElement(By.cssSelector("input[name='subjectbox']"));
        final String subject="Hi first automated subject box";
        subjectbutton.clear();
        subjectbutton.sendKeys(subject);

    //Write the mail
    WebElement bodybutton=driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
    final String body="Welcome to the automated test mail world guys";
    bodybutton.clear();
    bodybutton.sendKeys(body);
//Click the send button
    WebElement sendbutton=driver.findElement(By.cssSelector("div[aria-label*=\"Send\"]"));
    sendbutton.click();

    //Click the inbox
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=':i3']")));
    Assert.assertTrue("Inbox should present",driver.findElements(By.xpath(".//*[@id=':i3']")).size()>0);
    WebElement inboxLinkage=driver.findElement(By.xpath(".//*[@id=':i3']"));
    inboxLinkage.click();

    //Check new email is received
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [@class='y6']/span[contains(.,'Hi first automated subject box')]")));
    WebElement newMail = driver.findElement(By.xpath("//div [@class='y6']/span[contains(.,'Hi first automated subject box')]"));
    newMail.click();

    //Verify email csubject and body
    WebElement subjectArea=driver.findElement(By.cssSelector("h2[class='hP']"));
    Assert.assertEquals("Subject should be the same", subject, subjectArea.getText());

    WebElement bodyArea=driver.findElement(By.cssSelector("div[class='adn ads'] div[dir='ltr']"));
    Assert.assertEquals("Body text should be the same",body,bodyArea.getText());
    //Sign out
    WebElement profileButton1=driver.findElement(By.cssSelector("span[class='gb_2a gbii']"));
    profileButton1.click();

    WebElement signOutButton=driver.findElement(By.id("gb_71"));
    signOutButton.click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
//Verify user is sign out
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
    Assert.assertTrue("password box should present",driver.findElements(By.id("signIn")).size()>0);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
