public class Employee {

    String NAME,SURNAME,PESEL;
    double SALARY;


    void pay_rise(double PROC){
        if(PROC < 0){
            System.out.println("Wrong value!");
            return;
        }

        PROC = PROC / 100;
        this.SALARY += this.SALARY * PROC;
    }

    Employee(String NAME, String SURNAME, String PESEL, double SALARY){
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.PESEL = PESEL;
        this.SALARY = SALARY;
    }

    @Override
    public String toString() {
        return (NAME + " " + SURNAME + " " + PESEL + " " + Double.toString(SALARY) + "\n");
    }
}
