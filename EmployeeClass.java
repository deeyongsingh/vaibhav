package Employee;

public class EmployeeClass {
    String name;
    String department;
    int employeeld;
    double salary;
public EmployeeClass(String name,String department,int employeeld,double salary){
    this.name=name;
    this.department=department;
    this.employeeld=employeeld;
    this.salary=salary;
}
void Work(int hours){
    System.out.println("Employee worked: "+hours + "hours...");
}
void UpdateSalary(double newSalary){
    newSalary+=salary;
    System.out.println("New salary: "+newSalary);
}
void displayDetails(){
    System.out.println("Employee Details!");
    System.out.println("Name: "+name);
    System.out.println("Department: "+department);
    System.out.println("Employeeld: "+employeeld);
    System.out.println("Salary: "+salary);
}
public static void main(String[]args){
    EmployeeClass e1 = new EmployeeClass("Ankush patel","abcd",12,25000);
    e1.displayDetails();
    e1.Work(12);
    e1.UpdateSalary(2300);
}
}
