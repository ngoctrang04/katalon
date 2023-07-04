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
WebUI.setText(findTestObject('Object Repository/Register/input_txt',[('text'):'FirstName']), 'Nguyen')

'Input Last Name'
WebUI.setText(findTestObject('Object Repository/Register/input_txt',[('text'):'LastName']), 'Trang')

Date today = new Date()
String Date = today.format('dd.MM.yyyy').replace('.','-')
String Time = today.format('dd.MM.yyyy hh:mm:ss').replace(':', '.')

def driver = DriverFactory.getWebDriver()

'Select day of birth'
Random randDay = new Random()
rows_table_Day = driver.findElements(By.xpath('//select[@name="DateOfBirthDay"]/option'))
rows_table_Day.remove(0)
upperLimit_Day = rows_table_Day.size()
rows_table_Day.get(randDay.nextInt(upperLimit_Day)).click()

'select month of birth'
Random rand_Month = new Random()
rows_table_Month = driver.findElements(By.xpath('//select[@name="DateOfBirthMonth"]/option'))
rows_table_Month.remove(0)
 upperLimit_Month = rows_table_Month.size()
rows_table_Month.get(rand_Month.nextInt(upperLimit_Month)).click()

'select year of birth'
Random rand_Year = new Random()
rows_table_Year = driver.findElements(By.xpath('//select[@name="DateOfBirthYear"]/option'))
rows_table_Year.remove(0)
 upperLimit_Year = rows_table_Year.size()
rows_table_Year.get(rand_Year.nextInt(upperLimit_Year)).click()

int RN;
RN = (int)(Math.random()*500)

emailRnd1 = 'ngoctrangnguyenthi' +RN + '@gmail.com'
'Input Email'
//WebUI.setText(findTestObject('Object Repository/Register/input_txt',[('text'):'Email']), emailRnd1)
WebUI.setText(findTestObject('Object Repository/Register/txt_Email'), 'ngoctrangnguyenthi122@gmail.com')

'Input Company Name'
WebUI.setText(findTestObject('Object Repository/Register/input_txt',[('text'):'Company']), 'TMA')

'Input Password'
WebUI.setEncryptedText(findTestObject('Object Repository/Register/input_txt',[('text'):'Password']),
	'aeHFOx8jV/A=')

'Confirm password'
WebUI.setEncryptedText(findTestObject('Object Repository/Register/input_txt',[('text'):'ConfirmPassword']),
	'aeHFOx8jV/A=')

'Click on Register button'
WebUI.click(findTestObject('Object Repository/Register/btn_Register'))

m = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Register/msg_error'))

if (m == true) {
	WebUI.takeScreenshot((((((('Screenshot/Register/'+'/Error/')+ Date)+ '/') + emailRnd1 )+ '/')+ Time)+'.png')
}

while (m == true) {
		
		emailRnd2 = 'ngoctrangnguyenthi' +RN + '@gmail.com'
		WebUI.setText(findTestObject('Object Repository/Register/input_txt',[('text'):'Email']), emailRnd2)

		'Input Password'
		WebUI.setEncryptedText(findTestObject('Object Repository/Register/input_txt',[('text'):'Password']),
			'aeHFOx8jV/A=')
		
		'Confirm password'
		WebUI.setEncryptedText(findTestObject('Object Repository/Register/input_txt',[('text'):'ConfirmPassword']),
			'aeHFOx8jV/A=')
		
		'Click on Register button'
		WebUI.click(findTestObject('Object Repository/Register/btn_Register'))

		m = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Register/msg_error'))
		
}
// take screenshot succcess
WebUI.takeScreenshot((((((('Screenshot/Register/'+'/Success/')+ Date)+ '/') + emailRnd1 )+ '/')+ Time)+'.png')

WebUI.closeBrowser()


