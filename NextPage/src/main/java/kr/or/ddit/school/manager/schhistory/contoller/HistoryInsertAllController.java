package kr.or.ddit.school.manager.schhistory.contoller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.vo.ClassMemVO;
import kr.or.ddit.vo.Join_Year_SCH_VO;
import kr.or.ddit.vo.SchoolHistoryVO;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class poi
 */

/*
 * ★엑셀파일을 불러오기 위함
 * -김건호
 */

@Controller
public class HistoryInsertAllController {
	List<SchoolHistoryVO> list;
	BufferedReader br;
	Function ft;
	@RequestMapping("school/manager/history/poi")
	public String schoolSymbol(@ModelAttribute("fileName") String fileName,
			Model model
			, HttpSession session) {

		 
	        model.addAttribute("fileName",fileName);
	        // 먼저 @ 의 인덱스를 찾는다 - 인덱스 값: 5
	        int idx = fileName.indexOf("."); 
	        
	        // @ 앞부분을 추출
	        // substring은 첫번째 지정한 인덱스는 포함하지 않는다.
	        // 아래의 경우는 첫번째 문자열인 a 부터 추출된다.
	        fileName = fileName.substring(0, idx);

			
			list = new ArrayList<SchoolHistoryVO>();
			ft = new Function();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("진입성공");
			
			System.out.println("jsp에서 올라온 파일명" + fileName + "입니다.");
			try {
				ft.read(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("poi_list", list);
			model.addAttribute("list",list);
			return "schoolManager/81_82_historyInsertAll/InsertFile";
			
}



	class Function {

		private BufferedReader br;
		private String directory;
		private XSSFWorkbook workbook;

		public Function() {
			br = new BufferedReader(new InputStreamReader(System.in));
			directory = "D:/D_Other/Poison/";

		}

		public void read(String fileName) throws Exception {

//		System.out.println(filePath);//D:/D_Other/Poison/1.xlsx
//		BufferedInputStream file = new BufferedInputStream(new FileInputStream(new File(filePath)));
//		workbook = new XSSFWorkbook(file);

			String filePath=null;
			Scanner sc = new Scanner(System.in);

			

			
			
			
			
			
			File dir;
			boolean check=false;
			
			
			if(check==false)
			{
				System.out.println("들어옴1");
				dir = new File("C:/Users/SEM-PC/DeskTop/3조");
				String[] fileNm = dir.list();
				if(fileNm!=null)
				{
				for(int i = 0; i < fileNm.length; i++) {
					   if((fileName+".xlsx").equals(fileNm[i]))
					   {
						   System.out.println("들어옴11");
						    directory = "C:/Users/SEM-PC/DeskTop/3조";
							filePath = directory + fileName + ".xlsx";
						 	check=true;
					   }
					}
				}
			}
			if(check==false)
			{
				System.out.println("들어옴2");
				dir = new File("C:/");
				String[] fileNm = dir.list();
				if(fileNm!=null)
				{
				for(int i = 0; i < fileNm.length; i++) {
					   if((fileName+".xlsx").equals(fileNm[i]))
					   {
						   System.out.println("들어옴22");
						    directory = "C:/";
							filePath = directory + fileName + ".xlsx";
						 	check=true;
					   }
					}
				}
			}
			if(check==false)
			{
				System.out.println("들어옴3");
				dir = new File("D:/");
				String[] fileNm = dir.list();
				if(fileNm!=null)
				{
				for(int i = 0; i < fileNm.length; i++) {
					   if((fileName+".xlsx").equals(fileNm[i]))
					   {
						   System.out.println("들어옴33");
						    directory = "D:/";
							filePath = directory + fileName + ".xlsx";
						 	check=true;
					   }
					}
				}
			}
			
			if(check==false)
			{
				System.out.println("들어옴4");
				dir = new File("D:/D_Other/Poison/");
				String[] fileNm = dir.list();
				if(fileNm!=null)
				{
				for(int i = 0; i < fileNm.length; i++) {
					   if((fileName+".xlsx").equals(fileNm[i]))
					   {
						   System.out.println("들어옴44");
						    directory = "D:/D_Other/Poison/";
							filePath = directory + fileName + ".xlsx";
						 	check=true;
					   }
					}
				}
			}
			
			
			
			
			
			
			
			
			

			BufferedInputStream file = new BufferedInputStream(new FileInputStream(new File(filePath)));
			workbook = new XSSFWorkbook(file);
			Iterator<Sheet> sh = workbook.iterator();
			int line=0;
			while (sh.hasNext()) {
				Sheet sheet = sh.next();

				// 시트에 있는 모든 행 조회
				for (Row row : sheet) {
					Iterator<Cell> celliter = row.cellIterator();
					String str = "";
					
					while (celliter.hasNext()) {
						
						Cell cell = celliter.next();
						
						if(cell.getCellType() != null)
						{
							if(line!=0)
							{
								switch (cell.getCellType()) {

								case NUMERIC:
									// System.out.print("뉴메릭");
									str += cell.getNumericCellValue() + "★";
									str = str.replace(".0", "");
									// System.out.print((int) cell.getNumericCellValue() + "\t");
									break;
								case STRING:
									// System.out.print("스트링");
									str += cell.getStringCellValue() + "★";
									// System.out.print(cell.getStringCellValue() + "\t");

								}
							}
							line++;
						}
					
					}
					String[] arr = str.split("★", 0);

					SchoolHistoryVO vo = new SchoolHistoryVO();
					if (arr.length == 2) {
						vo.setHistDate(arr[0]);
						vo.setHistCntnt(arr[1]);
						list.add(vo);
					}
				}
			}
		}
	}
}
