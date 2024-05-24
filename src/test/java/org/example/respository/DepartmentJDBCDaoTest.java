package org.example.respository;

import org.example.model.Department;
import org.example.respository.DepartmentDao;
import org.example.respository.DepartmentJDBCDao;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DepartmentJDBCDaoTest {

    DepartmentDao departmentDao = new DepartmentJDBCDao();

    @Test
    public void getDepartmentTest() throws SQLException {

        List<Department> departments = departmentDao.getDepartments();

//        DepartmentJDBCDao dao = new DepartmentJDBCDao();
//        List<Department> departments = dao.getDepartments();

        assertEquals(0, departments.size());
    }

}
