package com.capgemini.tms.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

import com.capgemini.Util.AdminDatabaseUtil;
import com.capgemini.tms.dto.Admin;

public class AdminDaoImpl implements AdminDao {
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	Admin admin;

	HashMap<Integer, Admin> hashMap;

	public AdminDaoImpl() throws SQLException {
		connection = AdminDatabaseUtil.myconnection();
	}

	@Override
	public HashMap<Integer, Admin> getallAdmin() throws SQLException {
		st = connection.createStatement();
		rs = st.executeQuery("select * from admin");
		hashMap = new HashMap<>();
		while (rs.next()) {
			admin = null;
			admin = new Admin();

			admin.setTestId(rs.getInt(2));
			admin.setuserId(rs.getLong(1));

			hashMap.put(rs.getInt(2), admin);
		}
		return hashMap;
	}

	@Override
	public Admin SearchTest(long userId) throws SQLException {
		pst = connection.prepareStatement("select * from admin where userId=?");
		pst.setLong(1, userId);
		rs = null;
		rs = pst.executeQuery();
		if (rs.next()) {
			admin = null;
			admin = new Admin();

			admin.setTestId(rs.getInt(2));

		}
		return admin;
	}

	@Override
	public boolean assignTest(Admin admin1) throws SQLException {
		admin = SearchTest(admin1.getuserId());
		if (admin == null) {
			pst = null;
			pst = connection.prepareStatement("insert into admin values(?,?)");
			pst.setInt(1, admin1.getuserId());
			pst.setLong(2, admin1.getTestId());

			int res = pst.executeUpdate();
			if (res == 1)
				return true;
			else
				return false;
		}
		return false;
	}

}
