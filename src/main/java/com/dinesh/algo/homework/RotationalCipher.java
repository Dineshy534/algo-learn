package com.dinesh.algo.homework;

public class RotationalCipher {
    /*
    Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc

The alphabet is rotated by , matching the mapping above. The encrypted string is .

Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
     */

    public static void main(String[] args) {

        //a =97 and z =122
        //A=65     Z=90
        //0= 48  9=57

        //char c = (char) int;

        System.out.println("Rotational cipher "+ rotationalCipher("abcdZXYzxy-999.@",200));

    }
    private static String rotationalCipher(String input, int rotationFactor){
        StringBuilder sb = new StringBuilder();

        char a = 'a';
        int aInt = (int)a;


        for(char c: input.toCharArray()){
            int num = (int)c;
            if(num>=97 && num<=122){
                int newRotationFactor = rotationFactor%26;
                num += newRotationFactor;
                if(num>122){
                    num = num-26;
                }
                sb.append((char) num);
            }else if(num>=65 && num<=90){
                int new2rotationFactor = rotationFactor%26;
                num += new2rotationFactor;
                if(num>90){
                    num = num-26;
                }
                sb.append((char) num);
            } else if(num>=48 && num<=57){
                int new3rotationFactor = rotationFactor%10;
                num+=new3rotationFactor;
                if(num>57){
                    num -=10;
                }
                sb.append((char)num);
            } else {
                sb.append((char)num);
            }
        }

        return sb.toString();
    }
}
