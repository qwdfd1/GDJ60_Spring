package com.onion.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onion.s1.util.DBConn;


@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//mapper파일의 mapper 태그 속성 namespace의 이름과 일치해야함
	private final String NAMESPACE = "com.onion.s1.product.ProductDAO.";
	
	
	
	//delete
	public int setProductDelete(Long productNum) throws Exception {
	
		return sqlSession.delete(NAMESPACE + "setProductDelete" , productNum);
	}
	
	public Long getProductNum() throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "setProductNum");
	}
	
	public List<ProductOptionDTO> getProductOptionList () throws Exception {
		List<ProductOptionDTO> productOptionDTOs = new ArrayList<ProductOptionDTO>();
		
		Connection conn = DBConn.getConn();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getLong("OPTIONNUM"));
			productOptionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getInt("OPTIONPRICE"));
			productOptionDTO.setOptionStock(rs.getInt("OPTIONSTOCK"));
		}
		
		DBConn.disConnection(rs, ps, conn);
		
		return productOptionDTOs;
	}
	
	public List<ProductDTO> getProductList() throws Exception {
	
		return sqlSession.selectList(NAMESPACE+"getProductList");
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
		
	}
	
	public int setProductAdd (ProductDTO productDTO) throws Exception  {	
	
		return sqlSession.insert(NAMESPACE+"setProductAdd", productDTO);
	}
	
	public int setAddProductOption (ProductOptionDTO productOptionDTO) throws Exception {
		Connection conn = DBConn.getConn();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME,"
				+ " OPTIONPRICE, OPTIONSTOCK) VALUES ("
				+ "PRODUCTOPTION_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		

		ps.setLong(1, productOptionDTO.getProductNum());
		ps.setString(2, productOptionDTO.getOptionName());
		ps.setInt(3, productOptionDTO.getOptionPrice());
		ps.setInt(4, productOptionDTO.getOptionStock());
			
		int result = ps.executeUpdate();
		
		DBConn.disConnection(ps, conn);
		
		return result;
	}
	
	public static void main(String[] args) {
//		ProductDAO productDAO = new ProductDAO();
//		
////		List<ProductDTO> productList = null;
////		try {
////			productList = productDAO.getProductList();
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		System.out.println(productList.size() != 0);
//		
//		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
//		productOptionDTO.setProductNum(1L);
//		productOptionDTO.setOptionName("몰라");
//		productOptionDTO.setOptionPrice(34000);
//		productOptionDTO.setOptionStock(3);
//		
//		try {
//			int result = productDAO.setAddProductOption(productOptionDTO);
//			System.out.println(result != 0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
				
		
	}
}
