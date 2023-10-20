public final class Encrypt {
    public static String encrypt(String text, int seed) {
        seed %= 33;
        String[] binaryList = wordToBinaryString(text, true);
        String[] newBinaryList = moveBinaryListLeftBy(seed, binaryList);
        return binaryToWord(newBinaryList);
    }

    public static String decrypt(String text, int seed) {
        seed %= 33;
        String[] binaryList = wordToBinaryString(text, false);
        String[] newBinaryList = moveBinaryListRightBy(seed, binaryList, true);
        return binaryToWord(newBinaryList);
    }

    private static String[] wordToBinaryString(String word, boolean invert) {
        int wordLength = word.length();
        String[] binary = new String[wordLength];
        for (int i = 0; i < wordLength; i++) {
            int charNum;
            charNum = charToNumber(word.charAt(i));
            binary[i] = "";
            while (charNum > 0 || binary[i].length() < 5) {
                if (charNum != 0) {
                    binary[i] = binary[i].concat(charNum % 2 == 0 ? "0" : "1");
                    charNum /= 2;
                } else {
                    binary[i] = binary[i].concat("0");
                }
            }
            StringBuilder temp = new StringBuilder();
            for (int j = binary[i].length() - 1; j >= 0; j--) {
                temp.append(binary[i].charAt(j));
            }
            binary[i] = temp.toString();
            if(invert) {
                binary[i] = invertBinary(binary[i]);
            }
        }
        return binary;
    }

    private static int charToNumber(char character) {
        int charNum;
        switch (character) {
            case 'a' -> charNum = 0;
            case 'b' -> charNum = 1;
            case 'c' -> charNum = 2;
            case 'd' -> charNum = 3;
            case 'e' -> charNum = 4;
            case 'f' -> charNum = 5;
            case 'g' -> charNum = 6;
            case 'h' -> charNum = 7;
            case 'i' -> charNum = 8;
            case 'j' -> charNum = 9;
            case 'k' -> charNum = 10;
            case 'l' -> charNum = 11;
            case 'm' -> charNum = 12;
            case 'n' -> charNum = 13;
            case 'o' -> charNum = 14;
            case 'p' -> charNum = 15;
            case 'q' -> charNum = 16;
            case 'r' -> charNum = 17;
            case 's' -> charNum = 18;
            case 't' -> charNum = 19;
            case 'u' -> charNum = 20;
            case 'v' -> charNum = 21;
            case 'w' -> charNum = 22;
            case 'x' -> charNum = 23;
            case 'y' -> charNum = 24;
            case 'z' -> charNum = 25;
            case ' ' -> charNum = 26;
            case '0' -> charNum = 27;
            case '1' -> charNum = 28;
            case '2' -> charNum = 29;
            case '3' -> charNum = 30;
            case '4' -> charNum = 31;
            case '5' -> charNum = 32;
            default -> charNum = -1;
        }
        return charNum;
    }

    private static String[] moveBinaryListLeftBy(int n, String[] binaryList) {
        for(int i = 0; i < binaryList.length; i++) {
            binaryList[i] = moveBinaryLeftBy(n, binaryList[i]);
        }
        return binaryList;
    }

    private static String[] moveBinaryListRightBy(int n, String[] binaryList, boolean invert) {
        for(int i = 0; i < binaryList.length; i++) {
            binaryList[i] = moveBinaryRightBy(n, binaryList[i]);
            if(invert) {
                binaryList[i] = invertBinary(binaryList[i]);
            }
        }
        return binaryList;
    }
    private static String moveBinaryLeftBy(int n, String binary) {
        if (n == 0) {
            return binary;
        }

        StringBuilder temp = new StringBuilder();
        int size = binary.length();
        for (int i = 0; i < size; i++) {
            temp.append(binary.charAt((i + 1) % size));
        }
        return moveBinaryLeftBy(n - 1, temp.toString());
    }

    private static String moveBinaryRightBy(int n, String binary) {
        if (n == 0) {
            return binary;
        }

        StringBuilder temp = new StringBuilder();
        int size = binary.length();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                temp.append(binary.charAt(size - 1));
            } else {
                temp.append(binary.charAt((i - 1) % size));
            }
        }
        return moveBinaryRightBy(n - 1, temp.toString());
    }

    private static String binaryToWord(String[] binary) {
        StringBuilder word = new StringBuilder();
        for (String s : binary) {
            int decimalChar = binaryToDecimal(s);
            String character = "";
            character = numberToChar(decimalChar, character);
            word.append(character);
        }
        return word.toString();
    }

    private static String numberToChar(int decimalChar, String character) {
        switch (decimalChar) {
            case 0 -> character = "a";
            case 1 -> character = "b";
            case 2 -> character = "c";
            case 3 -> character = "d";
            case 4 -> character = "e";
            case 5 -> character = "f";
            case 6 -> character = "g";
            case 7 -> character = "h";
            case 8 -> character = "i";
            case 9 -> character = "j";
            case 10 -> character = "k";
            case 11 -> character = "l";
            case 12 -> character = "m";
            case 13 -> character = "n";
            case 14 -> character = "o";
            case 15 -> character = "p";
            case 16 -> character = "q";
            case 17 -> character = "r";
            case 18 -> character = "s";
            case 19 -> character = "t";
            case 20 -> character = "u";
            case 21 -> character = "v";
            case 22 -> character = "w";
            case 23 -> character = "x";
            case 24 -> character = "y";
            case 25 -> character = "z";
            case 26 -> character = " ";
            case 27 -> character = "0";
            case 28 -> character = "1";
            case 29 -> character = "2";
            case 30 -> character = "3";
            case 31 -> character = "4";
            case 32 -> character = "5";
        }
        return character;
    }

    private static int binaryToDecimal(String binary) {
        int binaryInt = Integer.parseInt(binary);
        int base = 1;
        int decimal = 0;
        while (binaryInt > 0) {
            int lastDigit = binaryInt % 10;
            binaryInt = binaryInt / 10;
            decimal += lastDigit * base;
            base = base * 2;
        }
        return decimal;

    }

    private static String invertBinary(String binary) {
        StringBuilder invertedBinary = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            invertedBinary.append(binary.charAt(i) == '1' ? '0' : '1');
        }
        return invertedBinary.toString();
    }
}
