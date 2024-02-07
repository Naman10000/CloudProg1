import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Employee {
    String empId;
    String depName;
    String empDesignation;
    String empName;
    String dateJoin;
    int basic;
    int hra;
    int it;
    char designationCode;
   

    public Employee(
            String empId,
            String depName,
            String empDesignation,
            String empName,
            String dateJoin,
            int basic,
            int hra,
            int it,
            char designationCode
    ) {
        this.empId = empId;
        this.depName = depName;
        this.empDesignation = empDesignation;
        this.empName = empName;
        this.dateJoin = dateJoin;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
        this.designationCode = designationCode;
    }

    public static int da(char designationCode) {
        int daValue;
        switch (designationCode) {
            case 'e':
                daValue = 20000;
                break;
            case 'c':
                daValue = 32000;
                break;
            case 'k':
                daValue = 12000;
                break;
            case 'r':
                daValue = 15000;
                break;
            case 'm':
                daValue = 40000;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + designationCode);
        }
        return daValue;
    }

    public static int salary(int basic, int hra, int da, int it) {
        int salary = basic + hra + da - it;
        return salary;
    }

    public static void details(
            String empId,
            String empName,
            String depName,
            String empDesignation,
            String dateJoin,
            int salary
    ) {
        System.out.println("Emp Id\t\tEmployee Name\tDepartment\t\tDesignation\t\tDate Join\t\tSalary");
        System.out.println(empId + "\t\t" + empName + "\t\t" + depName + "\t\t\t" + empDesignation + "\t\t" + dateJoin + "\t\t" + salary);
    }

    public static void main(String[] args) throws IOException {
        boolean val = true;
        Scanner sc = new Scanner(System.in);
        String empId;
        

        Employee[] employees = new Employee[3];

        employees[0] = new Employee(
                "10",
                "R&D",
                "Engineer",
                "Prasun",
                "1/04/2022",
                20000,
                8000,
                3000,
                'e'
        );

        employees[1] = new Employee(
                "11",
                "PM",
                "Consultant",
                "Ridhima",
                "23/08/2022",
                30000,
                12000,
                9000,
                'c'
        );

        employees[2] = new Employee(
                "12",
                "Acct",
                "Accountant",
                "Abhishek",
                "12/11/2008",
                10000,
                8000,
                1000,
                'k'
        );
        
        while (val) {
            System.out.println("TILAK RAJ");
            System.out.println("21BCS4773");
            System.out.println("Enter the employee ID ");
            System.out.println("Enter the -1 to Exit ");
            empId = sc.nextLine();
             if(empId.equals("-1")){
             val =false;
            }else{
            int c = 0;
            for (int i = 0; i <= 2; i++) {
                if (employees[i].empId.equals(empId)) {
                    c = 1;
                    int salary = salary(
                            employees[i].basic,
                            employees[i].hra,
                            da(employees[i].designationCode),
                            employees[i].it
                    );
                    details(
                            employees[i].empId,
                            employees[i].empName,
                            employees[i].depName,
                            employees[i].empDesignation,
                            employees[i].dateJoin,
                            salary
                    );
                    break;
                }
            }

            if (c != 1) {
                System.out.println("Entered employee ID not found");
            }
           
        }
    }}
}