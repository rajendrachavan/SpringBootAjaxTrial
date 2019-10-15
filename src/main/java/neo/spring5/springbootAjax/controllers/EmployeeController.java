package neo.spring5.springbootAjax.controllers;

import neo.spring5.springbootAjax.models.Employee;
import neo.spring5.springbootAjax.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/postdata")
    public Employee createEmployee(@Valid @RequestBody Employee emp){
        return employeeService.save(emp);
    }

    @GetMapping("/getdata")
    public List<Employee> getAllEmployees(){
        return employeeService.listAllEmployees();
    }

    @GetMapping("/getdata/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") long id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long id,
                                                   @Valid @RequestBody Employee employeeDetails){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        employee.setEmpname(employeeDetails.getEmpname());
        employee.setEmail(employeeDetails.getEmail());

        Employee updateEmp = employeeService.save(employee);
        return ResponseEntity.ok().body(updateEmp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        employeeService.delete(id);

        return new ResponseEntity("deleted.", HttpStatus.OK);
    }

   /* @RequestMapping(value = "/getdata", method = RequestMethod.GET)
    public ResponseEntity<Object> getData(){
        Employee employee1 = new Employee("rajendra", "rajendrachavan.jvm@gmail.com");
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }

    @RequestMapping(value = "/postdata", method = RequestMethod.POST)
    public ResponseEntity<Object> postData(@RequestBody Employee employee){
        System.out.println("Employee: "+employee);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }*/
}
