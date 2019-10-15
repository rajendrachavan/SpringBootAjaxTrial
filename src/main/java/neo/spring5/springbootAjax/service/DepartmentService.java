package neo.spring5.springbootAjax.service;

import neo.spring5.springbootAjax.models.Department;
import neo.spring5.springbootAjax.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> listAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }

    public void delete(Long id){
        departmentRepository.deleteById(id);
    }
}