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

'open browser'
WebUI.openBrowser('')

'Navigate to site: https://demo.nopcommerce.com/'
WebUI.navigateToUrl('https://demo.nopcommerce.com/')

'Maximize current window'
WebUI.maximizeWindow()

'click on Register'
WebUI.click(findTestObject('Object Repository/Register/a_Register'))

'Click on Register button'
WebUI.click(findTestObject('Object Repository/Register/btn_Register'))

'Verify warning displayed when First Name is blank'
WebUI.verifyElementText(findTestObject('Object Repository/Register/msg_FirstNameError'), 
    'First name is required.')

'Verify warning displayed when Last Name is blank'
WebUI.verifyElementText(findTestObject('Object Repository/Register/msg_LastNameError'),
	'Last name is required.')

'Verify warning displayed when Email is blank'
WebUI.verifyElementText(findTestObject('Object Repository/Register/msg_EmailError'),
	'Email is required.')

'Verify warning displayed when Password is blank'
WebUI.verifyElementText(findTestObject('Object Repository/Register/msg_PasswordError'),
	'Password is required.')

'Verify warning displayed when Confirm Password is blank'
WebUI.verifyElementText(findTestObject('Object Repository/Register/msg_ConfirmPasswordError'),
	'Password is required.')

'Take screenshot after register successfully'
WebUI.takeScreenshot('Screenshot/Register/TC2.png')

'Close browser'
WebUI.closeBrowser()