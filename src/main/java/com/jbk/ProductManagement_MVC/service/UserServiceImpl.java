package com.jbk.ProductManagement_MVC.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.ProductManagement_MVC.dao.UserDao;
import com.jbk.ProductManagement_MVC.entity.ForgotPassword;
import com.jbk.ProductManagement_MVC.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public User loginUser(User user) {

		return dao.loginUser(user);
	}

	@Override
	public boolean addUser(User user) {
		// user.setIsActive("0");
		return dao.addUser(user);
	}

	@Override
	public List<User> userList() {

		return dao.userList();
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.getUserByUsername(username);
	}

	@Override
	public boolean updateUser(User user) {

		return dao.updateUser(user);
	}

	@Override
	public boolean deleteUser(String username) {

		return dao.deleteUser(username);
	}

	@Override
	public String uploadSheet(CommonsMultipartFile file, HttpSession session) {
		String filePath = session.getServletContext().getRealPath("/WEB-INF/Uploaded");
		System.out.println(filePath);
		String fileName = file.getOriginalFilename();
		byte[] data = file.getBytes();
		String count = null;
		try {
			FileOutputStream fos = new FileOutputStream(new File(filePath + File.separator + fileName));
			fos.write(data);

			List<User> userList = readExcel(filePath + File.separator + fileName);
			count = dao.uploadUsers(userList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;

	}

	private List<User> readExcel(String path) {
		 List<User> userList=new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(new File(path));

			Workbook workbook = new XSSFWorkbook(fis);
			
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();

			User user = null;

			while (rows.hasNext()) {
				user = new User();
				Row row = rows.next();
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					// System.out.print(cell.getStringCellValue()+"\t");
				int col = cell.getColumnIndex();
				switch (col) {
				case 0:{
					user.setUsername(cell.getStringCellValue());
					break;
				}
				
				case 1:{
					user.setPassword(cell.getStringCellValue());
					break;
				}
				case 2:{
					user.setGender(cell.getStringCellValue());
					break;
				}
				case 3:{
					user.setRole(cell.getStringCellValue());
					break;
				}
				case 4:{
					user.setQuestion(cell.getStringCellValue());
					break;
				}
				case 5:{
					user.setAnswer(cell.getStringCellValue());
					break;
				}
				
				
				}
				
				}
				userList.add(user);
			//	System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public String forgotPassword(ForgotPassword forgotPassword) {

		return dao.forgotPassword(forgotPassword);
	}


	@Override
	public boolean logout(HttpSession httpSession) {
		
		return dao.logout(httpSession);
	}

}
