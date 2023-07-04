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

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.FormulaEvaluator
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.codehaus.groovy.runtime.InvokerInvocationException
import com.kms.katalon.core.configuration.RunConfiguration

public class excel {

	@Keyword
	public getRow(String path) {
		FileInputStream fileExcel = new FileInputStream(path)
		XSSFWorkbook workbook = new XSSFWorkbook(fileExcel)
		XSSFSheet Sheet = workbook.getSheet('Data')
		int lastRow = Sheet.getPhysicalNumberOfRows()
		return lastRow
	}

	@Keyword
	public readfileExcel(String path, int rowIndex, int columnIndex) {
		FileInputStream fileExcel = new FileInputStream(path)
		XSSFWorkbook workbook = new XSSFWorkbook(fileExcel)
		XSSFSheet sheet = workbook.getSheet("Data")
		Row row = sheet.getRow(rowIndex)
		Cell cell = row.getCell(columnIndex)
		return cell
		workbook.close()
		fileExcel.close()
	}

	@Keyword
	public void writefileExcel(String path, String text, int rowIndex, int columnIndex)  {

		FileInputStream fileExcel = new FileInputStream(path)
		XSSFWorkbook workbook = new XSSFWorkbook(fileExcel)
		XSSFSheet Sheet = workbook.getSheet('Data')
		Row row = Sheet.getRow(rowIndex);
		if (row == null) {
			row = Sheet.createRow(rowIndex);
		}
		Cell cell = row.getCell(columnIndex);

		if (cell == null) {
			cell = row.createCell(columnIndex);
		}
		cell.setCellValue(text);
		FileOutputStream file = new FileOutputStream(path)
		workbook.write(file);
		workbook.close();
		file.close();
	}

	@Keyword
	public void createExcel(String path) {
		XSSFWorkbook workbook = new XSSFWorkbook()
		XSSFSheet Sheet = workbook.createSheet('Data')
		FileOutputStream file = new FileOutputStream(path)
		workbook.write(file)
		file.close()
		workbook.close()
	}
}
