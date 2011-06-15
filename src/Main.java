
/**
 * @author raido
 */
public class Main {
   
   public static void main(String args[]) {
      
      Cells cells = new Cells(9);
      
      // http://es.wikipedia.org/wiki/Archivo:Sudoku-by-L2G-20050714.gif
      
      cells.setCell(0, 0, 5);
      cells.setCell(0, 1, 3);
      cells.setCell(0, 4, 7);
      
      cells.setCell(1, 0, 6);
      cells.setCell(1, 3, 1);
      cells.setCell(1, 4, 9);
      cells.setCell(1, 5, 5);
      
      cells.setCell(2, 1, 9);
      cells.setCell(2, 2, 8);
      cells.setCell(2, 7, 6);
      
      
      cells.setCell(3, 0, 8);
      cells.setCell(3, 4, 6);
      cells.setCell(3, 8, 3);
      
      cells.setCell(4, 0, 4);
      cells.setCell(4, 3, 8);
      cells.setCell(4, 5, 3);
      cells.setCell(4, 8, 1);

      cells.setCell(5, 0, 7);
      cells.setCell(5, 4, 2);
      cells.setCell(5, 8, 6);

      cells.setCell(6, 1, 6);
      cells.setCell(6, 6, 2);
      cells.setCell(6, 7, 8);
      
      cells.setCell(7, 3, 4);
      cells.setCell(7, 4, 1);
      cells.setCell(7, 5, 9);
      cells.setCell(7, 8, 5);
      
      cells.setCell(8, 4, 8);
      cells.setCell(8, 7, 7);
      cells.setCell(8, 8, 9);
      
      System.out.println("INPUT:");
      cells.output();
      
      System.out.println("SOLUTION:");
      new Solution(cells);
      
      // manual input
      
      Cells cellsm = new Cells(9);
      cellsm.input();
      cellsm.output();
      new Solution(cellsm);
   }
   
   
}
