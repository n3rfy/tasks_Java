public class Block1{
    public static void main(String[] args){
        System.out.println(convert(5));
        System.out.println(points(13, 12));
        System.out.println(footballPoints(3,4,2));
        System.out.println(divisibleByFive(-55));
        System.out.println(and(true, false));
        System.out.println(howManyWalls(54,1,43));
        System.out.println(squaed(9));
        System.out.println(profitableGamble(0.2,50,9));
        System.out.println(frames(10, 25));
        System.out.println(mod(218,5));
    }

    public static int convert(int x){
        return x * 60;
    }

    public static int points(int x, int y){
        return x*2+y*3;
    }

    public static int footballPoints(int x, int y, int z){
        return x*3+y;
    }

    public static boolean divisibleByFive(int x){
        return x%5 == 0;
    }
    
    public static boolean and(boolean x, boolean y){
        return x && y;
    }

    public static int howManyWalls(int n, int w, int h){
        return n / (w*h); 
    }
    
    public static int squaed(int a) {
        return a * a;
    }

    public static boolean profitableGamble(double prob, int prize, int pay){
        return prob * prize > pay;
    }
    
    public static int frames(int x, int y){
        return x*y*60;
    }

    public static int mod(int x, int y){
        return x % y;
    }
}
