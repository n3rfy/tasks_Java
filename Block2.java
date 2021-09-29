
public class Block2{
    public static void main(String[] args){
        int arr1[]={1,-2,3};
        System.out.println(repeat("word", 3));
        System.out.println(differenceMaxMin(arr1));
        System.out.println(isAvgWhole(arr1));
        System.out.println(java.util.Arrays.toString(cumulativeSum(arr1)));
        System.out.println(getDecimalPlaces("30.1234"));
        System.out.println(Fibonacci(12));
        System.out.println(isValid("12145"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(boxSeq(1));
    }

    public static String repeat(String word, int count){
        String new_string = "";
        for (int i = 0; i < word.length(); i++){
            for (int m = 0; m < count; m++){
                new_string += word.charAt(i);
            }
        }
        return new_string;
    }
    public static int differenceMaxMin(int[] myArray){
        int small = myArray[0];
        int big = myArray[0];

        for (int i = 0; i < myArray.length; i++){
            if (myArray[i] < small){
                small = myArray[i];
            }
            else if (myArray[i] > big){
                big = myArray[i];
            }
        }

        return big - small;

    }
    public static boolean isAvgWhole (int[] myArray){
        int sum = 0;
        int avg = 0;
        for (int i = 0; i < myArray.length; i++){
            sum += myArray[i];
        }
        avg = sum % myArray.length;
        return avg == 0;
    }
    public static int[] cumulativeSum(int[] myArray){
        int last_sum = 0;
        int[] new_array = new int[myArray.length];
        for (int i = 0; i < myArray.length; i++){
            new_array[i] = last_sum + myArray[i];
            last_sum = new_array[i];
        }

        return new_array;
    }
    public static int getDecimalPlaces(String num){
        String decimal = "";
        if (num.contains(".")){
            String[] num_split = num.split("\\.");
            decimal = num_split[1];
            return decimal.length();
        }
        else{
            return 0;
        }
    }
    public static int Fibonacci(int iter){
        int first = 1;
        int last = 1;
        int between = 0; 
        for (int i = 0; i < iter ; i++){
            between = last;
            last = first + last;
            first = between;
        }

        return first;
    }
    public static boolean isValid(String address){
    
        try{
            if (address.length() == 5){
                int addr = Integer.parseInt(address.trim());    
                return true;
            }
            else return false;
        }
        catch (NumberFormatException nfe){
            return false;
        }
    }

    public static boolean isStrangePair(String one, String two){
        if ((one.equals("")) & (two.equals(""))) return true;
        else if ((one.charAt(0) == two.charAt(two.length()-1)) & (one.charAt(one.length()-1) == two.charAt(0))) return true;
        else return false;
    }

    public static boolean isPrefix (String word, String prefix){
        prefix = prefix.substring(0, prefix.length() - 1);
        return word.startsWith(prefix);
    }
    public static boolean isSuffix (String word, String suffix){
        suffix = suffix.substring(1, suffix.length());
        return word.endsWith(suffix);
    }

    public static void isPrefix(String args[])
    {
        System.out.println(boxSeq(5));
    }
    public static int boxSeq (int Amount){
        int Count = 0;
        for (int i = 0; i <= Amount; i++){
            if(i==0){
                Count = Count;
            }
            else if(i%2==0){
                Count = Count - 1;
            }
            else{
                Count  = Count + 3;
            }
        }
        return Count;
    }
}
