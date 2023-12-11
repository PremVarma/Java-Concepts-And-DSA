package systemdesign.designpattern.structural.ProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDao employeeDao = new EmployeeDaoProxy();
            employeeDao.create("ADMIN", new EmployeeDo());
            System.out.println("Operation Success");
        } catch (Exception e) {
            System.out.println("Error => " + e.getMessage());
        }
    }
}
