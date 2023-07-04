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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import internal.GlobalVariable

public class verify {
	@Keyword

	def findElementandVerifyEqual(def sObjectRepository, def sExpectedData) {

		def sActualData = WebUI.getAttribute(findTestObject(sObjectRepository), 'value')
		WebUI.verifyEqual(sActualData, sExpectedData)
	}

	@Keyword
	boolean verifyObjectPresent(TestObject objectReference) {
		try {
			WebUiCommonHelper.findWebElement(objectReference,10)
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Keyword
	public boolean verifyObjectNotPresent(TestObject objectReference) {
		return WebUI.verifyElementNotPresent(objectReference, 10, FailureHandling.OPTIONAL)
	}

	@Keyword
	boolean verifyObjectNotClickable(TestObject objectReference) {
		return WebUI.verifyElementNotClickable(objectReference, FailureHandling.OPTIONAL)
	}

	@Keyword
	boolean verifyObjectClickable(TestObject objectReference) {
		return WebUI.verifyElementClickable(objectReference, FailureHandling.OPTIONAL)
	}

	@Keyword
	boolean verifyObjectChecked(TestObject objectReference) {
		return WebUI.verifyElementChecked(objectReference, 5, FailureHandling.OPTIONAL)
	}
}
