package EmailApp;

import java.util.List;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail = "";
    private String emailSuffix = "gaotek.com";
    private int passwordLength = 12;
    private int mailboxCapacity = 500;


    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(passwordLength);
        if (department == "") this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + emailSuffix;
        else this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.replace(" ", "") + "." + emailSuffix;
    }
    public String setDepartment() {
        List DepartmentList = List.of("IT", "Finance", "Production & Quality Assurance", "Supply Chain Management", "Service", "");
        Scanner scanner = new Scanner(System.in);
        int userChoice = 7;
        while (userChoice > 6 || userChoice < 1) {
            System.out.println("Enter the department:\n\t1_ IT Department\n\t2_ Finance Department\n\t3_ Production and Quality Assurance Departments\n\t4_ Supply Chain Management Department\n\t5_ Service Department\n\t6_ None");
            userChoice = scanner.nextInt();
        }
        return (String) DepartmentList.get(userChoice-1);
    }
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return password.toString();
    }

    public String showInformation() {
        return "\tFull Name: " + firstName + " " + lastName + "\n" +
                "\tDepartment: " + department + "\n" +
                "\tEmail: " + email + "\n" +
                "\tMailbox Capacity: " + mailboxCapacity + "mb\n";

    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDepartment() {
        return this.department;
    }

    public String getEmail() {
        return email;
    }
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }

}
