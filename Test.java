public class Test {
    
    public static void main(String[] args) {
       System.out.println(A(17));
    }

    static int A(int n){
        if(n==0) return 1;
        return C(n-1);
    }
    static int B(int n){
        if(n==0) return 0;
        return A(n-1) + C(n-1);
    }
    static int C(int n){
        if(n==0) return 0;
        return B(n-1) + C(n-1);
    }
}
