public class Test {

    int zawartosc = 0;



    static void argNiemodyfikowalny(final Test zmienna){
        zmienna.zawartosc = 1;
        //zmienna = null;    // nie mozna zmienic zawartosci argumentu przekazanego jako final
    }

    static void argModyfikoiwalny(Test zmienna){
        zmienna.zawartosc = 1;
        zmienna = null;
    }

    // nie mozemy zmienic referencji na ktora wskazuje zmienna 'niemodyfikowalna' ale
    // mozemy zmienic zawartosc obiektu na ktory zmienna final wskazuje

    public static void main(String[] args){
        Test modyfikowalna = new Test();
        final Test niemodyfikowalna = new Test();

        // a)
        argNiemodyfikowalny(modyfikowalna);
        System.out.println(modyfikowalna.zawartosc);  //1

        // b)
        argNiemodyfikowalny(niemodyfikowalna);
        System.out.println(niemodyfikowalna.zawartosc); //1

        // c)
        argModyfikoiwalny(modyfikowalna);
        System.out.println(modyfikowalna.zawartosc);  //1

        // d)
        argModyfikoiwalny(niemodyfikowalna);
        System.out.println(niemodyfikowalna.zawartosc); //1
    }
}
