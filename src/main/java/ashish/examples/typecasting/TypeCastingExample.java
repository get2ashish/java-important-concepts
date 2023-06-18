package ashish.examples.typecasting;

public class TypeCastingExample {
    public static void main(String[] args) {

        /**
         can only store whole numbers (size is 1 byte)
         -(2^n) to +(2^(n-1)-1)
         here n is the number of bits
         -(2^7) to +(2^7-1)
         Since byte is a signed value so out of 8 bits 1 will be used for storing sign (+ or -) remaining 7 are used
         for storing value
         signed bit 1:negative 0:positive value
         **/
        byte a = 5;

        //can only store whole numbers (size is 2 bytes)
        short b = 10;

        //can only store whole numbers(size is 4 bytes)
        int c = 15;

        //can only store whole numbers(8 bytes)
        long d = 20;

        //Stores fractional value(4 bytes)
        float e = 25;

        //Stores fractional value(8 bytes)
        double f = 30;

        //Case 1
        //By default java allows moving up in size (no explicit casting is needed)
        byte byteValue = 50;
        short shortValue = byteValue;
        int intValue = byteValue;
        long longValue = byteValue;
        float floatValue = byteValue;
        double doubleValue = byteValue;

        //Above all are moving up in size so there is no issue at all. Imagine as a small box being put in a bigger one

        //Down casting
        //When moving down is size we need to specify the type and there CAN be a precision loss
        int totalStudents = 150;
        byte byteStudentValue = (byte) totalStudents;
        System.out.println("Byte value for an int value is: " + byteStudentValue);

        //Output is 106 here as :
        /**
         150 in int is represented as 00000000-00000000-00000000-10010110 (int takes 4 bytes which is 32 bits)
         byte takes 8 bits and first bit (Most Significant Bit) will be used as signed bit
         so we only have remaining 7 bits for storing the number.
         so  10010110 will be represented as:
         10010110 :  here most significant bit is 1 so it denotes a negative number (if it was 0 then + number)
         When MSB is 1 or negative number then we find the 2's complement of remaining 7 bits -
         (0010110) --> first complement it then add 1
         0010110 --> 1101001
         +      1
         ------------
         1101010
         ------------
         1101010 --> in decimal is 106 but MSB was 1 so -106 is the result

         PS :  If the MSB was 0 then remaining 7 bits will be used as is for further calculation
         **/
    }
}
