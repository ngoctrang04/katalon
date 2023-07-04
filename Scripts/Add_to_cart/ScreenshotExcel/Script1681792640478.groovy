import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import java.awt.Desktop
import java.awt.*
import java.awt.Robot
import java.awt.event.KeyEvent

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.FormulaEvaluator
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.codehaus.groovy.runtime.InvokerInvocationException
import com.kms.katalon.core.configuration.RunConfiguration

import groovy.time.TimeCategory
import java.util.Calendar
import java.text.SimpleDateFormat
import com.kms.katalon.core.configuration.RunConfiguration
import java.awt.Desktop
import java.awt.Toolkit
import javax.imageio.ImageIO
import java.awt.Robot
import java.awt.image.BufferedImage
import java.awt.Rectangle
import java.awt.event.KeyEvent
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.kms.katalon.core.webui.driver.DriverFactory
Date today = new Date()
String Date = today.format('dd.MM.yyyy').replace('.','-')

String p = RunConfiguration.getProjectDir()
String filename = 'test.xlsx'
String path = p + '\\' + filename

Desktop.getDesktop().open(new File(path))
Robot robot = new Robot()

FileInputStream fileExcel = new FileInputStream(path)
XSSFWorkbook workbook = new XSSFWorkbook(fileExcel)
XSSFSheet Sheet = workbook.getSheet('Data')

robot.keyPress(KeyEvent.VK_CONTROL)
robot.keyPress(KeyEvent.VK_HOME)

robot.keyRelease(KeyEvent.VK_CONTROL)
robot.keyRelease(KeyEvent.VK_HOME)

'get row number in excel'
int lastRow = CustomKeywords.'_OMR_custom_keyword.excel.getRow'(path)

for (s=1; s < lastRow ; s++) {
	robot.keyPress(KeyEvent.VK_DOWN)
	robot.keyPress(KeyEvent.VK_SHIFT)
	robot.keyPress(KeyEvent.VK_SPACE)
	Thread.sleep(2000)
	robot.keyRelease(KeyEvent.VK_DOWN)
	robot.keyRelease(KeyEvent.VK_SHIFT)
	robot.keyRelease(KeyEvent.VK_SPACE)
	
	String path_excel = p + '/Screenshot' + '/ScreenshotExcel/' 
	String email = CustomKeywords.'_OMR_custom_keyword.excel.readfileExcel'(path, s, 0)
	String Product_Name = CustomKeywords.'_OMR_custom_keyword.excel.readfileExcel'(path, s, 2)
	String name_png = email + '_' + Product_Name + '.png'
	
	BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()))
	ImageIO.write(image, "png", new File(path_excel + name_png))
	
}
	
robot.keyPress(KeyEvent.VK_ALT)
robot.keyPress(KeyEvent.VK_F4)
	
robot.keyRelease(KeyEvent.VK_ALT)
robot.keyRelease(KeyEvent.VK_F4)

	




