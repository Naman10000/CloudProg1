import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int a[]={2,3,1,5,4,7,6};
        Arrays.sort(a);
        System.out.println("Hello, World!"); 
        System.out.println("min="+a[0]+ " " +"max="+a[a.length-1]);
    }
} 