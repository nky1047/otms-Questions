package com.capgemini.tms.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.tms.dto.Admin;

public interface AdminDao {

	static HashMap<Integer, Admin> getallAdmin() throws SQLException;

	Admin SearchTest(long userId) throws SQLException;

	boolean assignTest(Admin admin1) throws SQLException;

}
