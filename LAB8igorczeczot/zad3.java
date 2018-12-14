import java.lang.reflect.Array;
import java.util.ArrayList;

public class zad3 {



    public static ArrayList<Integer> duplicate(int tab1[], int tab2[]){

        int iter = 0;
        int l1 = tab1.length, l2 = tab2.length;
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0,j = 0; i < l1; i++,j++){

            if(j < l2){
                for(int i1 = 0; i1 < tab2[j]; i1++){
                    res.add(iter++,tab1[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){

        int tab1[] = {1,2,3,4};
        int tab2[] = {0,1,1,4,1};

        ArrayList<Integer> tab3 = zad3.duplicate(tab1,tab2);


        for(int i = 0; i < tab3.size(); i++)
            System.out.print(tab3.get(i));

    }

}
