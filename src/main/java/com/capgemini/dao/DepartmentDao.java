package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Department;

public interface DepartmentDao {
	  List<Department> findDepartmentByTitle(String title);
}
