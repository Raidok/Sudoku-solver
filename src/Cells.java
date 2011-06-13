/**
 * @author raido
 */
public class Cells {

   private int[][] cells;
   private int size;
   
   public Cells(int size) {
      cells = new int[size][size];
      this.size = size;
   }

   public int getSize() {
      return size;
   }

   public int[][] getCells() {
      return cells;
   }
   
   public int getCell(int row, int col) {
      return this.cells[row][col];
   }

   public void setCell(int row, int col, int cell) {
      this.cells[row][col] = cell;
   }
   
   public void output() {
      for (int[] row : cells) {
         for (int cell : row) {
            System.out.print(" " + cell);
         }
         System.out.println();
      }
   }
}
