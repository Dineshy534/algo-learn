package com.dinesh.algo;

public class ValidPalindrome {
    public static void main(String[] args){
        String s = "a man, a plan , a canal : Panama";
        System.out.println("Is given string a Valid Palindrome? : "+isValidPalindrome(s));
    }
    private static boolean isValidPalindrome(String s)
    {
        //To verify charAt index is alpha numeric or not
        //Character.isLetterOrDigit()
        int i = 0;
        int j = s.length()-1;

        //Let's start at both the ends
        while (i<j)
        {
            while(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            //Break the loop on below condition also check for the case
            if(j<i || Character.toLowerCase(s.charAt(i++))!=Character.toLowerCase(s.charAt(j--))){
                return false;
            }
        }
        return true;

    }
}
