public class TestAdd {
    public static void main(String[] args) {
       TestAdd add = new TestAdd();
       add.getPrintf(4);
    }

    public void getPrintf(Integer i){
        int t = 1;
        for(int j = 1; j<= 2*i ; j++){
            if(j<= i) {
                t = t + j - 1;

                System.out.println(t);
            }
            if(j> i){
                t = t + j + 1+( j - i) ;
                System.out.println( t );
            }
        }
    }
}
