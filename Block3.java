public class Block3{
    public static void main(String[] args){
        int[] mass1 = {1,3,4,4,4};
        int[] mass2 = {2,5,7};
        System.out.println(solutions(1, 0, -1));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(solutions(496));
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(same(mass1, mass2));
        System.out.println(isKaprekar(297));
    }
    public static int solutions(int x1, int x2, int x3){
        int disk = 0;
        disk = x2 * x2 - 4 * x1 * x3;
        if (disk > 0) {
            return 2;
        }
        else if (disk == 0) {
            return 1;
        }
        else return 0;
    }

    public static int findZip(String zip_string){
        String[] zip_mas = zip_string.split("zip");
        if (zip_mas.length == 3) {
            int count = 3; 
            String one = "";            
            String two = "";
            one = zip_mas[0];
            two = zip_mas[1];
            count += one.length() + two.length();
            return count;
        }
        else return -1;
    }
    public static boolean solutions(int var){
        int sum = 0; 
        for (int i = 1; i < var; i++){
            if (var % i == 0){
                sum += i;
            }
        }
        return sum == var;
    }
    public static String flipEndChars(String str){
        char one_char ; 
        char two_char ;
        if (str.length() > 1){
            one_char = str.charAt(0);
            two_char = str.charAt(str.length()-1);
            if (one_char == two_char){
                return "Two's a pair.";
            }
            else {
                return two_char + str.substring(1, str.length()-1) + one_char;
            }
        }
        else {
            return "Incompatible.";
        }
    }
    

    public static boolean isValidHexCode(String HEX){
        try{
            if (HEX.charAt(0) == '#'){
                HEX = HEX.substring(1, HEX.length());
                if (HEX.length() == 6){
                    int valid = Integer.parseInt(HEX, 16);
                    return true;
                }
                else return false;
            }
            else return false;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean same(int[] mass1, int[] mass2){
        int len_mass1 = mass1.length;
        int len_mass2 = mass2.length;
        for (int a = 0; a < mass1.length; a++){
            for (int i = a + 1; i < mass1.length; i++){
                if (mass1[a] == mass1[i]) {
                    len_mass1--;
                    break;
                }
            }
        }
        for (int a = 0; a < mass2.length; a++){
            for (int i = a + 1; i < mass2.length; i++){
                if (mass2[a] == mass2[i]) {
                    len_mass2--;
                    break;
                }
            }
        }
        if (len_mass1 == len_mass2) return true;
        else return false;
    }
    public static boolean isKaprekar(int var){
        int square = var * var;
        String str = String.valueOf(square);
        String first = str.substring(0, str.length()/2);
        String last = str.substring(str.length()/2, str.length());
        int first_int = Integer.parseInt(first.trim());
        int last_int = Integer.parseInt(last.trim());
        int sum = first_int + last_int;
        if (sum == var) return true;
        else return false;
    }
    
 
        




}
