public class Task implements Comparable<Task> {

    String NAME;
    Status STATUS;
    Mode MODE;
    Employee EMPLOYEE;


    void finish_task() throws  ModeException{
        if(STATUS == Status.InProgress ){
            throw (new ModeException("WRONG MODE!"));
        }

        else{
            STATUS = Status.Finished;
        }
    }

    void add_employee(Employee EMPLOYEE){

        if(EMPLOYEE == null){
            System.out.println("Wrong employee!");
            return;
        }

        this.EMPLOYEE = EMPLOYEE;
        this.STATUS = Status.InProgress;
    }

    Task(String NAME, Mode MODE){
        this.NAME = NAME;
        this.MODE = MODE;
        this.STATUS = Status.Preparing;
        this.EMPLOYEE = new Employee("DEFAULT","EMPLYEE","00000000",0);
    }


    @Override
    public int compareTo(Task task) {
        if(this.MODE == task.MODE){
            return 0;
        }
        else if(this.MODE == Mode.IMPORTANT ){
            return -1;
        }
        else{
            return 1;
        }
    }

    @Override
    public String toString() {
        String STR = "";
        STR += NAME + " status: ";

        switch (STATUS){
            case Finished:
                STR += "Finished";
                break;

            case InProgress:
                STR += "In Progress";
                break;

            case Preparing:
                STR += "Preparing";
                break;
        }

        STR += " mode: ";

        switch (MODE){
            case IMPORTANT:
                STR+= "IMPORTANT";
                break;
            case NORMAL:
                STR+= "NORMAL";
                break;
        }

        STR += " employee: ";

        if( EMPLOYEE.NAME.compareTo("DEFAULT") == 0){
            STR += " not assigned";
        }
        else{
            STR += EMPLOYEE.toString();
        }

        return STR;
    }
}
