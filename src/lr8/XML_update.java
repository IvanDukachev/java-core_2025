package lr8;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XML_update {
    private static void printEmployees(NodeList employeeList) {
        System.out.println("\nСписок сотрудников:");
        for (int i = 0; i < employeeList.getLength(); i++) {
            Node node = employeeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Имя: " + element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Должность: " + element.getElementsByTagName("position").item(0).getTextContent());
                System.out.println("Зарплата: " + element.getElementsByTagName("salary").item(0).getTextContent());
            }
        }
    }

    private static void addNewEmployee(Document doc, Scanner in) throws Exception {
        System.out.print("Введите ФИО сотрудника: ");
        String name = in.nextLine();
        System.out.print("Введите должность: ");
        String position = in.nextLine();
        System.out.print("Введите зарплату: ");
        String salary = in.nextLine();

        Element root = doc.getDocumentElement();
        Element newEmployee = doc.createElement("employee");
        root.appendChild(newEmployee);

        addChild(doc, newEmployee, "name", name);
        addChild(doc, newEmployee, "position", position);
        addChild(doc, newEmployee, "salary", salary);

        saveChanges(doc);
        System.out.println("Сотрудник успешно добавлен!");
    }

    private static void addChild(Document doc, Element parent, String tagName, String text) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(text));
        parent.appendChild(element);
    }

    private static void searchEmployees(Document doc, Scanner in) {
        System.out.println("Поиск по должности:");

        System.out.print("Введите значение для поиска: ");
        String value = in.nextLine();

        NodeList employeeList = doc.getElementsByTagName("employee");
        List<Element> results = new ArrayList<>();

        for (int i = 0; i < employeeList.getLength(); i++) {
            Node node = employeeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String fieldValue = element.getElementsByTagName("position").item(0).getTextContent();
                if (fieldValue.equalsIgnoreCase(value)) {
                    results.add(element);
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println("Сотрудники не найдены!");
        } else {
            System.out.println("\nРезультаты поиска:");
            for (Element element : results) {
                System.out.println("Имя: " + element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Должность: " + element.getElementsByTagName("position").item(0).getTextContent());
                System.out.println("Зарплата: " + element.getElementsByTagName("salary").item(0).getTextContent());
            }
        }
    }

    private static void deleteEmployee(Document doc, Scanner in) throws Exception {
        System.out.print("Введите ФИО сотрудника для удаления: ");
        String nameToDelete = in.nextLine();

        NodeList employeeList = doc.getElementsByTagName("employee");
        boolean found = false;

        for (int i = 0; i < employeeList.getLength(); i++) {
            Node node = employeeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getElementsByTagName("name").item(0).getTextContent();

                if (name.equalsIgnoreCase(nameToDelete)) {
                    node.getParentNode().removeChild(node);
                    found = true;
                }
            }
        }

        if (found) {
            saveChanges(doc);
            System.out.println("Сотрудник успешно удален!");
        } else {
            System.out.println("Сотрудник не найден!");
        }
    }

    private static void saveChanges(Document doc) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/lr8/employees.xml"));
        transformer.transform(source, result);
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lr8/employees.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Scanner in = new Scanner(System.in);
            NodeList employeeList = doc.getElementsByTagName("employee");

            printEmployees(employeeList);

            System.out.print("\nДобавить нового сотрудника? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                addNewEmployee(doc, in);
            }

            System.out.print("\nНайти сотрудников? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                searchEmployees(doc, in);
            }

            System.out.print("\nУдалить сотрудника? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                deleteEmployee(doc, in);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
