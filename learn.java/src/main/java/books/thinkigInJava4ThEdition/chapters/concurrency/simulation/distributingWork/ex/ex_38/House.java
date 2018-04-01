package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

import java.util.stream.Stream;

class House {
    private static int counter= 0;
    private final  int id = ++counter;


    private char[][] matrix = new char[22][29];
    {
        for(int i = 0; i < 22; i++) {
            for(int j = 0; j < 29; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    public static void main(String[] args) {
        House h = new House();
        h.print();
    }

    synchronized void foundation() {

        horizontal(2, 27, 19);
        horizontal(0, 29, 21);

        vertical(20, 22, 1);
        vertical(20, 22, 27);
    }

    synchronized void frame() {
        vertical(5, 19, 3);
        vertical(5, 19, 25);
    }

    synchronized void roof() {
        horizontal(2, 27, 5);
        leftRoof();
        rightRoof();
        horizontal(6, 22, 0);
    }

    synchronized void window() {
        vertical(9, 15, 6);
        vertical(9, 15, 11);
        horizontal(7, 11, 8);
        horizontal(7, 11, 15);
    }

    synchronized void door() {
        vertical(9, 19, 16);
        vertical(9, 19, 21);
        horizontal(17, 21, 8);
        horizontal(17, 21, 15);
    }


    synchronized void leftRoof() {
        for(int i = 4, j = 2; i > 0; i--, j++) {
            matrix[i][j] = '/';
        }
    }

    synchronized void rightRoof() {
        for(int i = 4, j = 26; i > 0; i--, j--) {
            matrix[i][j] = '\\';
        }
    }

    synchronized void horizontal(int start, int end, int fixed) {
        for(int i = start; i < end; i++) {
            matrix[fixed][i] = '-';
        }
    }

    synchronized void vertical(int start, int end, int fixed) {
        for(int i = start; i < end; i++) {
            matrix[i][fixed] = '|';
        }
    }

    synchronized void built() {
        foundation();
        frame();
        roof();
        window();
        door();
        nb();
    }

    private void nb() {
       char[] cs = String.valueOf(id).toCharArray();
        for(int i= 20, j=10, k = 0; k<cs.length; j++, k++){
            matrix[i][j] = cs[k];
        }
    }

    synchronized void print() {
        built();
        Stream.of(matrix).forEach(System.out::println);
        System.out.println("\n\n");
    }
}
