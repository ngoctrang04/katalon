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
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Keys as Keys
import java.lang.String
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.kms.katalon.core.webui.driver.DriverFactory
import java.io.File;
import java.util.ArrayList;
import java.util.List;

String p = RunConfiguration.getProjectDir()
String filename = p + '\\' + 'orders.csv'

'open browser'
WebUI.openBrowser('https://robotsparebinindustries.com/#/robot-order')

'maximize window'
WebUI.maximizeWindow()

'Read file CSV'
List<String> Listdata= CustomKeywords.'_OMR_custom_keyword.readfile.readfilecsv'(filename)
print Listdata

for(s=1; s < Listdata.size() ;s++) {
	
	'Click ok'
	WebUI.click(findTestObject('Object Repository/order_Robot/btn_ok'))
	
	'Choose a head'
	WebUI.selectOptionByValue(findTestObject('Object Repository/order_Robot/select_head'),Listdata[s][1], false)
	
	'Body'
	WebUI.click(findTestObject('Object Repository/order_Robot/body',[("i"):Listdata[s][2]]))
	
	'Legs'
	WebUI.setText(findTestObject('Object Repository/order_Robot/input_Legs'), Listdata[s][3])
	
	'Address'
	WebUI.setText(findTestObject('Object Repository/order_Robot/input_address'), Listdata[s][4])
	
	'Click button Preview'
	WebUI.click(findTestObject('Object Repository/order_Robot/btn_Preview'))
	
	'Click button Order'
	WebUI.click(findTestObject('Object Repository/order_Robot/btn_Order'))
	
	m = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/order_Robot/message_error'))
	
	while(m==true) {
		'Click button Order'
		WebUI.click(findTestObject('Object Repository/order_Robot/btn_Order'))
		
		m = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/order_Robot/message_error'))
	}
	
	'Click Order Another Robot'
	WebUI.click(findTestObject('Object Repository/order_Robot/btn_OrderAnotherRobot'))
}
WebUI.closeBrowser()




