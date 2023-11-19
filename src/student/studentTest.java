package student;

import java.util.ArrayList;
import java.util.Scanner;

public class studentTest {
    
    static Scanner input = new Scanner(System.in);
    static int select;
    
    public static void main(String args[]) {
        
        Student student1 = new Student(1,"Ezgi","Kaya");
        Student student2 = new Student(2,"Onur","Güven");
        
        ArrayList<Student>students = new ArrayList<Student>();
        
        students.add(student1);
        students.add(student2);
        
        while (true) {
            menu();
            switch (select) {
                case 1:
                    displayingStudentInformation(students);
                    break;
                case 2:
                    Student newStudent = creatingNewStudent(students);
                    addStudent(students,newStudent);
                    break;
                case 3:
                    break;
                case -1:
                    System.out.println("Leaving The Program...");
                    return;
                default:
                    System.out.println("you have made an invalid choice..");
            }
        }
    }
     
    public static void menu() {
        
        System.out.println("************MENU*************");
        System.out.println("1 - List all students");
        System.out.println("2 - Add new student");
        System.out.println("3 - Student deletion according to id");
        System.out.println("-1 - Exit");
        System.out.println("*****************************");
        System.out.println("Please select an option :");
        select = input.nextInt();
        
    }
    
    public static void displayingStudentInformation(ArrayList<Student>students) {
        
        for (int i = 0; i <students.size(); i++) {
            
            students.get(i).listStudentInformation();
            System.out.println();
            
        }
    }
    
    public static void addStudent(ArrayList<Student>students,Student student) {
        
        students.add(student);
        System.out.println("The new student was successfully added.");
        
    }
    
    public static Student creatingNewStudent(ArrayList<Student>students) {
        
        int id;
        boolean validId = false;
        
        do {
            
            System.out.println("Enter the ID of the new student :");
            id = input.nextInt();
            validId = ıdControl(students,id);
            
            if (validId) {
                System.out.println("This ID is used. Please enter a different ID...");
            }
          
        } while (validId);
        
        System.out.println("Enter the name of the new student :");
        String firstName = input.next();
        System.out.println("Enter the surname of the new student :");
        String lastName = input.next();
        
        return new Student(id, firstName, lastName);
    }
    
    public static boolean ıdControl(ArrayList<Student>students,int id) {
        
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    public static void studentDeletion(ArrayList<Student>students) {
        
        boolean control = false;
        System.out.println("Please enter an ID to delete :");
        int ıdDeleted = input.nextInt();
        
        for (int i = 0; i < students.size() ; i++) {
            
            if (students.get(i).getId() == ıdDeleted) {
                
                control = true;
                students.remove(i);
                System.out.println("The student was successfully deleted..");
                
            }
        }
        
        if (control == false) {
            
            System.out.println("No such id was found....");
            
        }  
    }
}
