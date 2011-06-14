/**
 * @author raido
 */
public class Solution {

   private Cells cells;
   
   public Solution(Cells cells) {
      this.cells = cells;
      int size = cells.getSize();
      System.out.println("Lahendus leitud: "+solve(size, 0));
   }
   
   public void output() {
      cells.output();
   }
   
   private boolean solve(int size, int count) {
      int row = count / size;
      int col = count % size;
      
//      System.out.println("rida "+row+" veerg "+col);
      
      if (cells.getCell(row, col) == 0) {
         for (int val = 1; val <= size; val++) {
            boolean legal = isLegal(col, row, val);
//            System.out.println("r"+row+" v"+col+" -> "+val+" "+legal);
            if (legal) {
               cells.setCell(row, col, val);
               break;
            }
         }
         if (cells.getCell(row, col) == 0) {
            return false;
         }
      }
      
      count++;
      if (count < (size*size)) return solve(size, count);
      return true;
   }
   
   private boolean isLegal(int col, int row, int value) {
      int i = 0, j = 0;
      for (int[] rowOfCells : cells.getCells()) {
         for (int cellValue : rowOfCells) {
            if ((j == row || i == col) && cellValue == value) {
//               System.out.println("i:col "+i+":"+col+" /// j:row "+j+":"+row);
               return false;
            }
            i++;
         }
         j++;
         i = 0;
      }
      return true;
   }
   
}
