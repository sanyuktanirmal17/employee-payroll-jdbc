package service;

	import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import DBFile.EmployeeDBService;
import model.EmployeeData;

public class EmployeePayrollService {
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

    private List<EmployeeData> employeepayrollList;

    public EmployeePayrollService() {
    }

    public EmployeePayrollService(List<EmployeeData> employeepayrollList) {
        this.employeepayrollList = employeepayrollList;
    }

    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeepayrollList.add(new EmployeeData(id, name, salary));
    }

    public List<EmployeeData> readEmployeePayrollData(IOService ioService){
        if (ioService.equals(IOService.DB_IO))
            this.employeepayrollList = new EmployeeDBService().readData();
        return employeepayrollList;

    }

    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\n Writting Employee payroll to Console\n" + employeepayrollList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeeFileIOService().writeData(employeepayrollList);
    }

    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeeFileIOService().printData();
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeeFileIOService().countEntries();
        return 0;
    }
}