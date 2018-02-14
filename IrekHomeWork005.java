/**
 * Java 1. Home work 5. Task1.
 *
 * @author Irek Nabiullin
 * @version #2 dated Feb 12, 2018
 * @link https://github.com/IrekNabiullin
 */

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/*
 * Task 1.
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 */

class Employee {        // создаем класс "Сотрудник"
    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) { //конструктор класса
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

        System.out.println ("Name: " + this.name + ", position: " + this.position  + ", email: " + this.email + ", phone: " + this.phone + ", salary: " + this.salary + ", age: " + this.age);
    }
}
public class IrekHomeWork005 {

    public static void main(String[] args) {
        Employee person = new Employee("Ivan Ivanov", "Developer", "ivanivanov@mail.box", "89991112233", 30000, 30);
        person.name = "Ivan Ivanov";
        person.position = "Engineer";
        person.email = "ivanivanov@mail.box";
        person.phone = "89991112233";
        person.salary = 30000;
        person.age = 30;

        System.out.println ("Task1 completed");
        System.out.println();
/*
 * Task 2.
 * Создать массив из 5 сотрудников
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */
        System.out.println("Task 2.");
        Employee [] persArray = new Employee [5];
        persArray[0] = new Employee ("Ivan Ivanov", "Developer", "ivanivanov@mail.box", "89991112233", 30000, 30);
        persArray[1] = new Employee ("Pedro Petrov", "Senior Developer", "pedropetrov@mail.box", "899912223344", 50000, 35);
        persArray[2] = new Employee ("Semen Semenov", "Team leader", "semensemenov@mail.box", "89993334455", 100000, 40);
        persArray[3] = new Employee ("Nick Nickolaev", "Project manager", "nickbickolaev@mail.box", "89884445566", 150000, 45);
        persArray[4] = new Employee ("Serg Sergeev", "Director", "sergsergeev@mail.box", "89995556677", 200000, 50);

        System.out.println();

        System.out.println ("Employees older than 40 years.");
        System.out.printf("%3s %15s %23s %25s %25s %14s %6s\n",
                "Number", "Name", "Position", "e-mail", "phone", "salary", "age"); // добавим форматированный вывод
        for (int i=0; i<persArray.length;i++) {
            if (persArray[i].age>40) {
                System.out.printf("%3s %23s %20s %30s %20s %12s %6s\n",
                        i, persArray[i].name, persArray[i].position, persArray[i].email, persArray[i].phone, persArray[i].salary, persArray[i].age);
            }
        }
/*
 * Task 3. Создать методы записи созданного массива в текстовый файл и чтения из него.
 */
        System.out.println();
        System.out.println("Task 3.");
        try {
            File dir = new File ("C:\\javatest\\");
            while (!dir.isDirectory()) {
                dir.mkdir();
            }
            if(dir.isDirectory())
                System.out.println("A directory C:\\javatest\\ has been created to write the file.");
        } catch (Exception ex1) {
            System.out.println("Error");
        }
        try {
            Formatter myFile = new Formatter("C:\\javatest\\test.txt");//создадим файл test.txt на диске С:
            myFile.format("%3s %15s %23s %25s %25s %14s %6s\r\n",          // запишем в файл "шапку" списка
                    "Number", "Name", "Position", "e-mail", "phone", "salary", "age\n");
            for (int i=0; i<persArray.length;i++) {                        // в цикле запишем в файл строки массива
                myFile.format("%3s %23s %20s %30s %20s %12s %6s\r\n",      // используя форматированную запись
                        i, persArray[i].name, persArray[i].position, persArray[i].email, persArray[i].phone, persArray[i].salary, persArray[i].age);
            }
            myFile.close();                                                // не забудем закрыть файл
        } catch (Exception ex2) {
            System.out.println("Error");
        }
        try {
            File myFile2 = new File("C:\\javatest\\test.txt");
            if (myFile2.exists()) {                                 // проверим, удалось ли нам записать файл на диск
                System.out.println("File " + myFile2.getName() + " created.");
            } else {
                System.out.println("Error creating file.");
            }
        } catch (Exception ex3) {
            System.out.println("Error");
        }
        try {
            System.out.println("Reading file ... ");
            File myFile3 = new File("C:\\javatest\\test.txt");   // считываем данные из файла
            Scanner sc = new Scanner(myFile3);                        // используя scanner
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            System.out.println("The file was read successfully.");
            sc.close();                                               // не забываем закрыть сканнер

        } catch (Exception ex4) {
            System.out.println("Error");
        }
    }
}








