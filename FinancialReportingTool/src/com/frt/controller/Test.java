package com.frt.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.frt.model.ErrorDesc;
import com.frt.service.ClientService;
import com.frt.service.EmployeeService;
import com.frt.service.FinancialDataService;
import com.frt.service.ProjectService;
import com.frt.service.SubProjectService;

public class Test {

	@Autowired
	static
	ClientService clientService;

	@Autowired
	static
	ProjectService projectService;

	@Autowired
	static
	FinancialDataService financialDataService;

	@Autowired
	static
	SubProjectService subProjectService;

	@Autowired
	static
	EmployeeService employeeService;

	public static void main(String[] args) throws IOException, Exception {		
		
		List<List<String>> rowData = new ArrayList<List<String>>();	
		
		
		
		int count = 0;	
		
		String fileName = "C:/test/Book1.xls";

		FileInputStream fis = new FileInputStream(fileName);

		Workbook workbook = null;

		if (fileName.toLowerCase().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (fileName.toLowerCase().endsWith("xls")) {
			workbook = new HSSFWorkbook(fis);
		} else {
			System.out.println("file not compatible");
		}

		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();		
		int totalRow = 0;		
		int error[] = new int[2];
		List<ErrorDesc> errorDescList = new ArrayList<ErrorDesc>();
		while (rowIterator.hasNext()) {
			totalRow++;				
			StringBuffer sb = new StringBuffer("Follwing field cannot be empty: ");		
			ErrorDesc errorDesc = new ErrorDesc();
			errorDesc.setRowNo(totalRow);
			List<String> list = new ArrayList<>();
			Row row = rowIterator.next();			
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int i = cell.getColumnIndex();					
				if(i == 0 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "QB, ";
					sb.append(msg);				
				}
				if(i == 1 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Region, ";
					sb.append(msg);							
				}
				if(i == 2 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Client, ";
					sb.append(msg);				
					
				}
				if(i == 3 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Project name per QEST, ";
					sb.append(msg);				
					
				}
				if(i == 4 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Project name per QB, ";
					sb.append(msg);				
					
				}
				if(i == 5 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "SubProject, ";
					sb.append(msg);			
				
				}
				if(i == 6 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Sales Head, ";
					sb.append(msg);				
					
				}
				if(i == 7 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Sales Person, ";
					sb.append(msg);				
					
				}
				if(i == 13 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Project Manager, ";
					sb.append(msg);				
					
				}
				if(i == 14 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Delivery Head, ";
					sb.append(msg);				
					
				}
				if(i == 17 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Project Resource, ";
					sb.append(msg);				
					
				}
				if(i == 25 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Stream, ";
					sb.append(msg);				
					
				}
				if(i == 16 & cell.getCellType() == Cell.CELL_TYPE_BLANK){
					String msg = "Type, ";
					sb.append(msg);
					
				}		
				
				
				if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					if (DateUtil.isCellDateFormatted(cell)) {							
						Date date = cell.getDateCellValue();
						DateFormat df = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);								
						String string = df.format(date);
						list.add(string);
					}else {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						list.add(cell.toString());
					}
				}else{								
			        
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
			
			Row rown = null;
			for (int x = 0; x < errorDescList.size(); x++) {

				ErrorDesc errDsc = errorDescList.get(x);
				
				rown = logSheet.createRow(x + 3);
				Cell celln = rown.createCell(0);
				celln.setCellValue(errDsc.getRowNo());
				celln = rown.createCell(1);
				if(errDsc.getDescription().toString().equals("Follwing field cannot be empty: ")){
					celln.setCellValue("Succsess");	
				}else{				
					celln.setCellValue("Failed");				
					count++;					
				}				
				
				logSheet.setColumnWidth(2, 20000);
				CellStyle style1 = logbook.createCellStyle();
				style1.setWrapText(true);
				celln = rown.createCell(2);
				celln.setCellStyle(style1);
				if(errDsc.getDescription().toString().equals("Follwing field cannot be empty: ")){
					celln.setCellValue("");	
				}else{
					celln.setCellValue(errDsc.getDescription().toString());	
				}
								
			}  
			
						
		
			
	        
	        FileOutputStream outputStream;
			
	        try {
				outputStream = new FileOutputStream("error.xls");
				logbook.write(outputStream);
				
			} catch (IOException e) {
	            e.printStackTrace();
	        } 
	        
	        int correctRow = totalRow - count;		
			error[0] = correctRow;
			error[1] = count;
			System.out.println(error[0]);
			System.out.println(error[1]);
		}
		
		//if(rowData != null && rowData.size()>0){
		
		/*for(List<String> list:rowData){			
			totalRow++;	
			
			StringBuffer sb = new StringBuffer("Follwing field cannot be empty: ");		
			ErrorDesc errorDesc = new ErrorDesc();
			errorDesc.setRowNo(totalRow);
			
			if(list.get(0).isEmpty()){
				String msg = "QB, ";
				sb.append(msg);				
			}
			
			if(list.get(1).isEmpty()){
				String msg = "Region, ";
				sb.append(msg);				
				
			}
			
			if(list.get(2).isEmpty()){
				String msg = "Client, ";
				sb.append(msg);				
				
			}
			
			if(list.get(3).isEmpty()){
				String msg = "Project name per QEST, ";
				sb.append(msg);				
				
			}
			
			if(list.get(4).isEmpty()){
				String msg = "Project name per QB, ";
				sb.append(msg);				
				
			}
			
			if(list.get(5).isEmpty()){
				String msg = "SubProject, ";
				sb.append(msg);			
			
			}
			
			if(list.get(6).isEmpty()){
				String msg = "Sales Head, ";
				sb.append(msg);				
				
			}
			
			if(list.get(7).isEmpty()){
				String msg = "Sales Person, ";
				sb.append(msg);				
				
			}
			
			if(list.get(13).isEmpty()){
				String msg = "Project Manager, ";
				sb.append(msg);				
				
			}
						
			if(list.get(14).isEmpty()){
				String msg = "Delivery Head, ";
				sb.append(msg);				
				
			}
			
			if(list.get(17).isEmpty()){
				String msg = "Project Resource, ";
				sb.append(msg);				
				
			}
			
			if(list.get(25).isEmpty()){
				String msg = "Stream, ";
				sb.append(msg);				
				
			}
			
			if(list.get(16).isEmpty()){
				String msg = "Type, ";
				sb.append(msg);
				
			}		
			
			errorDesc.setDescription(sb);
			errorDescList.add(errorDesc);			
		}		
		
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
		
		Row rown = null;
		for (int x = 0; x < errorDescList.size(); x++) {

			ErrorDesc errDsc = errorDescList.get(x);
			
			rown = logSheet.createRow(x + 3);
			Cell celln = rown.createCell(0);
			celln.setCellValue(errDsc.getRowNo());
			celln = rown.createCell(1);
			if(errDsc.getDescription().toString().equals("Follwing field cannot be empty: ")){
				celln.setCellValue("Succsess");	
			}else{				
				celln.setCellValue("Failed");				
				count++;
				System.out.println(count);
				System.out.println(totalRow);
			}				
			
			logSheet.setColumnWidth(2, 20000);
			CellStyle style1 = logbook.createCellStyle();
			style1.setWrapText(true);
			celln = rown.createCell(2);
			celln.setCellStyle(style1);
			if(errDsc.getDescription().toString().equals("Follwing field cannot be empty: ")){
				celln.setCellValue("");	
			}else{
				celln.setCellValue(errDsc.getDescription().toString());	
			}
							
		}  
		
		int correctRow = totalRow - count;		
		error[0] = correctRow;
		error[1] = count;
		
		for(int i : error){
			System.out.println(i);
		}

        
        FileOutputStream outputStream;
		
        try {
			outputStream = new FileOutputStream("error.xls");
			logbook.write(outputStream);
			
		} catch (IOException e) {
            e.printStackTrace();
        }       
        
       
	}*/
	}
}

		//System.out.println(rowData.get(0));
		

		/*for (List<String> row : rowData) {

			System.out.println("rowData:"+rowData.size());
			Client client = new Client();

			client.setClientName(row.get(2));

			//List<Client> searchClientList = clientService.search(client);

				client.setRegion(row.get(1));
				client.setClientJoining(row.get(9));
				client.setDomain(row.get(11));
				
				String string = row.get(26);
				DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				Date date = format.parse(string);
				System.out.println(date); 
				
			
			Project project = new Project();
			project.setProjectNamePerQB(row.get(4));
			project.setProjectNamePerQuest(row.get(3));

			//List<Project> searchProjectList = projectService.search(project);				
			
			
			
				project.setProjectNew(row.get(10).trim().toLowerCase()
						.equalsIgnoreCase("new"));
				project.setSourceOfBusiness(row.get(8));
				project.setNatureOfDeal(row.get(12));
				project.setType(row.get(16));
				project.setGroupSkill(row.get(20));
				project.setStream(row.get(25));
				project.setSubTechnology(row.get(27));
				project.setTechnology(row.get(28));
				project.setEndPeriod(row.get(26));
				project.setQb(row.get(0));
				
				System.out.println(project.getEndPeriod());
			

			SubProject subProject = new SubProject();
			subProject.setSubProjectName(row.get(5));

			

			subProject.setProject(project);

			Set<SubProject> subProjectList = new LinkedHashSet<SubProject>();

			subProjectList.add(subProject);
			project.setClient(client);
			project.setSubProjectList(subProjectList);

			Employee salesHead = new Employee();
			salesHead.setName(row.get(6));
			salesHead.setRole(Role.Sales_Head);			

			Employee salesPerson = new Employee();
			salesPerson.setName(row.get(7));
			salesPerson.setRole(Role.Sales_Person);		

			Employee projectManager = new Employee();
			projectManager.setName(row.get(13));
			projectManager.setRole(Role.Project_Manager);
			
			Employee deliveryHead = new Employee();
			deliveryHead.setName(row.get(14));
			deliveryHead.setRole(Role.Delivery_Head);			

			Employee resource = new Employee();
			resource.setName(row.get(17));
			resource.setRole(Role.Project_Resource);
			resource.setResourceCode(row.get(22));
			
			long year = Long.parseLong(row.get(29));	

			for (int j = 30, i = 0; j <= 88; ++j, i++) {

				FinancialData financialData = new FinancialData();
				financialData.setOnSite(row.get(16).trim().toLowerCase()
						.equalsIgnoreCase("onsite") ? true : false);
				financialData.setRoleOfResource(row.get(18));
				financialData.setRequestedBy(row.get(19));
				financialData.setResourceSkill(row.get(21));
				financialData.setLocationOfResource(row.get(23));
				financialData.setResourceExpense(row.get(24));
		

				if (row.get(j).isEmpty()) {
					j += 5;
					i++;
				}

				financialData.setMonth(Month.values()[i]);
				
				if(Month.values()[i].equals(Month.JAN)){
					year += 1;
				}

				if (!row.get(28).isEmpty()) {					
					financialData.setYear(year);
				}
				
				if (!row.get(j).isEmpty()) {
					financialData.setHrs_days(Long.parseLong(row.get(j)));
				}

				if(!row.get(++j).isEmpty()){
					financialData
					.setActualRevenue(Double.parseDouble(row.get(j)));
				}
				
				if(!row.get(++j).isEmpty()){
					financialData.setActualCost(Double.parseDouble(row.get(j)));
				}
				
				if(!row.get(++j).isEmpty()){
					financialData.setActualProjectMargin(Double.parseDouble(row
							.get(j)));
				}
				
				if(!row.get(++j).isEmpty()){
					financialData.setActualMarginPercentage(Double.parseDouble(row
							.get(j)));
				}			

				financialData.setProjectResource(resource);

				financialData.setSalesHead(salesHead);

				financialData.setSalesPerson(salesPerson);

				financialData.setProjectManager(projectManager);

				financialData.setDeliveryHead(deliveryHead);

				financialData.setClient(client);

				financialData.setProject(project);

				//financialDataService.saveFinanceData(financialData);
			}

		}*/

	
	
		
	
	
		/*
		 * List<List<String>> mainList = new ArrayList<List<String>>();
		 * 
		 * 
		 * 
		 * try { File fl = new File(fileName); BufferedReader br = new
		 * BufferedReader(new FileReader(fl)); String str;
		 * 
		 * while ((str = br.readLine()) != null) { String[] stringsArray =
		 * str.split(","); mainList.add(Arrays.asList(stringsArray));
		 * 
		 * }
		 * 
		 * br.close();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 * 
		 * for (List<String> row : mainList) {
		 */
	
		
		
		

		// Instantiating 1st client

		/*
		 * Client client = new Client();
		 * 
		 * client.setRegion("USA"); client.setClientName("IBM");
		 * client.setClientJoining("New"); client.setDomain("Networking");
		 * client.setDisplay(true);
		 * 
		 * Project project = new Project();
		 * project.setProjectNamePerQB("IBM Portal");
		 * project.setProjectNamePerQuest("IBM User Management Portal");
		 * project.setSourceOfBusiness("EE"); project.setProjectNew(true);
		 * project.setNatureOfDeal("Managed T&M");
		 * project.setType("Onsite Vendor"); project.setGroupSkill("Java");
		 * project.setStream("Consulting"); // project.setEndPeriod(new Date());
		 * project.setSubTechnology("Liferay");
		 * project.setTechnology("Portals"); project.setQb("AMER");
		 * 
		 * SubProject subProject1 = new SubProject();
		 * subProject1.setSubProjectName("Liferay Portal");
		 * 
		 * Set<SubProject> subProjectList = new LinkedHashSet<SubProject>();
		 * subProjectList.add(subProject1);
		 * 
		 * project.setSubProjectList(subProjectList);
		 * 
		 * FinancialData financialData = new FinancialData();
		 * financialData.setOnSite(true);
		 * financialData.setRoleOfResource("Developer");
		 * financialData.setRequestedBy("Vishal Rangras");
		 * financialData.setResourceSkill("Java Web");
		 * financialData.setLocationOfResource("California");
		 * financialData.setResourceExpense("Resource");
		 * financialData.setMonth(Month.JAN); financialData.setYear(2017);
		 * financialData.setHrs_days(30); financialData.setActualRevenue(10000);
		 * financialData.setActualCost(5960);
		 * financialData.setActualProjectMargin(4060);
		 * financialData.setActualMarginPercentage(40);
		 * 
		 * FinancialData financialData1 = new FinancialData();
		 * financialData1.setOnSite(true);
		 * financialData1.setRoleOfResource("Developer");
		 * financialData1.setRequestedBy("Vishal Rangras");
		 * financialData1.setResourceSkill("Java Web");
		 * financialData1.setLocationOfResource("California");
		 * financialData1.setResourceExpense("Resource");
		 * financialData1.setMonth(Month.JAN); financialData.setYear(2017);
		 * financialData1.setHrs_days(28);
		 * financialData1.setActualRevenue(15000);
		 * financialData1.setActualCost(5967);
		 * financialData1.setActualProjectMargin(4160);
		 * financialData1.setActualMarginPercentage(30);
		 * 
		 * Employee projectResource = new Employee();
		 * projectResource.setName("Juhi Soni");
		 * projectResource.setRole(Role.Project_Resource);
		 * projectResource.setResourceCode("CAD161009L");
		 * 
		 * financialData.setProjectResource(projectResource);
		 * 
		 * Employee projectManager = new Employee();
		 * projectManager.setName("Vatsal Thakkar");
		 * projectManager.setRole(Role.Project_Manager);
		 * projectManager.setResourceCode("CAD157007L");
		 * 
		 * financialData.setProjectManager(projectManager);
		 * 
		 * Employee salesHead = new Employee();
		 * salesHead.setName("Paul Anthony");
		 * salesHead.setRole(Role.Sales_Head);
		 * salesHead.setResourceCode("CAD175307L");
		 * 
		 * financialData.setSalesHead(salesHead);
		 * 
		 * Employee salesPerson = new Employee();
		 * salesPerson.setName("Vivek Obhrai");
		 * salesPerson.setRole(Role.Sales_Person);
		 * salesPerson.setResourceCode("CAD157237L");
		 * 
		 * financialData.setSalesPerson(salesPerson);
		 * 
		 * Employee deliveryHead = new Employee();
		 * deliveryHead.setName("Srinivas Tadepatri");
		 * deliveryHead.setRole(Role.Delivery_Head);
		 * deliveryHead.setResourceCode("CAD114327L");
		 * 
		 * financialData.setDeliveryHead(deliveryHead);
		 * 
		 * Set<FinancialData> financialDataList = new
		 * LinkedHashSet<FinancialData>(); financialDataList.add(financialData);
		 * 
		 * project.setFinancialDataList(financialDataList);
		 * client.setFinanceDataList(financialDataList);
		 * 
		 * Set<Project> projectList = new LinkedHashSet<Project>();
		 * projectList.add(project); client.setProjectList(projectList);
		 * 
		 * // projectService.saveProject(project);
		 * clientService.saveClient(client);
		 * 
		 * System.out.println("Data insertion completed... Fetching data now" );
		 * 
		 * Client searchClient = new Client();
		 * searchClient.setClientName("IBM");
		 * 
		 * List<Client> searchClientList = clientService.search(searchClient);
		 * 
		 * for (Client myClient : searchClientList) {
		 * System.out.println("Searched Client is:" + myClient.getClientName() +
		 * ", Domain " + myClient.getDomain()); }
		 */

		// }




