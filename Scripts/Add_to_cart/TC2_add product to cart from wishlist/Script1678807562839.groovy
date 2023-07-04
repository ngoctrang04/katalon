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

Date today = new Date()
String Date = today.format('dd.MM.yyyy').replace('.','-')
String Time = today.format('dd.MM.yyyy hh:mm:ss').replace(':', '.')

'open browser'
WebUI.openBrowser('')

'Navigate to site: https://demo.nopcommerce.com/'
WebUI.navigateToUrl('https://demo.nopcommerce.com/')

'Maximize current window'
WebUI.maximizeWindow()

'Click on Login'
WebUI.click(findTestObject('Object Repository/Login/btn_Login1'))

'Input email'
WebUI.setText(findTestObject('Object Repository/Register/input_txt',[('text'):'Email']), 'ngoctrangnguyenthi122@gmail.com')

'Input password'
WebUI.setEncryptedText(findTestObject('Object Repository/Register/input_txt',[('text'):'Password']),'aeHFOx8jV/A=')

'Click on Login button'
WebUI.click(findTestObject('Object Repository/Login/btn_Login2'))

'Click add to wishlist'
WebUI.click(findTestObject('Object Repository/Add_to_cart/add_to_wishlist',[('text'):'3']))

'Click Wishlist'
WebUI.click(findTestObject('Object Repository/Add_to_cart/Wishlist_label'))

String product_name1 = WebUI.getText(findTestObject('Object Repository/Add_to_cart/productname_cart'))

'Check product'
WebUI.check(findTestObject('Object Repository/Add_to_cart/check_product_wishlist'))

'Click add to cart'
WebUI.click(findTestObject('Object Repository/Add_to_cart/btn_AddToCart_Wishlist'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Add_to_cart/page_shoppingcart'), 2)

String product_name2 = WebUI.getText(findTestObject('Object Repository/Add_to_cart/productname_cart'))

if (product_name1 == product_name2) {
	WebUI.takeScreenshot(((((('Screenshot/Add to cart/'+'/Success/')+ Date)+ '/')+ Time) + ' From wishlist')+'.png')
}
else {
	WebUI.takeScreenshot(((((('Screenshot/Add to cart/'+'/Error/')+ Date)+ '/')+ Time) + ' From wishlist')+'.png')
}

'Close browser'
WebUI.closeBrowser()



