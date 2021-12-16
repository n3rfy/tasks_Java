import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.lang.*;

public class Block5{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(new int[] {72,29,7,0,3}));
        System.out.println(canMove("rook", "A1", "C1"));
        System.out.println(canComplete("mas", "masseffect"));
        System.out.println(sumDigitProd(new int[] {16,21,10}));
        System.out.println(sameVowelGroup(new String[] {"vae","eav", "value"}));
        System.out.println(validateCard(1234567890123452L));
        System.out.println(numToEng(129));
        System.out.println(numToRus(129));
        System.out.println(getSha256Hash("Mama Ya ne Hochu Umirat"));
        System.out.println(correctTitle("jOn Snow, King IN thE noRth."));
        System.out.println(hexLattice(7));
    }

    public static int[] encrypt(String str){
        int[] arr = new int[str.length()];
        arr[0]=str.charAt(0);
        for (int i = 0; i < str.length()-1; i++) {
            arr[i+1]= str.charAt(i+1)-str.charAt(i);
        }
        return arr;
    }

    public static String decrypt(int[] arr){
        String str = ""+ (char)arr[0];
        int tmp = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            tmp+=arr[i+1];
            str+=(char)(tmp);
        }
        return str;
    }

    public static boolean canMove(String fig, String stP, String endP){
        stP=stP.toUpperCase(Locale.ROOT);
        endP=endP.toUpperCase(Locale.ROOT);
        if (!(stP.matches("[A-H][1-8]") && endP.matches("[A-H][1-8]"))){ System.out.println("exit");return false;}
        switch (fig.toLowerCase(Locale.ROOT)){
            case "pawn": //пешка
                if (stP.charAt(0)==endP.charAt(0) && (Math.abs(stP.charAt(1)-endP.charAt(1))<=2)) {
                    return true;
                }
                break;
            case "knight": //конь
                if ((Math.abs(stP.charAt(0)-endP.charAt(0)) == 1 && Math.abs(stP.charAt(1)-endP.charAt(1)) == 2) ||
                (Math.abs(stP.charAt(0)-endP.charAt(0)) == 2 && Math.abs(stP.charAt(1)-endP.charAt(1)) == 1)){
                    return true;
                }
                break;
            case "rook": //ладья
                if (((stP.charAt(0) == endP.charAt(0)) && (stP.charAt(1) != endP.charAt(1))) ||
                        ((stP.charAt(0) != endP.charAt(0)) && (stP.charAt(1) == endP.charAt(1)))){
                    return true;
                }
                break;
            case "bishop": //слон
                if (Math.abs(stP.charAt(0)-endP.charAt(0)) == Math.abs(stP.charAt(1) - endP.charAt(1))){
                    return true;
                }
                break;
            case "queen": //королева
                if((Math.abs(stP.charAt(0)-endP.charAt(0)) == Math.abs(stP.charAt(1) - endP.charAt(1))) ||
                        ((stP.charAt(0) == endP.charAt(0)) && (stP.charAt(1) != endP.charAt(1))) ||
                        ((stP.charAt(0) != endP.charAt(0)) && (stP.charAt(1) == endP.charAt(1)))){
                    return true;
                }
                break;
            case "king": // король
                if (Math.abs(stP.charAt(0)-endP.charAt(0))<=1 &&  Math.abs(stP.charAt(1) - endP.charAt(1))<=1){
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    public static boolean canComplete(String input, String output){
        char[] chars = input.toCharArray();
        int startOfSearch = 0;
        for (char c : chars) {
            if (output.indexOf(String.valueOf(c), startOfSearch) != -1)
                startOfSearch = output.indexOf(String.valueOf(c), startOfSearch) + 1;
            else
                return false;
        }
        return true;
    }

    public static int sumDigitProd(int[] arr){
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        while (sum > 9){
            int m =1;
            while (sum >0){
                m*=sum%10;
                sum/=10;
            }
            sum=m;
        }
        return sum;
    }

    public static ArrayList<String> sameVowelGroup(String[] strs) {
        String[] allVowels = new String[]{"a", "e", "u", "i", "o"};
        String vowels = "";
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < allVowels.length; i++) {
            if (strs[0].contains(allVowels[i]) && !vowels.contains(allVowels[i])) {
                vowels += allVowels[i];
            }
        }

        if (vowels.length() > 0) {
            result.add(strs[0]);
        } else {
            return result;
        }

        for (int i = 1; i < strs.length; i++) {
            boolean pass = true;
            for (int j = 0; j < vowels.length(); j++) {
                if (!strs[i].contains(String.valueOf(vowels.charAt(j)))) {
                    pass = false;
                    break;
                }
            }
            if (pass) result.add(strs[i]);
        }
        return result;
    }

    public static boolean validateCard(long init){
        String c =  Long.toString(init);
        if (c.length() < 14 && c.length()>19){
            return false;
        }
        char checkDigit = c.charAt(c.length()-1);
        int[] card = new int[c.length()-1];
        int sum=0;
        for (int i = 0; i <c.length()-1; i++) {
            card[i]=c.charAt(c.length()-2-i)-48;
            if (i%2==1){
                card[i]*=2;
                if (card[i]>9){
                    int tmp = 0;
                    while (card[i]>0){
                        tmp+=card[i]%10;
                        card[i]/=10;
                    }
                    card[i]=tmp;
                }
            }
            sum+=card[i];
        }

        if (10-sum%10 == (checkDigit-48)){
            return true;
        }
        return false;
    }

    public static String numToEng(int num) {
        String str = "";
        if (num == 0) return "zero";
        switch (num / 100) {
            case 1: {
                str += "one hundred ";
                break;
            }
            case 2: {
                str += "two hundred ";
                break;
            }
            case 3: {
                str += "three hundred ";
                break;
            }
            case 4: {
                str += "four hundred ";
                break;
            }
            case 5: {
                str += "five hundred ";
                break;
            }
            case 6: {
                str += "six hundred ";
                break;
            }
            case 7: {
                str += "seven hundred ";
                break;
            }
            case 8: {
                str += "eight hundred ";
                break;
            }
            case 9: {
                str += "nine hundred ";
                break;
            }
        }
        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "ten";
                        return str;
                    }
                    case 1: {
                        str += "eleven";
                        return str;
                    }
                    case 2: {
                        str += "twelve";
                        return str;
                    }
                    case 3: {
                        str += "thirteen";
                        return str;
                    }
                    case 4: {
                        str += "fourteen";
                        return str;
                    }
                    case 5: {
                        str += "fifteen";
                        return str;
                    }
                    case 6: {
                        str += "sixteen";
                        return str;
                    }
                    case 7: {
                        str += "seventeen";
                        return str;
                    }
                    case 8: {
                        str += "eighteen";
                        return str;
                    }
                    case 9: {
                        str += "nineteen";
                        return str;
                    }
                }
            }
            case 2: {
                str += "twenty ";
                break;
            }
            case 3: {
                str += "thirty ";
                break;
            }
            case 4: {
                str += "forty ";
                break;
            }
            case 5: {
                str += "fifty ";
                break;
            }
            case 6: {
                str += "sixty ";
                break;
            }
            case 7: {
                str += "seventy ";
                break;
            }
            case 8: {
                str += "eighty ";
                break;
            }
            case 9: {
                str += "ninety ";
                break;
            }
        }
        switch (num % 10) {
            case 1: {
                str += "one";
                break;
            }
            case 2: {
                str += "two";
                break;
            }
            case 3: {
                str += "three";
                break;
            }
            case 4: {
                str += "four";
                break;
            }
            case 5: {
                str += "five";
                break;
            }
            case 6: {
                str += "six";
                break;
            }
            case 7: {
                str += "seven";
                break;
            }
            case 8: {
                str += "eight";
                break;
            }
            case 9: {
                str += "nine";
                break;
            }
        }
        return str;
    }

    public static String numToRus(int num) {
        String str = "";
        if (num == 0) return "ноль";
        switch (num / 100) {
            case 1: {
                str += "сто ";
                break;
            }
            case 2: {
                str += "двести ";
                break;
            }
            case 3: {
                str += "триста ";
                break;
            }
            case 4: {
                str += "четыреста ";
                break;
            }
            case 5: {
                str += "пятьсот ";
                break;
            }
            case 6: {
                str += "шестьсот ";
                break;
            }
            case 7: {
                str += "семьсот ";
                break;
            }
            case 8: {
                str += "восемьсот ";
                break;
            }
            case 9: {
                str += "девятьсот ";
                break;
            }
        }
        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "десять";
                        return str;
                    }
                    case 1: {
                        str += "одиннадцать";
                        return str;
                    }
                    case 2: {
                        str += "двенадцать";
                        return str;
                    }
                    case 3: {
                        str += "тринадцать";
                        return str;
                    }
                    case 4: {
                        str += "четырнадцать";
                        return str;
                    }
                    case 5: {
                        str += "пятнадцать";
                        return str;
                    }
                    case 6: {
                        str += "шестнадцать";
                        return str;
                    }
                    case 7: {
                        str += "семнадцать";
                        return str;
                    }
                    case 8: {
                        str += "восемьнадцать";
                        return str;
                    }
                    case 9: {
                        str += "двадцать";
                        return str;
                    }
                }
            }
            case 2: {
                str += "двадцать ";
                break;
            }
            case 3: {
                str += "тридцать ";
                break;
            }
            case 4: {
                str += "сорок ";
                break;
            }
            case 5: {
                str += "пятьдесят ";
                break;
            }
            case 6: {
                str += "шестьдесят ";
                break;
            }
            case 7: {
                str += "семьдесят ";
                break;
            }
            case 8: {
                str += "восемьдесят ";
                break;
            }
            case 9: {
                str += "девяносто ";
                break;
            }
        }
        switch (num % 10) {
            case 1: {
                str += "один";
                break;
            }
            case 2: {
                str += "два";
                break;
            }
            case 3: {
                str += "три";
                break;
            }
            case 4: {
                str += "четыре";
                break;
            }
            case 5: {
                str += "пять";
                break;
            }
            case 6: {
                str += "шесть";
                break;
            }
            case 7: {
                str += "семь";
                break;
            }
            case 8: {
                str += "восемь";
                break;
            }
            case 9: {
                str += "девять";
                break;
            }
        }
        return str;
    }

    public static String getSha256Hash(String s) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
        return convertToString(hash);
    }

    public static String convertToString(byte[] hash) {
        String hexString = "";
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString += '0';
            }
            hexString += hex;
        }
        return hexString;
    }

    public static StringBuilder correctTitle(String string){
        String[] strings=string.split(" ");
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            strings[i]=strings[i].toLowerCase(Locale.ROOT);
            if (strings[i].equals("and") || strings[i].equals("the") || strings[i].equals("of") || strings[i].equals("in")){
                tmp.append(strings[i]+" ");
            }
            else {
                tmp.append(strings[i].toUpperCase(Locale.ROOT).charAt(0) + strings[i].substring(1) + " ");
            }
        }
        return tmp;
    }

    public static String hexLattice(int n) {
        int num = 1;
        int i = 1;
        String res = "";
        String str2 = "";
        while (n > num) {
            i++;
            num = 3 * i * (i - 1) + 1;
        }
        int l = i;
        if (n != num)
            res = "invalid";
        else {
            while (l < i * 2 - 1) {
                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += " ";
                for (int b = 0; b < l; b++)
                    res += " o";
                res += "\n";
                l++;
            }
            while (l >= i) {
                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += " ";
                for (int b = l; b > 0; b--)
                    res += " o";
                res += " \n";
                l--;
            }
        }
        return res;
    }


}
