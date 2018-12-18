import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Company {

    ArrayList<Employee> ARRAY;
    ArrayList<Task> TASKS;


    void bonus_fSpecialist(String PESEL, double BONUS){

        Employee SPEC = find(PESEL);

        if(SPEC == null){
            System.out.println("Wrong PESEL!");
            return;
        }

        else{

            if( SPEC instanceof Specialist){

                ((Specialist) SPEC).bonus(BONUS);

            }

            else{
                System.out.println("Emplyee is not specialist!");
            }
        }
    }

    void company_pay_rise(double PROC){

        for(Employee EMP : ARRAY){
            EMP.pay_rise(PROC);
        }
    }

    void sort_tasks(){

        Collections.sort(TASKS);
    }

    void add_task(Task TASK){

        if(TASK != null){
            TASKS.add(TASK);
        }
    }

    Employee find(String PESEL){

        for(Employee EMP : ARRAY){
            if(EMP.PESEL.compareTo(PESEL) == 0){
                return EMP;
            }
        }
        System.out.println("There is no employee with given PESEL!");
        return null;
    }

    void add_employee(String NAME, String SURNAME, String PESEL, double SALARY, boolean isSpecialist){  // IF SPECIALIST THEN TRUE

        if(isSpecialist){
            ARRAY.add(new Specialist(NAME,SURNAME,PESEL,SALARY));
        }

        else{
            ARRAY.add(new Employee(NAME,SURNAME,PESEL,SALARY));
        }
    }

    void add_employee(Employee EMP){
        ARRAY.add(EMP);
    }

    ArrayList<Task> filter_by(Predicate<Task>... PRED){

        Stream<Task> TASKSS = this.TASKS.stream();

        for(Predicate pred : PRED){

            TASKSS = TASKSS.filter(pred);
        }

        return TASKSS.collect(Collectors.toCollection(ArrayList::new));
    }



    Company(){
        ARRAY = new ArrayList<>();
        TASKS = new ArrayList<>();
    }

    @Override
    public String toString() {

        String STR = "\nCompany:\n";

        STR += "Emplyess: \n";



        for(Employee EMP : ARRAY){
            STR += EMP.toString();
            STR += "\n";
        }

        STR += "\nTasks: \n";

        for(Task TASK : TASKS){
            STR += TASK.toString();
            STR += "\n";
        }

        return STR;
    }
}
