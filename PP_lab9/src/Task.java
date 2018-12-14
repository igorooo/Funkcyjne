public class Task implements Comparable<Task> {

    String NAME,MODE,STATUS;
    Employee EMPLOYEE;


    void finish_task() throws  ModeException{
        if(STATUS.compareTo("IN PROGRESS") != 0){
            throw (new ModeException("WRONG MODE!"));
        }

        else{
            STATUS = "FINISHED";
        }
    }

    void add_employee(Employee EMPLOYEE){

        if(EMPLOYEE == null){
            System.out.println("Wrong employee!");
            return;
        }

        this.EMPLOYEE = EMPLOYEE;
        this.STATUS = "IN PROGRESS";
    }

    Task(String NAME, String MODE){
        this.NAME = NAME;
        this.MODE = MODE;
        this.STATUS = "PREPARING";
    }


    @Override
    public int compareTo(Task task) {
        if(this.MODE.compareTo(task.MODE) == 0 ){
            return 0;
        }
        else if(this.MODE.compareTo("PILNY") == 0 ){
            return 1;
        }
        else{
            return -1;
        }
    }
}
