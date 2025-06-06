package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class JSON_update {
    private static void printEmployees(JSONArray employees) {
        System.out.println("\nСписок сотрудников:");
        for (Object employee : employees) {
            JSONObject emp = (JSONObject) employee;
            System.out.println("Имя: " + emp.get("name"));
            System.out.println("Должность: " + emp.get("position"));
            System.out.println("Зарплата: " + emp.get("salary"));
        }
    }

    private static void addNewEmployee(JSONArray employees, Scanner in) {
        System.out.print("Введите ФИО сотрудника: ");
        String name = in.nextLine();
        System.out.print("Введите должность: ");
        String position = in.nextLine();
        System.out.print("Введите зарплату: ");
        String salary = in.nextLine();
        in.nextLine();

        JSONObject newEmployee = new JSONObject();
        newEmployee.put("name", name);
        newEmployee.put("position", position);
        newEmployee.put("salary", salary);

        employees.add(newEmployee);
        System.out.println("Сотрудник успешно добавлен!");
    }

    private static void searchEmployees(JSONArray employees, Scanner in) {
        System.out.print("Введите должность для поиска: ");
        String position = in.nextLine();
        boolean found = false;

        System.out.println("\nРезультаты поиска:");
        for (Object employee : employees) {
            JSONObject emp = (JSONObject) employee;
            if (emp.get("position").toString().equalsIgnoreCase(position)) {
                System.out.println("Имя: " + emp.get("name"));
                System.out.println("Должность: " + emp.get("position"));
                found = true;
            }
        }

        if (!found) {
            System.out.println("Сотрудник " + position + " не найдены!");
        }
    }

    private static void deleteEmployee(JSONArray employees, Scanner in) {
        System.out.print("Введите ФИО сотрудника для удаления: ");
        String name = in.nextLine();
        boolean found = false;

        Iterator iterator = employees.iterator();
        while (iterator.hasNext()) {
            JSONObject employee = (JSONObject) iterator.next();
            if (employee.get("name").toString().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
            }
        }

        if (found) {
            System.out.println("Сотрудник успешно удален!");
        } else {
            System.out.println("Сотрудник не найден!");
        }
    }

    private static void saveChanges(JSONObject jsonObject) throws Exception {
        try (FileWriter file = new FileWriter("src/lr8/employees.json")) {
            file.write(jsonObject.toJSONString());
        }
    }

    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/lr8/employees.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray employees = (JSONArray) jsonObject.get("employees");

            Scanner in = new Scanner(System.in);

            printEmployees(employees);

            System.out.print("\nДобавить нового сотрудника? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                addNewEmployee(employees, in);
                saveChanges(jsonObject);
            }

            System.out.print("\nНайти сотрудников по должности? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                searchEmployees(employees, in);
            }

            System.out.print("\nУдалить сотрудника? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                deleteEmployee(employees, in);
                saveChanges(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
