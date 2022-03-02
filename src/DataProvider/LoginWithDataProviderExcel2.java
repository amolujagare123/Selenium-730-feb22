package DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginWithDataProviderExcel2 {

    @Test (dataProvider = "getData")
    public void loginTest(String username , String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys(username);

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys(password);

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();
    }

    @DataProvider /*(name = "myDataProvider")*/
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/LoginData.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fis);

        HSSFSheet sheet = workbook.getSheet("Sheet2");

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data= new Object[rowCount][2]; // row x col
                                                 // records x inputs
        for(int i=0;i<rowCount;i++)
        {
            HSSFRow row = sheet.getRow(i);

            HSSFCell username = row.getCell(0);
           try {
                username.setCellType(CellType.STRING);
                data[i][0] = username.getStringCellValue();
            }
           catch (Exception e)
           {
               data[i][0] ="";
           }

            HSSFCell password = row.getCell(1);
            try {
                password.setCellType(CellType.STRING);
                data[i][1] = password.getStringCellValue();
            }
            catch (Exception e)
            {
                data[i][1] ="";
            }


          /*  HSSFCell username = row.getCell(0);
            if (username==null)
                data[i][0] ="";
            else {
                username.setCellType(CellType.STRING);
                data[i][0] = username.getStringCellValue();
            }

            HSSFCell password = row.getCell(1);
            if (password==null)
                data[i][1]="";
            else {
                password.setCellType(CellType.STRING);
                data[i][1] = password.getStringCellValue();
            }*/
        }

        return data;
    }
}
