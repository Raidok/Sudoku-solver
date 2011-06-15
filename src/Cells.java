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
      for (int j=0; j<cells.length; j++) {
         if (j % 3 == 0) System.out.println(" +-------+-------+-------+ ");
         for (int i=0; i<cells.length; i++) {
            if (i % 3 == 0) System.out.print(" |");
            System.out.print(" " + cells[j][i]);
         }
         System.out.println(" |");
      }
      System.out.println(" +-------+-------+-------+ ");
   }
}
