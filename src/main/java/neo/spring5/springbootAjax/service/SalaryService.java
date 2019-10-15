package neo.spring5.springbootAjax.service;

import neo.spring5.springbootAjax.models.Salary;
import neo.spring5.springbootAjax.repositories.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    private SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public List<Salary> listAllSalaries(){
        return salaryRepository.findAll();
    }

    public Salary save(Salary salary){
        return salaryRepository.save(salary);
    }

    public Salary getSalaryById(Long id){
        return salaryRepository.findById(id).get();
    }

    public void delete(Long id){
        salaryRepository.deleteById(id);
    }
}