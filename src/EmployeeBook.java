public class EmployeeBook {
    private Employee[] employees = new Employee[100];

    public EmployeeBook(){}

    public EmployeeBook(Employee[] employees) {
        if (employees.length - 1 >= 0) System.arraycopy(employees, 1, this.employees, 1, employees.length - 1);
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i <= employees.length; i++){
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public void delEmployee(int id) {
        for (int i = 0; i <= employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
    }

    public Employee getEmployee(int id) {
        for (int i = 0; i <= employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public String getEmployees (){

        String result = "";
        for (Employee employee : employees) {
            if (employee != null) result += employee + "\n";
        }
        return result;

    }

    public String getEmployees(byte department) {
        String result = "";
        for (Employee employee : employees) {
            if (employee != null) result += employee.getName() + ", зарплата: " + employee.getSalary() + "\n";
        }
        return result;

    }

    public int getAllSalaryMonth (){

        int sum = 0;
        for (Employee employee : employees) {
            if ( employee != null) sum+=employee.getSalary();
        }
        return sum;

    }

    public int getAllSalaryMonth (byte department){

        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) sum+=employee.getSalary();
        }
        return sum;

    }

    public Employee getEmployeeMinSalary (){

        int index = 0;
        while (employees[index] == null){
            index+=1;
            if (index >= employees.length){
                System.out.println("В организации никто не работает");
                return null;
            }
        }
        int min = employees[index].getSalary();
        for (int i = 1; i < employees.length; i++) {
                if (employees[i] != null && min > employees[i].getSalary()) {
                    index = i;
                    min = employees[i].getSalary();
                }
        }
        return employees[index];

    }

    public Employee getEmployeeMinSalary (byte department){

        int index = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department){
                index = i;
                break;
            }
            if (i == employees.length - 1){
                System.out.println("В отделе " + department + " никто не работает");
                return null;
            }
        }

        int min = employees[index].getSalary();

        for (int i = index; i < employees.length; i++) {
            if (employees[i] != null && min > employees[i].getSalary() && department == employees[i].getDepartment()) {
                index = i;
                min = employees[i].getSalary();
            }
        }
        return employees[index];

    }

    public Employee getEmployeeMaxSalary (){

        int index = 0;

        while (employees[index] == null) {
            index+=1;
            if (index >= employees.length){
                System.out.println("В организации никто не работает");
                return null;
            }
        }

        int max = employees[index].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && max < employees[i].getSalary()) {
                index = i;
                max = employees[i].getSalary();
            }
        }
        return employees[index];

    }

    public Employee getEmployeeMaxSalary (byte department){

        int index = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department){
                index = i;
                break;
            }
            if (i == employees.length - 1){
                System.out.println("В отделе " + department + " никто не работает");
                return null;
            }
        }

        int max = employees[index].getSalary();
        for (int i = index; i < employees.length; i++) {
            if (employees[i] != null && max < employees[i].getSalary() && department == employees[i].getDepartment()) {
                index = i;
                max = employees[i].getSalary();
            }
        }

        return  employees[index];

    }

    public int getAverageSalary() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return getAllSalaryMonth() / count;
    }

    public int getAverageSalary(byte department) {
        int count = 0;
        int salaryAll = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
                salaryAll+=employee.getSalary();
            }
        }
        return salaryAll/count;
    }

    public String getEmployeesName (){

        String result = "";
        for (Employee employee : employees){
            if (employee != null) {
                result += employee.getName() + "\n";
            }
        }

        return result;

    }

    public void setSalaryIndexation(float index){
        for (Employee employee : employees){
            if (employee != null) {
                int salary = employee.getSalary();
                salary+=Math.round(salary*index*0.01f);
                employee.setSalary(salary);
            }
        }
    }

    public void setSalaryIndexation(float index, byte department) {
        for (Employee employee : employees){

            if (employee != null && employee.getDepartment() == department) {
                int salary = employee.getSalary();
                salary+=Math.round(salary*index*0.01f);
                employee.setSalary(salary);
            }
        }
    }

    public void printSalaryLess(int salary) {
        System.out.println("Сотрудники с зарплатой меньше чем " + salary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() <= salary) {
                System.out.println("id: " + employee.getId() + ", " + employee.getName() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    public void printSalaryMore(int salary) {
        System.out.println("Сотрудники с зарплатой больше чем " + salary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > salary) {
                System.out.println("id: " + employee.getId() + ", " + employee.getName() + ", зарплата: " + employee.getSalary());
            }
        }
    }
}
