package _OMR_custom_keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

public class setup {
	def register() {
		'click on Register'
		WebUI.click(findTestObject('Object Repository/Register/a_Register'))

		'Input First Name'
		WebUI.setText(findTestObject('Object Repository/Register/txt_FirstName'), 'Nguyen')

		'Input Last Name'
		WebUI.setText(findTestObject('Object Repository/Register/txt_LastName'), 'Trang')

		'Input Email'
		WebUI.setText(findTestObject('Object Repository/Register/txt_Email'), 'ngoctrangnguyenthi122@gmail.com')

		'Input Password'
		WebUI.setEncryptedText(findTestObject('Object Repository/Register/txt_password'),
				'aeHFOx8jV/A=')

		'Confirm password'
		WebUI.setEncryptedText(findTestObject('Object Repository/Register/txt_ConfirmPassword'),
				'aeHFOx8jV/A=')

		'Click on Register button'
		WebUI.click(findTestObject('Object Repository/Register/btn_Register'))
	}


	def login( ) {
		'Click on Login'
		WebUI.click(findTestObject('Object Repository/Login/btn_Login1'))

		'Input email'
		WebUI.setText(findTestObject('Object Repository/Register/input_txt',[('text'):'Email']), 'ngoctrangnguyenthi122@gmail.com')

		'Input password'
		WebUI.setEncryptedText(findTestObject('Object Repository/Register/input_txt',[('text'):'Password']),'aeHFOx8jV/A=')

		'Click on Login button'
		WebUI.click(findTestObject('Object Repository/Login/btn_Login2'))
	}
}
