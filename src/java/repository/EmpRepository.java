package repository;

import java.util.ArrayList;
import java.util.List;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//@Repository
public class EmpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addEmployee(Employees employees) {
        String sql = "insert into employees(Name, Address, Age, ConNumber) "
                + "values ('" + employees.getName() + "','" + employees.getAddress()
                + "','" + employees.getAge() + "'," + employees.getConNumber() + " ) ";
        jdbcTemplate.update(sql);
    }

    public List<Employees> getEmpList() {
        List<Employees> empList = new ArrayList<Employees>();
        String sql = "SELECT * FROM employees";
        empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employees.class));
        return empList;
    }

    public List<Employees> deleteById(int id) {
        List<Employees> empList = new ArrayList<Employees>();
        
        String sql = "delete  from employees where id =  " + id;
        String sql2 = "SELECT * FROM employees";
        
        jdbcTemplate.update(sql);
        empList = jdbcTemplate.query(sql2, new BeanPropertyRowMapper(Employees.class));

        return empList;       
    }

    public List<Employees> getEmployeebyId(int id) {
        List<Employees> empListE = new ArrayList<Employees>();
        String sql = "SELECT * FROM employees where id = " + id;
        empListE = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employees.class));

        return empListE;
    }

    public List<Employees> SaveEdit(Employees employees) {
        List<Employees> empList = new ArrayList<>();
        String sql = "update employees set name='" + employees.getName() + "'," + " address= '" + employees.getAddress() + "'," + "age =" + employees.getAge() + ", " + "ConNumber= '" + employees.getConNumber() + "'" + " where id= '" + employees.getId() + "'";
        String sql2 = "SELECT * FROM employees";
        jdbcTemplate.update(sql);
        empList = jdbcTemplate.query(sql2, new BeanPropertyRowMapper(Employees.class));

        return empList;
    }

}
