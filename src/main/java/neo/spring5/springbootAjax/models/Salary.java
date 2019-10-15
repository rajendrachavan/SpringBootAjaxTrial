package neo.spring5.springbootAjax.models;

import javax.persistence.*;

@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private GrossSalary grossSalary;

    @OneToOne(mappedBy = "salary")
    private Employee employee;

    public Salary() {
    }

    public Salary(GrossSalary grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GrossSalary getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(GrossSalary grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}