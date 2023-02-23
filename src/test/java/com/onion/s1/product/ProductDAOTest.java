package com.onion.s1.product;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onion.s1.MyTestCase;

public class ProductDAOTest extends MyTestCase {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductService productService;
	
//	@Test
//	public void getProductListTest() throws Exception {
//		List<ProductDTO> productDTOs = productDAO.getProductList();
//		
//		//단정문
//		assertNotEquals(0, productDTOs.size());
//		
//
//	}
//	
//	@Test
//	public void getProductDetailtest() throws Exception {
//		// TODO Auto-generated method stub
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductNum(2030L);
//		productDTO = productDAO.getProductDetail(productDTO);
//		assertNull(productDTO);
//	}
	
	
//	insert
	@Test
	public void setProductAddTest() throws Exception {
		int result = 0;
		for(int i=0; i<60; i++) {
			Random r = new Random();
			double d = r.nextDouble();//0.1234
			int num = (int)(d*1000);
			d = num/100.0;
			
			Long l = productDAO.getProductNum();
			
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(l);
			productDTO.setProductName("알파메일 우진규" + i);
			productDTO.setProductDetail("응 구라야" + i);
			productDTO.setProductJumsu(d);
			result = productDAO.setProductAdd(productDTO);
		}

		assertNotEquals(0, result);
		
	}
	
	

}
