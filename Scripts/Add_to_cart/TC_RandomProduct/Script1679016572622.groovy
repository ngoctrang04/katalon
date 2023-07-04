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
CustomKeywords.'_OMR_custom_keyword.setup.login'()

'Random Menu'
Random rnd = new Random()
List listCategory = CustomKeywords.'_OMR_custom_keyword.Product.Text'('Object Repository/Add_to_cart/Random_product/div_menu')
randCategory = rnd.nextInt(listCategory.size()-4)
//WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/a_navigate',[("dt"):listCategory[randCategory]]))
WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/a_navigate',[("dt"):listCategory[2]]))

'Random item-grid'
List listCategory_item = CustomKeywords.'_OMR_custom_keyword.Product.Text'('Object Repository/Add_to_cart/Random_product/div_CategoryItem')
randCategory_item = rnd.nextInt(listCategory_item.size())
//WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/a_Item',[('dt'):listCategory_item[randCategory_item]]))
WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/a_Item',[('dt'):listCategory_item[0]]))

'Random Product'
List listProduct_Name = CustomKeywords.'_OMR_custom_keyword.Product.Text'('Object Repository/Add_to_cart/Random_product/div_product')
randProduct_name = rnd.nextInt(listProduct_Name.size())
//WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/a_productName', [('dt'):listProduct_Name[randProduct_name]]))
WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/a_productName', [('dt'):listProduct_Name[0]]))

List list_btn_AddToCart = CustomKeywords.'_OMR_custom_keyword.Product.Text'('Object Repository/Add_to_cart/btn2_AddToCart')
count_AddToCart = list_btn_AddToCart.size()
System.out.println(count_AddToCart)

if (count_AddToCart == 0) {
	WebUI.takeScreenshot((((('Screenshot/Add to cart/'+'/Error/')+ Date)+ '/')+ Time) +'.png')
}

else if (count_AddToCart >= 1) {
	if (count_AddToCart == 1) {
		WebUI.click(findTestObject('Object Repository/Add_to_cart/btn2_AddToCart'))
	}

	else if (count_AddToCart >= 2) {
		rand_AddToCart = 1 + rnd.nextInt(count_AddToCart)  
		WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/AddToCart_count', [('dt'):rand_AddToCart]))
	}
	def driver = DriverFactory.getWebDriver()
	
//	msg = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Add_to_cart/Random_product/msg_ERROR'))
//	while (msg == true) {
	
//		'Random RAM'
//		msg_RAM = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Add_to_cart/Random_product/msg_selectRAM'))
//		if (msg_RAM == true) {
//			List listRAM = CustomKeywords.'_OMR_custom_keyword.Product.Text'('Object Repository/Add_to_cart/Random_product/selectRam')
//			System.out.println(listRAM)
//			randRAM =  1 + rnd.nextInt(listRAM.size())
//			WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/optionRam', [('dt'):listRAM[randRAM]]))
//		}
//		
//		'Random HDD'
//		msg_HDD = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Add_to_cart/Random_product/msg_selectHDD'))
//		if (msg_HDD == true) {
//			List listHDD = CustomKeywords.'_OMR_custom_keyword.Product.Text'('Object Repository/Add_to_cart/Random_product/selectHDD')
//			System.out.println(listHDD)
//			randHDD =  rnd.nextInt(listHDD.size())
//			WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/optionHDD', [('dt'):listHDD[randHDD]]))
//		}
//		
//		'Random Print'
//		msg_Print =  CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Add_to_cart/Random_product/msg_selectPrint'))
//		if (msg_Print == true) {
//			Print = driver.findElements(By.xpath('//span[@class="attribute-square"]'))
//			Print.get(rnd.nextInt(Print.size())).click()
//		}
//		
//		'Enter your text'
//		msg_Enteryourtext =  CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Add_to_cart/Random_product/msg_enteryourText'))
//		if (msg_Enteryourtext == true) {
//			WebUI.setText(findTestObject('Object Repository/Register/input_txt',[('text'):'product_attribute_12']), 'I love')
//		}
//		
//		'Random color'
//		msg_color = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Add_to_cart/Random_product/msg_selectcolor'))
//		if (msg_color == true) {
//			List listColor = CustomKeywords.'_OMR_custom_keyword.Product.Text'('Object Repository/Add_to_cart/Random_product/selectColor')
//			System.out.println(listColor)
//			randColor = 1+  rnd.nextInt(listColor.size())
//			WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/optionColor', [('dt'):listColor[randColor]]))
//		}
		
		'Random size'
		msg_selectSize = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Add_to_cart/Random_product/msg_selectSize'))
		if (msg_selectSize == true) {
//			WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/click_size'))
//			ssize = driver.findElements(By.xpath('//select[@class="valid"]/option'))
//			println ssize
			//ssize.remove(0)
			//ssize.get(rnd.nextInt(ssize.size())).click()
			
//			List listSize = CustomKeywords.'_OMR_custom_keyword.Product.Text'('Object Repository/Add_to_cart/Random_product/selectSize13')
//			System.out.println(listSize)
//			randSize = 1+  rnd.nextInt(listSize.size())
//			WebUI.click(findTestObject('Object Repository/Add_to_cart/Random_product/optionSize13', [('dt'):listSize[randSize]]))
			 
			WebUI.selectOptionByIndex(findTestObject('Object Repository/Add_to_cart/Random_product/selectSize13'), 1)
		
		}
		
		'click Add to cart'
		WebUI.click(findTestObject('Object Repository/Add_to_cart/btn2_AddToCart'))
		
//		msg = CustomKeywords.'_OMR_custom_keyword.verify.verifyObjectPresent'(findTestObject('Object Repository/Add_to_cart/Random_product/msg_ERROR'))
//		
//	}
	WebUI.click(findTestObject('Object Repository/Add_to_cart/cart'))
	WebUI.takeScreenshot((((('Screenshot/Add to cart/'+'/Succes/')+ Date)+ '/')+ Time) +'.png')
}

'Close browser'
//WebUI.closeBrowser()
















//WebUI.click(findTestObject('Object Repository/Add_to_cart/1'))
//WebUI.click(findTestObject('Object Repository/Add_to_cart/2'))
//WebUI.click(findTestObject('Object Repository/Add_to_cart/3'))





