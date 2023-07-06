package ashish.examples.string;

public class CompareToExample {
    public static void main(String[] args) {

        /**CompareTo compares the String Lexicographically (same way as in dictionary)
        ABC then ABD as D comes after C
        A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z
        It will compare character by character.**/

        String s1 = "Ape";
        String s2 = "Zebra";

        //Output is -25 because there are 25 characters between A-Z and since S2 is greater(Lexicographically) hence negative
        System.out.println(s1.compareTo(s2));

        s1 = "Ashish";
        s2 = "Ash";
        //Output is +3 because s1 has 3 additional characters than s2

        s1 = "Apple";
        s2 = "Applf";

        //-1 as there is f is ahead of e
        System.out.println(s1.compareTo(s2));


        s1 = "Apple";
        s2 = "apple";

        //Upper case 'A' has lower value than lower case 'a' hence -32
        //A(65),B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z(90)
        //a(97),b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z(122)
        //0(48),1,2,3,4,5,6,7,8,9(57)
        System.out.println(s1.compareTo(s2));


        s1 = "1Apple";
        s2 = "Apple";
        System.out.println(s1.compareTo(s2));

        s1 = "Apple";
        s2 = " Apple";//Notice there is a space

        System.out.println(s1.compareTo(s2));
    }


    static int myCompareToImplementation(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();

        int minLength = Math.min(l1, l2);

        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        for (int i = 0; i < minLength; i++) {
            char c1 = s1CharArray[i];
            char c2 = s2CharArray[i];
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return l1 - l2;
    }


}
