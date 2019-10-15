package neo.spring5.springbootAjax.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empname;
    private String email;

    @OneToOne
    private Salary salary;

    @ManyToOne
    @JoinColumn
    private Department department;

    public Employee() {
    }

    public Employee(String empname, String email) {
        this.empname = empname;
        this.email = email;
    }

    public Employee(String empname, String email, Salary salary) {
        this.empname = empname;
        this.email = email;
        this.salary = salary;
    }

    public Employee(String empname, String email, Salary salary, Department department) {
        this.empname = empname;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}