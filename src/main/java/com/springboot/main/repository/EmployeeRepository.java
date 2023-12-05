package com.springboot.main.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.main.model.Employee;
import com.springboot.main.model.EmployeeProduct;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.hr.id=?1")
	List<Employee> getEmployeesByHr(int hid);

	@Query("SELECT ep FROM EmployeeProduct ep WHERE ep.employee.id=?1")
	List<EmployeeProduct> findByTheEmployeeId(int eid);

	@Query("select e.pointsBalance from Employee e where e.id=?1")
	double getpointsbalanace(int eid);

	@Query("select e from Employee e join EmployeeProduct ep on e.id=ep.employee.id where ep.dateOfPurchase=?1")
	List<Employee> getEmployeesByDateOfPurchase(LocalDate date);

	

    @Query("SELECT e FROM Employee e ORDER BY e.pointsBalance DESC")
	List<Employee> getEmployeesByPointsBalance();

    @Query("select e from Employee e join User u on e.user.id=u.id where u.id=?1")
	Employee getEmployeeByUserId(int uid);

    @Query("select e from Employee e join Manager m on e.manager.id=m.id join User u on m.user.id=u.id where u.id=?1")
	List<Employee> getEmployeesByManagerId(int muid);

	
	
}
