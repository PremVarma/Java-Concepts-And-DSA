package systemdesign.designpattern.structural.ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        System.out.println("Created new row in emp table ->");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("Deleted row from emp table ->");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        System.out.println("Fetching data from DB...");
        return new EmployeeDo();
    }
}
