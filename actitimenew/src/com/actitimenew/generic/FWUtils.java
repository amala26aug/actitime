package com.actitimenew.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FWUtils {
	
	public static String getXLdata(String path,String sheet,int row,int cell)
	{
		String value="";
		try
		{
			File file=new File(path);
			Workbook wk = WorkbookFactory.create(file);
			value = wk.getSheet(sheet).getRow(row).getCell(cell).toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void setXLData(String path,String sheet,int row,int cell,String value)
	{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		Workbook wk=null;
		try
		{
			fis=new FileInputStream(path);
			wk = WorkbookFactory.create(fis);
			Sheet sh = wk.getSheet(sheet);
			Row r=null;
			if(sh!=null)
				r=sh.getRow(row);
			if(r==null)
				r=sh.createRow(row);
			Cell c = r.getCell(cell);
			if(c==null)
				c=r.createCell(cell);
			c.setCellValue(value);
			fos=new FileOutputStream(path);
			wk.write(fos);
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try
			{
				fis.close();
				wk.close();
				fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	public static void setXLData(String path,String sheet,int row,int cell,int value)
	{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		Workbook wk=null;
		try
		{
			fis=new FileInputStream(path);
			wk = WorkbookFactory.create(fis);
			Sheet sh = wk.getSheet(sheet);
			Row r=null;
			if(sh!=null)
				r=sh.getRow(row);
			if(r==null)
				r=sh.createRow(row);
			Cell c = r.getCell(cell);
			if(c==null)
				c=r.createCell(cell);
			c.setCellValue(value);
			fos=new FileOutputStream(path);
			wk.write(fos);
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try
			{
				fis.close();
				wk.close();
				fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	public static String getPropFile(String path,String key)
	{
		String value="";
		try
		{
			FileInputStream fis=new FileInputStream(path);
			Properties p=new Properties();
			p.load(fis);
			value=p.getProperty(key);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void getSnapshot(WebDriver driver ,String path)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(path);
		try
		{
			FileUtils.copyFile(srcFile, destFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int getLastRowNumber(String path,String sheet)	
	{
		int count=0;
		try
		{
		Workbook wk = WorkbookFactory.create(new File(path));
			Sheet sh = wk.getSheet(sheet);
		count=sh.getLastRowNum();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public static void titleVerifier(WebDriver driver,String expectedTitle)
	{
		Assert.assertEquals(expectedTitle, driver.getTitle());
	}

}
