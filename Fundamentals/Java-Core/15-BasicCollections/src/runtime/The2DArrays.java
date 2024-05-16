package runtime;

import java.util.Arrays;

//work with grid use 2d Array
public class The2DArrays {

  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }
    board[0][0] = '0';
    board[1][0] = '0';
    board[2][0] = '0';

    //Exact same as above array but i define in other way
    char[][] boardTwo = new char[][]{
        new char[]{'0', '-', '-'},
        new char[]{'0', '-', '-'},
        new char[]{'0', '-', '-'},
    };

    //Traversal 2d Array Using deep, not toString
    System.out.println("First way "+Arrays.deepToString(board));
    System.out.println("Second way"+Arrays.deepToString(boardTwo));
  }
}
