package org.example.respository;

import org.example.model.Department;
import org.example.respository.DepartmentJDBCDao;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {
    List<Department> getDepartments() throws SQLException;
}
