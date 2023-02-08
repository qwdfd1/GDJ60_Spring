package com.onion.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onion.s1.MyTestCase;

public class ProductDAOTest extends MyTestCase {

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getProductListTest() throws Exception {
		List<ProductDTO> productDTOs = productDAO.getProductList();
		
		//단정문
		assertNotEquals(0, productDTOs.size());
		

	}
	
	@Test
	public void getProductDetailtest() throws Exception {
		// TODO Auto-generated method stub
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(2030L);
		productDTO = productDAO.getProductDetail(productDTO);
		assertNull(productDTO);
	}
	
	
//	insert
	@Test
	public void setProductAddTest() throws Exception {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(154L);
		productDTO.setProductName("잠와");
		productDTO.setProductDetail("살려줘ㅓㅓㅓㅓㅓㅓ");
		productDTO.setProductJumsu(3.4);
		int result = productDAO.setProductAdd(productDTO);
		assertNotEquals(0, result);
		
	}
	
	

}
