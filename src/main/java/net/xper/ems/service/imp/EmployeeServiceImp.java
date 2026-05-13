package net.xper.ems.service.imp;

import lombok.AllArgsConstructor;
import net.xper.ems.dto.EmployeeDto;
import net.xper.ems.entity.Employee;
import net.xper.ems.exception.ResourceNotFoundException;
import net.xper.ems.mapper.EmployeeMapper;
import net.xper.ems.repository.EmployeeRepository;
import net.xper.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee  employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }


}
