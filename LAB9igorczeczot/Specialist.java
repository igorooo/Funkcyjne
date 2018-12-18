public class Specialist extends Employee {


    double BONUS;

    void bonus(double BONUS){
        this.BONUS = BONUS;
    }

    Specialist(String NAME, String SURNAME, String PESEL, double SALARY) {
        super(NAME, SURNAME, PESEL, SALARY);
        BONUS = 0;
    }

    @Override
    public String toString() {
        return (NAME + " " + SURNAME + " " + PESEL + " " + Double.toString(SALARY) + " " + Double.toString(BONUS));
    }
}
