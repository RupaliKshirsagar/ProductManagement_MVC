package com.jbk.ProductManagement_MVC.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.ProductManagement_MVC.dao.ProductDao;
//import com.jbk.ProductManagement_MVC.dao.UserDao;
import com.jbk.ProductManagement_MVC.entity.Product;
//import com.jbk.ProductManagement_MVC.entity.User;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
//	@Override
//	public User login(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Product addProduct(Product product) {

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		product.setProcudtId(timeStamp);
		return dao.addProduct(product);
	}

	@Override
	public List<Product> productList() {
		
		return dao.productList();
	}
	

	@Override
	public String uploadSheet(CommonsMultipartFile file, HttpSession session) {
//		@Override
//		public String uploadProduct(CommonsMultipartFile file, HttpSession session) {

			String filePath = session.getServletContext().getRealPath("/WEB-INF/Uploaded");
			String fileName = file.getOriginalFilename();
			byte[] data = file.getBytes();
			FileOutputStream fos;
			String message = null;
			if (!file.isEmpty()) {
				try {
					fos = new FileOutputStream(new File(filePath + File.separator + fileName));
					fos.write(data);

					List<Product> productList = readProductExcelSheet(filePath + File.separator + fileName);
					message = dao.uploadProducts(productList);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {

				}
			} else {
				message = "first select file and then upload";
			}

			return message;
		}

		public List<Product> readProductExcelSheet(String file) {
			List<Product> productList = new ArrayList<Product>();
			DataFormatter formatter = new DataFormatter();
			try {

				FileInputStream fis = new FileInputStream(file);
				Workbook workbook = new XSSFWorkbook(fis);
				Sheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rows = sheet.rowIterator();
				Product product = null;
				while (rows.hasNext()) {
					Thread.sleep(5);
					product = new Product();
					String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
					product.setProcudtId(timeStamp);
					Row row = rows.next();
					Iterator<Cell> cells = row.cellIterator();

					while (cells.hasNext()) {

						Cell cell = cells.next();
						int column = cell.getColumnIndex();

						switch (column) {
						case 0: {
							product.setProductName(cell.getStringCellValue());

							break;
						}
						case 1: {

							float productPrice = formatter.formatCellValue(cell);
							product.setProductPrice(productPrice);
							break;
						}
						case 2: {
							Date productexpiry = formatter.formatCellValue(cell);
							product.setProductExpiryDate(productexpiry);
							break;
						}

						}

					}

					productList.add(product);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return productList;
		}

	}
