package model;

public class EmployeeData {

	    public int id;
	    public String name;
	    public double salary;

	    public EmployeeData(Integer id, String name, Double salary) {
	        this.id = id;
	        this.name = name;
	        this.salary = salary;
	    }

	    @Override
	    public String toString() {
	        return "EmployeePayrollData [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	    }

	}


