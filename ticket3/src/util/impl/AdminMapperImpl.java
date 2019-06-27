package util.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Admin;
import util.RowMapperObject;
/**
 * 管理员对象映射
 * @author Mr.DU
 * @date: 2019-06-24 
 */
public class AdminMapperImpl implements RowMapperObject {

	@Override
	public Object rowMapperObject(ResultSet rs) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getInt("id"));
		admin.setLoginname(rs.getString("loginname"));
		admin.setPassword(rs.getString("password"));
		admin.setUsername(rs.getString("username"));
		admin.setIdentity(rs.getString("identity"));
		admin.setPhone(rs.getString("phone"));
		return admin;
	}

}
