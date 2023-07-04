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
import java.util.Random

import  java.lang.Float
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

Date today = new Date()
String Date = today.format('dd.MM.yyyy').replace('.','-')
String Time = today.format('dd.MM.yyyy hh:mm:ss').replace(':', '.')

'open browser'
WebUI.openBrowser('')

'Navigate to site: https://demo.nopcommerce.com/'
WebUI.navigateToUrl('https://demo.nopcommerce.com/')

'Maximize current window'
WebUI.maximizeWindow()

'Register'
//CustomKeywords.'_OMR_custom_keyword.setup.register'()

 'Login'
//CustomKeywords.'_OMR_custom_keyword.setup.login'()

Random rnd = new Random()
 
'count Category'
countCategory = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/ul_count_category')

'get random category to click'
rndCate = (1 + rnd.nextInt(countCategory.size()))

//rndCate = 3

'click to category'
WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/ul_category_to_click',[('number'): 4]))
WebUI.waitForPageLoad(300)

'check location is have subcategory or not'
countSubCate = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/div_sub_category_item')

if(countSubCate.size() > 0) {
	'random select subcate'
	rndSubCate = (1+ rnd.nextInt(countSubCate.size()))
//	rndSubCate = 1
	'click random category'
	WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/a_subCate_to_click',[('number'): rndSubCate]))
	WebUI.waitForPageLoad(300)
	
}

'count product to random select'
countProduct = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/div_product_item')
rndProduct = (1+ rnd.nextInt(countProduct.size()))
//rndProduct = 1

'click random product'
WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/a_product_item_to_click',[('number'): 3]))
WebUI.waitForPageLoad(300)

'check product have Attribute or not'
countAttribute = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/div_Count_Attribute')

if (countAttribute.size() > 0) {

		'count select detail'
		countAttriDetail = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/select_Count_Select_Box')
		
		if (countAttriDetail.size()> 0) {
			for (i = 1; i <= countAttriDetail.size(); i ++) {
				'select random'
				//WebUI.selectOptionByIndex(findTestObject('Object Repository/Add_to_cart/Random_product/select_Select_Box',[('number'): i]), 1)
				int totalOptions_select = WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Add_to_cart/Random_product/select_Select_Box',[('number'): i]))
				rndoption_select =  2 + rnd.nextInt(totalOptions_select - 1)
				WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/option_select',[('number') : i, ('option') : rndoption_select]))
			}
		}
		
		'count radio detail'
		countAttriDetail = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/ul_Count_Radio')
		if (countAttriDetail.size()> 0) {
			for (i = 1; i <= countAttriDetail.size(); i ++) {
				'select random'
				optionRadio = CustomKeywords.'customKeywords.getElement'('Object Repository/Add_to_cart/Random_product/option_Radio', [('number'):i])
				print optionRadio.size()
				rndoption_radio = 1 + rnd.nextInt(optionRadio.size())
				WebUI.check(findTestObject('Object Repository/Add_to_cart/Random_product/ul_Radio_option',[('number'): i, ('option') : rndoption_radio]))
			}
		}
		
		'count text box'
		count_textbox = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/text_box')
		if (count_textbox.size()> 0) {
			for (i = 1; i <= count_textbox.size(); i++ ) {
				WebUI.setText(findTestObject('Object Repository/Add_to_cart/Random_product/input_textbox',[('number'): i]), 'abc')
			}
		}
	}

'check gift card'
gift_card = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/div_giftcard')
if (gift_card.size()>0) {
	
	count_text_giftcard = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/giftcard_text')
	if (count_text_giftcard.size() > 0) {
		for (i=1; i<= count_text_giftcard.size(); i++) {
			WebUI.setText(findTestObject('Object Repository/Add_to_cart/Random_product/input_text_giftcard',[('number'): i]), 'abc')
		}
	}
	count_email_giftcard = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/giftcard_email')
	if (count_email_giftcard.size() > 0) {
		for (i=1; i <= count_email_giftcard.size(); i++) {
			WebUI.setText(findTestObject('Object Repository/Add_to_cart/Random_product/input_email_giftcard',[('number'): i]), 'abc@gmail.com')
		}
	}
}

'check rental attributes'
rental_attributes = CustomKeywords.'customKeywords.getNumberElement'('Object Repository/Add_to_cart/Random_product/div_rental')
if (rental_attributes.size() >0) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy")
	Calendar calendar = Calendar.getInstance()
	String currentDate = dateFormat.format(calendar.getTime())
	'start date'
	calendar.add(Calendar.MONTH, 3)
	String futureDate = dateFormat.format(calendar.getTime())
	
	long diff = dateFormat.parse(futureDate).getTime() - dateFormat.parse(currentDate).getTime();
	int randomFutureDays = (int) (Math.random() * diff / (1000 * 60 * 60 * 24));
	calendar.setTime(dateFormat.parse(currentDate));
	calendar.add(Calendar.DATE, randomFutureDays);
	String selectedFutureDate = dateFormat.format(calendar.getTime());
	WebUI.setText(findTestObject('Object Repository/Add_to_cart/startdate'), selectedFutureDate);
	
	
	'end date'
	calendar.add(Calendar.MONTH, 3)
	String futureDate_end = dateFormat.format(calendar.getTime())
	
	long diff_end = dateFormat.parse(futureDate_end).getTime() - dateFormat.parse(selectedFutureDate).getTime()
	int randomFutureDays_end = (int) (Math.random() * diff_end / (1000*60*60*24))
	calendar.setTime(dateFormat.parse(selectedFutureDate))
	calendar.add(Calendar.DATE, randomFutureDays_end)
	String selectedFutureDate_end = dateFormat.format(calendar.getTime())
	WebUI.setText(findTestObject('Object Repository/Add_to_cart/enddate'), selectedFutureDate_end)

}

List list_btn_AddToCart = CustomKeywords.'_OMR_custom_keyword.Product.Text'('Object Repository/Add_to_cart/btn2_AddToCart')

if (list_btn_AddToCart.size() == 0) {
	WebUI.takeScreenshot((((('Screenshot/Add to cart/'+'/Error/')+ Date)+ '/')+ Time) +'.png')
}
else if (list_btn_AddToCart.size() == 1) {
	WebUI.click(findTestObject('Object Repository/Add_to_cart/btn2_AddToCart'))
//	WebUI.click(findTestObject('Object Repository/Add_to_cart/cart'))
	WebUI.navigateToUrl('https://demo.nopcommerce.com/cart')
	WebUI.takeScreenshot((((('Screenshot/Add to cart/'+'/Successecful/')+ Date)+ '/')+ Time) +'.png')
}
else if (list_btn_AddToCart.size() >= 2) {
	rand_AddToCart = 1 + rnd.nextInt(list_btn_AddToCart.size())
	WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/AddToCart_count', [('dt'):rand_AddToCart]))
//	WebUI.click(findTestObject('Object Repository/Add_to_cart/cart'))
	WebUI.navigateToUrl('https://demo.nopcommerce.com/cart')
	WebUI.takeScreenshot((((('Screenshot/Add to cart/'+'/Successful/')+ Date)+ '/')+ Time) +'.png')
}

'Close browser'
WebUI.closeBrowser()
















