package com.frt.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frt.model.ErrorDesc;
import com.frt.service.ClientService;
import com.frt.service.DataImportService;
import com.frt.service.EmployeeService;
import com.frt.service.FinancialDataService;
import com.frt.service.ProjectService;
import com.frt.service.SubProjectService;

@RestController
@RequestMapping(value = "/test")
public class DataImportController {

	public static final SimpleDateFormat SDF = new SimpleDateFormat(
			"dd-MM-yyyy");

	@Autowired
	HttpServletResponse response;

	@Autowired
	DataImportService dataImportService;

	@Autowired
	ClientService clientService;

	@Autowired
	ProjectService projectService;

	@Autowired
	FinancialDataService financialDataService;

	@Autowired
	SubProjectService subProjectService;

	@Autowired
	EmployeeService employeeService;

	HSSFWorkbook logbook = null;

	Workbook workbook = null;

	final String dirpath = ".";

	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = { "application/json; charset=UTF-8" })
	public int[] validateExcelFile(HttpServletRequest request) throws Exception {

		List<List<String>> rowData = new ArrayList<List<String>>();

		int error[] = null;
		try {

			DiskFileItemFactory factory = new DiskFileItemFactory();

			ServletFileUpload upload = new ServletFileUpload(factory);

			FileItem fi = (FileItem) upload.parseRequest(request).iterator()
					.next();

			InputStream fileContent = fi.getInputStream();

			String fileName = fi.getName();

			if (!fileContent.equals(null)) {

				if (fileName.toLowerCase().endsWith("csv")) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(fileContent));
					String str;
					while ((str = br.readLine()) != null) {
						String[] stringsArray = str.split(",");
						rowData.add(Arrays.asList(stringsArray));
					}
					br.close();

				} else if (fileName.toLowerCase().endsWith("xlsx")) {
					workbook = new XSSFWorkbook(fileContent);
					error = saveData(rowData);
				} else if (fileName.toLowerCase().endsWith("xls")) {
					workbook = new HSSFWorkbook(fileContent);
					error = saveData(rowData);
				} else {
					throw new NullPointerException();
				}
			}
		} catch (NullPointerException e) {
			return error;
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (FileUploadException e) {
			// e.printStackTrace();
		}

		if (!rowData.isEmpty()) {
			rowData.remove(0);
		}

		if (error[1] == 0) {
			dataImportService.saveXlsFileData(rowData);
			return error;
		} else {
			return error;
		}
	}

	public int[] saveData(List<List<String>> rowData) {

		int numberOfSheets = workbook.getNumberOfSheets();
		int totalRow = 0;
		int error[] = new int[3];
		for (int j = 0; j < numberOfSheets; j++) {

			Sheet sheet = workbook.getSheetAt(j);
			Iterator<Row> rowIterator = sheet.iterator();			
			List<ErrorDesc> errorDescList = new ArrayList<ErrorDesc>();
			while (rowIterator.hasNext()) {
				totalRow++;
				StringBuffer sb = new StringBuffer(
						"Follwing field cannot be empty: ");
				ErrorDesc errorDesc = new ErrorDesc();
				errorDesc.setRowNo(totalRow);
				List<String> list = new ArrayList<>();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int i = cell.getColumnIndex();
					if (i == 0 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "QB, ";
						sb.append(msg);
					}
					if (i == 1 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Region, ";
						sb.append(msg);
					}
					if (i == 2 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Client, ";
						sb.append(msg);

					}
					if (i == 3 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Project name per QEST, ";
						sb.append(msg);

					}
					if (i == 4 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Project name per QB, ";
						sb.append(msg);

					}
					if (i == 5 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "SubProject, ";
						sb.append(msg);

					}
					if (i == 6 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Sales Head, ";
						sb.append(msg);

					}
					if (i == 7 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Sales Person, ";
						sb.append(msg);

					}
					if (i == 13 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Project Manager, ";
						sb.append(msg);

					}
					if (i == 14 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Delivery Head, ";
						sb.append(msg);

					}
					if (i == 17 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Project Resource, ";
						sb.append(msg);

					}
					if (i == 25 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Stream, ";
						sb.append(msg);

					}
					if (i == 16 & cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						String msg = "Type, ";
						sb.append(msg);

					}

					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						if (DateUtil.isCellDateFormatted(cell)) {
							Date date = cell.getDateCellValue();
							DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
							String string = df.format(date);
							list.add(string);
						} else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							list.add(cell.toString());
						}
					} else {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						list.add(cell.toString());
					}
				}

				errorDesc.setDescription(sb);
				errorDescList.add(errorDesc);
				rowData.add(list);

				HSSFWorkbook logbook = new HSSFWorkbook();
				HSSFSheet logSheet = logbook.createSheet("Error");

				Row row0 = logSheet.createRow(0);
				Cell cell0 = row0.createCell(0);
				cell0.setCellValue("Error Details");

				cell0 = row0.createCell(1);
				cell0 = row0.createCell(2);

				CellRangeAddress cra = new CellRangeAddress(0, 0, 0, 2);
				logSheet.addMergedRegion(cra);

				Row row1 = logSheet.createRow(1);

				CellRangeAddress cra2 = new CellRangeAddress(1, 1, 0, 2);
				logSheet.addMergedRegion(cra2);

				Row row2 = logSheet.createRow(2);
				Cell r2c0 = row2.createCell(0);
				r2c0.setCellValue("Record No.");

				Cell r2c1 = row2.createCell(1);
				r2c1.setCellValue("Status");

				Cell r2c2 = row2.createCell(2);
				r2c2.setCellValue("Description");

				CellRangeAddress cra1 = new CellRangeAddress(0, 2, 2, 2);
				logSheet.addMergedRegion(cra1);

				HSSFCellStyle style = logbook.createCellStyle();
				style.setBorderTop((short) 2);
				style.setBorderLeft((short) 2);
				style.setBorderRight((short) 2);
				style.setBorderBottom((short) 2);
				HSSFFont font = logbook.createFont();
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints((short) 10);
				style.setFont(font);
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

				for (int formatCounter = 0; formatCounter < 3; formatCounter++) {
					row0.getCell(formatCounter).setCellStyle(style);
					row2.getCell(formatCounter).setCellStyle(style);
				}

				int count = 0;

				Row rown = null;

				for (int x = 0; x < errorDescList.size(); x++) {

					ErrorDesc errDsc = errorDescList.get(x);

					rown = logSheet.createRow(x + 3);
					Cell celln = rown.createCell(0);
					celln.setCellValue(errDsc.getRowNo());
					celln = rown.createCell(1);
					if (errDsc.getDescription().toString()
							.equals("Follwing field cannot be empty: ")) {
						celln.setCellValue("Succsess");
					} else {
						count++;
						System.out.println(count);
						celln.setCellValue("Failed");
					}

					logSheet.setColumnWidth(2, 20000);
					CellStyle style1 = logbook.createCellStyle();
					style1.setWrapText(true);
					celln = rown.createCell(2);
					celln.setCellStyle(style1);
					if (errDsc.getDescription().toString()
							.equals("Follwing field cannot be empty: ")) {
						celln.setCellValue("");
					} else {
						celln.setCellValue(errDsc.getDescription().toString());
					}

					int correctRow = totalRow - count;
					error[0] = correctRow;
					error[1] = count;
					error[2] = totalRow;
					System.out.println(error.length);
					System.out.println(error[0]);
				}

				FileOutputStream outputStream;
				try {
					outputStream = new FileOutputStream("error.xls");
					logbook.write(outputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		return error;
	}

	@RequestMapping(value = "/exportexcel", produces = { "application/json; charset=UTF-8" }, method = RequestMethod.GET)
	public void exportErrorFile() {

		try {
			InputStream inputStream = new FileInputStream(dirpath
					+ "\\error.xls");
			byte[] out = IOUtils.toByteArray(inputStream);
			inputStream.close();
			response.setContentType("application/ms-excel");
			Date date = new Date();
			String strDate = SDF.format(date);
			response.addHeader("Content-disposition", "attachment; filename="
					+ "error" + strDate + ".xls");
			OutputStream outstrm = response.getOutputStream();
			outstrm.write(out);
			outstrm.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
