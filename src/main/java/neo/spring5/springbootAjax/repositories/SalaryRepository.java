package neo.spring5.springbootAjax.repositories;

import neo.spring5.springbootAjax.models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

}
