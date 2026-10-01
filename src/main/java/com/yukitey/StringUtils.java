package com.yukitey;

public class StringUtils {
    public String reverse(String s){
        return new StringBuilder(s)
                .reverse()
                .toString();
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}