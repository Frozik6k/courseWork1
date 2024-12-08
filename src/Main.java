import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("Кучумов Александр Иванович", (byte) 1, 200000),
                new Employee("Иванов Андрей Петрович", (byte) 3, 180000),
                new Employee("Андрианова Мария Николаевна", (byte) 5, 160000),
                new Employee("Пастаногов Александр Владиславович", (byte) 2, 177000),
                new Employee("Григорьев Марат Александрович", (byte) 4, 230000),
                new Employee("Фархшатов Айрат Назифович", (byte) 1, 80000),
                new Employee("Нарцисова Анна Сергеевна", (byte) 3, 150000),
                new Employee("Каменских Алексей Викторович", (byte) 5, 185000),
                new Employee("Литвинова Алена Андреевна", (byte) 2, 145000),
                new Employee("Пономарёв Максим Сергеевич", (byte) 4, 1000000),
        };

        // информация по всем сотрудникам
        System.out.println(getEmployees(employees));
        System.out.println();

        // зарплата всех сотрудников в месяц
        System.out.println("Выплаченная зарплата всем сотрудникам: " + getAllSalaryMonth(employees));
        System.out.println();

        // Сотрудник с наименьшей зарплатой
        Employee minSalaryEmployee = getEmployeeMinSalary(employees);
        System.out.println("Сотрудник " + minSalaryEmployee.getName() +
                " имеет самую маленькую зарплату " + minSalaryEmployee.getSalary());
        System.out.println();

        // Сотрудник с самой большой зарплатой
        Employee maxSalaryEmployee = getEmployeeMaxSalary(employees);
        System.out.println("Сотрудник " + maxSalaryEmployee.getName() +
                " имеет самую большую зарплату " + maxSalaryEmployee.getSalary());
        System.out.println();

        System.out.println("Среднее значение зарплат " + getAverageSalary(employees));
        System.out.println();

        // ФИО всех сотруников
        System.out.println(getEmployeesName(employees));
        System.out.println();

        // Индексация зарплаты всех сотрудников
        setSalaryIndexation(employees, 10);
        System.out.println(getEmployees(employees));
        System.out.println();

        // Минимальная зарплата сотрудника отдела
        byte department = 3;
        minSalaryEmployee = getEmployeeMinSalary(employees, department);
        System.out.println("Сотрудник " + minSalaryEmployee.getName() +
                ", из отдела " + department + ", имеет самую маленькую зарплату " + minSalaryEmployee.getSalary());
        System.out.println();

        // Максимальная зарплата сотрудника отдела
        department = 1;
        maxSalaryEmployee = getEmployeeMaxSalary(employees, department);
        System.out.println("Сотрудник " + maxSalaryEmployee.getName() +
                ", из отдела " + department + " имеет самую большую зарплату " + maxSalaryEmployee.getSalary());
        System.out.println();

        // Зарплата сотрудников отдела
        department = 4;
        System.out.println("Выплаченная зарплата отдела " + department + ": " + getAllSalaryMonth(employees, department));
        System.out.println();

        // Средняя зарплата по отделу
        department = 3;
        System.out.println("Средняя зарплата по отделу " + department + " равна " + getAverageSalary(employees, department));
        System.out.println();

        department = 1;
        setSalaryIndexation(employees, 5, department);

        System.out.println(getEmployees(employees, department));
        System.out.println();

        printSalaryLess(employees, 120000);
        System.out.println();

        printSalaryMore(employees, 200000);

    }

    static String getEmployees (Employee[] employees){

        String result = "";
        for (Employee employee : employees) {
            result += employee + "\n";
        }
        return result;

    }

    static String getEmployees(Employee[] employees, byte department) {
        String result = "";
        for (Employee employee : employees) {
            result += employee.getName() + ", зарплата: " + employee.getSalary() + "\n";
        }
        return result;

    }

    static int getAllSalaryMonth (Employee[] employees){

        int sum = 0;
        for (Employee employee : employees) {
            sum+=employee.getSalary();
        }
        return sum;

    }

    static int getAllSalaryMonth (Employee[] employees, byte department){

        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) sum+=employee.getSalary();
        }
        return sum;

    }

    static Employee getEmployeeMinSalary (Employee[] employees){

        int index = 0;
        int min = employees[index].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (min > employees[i].getSalary()) {
                index = i;
                min = employees[i].getSalary();
            }
        }
        return employees[index];

    }

    static Employee getEmployeeMinSalary (Employee[] employees, byte department){

        int index = 0;

        while (employees[index].getDepartment() != department){
            index+=1;
            if (index >= employees.length){
                System.out.println("В отделе " + department + " никто не работает");
                return null;
            }
        }

        int min = employees[index].getSalary();

        for (int i = index; i < employees.length; i++) {
            if (min > employees[i].getSalary() && department == employees[i].getDepartment()) {
                index = i;
                min = employees[i].getSalary();
            }
        }
        return employees[index];

    }

    static Employee getEmployeeMaxSalary (Employee[] employees){

        int index = 0;
        int max = employees[index].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (max < employees[i].getSalary()) {
                index = i;
                max = employees[i].getSalary();
            }
        }
        return employees[index];

    }

    static Employee getEmployeeMaxSalary (Employee[] employees, byte department){

        int index = 0;

        while (employees[index].getDepartment() != department){
            index+=1;
            if (index >= employees.length){
                System.out.println("В отделе " + department + " никто не работает");
                return null;
            }
        }

        int max = employees[index].getSalary();
        for (int i = index; i < employees.length; i++) {
            if (max < employees[i].getSalary() && department == employees[i].getDepartment()) {
                index = i;
                max = employees[i].getSalary();
            }
        }

        return  employees[index];

    }

    static int getAverageSalary(Employee[] employees) {
        return getAllSalaryMonth(employees) / employees.length;
    }

    static int getAverageSalary(Employee[] employees, byte department) {
        int count = 0;
        int salaryAll = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                count++;
                salaryAll+=employee.getSalary();
            }
        }
        return salaryAll/count;
    }

    static String getEmployeesName (Employee[] employees){

        String result = "";
        for (Employee employee : employees){
            result += employee.getName() + "\n";
        }

        return result;

    }

    static void setSalaryIndexation(Employee[] employees, float index){
        for (Employee employee : employees){
            int salary = employee.getSalary();
            salary+=Math.round(salary*index*0.01f);
            employee.setSalary(salary);
        }
    }

    static void setSalaryIndexation(Employee[] employees, float index, byte department) {
        for (Employee employee : employees){

            if (employee.getDepartment() == department) {
                int salary = employee.getSalary();
                salary+=Math.round(salary*index*0.01f);
                employee.setSalary(salary);
            }
        }
    }

    static void printSalaryLess(Employee[] employees, int salary) {
        System.out.println("Сотрудники с зарплатой меньше чем " + salary + ":");
        for (Employee employee : employees) {
            if (employee.getSalary() <= salary) {
                System.out.println("id: " + employee.getId() + ", " + employee.getName() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    static void printSalaryMore(Employee[] employees, int salary) {
        System.out.println("Сотрудники с зарплатой больше чем " + salary + ":");
        for (Employee employee : employees) {
            if (employee.getSalary() > salary) {
                System.out.println("id: " + employee.getId() + ", " + employee.getName() + ", зарплата: " + employee.getSalary());
            }
        }
    }
}