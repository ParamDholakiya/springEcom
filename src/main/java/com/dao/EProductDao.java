package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EProductBean;

@Repository
public class EProductDao {

	@Autowired
	JdbcTemplate stmt;// used to execute sql query into databse

	public void addProduct(EProductBean productBean) {
		stmt.update("insert into products (productName,category,price,qty) values (?,?,?,?) ",
				productBean.getProductName(), productBean.getCategory(), productBean.getPrice(), productBean.getQty());
	}

	public List<EProductBean> getAllProducts() {
		List<EProductBean> list = stmt.query("select * from products",
				new BeanPropertyRowMapper<EProductBean>(EProductBean.class));
		return list;
	}
	
	public void deleteProduct(int id) {
		stmt.update("delete from products where id=?", id);
	}
}
