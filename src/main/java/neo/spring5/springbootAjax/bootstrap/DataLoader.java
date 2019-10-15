package neo.spring5.springbootAjax.bootstrap;

import neo.spring5.springbootAjax.models.Department;
import neo.spring5.springbootAjax.models.Employee;
import neo.spring5.springbootAjax.models.GrossSalary;
import neo.spring5.springbootAjax.models.Salary;
import neo.spring5.springbootAjax.service.DepartmentService;
import neo.spring5.springbootAjax.service.EmployeeService;
import neo.spring5.springbootAjax.service.SalaryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final SalaryService salaryService;

    public DataLoader(EmployeeService employeeService, DepartmentService departmentService, SalaryService salaryService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.salaryService = salaryService;
    }

    @Override
    public void run(String... args) throws Exception {

        Department dept1 = new Department("Java");
        departmentService.save(dept1);
        Department dept2 = new Department("Android");
        departmentService.save(dept2);
        Department dept3 = new Department("ML");
        departmentService.save(dept3);

        System.out.println("------------------Initial-Departments Added------------------");

        Employee emp1 = new Employee("test123","test123@gmail.com");

        GrossSalary grossSalary1 = new GrossSalary(20000, 5000, 5000);
        Salary salary1 = new Salary(grossSalary1);
        salaryService.save(salary1);

        emp1.setSalary(salary1);
        emp1.setDepartment(dept1);
        employeeService.save(emp1);

        Employee emp2 = new Employee("test456","test456@gmail.com");

        GrossSalary grossSalary2 = new GrossSalary(15000, 5000, 5000);
        Salary salary2 = new Salary(grossSalary2);
        salaryService.save(salary2);

        emp2.setSalary(salary2);
        emp2.setDepartment(dept2);
        employeeService.save(emp2);

        Employee emp3 = new Employee("test789","test789@gmail.com");

        GrossSalary grossSalary3 = new GrossSalary(30000, 5000, 5000);
        Salary salary3 = new Salary(grossSalary3);
        salaryService.save(salary3);

        emp3.setSalary(salary3);
        emp3.setDepartment(dept3);
        employeeService.save(emp3);
        
        System.out.println("------------------Initial-Employees Added------------------");
    }
}