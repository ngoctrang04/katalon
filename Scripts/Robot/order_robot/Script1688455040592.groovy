import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.kklisura.cdt.protocol.types.page.Navigate
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.openqa.selenium.Rectangle as Rectangle
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import com.kms.katalon.core.configuration.RunConfiguration
browserName = DriverFactory.getExecutedBrowser().getName()

String p0 = RunConfiguration.getProjectDir()
String filename = p0 + '\\' + 'orders.csv'
String p = p0.replaceAll('/','\\\\')

Map DownloadDriver = [('download.default_directory'): p]

if (browserName== 'CHROME_DRIVER') {
	RunConfiguration.setWebDriverPreferencesProperty('prefs', DownloadDriver)
}
else if(browserName == 'EDGE_CHROMIUM_DRIVER') {
	Map edge = ["prefs": DownloadDriver]
	RunConfiguration.setWebDriverPreferencesProperty('ms:edgeOptions', edge)
}
WebUI.openBrowser('https://robotsparebinindustries.com/orders.csv')

//'open browser'
//WebUI.openBrowser('https://robotsparebinindustries.com/#/robot-order')
//
//'maximize window'
//WebUI.maximizeWindow()
//
//'Read file CSV'
//List<String> Listdata= CustomKeywords.'_OMR_custom_keyword.readfile.readfilecsv'(filename)
//print Listdata
//
//for(s=1; s < Listdata.size() ;s++) {
//	
//	'Click ok'
//	WebUI.click(findTestObject('Object Repository/order_Robot/btn_ok'))
//	
//	'Choose a head'
//	WebUI.selectOptionByValue(findTestObject('Object Repository/order_Robot/select_head'),Listdata[s][1], false)
//	
//	'Body'
//	WebUI.click(findTestObject('Object Repository/order_Robot/body',[("i"):Listdata[s][2]]))
//	
//	'Legs'
//	WebUI.setText(findTestObject('Object Repository/order_Robot/input_Legs'), Listdata[s][3])
//	
//	'Address'
//	WebUI.setText(findTestObject('Object Repository/order_Robot/input_address'), Listdata[s][4])
//	
//	'Click button Preview'
//	WebUI.click(findTestObject('Object Repository/order_Robot/btn_Preview'))
//	
//	'Click button Order'
//	WebUI.click(findTestObject('Object Repository/order_Robot/btn_Order'))
//	
//	m = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/order_Robot/message_error'))
//	
//	while(m==true) {
//		'Click button Order'
//		WebUI.click(findTestObject('Object Repository/order_Robot/btn_Order'))
//		
//		m = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/order_Robot/message_error'))
//	}
//	
//	'Click Order Another Robot'
//	WebUI.click(findTestObject('Object Repository/order_Robot/btn_OrderAnotherRobot'))
//}
//WebUI.closeBrowser()
//
//
//
//
