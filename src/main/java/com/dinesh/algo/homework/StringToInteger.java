package com.dinesh.algo.homework;

public class StringToInteger {
    public int myAtoi(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        char[] letters = str.toCharArray();

        long result = 0;

        boolean isNegative = false;
        // The following boolean symbolEncountered will handle inputs like "--2891" or "-+189"
        boolean symbolEncountered = false;
        boolean numbersStarted = false;
        for(int i = 0 ; i < letters.length ; ++i) {
            char c = letters[i];

            if(!Character.isDigit(c)) {
                if(numbersStarted) {
                    break;
                }

                if (c == '-') {
                    if(symbolEncountered) {
                        return 0;
                    }
                    isNegative = true;
                    numbersStarted = true;
                    symbolEncountered = true;
                    continue;
                }
                if (c == '+') {
                    if(symbolEncountered) {
                        return 0;
                    }
                    numbersStarted = true;
                    symbolEncountered = true;
                    continue;
                }
                if(c == ' ') {
                    if(!numbersStarted) {
                        continue;
                    }
                }

                return 0;
            }

            numbersStarted = true;
            int numLetter = Character.getNumericValue(c);
            result = result * 10 + numLetter;

            if(isNegative && result > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }

            if(result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        if(isNegative) {
            result = result * -1;
        }

        return (int)result;
    }
}
