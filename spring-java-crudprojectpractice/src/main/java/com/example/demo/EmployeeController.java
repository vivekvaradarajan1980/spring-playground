package com.example.demo;

import com.example.demo.Employee;
import com.example.demo.EmployeeRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;



import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){ this.repository=repository;}


    @GetMapping("")
    public Iterable<Employee> getAllEmployees() {
        return this.repository.findAll();
    }


    @GetMapping("/{empID}")
    public Optional<Employee> getEmployee(@PathVariable Long empID) {
        return this.repository.findById(empID);
    }



    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.repository.save(employee);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        this.repository.deleteById(id);

    }



    @PatchMapping("/{empID}")
    public Employee updateOrCreate(@RequestBody Employee employee, @PathVariable Long empID) {

        Optional<Employee> old = this.repository.findById(empID);

        Employee actually = new Employee();

        if (old.isPresent()) {
            actually.setEmpID(old.get().getEmpID());
            actually.setEmpName(employee.getEmpName());
            actually.setStartDate(employee.getStartDate());

            return this.repository.save(actually);

        }

        else {
            return this.repository.save(employee);}

    }



}
