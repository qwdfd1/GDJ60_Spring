package com.onion.s1.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//1번째 방법 
	//문자열 리턴
	@RequestMapping(value = "list")
	public ModelAndView getProductList() throws Exception {
		ModelAndView mv = new ModelAndView();

		
		System.out.println("Product List");

		List<ProductDTO> productDTOs = productService.getProductList();
		
		
		System.out.println(productDTOs.size() != 0);
		mv.addObject("productDTOs", productDTOs);
		mv.setViewName("product/productList");
		return mv;
	}
	
	@RequestMapping(value = "detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		//파라미터의 이름과 setter의 이름과 같아야함
		
		System.out.println("Product Detail");

		productDTO = productService.getProductDetail(productDTO);
		
		System.out.println(productDTO != null);
		
		model.addAttribute("productDTO", productDTO);
		return "product/productDetail";
	}
	
	
	//2번째 방법
	//void사용, url경로를 리턴 (jsp파일명과 동일해야함)
	
	//메서드 get방식
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void setProductAdd() {
		System.out.println("Product Add");
		
	}
	
	//메서드 post방식
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String setPproductAdd(ProductDTO productDTO) throws Exception {
		int result = productService.setProductAdd(productDTO, null);
		System.out.println(result == 1);
		
		return "redirect:./list";
		
		
	}
	
	
	// ModelAndView 객체에 경로를 담아서 ModelAndView타입의 객체를 리턴
	@RequestMapping(value = "update")
	public ModelAndView productUpdate() {
		System.out.println("Product Update");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
		
	}
}
