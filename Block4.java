import java.util.*;

public class Block4{
    public static void main(String[] args){
        System.out.println(text(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println(Arrays.toString(split("()()()")));
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabitArr"));
        System.out.println(overTime(new double[] {9,17,30,1.5}));
        System.out.println(BMI("123 pounds", "222 inches"));
        System.out.println(bugger(999));
        System.out.println(toStarShorthand("77777fafafa2ssxaxasss2adasdvladlasldalaldlaldasl"));
        System.out.println(doesRhyme("Sam I jjjaaam!", "Green eggs and haaim."));
        System.out.println(trouble(111222929, 22));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
    }
    public static String text(int lenght_message, int max_len_str, String message){
        String[] mas_message = message.split(" ");
        String out_str = ""; 
        int curent_len = 0;
        for (int i = 0; i < lenght_message; i++){
            if (curent_len + mas_message[i].length() <= max_len_str){
                out_str += mas_message[i] + " ";
                curent_len += mas_message[i].length();
            }
            else{
                curent_len = mas_message[i].length();
                out_str += "\n" + mas_message[i] + " ";
            }

        } 
        return out_str;
    }
    public static String[] split(String text){
        char[] mas_char = text.toCharArray();
        String[] out_mas = new String[text.length()/2];
        int open = 0;
        int close = 0;
        int add_mas = 0;
        int last = 0;
        for (int i = 0; i < text.length(); i++){
            if (mas_char[i] == '(') open += 1;
            else close += 1;

            if (open == close){
                out_mas[add_mas] = text.substring(last, i+1);
                last = i+1;
                add_mas += 1;
            }
        }   
        return out_mas;
    }
    public static String toCamelCase(String text){
        String[] mas_message = text.split("_");
        String out_text = "";
        for (String word: mas_message){
           out_text += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        }
        return out_text;
    }
    public static String toSnakeCase(String text){
        String new_text = "";
        int open = 0;
        int last = 0;
        for (int i = 0; i < text.length(); i++){
            if(Character.isUpperCase(text.charAt(i))){
                last = i + 1;
                new_text += text.substring(open, i) + "_" + text.substring(i,last).toLowerCase();
                open = last;

            }
        }
        new_text += text.substring(last, text.length());
        return new_text;
    }
    public static String overTime(double[] arr){
        double sum = 0;
        for (double i = arr[0]; i < arr[1]; i+=0.25) {
            if (i>17) {sum+=0.25*arr[2]*arr[3];}
            else sum+=0.25*arr[2];
        }
        return String.format("$%.2f",sum);
    }

    public static String BMI (String weight,String height){
        String[] weig = weight.split(" ");
        String[] heig = height.split(" ");
        String result = "";
        double kilos = weig[1].equals("pounds") ? Double.parseDouble(weig[0]) * 0.453592 : Double.parseDouble(weig[0]);
        double meters = heig[1].equals("inches") ? Double.parseDouble(heig[0]) * 0.0254 : Double.parseDouble(heig[0]);
        double val = kilos / (meters * meters);
        val = Math.round(val * 10.0) / 10.0;
        if (val < 18.5) result += val + " Underweight";
        if (val >= 18.5 && val <= 24.5) result += val + " Normal weight";
        if (val >= 25 && val <= 29.9) result += val + " Overweight";
        if (val >= 30) result += val + " Obesity";
        return result;
    }

    public static int bugger(int n){
       int result = 0;
       while (Integer.toString(n).length() > 1){
           int param = n;
           n=1;
           while(param>0) {
               n *=param%10;
               param = param / 10;
           }
           result++;
       }
       return result;
    }

    public static String toStarShorthand(String string){
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        String result = "";
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (!strings.contains(Character.toString(string.charAt(i)))) {
                strings.add(count,Character.toString(string.charAt(i)));
                numbers.add(count,1);
                for(int j = i+1; j < string.length();j++) {
                    if (string.charAt(j) == string.charAt(i)) {
                        numbers.add(count,numbers.get(count)+1);
                    }
                }
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
           if (numbers.get(i)==1){
               result +=strings.get(i)+"*";
           }
           else if (strings.get(i).matches("[0-9]+")){
               result +="("+numbers.get(i)+"*"+strings.get(i)+")*";
           }
           else result +=numbers.get(i)+strings.get(i)+"*";
        }
        return result.substring(0,result.length()-1);
    }

    public static boolean doesRhyme(String firstString, String secondString){
        String firstLastWord = firstString.substring(firstString.lastIndexOf(" ")+1);
        String secondLastWord = secondString.substring(secondString.lastIndexOf(" ")+1);
        int jCount = 0;
        int fNum = 0, sNum=0;
        for (int i = 0; i < firstLastWord.length(); i++) {
            if (Character.toString(firstLastWord.charAt(i)).matches("[AIOUEYaiouey]")){
                fNum++;
                for (int j = jCount; j < secondLastWord.length(); j++) {
                    jCount++;
                    if (Character.toString(secondLastWord.charAt(j)).matches("[AIOUEYaiouey]")){
                        if (secondLastWord.charAt(j) == firstLastWord.charAt(i)){
                            sNum++;
                            break;
                        }
                    }
                }
            }

        }
         if (sNum==fNum){
             return true;
         }
         else{
             return false;
         }
    }

    public static boolean trouble(int num1, int num2){
        String numberOne = Integer.toString(num1);
        String numberTwo = Integer.toString(num2);
        for (int i = 0; i < numberOne.length()-2; i++) {
            if (numberOne.charAt(i)==numberOne.charAt(i+1) && numberOne.charAt(i)==numberOne.charAt(i+2)){
                for (int j = 0; j < numberTwo.length()-1; j++) {
                    if (numberOne.charAt(i)==numberTwo.charAt(j) && numberOne.charAt(i)==numberTwo.charAt(j+1)){
                        return true;
                    }
                }
            }
        }
        return  false;
    }

    public static int countUniqueBooks(String books, char divider){
        int result=0;
        for (int i = 0; i < books.length(); i++) {
            if ( books.charAt(i) == divider){
                ArrayList<Character> uniqueSymbol = new ArrayList();
                int j = i+1;
                while(j < books.length() && books.charAt(j) != divider){
                    if (!uniqueSymbol.contains(books.charAt(j))){
                        uniqueSymbol.add(books.charAt(j));
                    }
                    j++;
                }
                i = j;
                result+=uniqueSymbol.size();
            }
        }
        return result;
    }
        


}
