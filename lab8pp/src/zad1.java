public class zad1 {


    public static int[] connect(int tab1[],int tab2[]){

        int i = 0, j = 0,iter = 0;
        boolean flag = true;
        int l1 = tab1.length, l2 = tab2.length;
        int res[] = new int[l1+l2];

        while(i < l1 || j < l2){

            if(flag){

                if( i < l1 ){
                    res[iter++] = tab1[i++];
                }
            }

            if(!flag){

                if( j < l2 ){
                    res[iter++] = tab2[j++];
                }
            }

           flag = !flag;
        }

        return res;
    }


    public static void main(String[] args){

        int tab1[] = {1,2,3,4};
        int tab2[] = {5,6,7,8,9,10};

        int tab3[] = zad1.connect(tab1,tab2);


        for(int i = 0; i < tab3.length; i++)
            System.out.print(tab3[i]);

    }


}
