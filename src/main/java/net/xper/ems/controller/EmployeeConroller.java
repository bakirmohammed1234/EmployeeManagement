package net.xper.ems.controller;


import lombok.AllArgsConstructor;
import net.xper.ems.dto.EmployeeDto;
import net.xper.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeConroller {
    private EmployeeService employeeService;


    // build add Employee Rest API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        return  new  ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    // build get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    //build get all employees method RESTAPI
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // build update employee methode REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto employeeDto) {
      EmployeeDto employee =employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok(employee);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee (employeeId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
