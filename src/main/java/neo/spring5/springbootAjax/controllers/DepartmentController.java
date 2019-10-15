package neo.spring5.springbootAjax.controllers;

import neo.spring5.springbootAjax.models.Department;
import neo.spring5.springbootAjax.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/postdata")
    public Department createDepartment(@Valid @RequestBody Department dept){
        return departmentService.save(dept);
    }

    @GetMapping("/getdata")
    public List<Department> departments(){
        return departmentService.listAllDepartments();
    }

    @GetMapping("/getdata/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Long id){
        Department department = new Department();
        if(department == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(department);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Long id,
                                                       @Valid @RequestBody Department dept){
        Department department = departmentService.getDepartmentById(id);
        if(department == null){
            return ResponseEntity.notFound().build();
        }
        department.setDeptName(dept.getDeptName());

        Department updateDept = departmentService.save(department);
        return ResponseEntity.ok().body(updateDept);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable(value = "id") Long id){

        Department department = departmentService.getDepartmentById(id);
        if(department == null) {
            return ResponseEntity.notFound().build();
        }
        departmentService.delete(id);
        return new ResponseEntity("deleted", HttpStatus.OK);
    }
}