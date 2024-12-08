public class Employee {
    private String name; // Содержит ФИО
    private byte department; // Номер отдела где работает сотрудник
    private int salary; // Зарплата сотрудника в месяц
    private int id;

    public Employee( String name, byte department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = idCounter;
        idCounter++;
    }

    private static int idCounter = 0;

    public String getName() {
        return name;
    }

    public byte getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(byte department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ", отдел: " + department + ", зарплата: " + salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()){
            return false;
        }
        Employee employee = (Employee) obj;
        return  this.name.equals(employee.getName()) &&
                this.department == employee.getDepartment() &&
                this.salary == employee.getSalary();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name.hashCode(), department, salary);
    }
}
