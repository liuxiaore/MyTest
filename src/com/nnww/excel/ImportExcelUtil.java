package com.nnww.excel;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImportExcelUtil {

	private final static String excel2003L = ".xls"; // 2003- 版本的excel
	private final static String excel2007U = ".xlsx"; // 2007+ 版本的excel

	/**
	 * 描述：获取IO流中的数据，组装成List<List<Object>>对象
	 * 
	 * @param in,fileName
	 * @return
	 * @throws IOException
	 */
	public List<List<String>> getBankListByExcel(InputStream in, String fileName) throws Exception {
		List<List<String>> list = null;

		// 创建Excel工作薄
		Workbook work = this.create(in);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;

		list = new ArrayList<List<String>>();
		// 遍历Excel中所有的sheet
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			sheet = work.getSheetAt(i);
			if (sheet == null) {
				continue;
			}

			// 遍历当前sheet中的所有行
			for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum() + 1; j++) {
				row = sheet.getRow(j);
				if (row == null || row.getFirstCellNum() == j) {//跳过取第一行表头的数据内容了
					continue;
				}

				// 遍历所有的列
				List<String> li = new ArrayList<String>();
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					cell = row.getCell(y);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					if(cell != null && cell.getCellType()!=Cell.CELL_TYPE_BLANK){//空白判定
						li.add(cell.getStringCellValue());
					}
					
				}
				list.add(li);
			}
		}
		//work.close();
		return list;
	}

	public void getBankListByExcel2(InputStream in, int sheetIndex) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append("CREATE TABLE ");
		List<List<String>> list = null;

		// 创建Excel工作薄
		Workbook work = this.create(in);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;

		list = new ArrayList<List<String>>();
		// 遍历Excel中所有的sheet
		int i = sheetIndex;
		sheet = work.getSheetAt(i);
		String sheetName = sheet.getSheetName();
		builder.append(sheetName);
		builder.append(" ( ID NVARCHAR2(38) DEFAULT SYS_GUID() NOT NULL,");
		// 遍历当前sheet中的所有行
		for (int j = 2; j < sheet.getLastRowNum() + 1; j++) {
			row = sheet.getRow(j);
			// 遍历所有的列
			String zd = "";
			String zdlx = "";
			String zdcd = "";
			List<String> li = new ArrayList<String>();
			for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
				try {
					zd = row.getCell(2).getStringCellValue();
				} catch (Exception e) {
					continue;
				}
				zdlx = row.getCell(3).getStringCellValue();
				Cell cellzdc = row.getCell(4);
				cellzdc.setCellType(Cell.CELL_TYPE_STRING);
				zdcd = cellzdc.getStringCellValue();
				if (zdcd == null) {
					zdcd = "";
				}
				if (zdlx.equals("Int")) {
					zdlx = "NUMBER";
					zdcd = "";
				}
				if (zdlx.equals("Char")) {
					zdlx = "NVARCHAR2";
					if (zdcd.equals("")) {
						zdcd = "(255)";
					} else {
						zdcd = "(" + zdcd + ")";
					}
				}
				if (zdlx.equals("Date")) {
					zdlx = "Date";
					zdcd = "";
				}
				if (zdlx.equals("Float")) {
					zdlx = "NUMBER";
					zdcd = "(38,8)";
				}

			}
			builder.append(zd).append(" ").append(zdlx).append(zdcd).append(",");
		}
		builder.append("XMBH NVARCHAR2(18),");
		builder.append("DYBM NVARCHAR2(19),");
		builder.append("PRIMARY KEY (ID));");
		System.out.println(builder.toString());

	}

	/**
	 * 添加表注释：
	 COMMENT ON table test1 IS '个人信息';

	 添加字段注释：
	 comment on column test1.id is 'id';
	 comment on column test1.nameis '姓名';
	 comment on column test1.age is '年龄';
	 * @param in
	 * @param sheetIndex
	 * @throws Exception
	 */
	public void getBankListByExcel3(InputStream in, int sheetIndex) throws Exception {
		StringBuilder tabzsbuilder = new StringBuilder();
		StringBuilder zdzsbuilder = new StringBuilder();
		tabzsbuilder.append("COMMENT ON TABLE ");

		List<List<String>> list = null;

		// 创建Excel工作薄
		Workbook work = this.create(in);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;

		list = new ArrayList<List<String>>();
		// 遍历Excel中所有的sheet
		int i = sheetIndex;
		sheet = work.getSheetAt(i);
		String sheetName = sheet.getSheetName();
		Pattern pattern = Pattern.compile("[A-Za-z]");
		Matcher matcher = pattern.matcher(sheetName);
		String tabName = "";
		while (matcher.find()) {
			tabName = tabName + matcher.group();
		}
		tabzsbuilder.append(tabName).append(" is '").append(sheetName.replace(tabName, "")).append("';");

		// 遍历当前sheet中的所有行
		for (int j = 2; j < sheet.getLastRowNum() + 1; j++) {
			row = sheet.getRow(j);
			// 遍历所有的列
			String zd = "";
			String zdmc = "";

			List<String> li = new ArrayList<String>();
			for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
				try {
					zdmc = row.getCell(1).getStringCellValue();
				} catch (Exception e) {
					continue;
				}
				zd = row.getCell(2).getStringCellValue();

			}
			zdzsbuilder.append("comment on column ");
			zdzsbuilder.append(tabName + ".");
			zdzsbuilder.append(zd).append(" is ").append("'").append(zdmc).append("';");
			System.out.println("String " + zd + " = " + "o.get("+(j-2)+");");
		}

//		System.out.println(tabzsbuilder.toString());
//		System.out.println(zdzsbuilder.toString());
		System.out.println();
		System.out.println();
	}


	public Workbook create(InputStream inStr) throws IOException, InvalidFormatException {
		if (!inStr.markSupported()) {
			inStr = new PushbackInputStream(inStr, 8);
		}
		if (POIFSFileSystem.hasPOIFSHeader(inStr)) {
			return new HSSFWorkbook(inStr);
		}
		if (POIXMLDocument.hasOOXMLHeader(inStr)) {
			return new XSSFWorkbook(OPCPackage.open(inStr));
		}
		throw new IllegalArgumentException("你的excel版本目前poi解析不了");
	}

	public static void main(String[] args) throws Exception {

		ImportExcelUtil util = new ImportExcelUtil();
		for (int i = 62; i < 65; i++) {
			FileInputStream stream = new FileInputStream(new File("C:\\Users\\zhangjinhao\\Desktop\\zhzz数据库入库标准_qiubo) - 副本.xlsx"));
			util.getBankListByExcel2(stream, i);
		}
	}

}