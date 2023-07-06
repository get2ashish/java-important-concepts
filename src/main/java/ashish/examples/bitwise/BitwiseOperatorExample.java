package ashish.examples.bitwise;

public class BitwiseOperatorExample {
    public static void main(String[] args) {

        //Note : When converting binary to decimal in Java keep in mind that integers are represented using 2s complement

        int a = 5; // binary: 0101
        int b = 3; // binary: 0011

        int result = a & b; // bitwise AND: 0001 (decimal 1)
        System.out.println(result);

        result = a | b;    // bitwise OR:  0111 (decimal 7)
        System.out.println(result);

        result = a ^ b;    // bitwise XOR: 0110 (decimal 6)
        System.out.println(result);

        result = ~a;       // bitwise complement: 1010 (decimal -6)
        // here MSB is 1 which means negative number so we will use 2s complement to compute the value
        //1010 --> 1-010 ==> 101+1  ==> 110 ==> 6 in integer adding negative as MSB was 1 so it gives -6
        System.out.println(result);

        result = a << 2;   // left shift:  010100 (decimal 20)
        System.out.println(result);

        result = a >> 1;   // right shift: 0010 (decimal 2)
        System.out.println(result);
    }

}
