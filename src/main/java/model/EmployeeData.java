package model;

import java.time.LocalDate;

public class EmployeeData {

	    public int id;
	    public String name;
	    public double salary;
		public LocalDate startDate;

	    public EmployeeData(Integer id, String name, Double salary) {
	        this.id = id;
	        this.name = name;
	        this.salary = salary;
	    }

	    public EmployeeData(Integer id, String name, Double salary, LocalDate startDate) {
	        this(id, name, salary);
	        this.startDate =startDate;
	    }

	    @Override
	    public String toString() {
	        return "EmployeePayrollData{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", salary=" + salary +
	                ", startDate=" + startDate +
	                '}';
	    }
	}


