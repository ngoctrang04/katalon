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

'select radio gender'
WebUI.click(findTestObject('Object Repository/Register/radio_gender'))

'Input First Name'
WebUI.setText(findTestObject('Object Repository/Register/txt_FirstName'), 'Nguyen')

'Input Last Name'
WebUI.setText(findTestObject('Object Repository/Register/txt_LastName'), 'Trang')

'Select date of birth'
WebUI.selectOptionByValue(findTestObject('Object Repository/Register/Day'),
	'10', true)

'Select month of birth'
WebUI.selectOptionByValue(findTestObject('Object Repository/Register/Month'),
	'4', true)

'Select year of birth'
WebUI.selectOptionByValue(findTestObject('Object Repository/Register/Year'),
	'2001', true)

'Input Email'
WebUI.setText(findTestObject('Object Repository/Register/txt_Email'), 'trangngoc@gmail.com')

'Input Company Name'
WebUI.setText(findTestObject('null'), 'TMA')

'Input Password'
WebUI.setEncryptedText(findTestObject('Object Repository/Register/txt_password'),
	'aeHFOx8jV/A=')

'Confirm password'
WebUI.setEncryptedText(findTestObject('Object Repository/Register/txt_ConfirmPassword'),
	'aeHFOx8jV/A=')

'Click on Register button'
WebUI.click(findTestObject('Object Repository/Register/btn_Register'))

'Verify warning displayed when register 2 account with 1 email'
WebUI.verifyElementText(findTestObject('Object Repository/Register/msg_error'),
	'The specified email already exists')

'Take screenshot after register successfully'
WebUI.takeScreenshot('Screenshot/Register/TC9.png')

'Close browser'
WebUI.closeBrowser()