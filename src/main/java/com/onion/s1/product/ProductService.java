package com.onion.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getProductDetail(productDTO);
		
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		return productDAO.getProductList();
	}

	public int setProductAdd(ProductDTO productDTO, List<ProductOptionDTO> productOptionDTOs) throws Exception {
		//product , option
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		
		int result = productDAO.setProductAdd(productDTO);
		
		
		if(productOptionDTOs != null) {
			for (ProductOptionDTO productOptionDTO : productOptionDTOs) {
				productOptionDTO.setProductNum(productNum);
				result = productDAO.setAddProductOption(productOptionDTO);
			}
		}
		
		
		return result;
		
		
	}



}

