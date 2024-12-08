import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = {
               // new Employee("Кучумов Александр Иванович", (byte) 1, 200000),
                null,
                new Employee("Иванов Андрей Петрович", (byte) 3, 180000),
                // new Employee("Андрианова Мария Николаевна", (byte) 5, 160000),
                null,
                new Employee("Пастаногов Александр Владиславович", (byte) 2, 177000),
                new Employee("Григорьев Марат Александрович", (byte) 4, 230000),
                new Employee("Фархшатов Айрат Назифович", (byte) 1, 80000),
                new Employee("Нарцисова Анна Сергеевна", (byte) 3, 150000),
                new Employee("Каменских Алексей Викторович", (byte) 5, 185000),
                new Employee("Литвинова Алена Андреевна", (byte) 2, 145000),
                new Employee("Пономарёв Максим Сергеевич", (byte) 4, 1000000),
        };

        EmployeeBook employeeBook = new EmployeeBook(employees);

        // информация по всем сотрудникам
        System.out.println(employeeBook.getEmployees());
        System.out.println();

        // зарплата всех сотрудников в месяц
        System.out.println("Выплаченная зарплата всем сотрудникам: " + employeeBook.getAllSalaryMonth());
        System.out.println();

        // Сотрудник с наименьшей зарплатой
        Employee minSalaryEmployee = employeeBook.getEmployeeMinSalary();
        System.out.println("Сотрудник " + minSalaryEmployee.getName() +
                " имеет самую маленькую зарплату " + minSalaryEmployee.getSalary());
        System.out.println();

        // Сотрудник с самой большой зарплатой
        Employee maxSalaryEmployee = employeeBook.getEmployeeMaxSalary();
        System.out.println("Сотрудник " + maxSalaryEmployee.getName() +
                " имеет самую большую зарплату " + maxSalaryEmployee.getSalary());
        System.out.println();

        // Средняя зарплата
        System.out.println("Среднее значение зарплат " + employeeBook.getAverageSalary());
        System.out.println();

        // ФИО всех сотруников
        System.out.println(employeeBook.getEmployeesName());
        System.out.println();

        // Индексация зарплаты всех сотрудников
        employeeBook.setSalaryIndexation(10);
        System.out.println(employeeBook.getEmployees());
        System.out.println();

        // Минимальная зарплата сотрудника отдела
        byte department = 3;
        minSalaryEmployee = employeeBook.getEmployeeMinSalary(department);
        System.out.println("Сотрудник " + minSalaryEmployee.getName() +
                ", из отдела " + department + ", имеет самую маленькую зарплату " + minSalaryEmployee.getSalary());
        System.out.println();

        // Максимальная зарплата сотрудника отдела
        department = 1;
        maxSalaryEmployee = employeeBook.getEmployeeMaxSalary(department);
        System.out.println("Сотрудник " + maxSalaryEmployee.getName() +
                ", из отдела " + department + " имеет самую большую зарплату " + maxSalaryEmployee.getSalary());
        System.out.println();

        // Зарплата сотрудников отдела
        department = 4;
        System.out.println("Выплаченная зарплата отдела " + department + ": " + employeeBook.getAllSalaryMonth(department));
        System.out.println();

        // Средняя зарплата по отделу
        department = 3;
        System.out.println("Средняя зарплата по отделу " + department + " равна " + employeeBook.getAverageSalary(department));
        System.out.println();

        // Индексация зарплаты в отделе
        department = 1;
        employeeBook.setSalaryIndexation(5, department);

        // Вывод сотрудников в отделе
        System.out.println(employeeBook.getEmployees(department));
        System.out.println();

        // Сотрудники с зарплатой меньше заданного числа
        employeeBook.printSalaryLess(120000);
        System.out.println();

        // Сотрудники с зарплатой больше заданного числа
        employeeBook.printSalaryMore(200000);

    }

}