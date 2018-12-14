import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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

    Company(){
        ARRAY = new ArrayList<>();
    }
}
