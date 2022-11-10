public class Test2 {
    public static void main(String[] args) {

        for(int i = 0; i < 4; i++){
            for(int j = 0; j <= i; j++){
                System.out.println("*");
            }
        }

        /**
         * i = 0, 0 < 4
         *  j = 0, 0 <= 0 -> println("*");
         *  j = 1, 1 <= 0 -> 탈출;
         * i = 1
         *  j = 0, 0 <= 1 -> println("*");
         *  j = 1, 1 <= 1 -> println("*");
         *  j = 2, 2 <= 1 -> 탈출;
         * i = 2
         * i = 3
         */
    }
}
