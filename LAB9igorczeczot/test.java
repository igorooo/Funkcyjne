import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args){

        Employee emp1 = new Employee("Arek1","Kowal1","1231",500);
        Employee emp2 = new Employee("Arek2","Kowal2","1232",1000);
        Employee emp3 = new Employee("Arek3","Kowal3","1233",1500);
        Employee emp4 = new Employee("Arek4","Kowal4","1234",2000);
        Employee spec1 = new Specialist("Arek5","Kowal5","1235",3000);

        ArrayList<Employee> EmpArray = new ArrayList<>();
        EmpArray.add(emp1);
        EmpArray.add(emp2);
        EmpArray.add(emp3);
        EmpArray.add(emp4);
        EmpArray.add(spec1);

        ArrayList<Task> TaskArray = new ArrayList<>();

        TaskArray.add(new Task("task1",Mode.NORMAL));
        TaskArray.add(new Task("task2",Mode.IMPORTANT));
        TaskArray.add(new Task("task3",Mode.NORMAL));
        TaskArray.add(new Task("task4",Mode.IMPORTANT));
        TaskArray.add(new Task("TASK5",Mode.IMPORTANT));

        Company COMPANY = new Company();

        for(Task task : TaskArray){
            COMPANY.add_task(task);
        }

        for(Employee EMP : EmpArray){
            COMPANY.add_employee(EMP);
        }

        Random gen = new Random();

        for(Task TASK : TaskArray){
            TASK.add_employee( EmpArray.get( gen.nextInt(EmpArray.size())));
        }

        /** TESTING FILTER METHOD */

        System.out.println("\n FILTER \n");

        ArrayList<Task> nar = COMPANY.filter_by((x -> x.MODE == Mode.IMPORTANT), (x -> x.NAME.contains("task")), (x -> x.EMPLOYEE.SALARY > 1000) );

        for( Task t : nar){
            System.out.println(t.NAME);
        }


        /** SORTING */

        System.out.println("\n SORTING \n");

        COMPANY.sort_tasks();

        System.out.println(COMPANY.toString());

        /** SALARY BONUS */

        System.out.println("\n SALARY BONUS \n");

        Employee EMP1,EMP2;

        EMP1 = COMPANY.find("1232");

        EMP1.pay_rise(25);

        EMP2 = COMPANY.find("1235");

        EMP2.pay_rise(50);

        if(EMP2 instanceof Specialist){
            ((Specialist) EMP2).bonus(300);
        }

        System.out.println(COMPANY.toString());

        /** PAY RISE FOR EVERYONE */

        System.out.println("\n PAY RISE FOR EVERYONE \n");

        COMPANY.company_pay_rise(100);
        System.out.println(COMPANY.toString());


    }
}
