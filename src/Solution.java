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
      if (count-1 == (size*size)) return true;
      int row = count / size;
      int col = count % size;
      count++;
      
      
      if (cells.getCell(row, col) == 0) { // is cell preset or not?
         for (int val = 1; val <= size; val++) { // loop through valid values
            if (isLegal(row,col,  val)) { // can this value be put in current cell
//               System.out.println("r"+row+" v"+col+ " = "+val);
               cells.setCell(row, col, val); // sets cell's value
               if (solve(size, count)) return true;
            }
         } // end of loop through valid values
         if (cells.getCell(row, col) == 0) {
//            System.out.println("r"+row+" v"+col+ " IKKA NULL");
         }
      } else { // next cell if this one is not empty
         if (solve(size, count)) return true;
      }
      cells.setCell(row, col, 0); // reset cell
      return false;
   }
   
   private boolean isLegal(int row, int col, int value) {
      int i = 0, j = 0;
//      int left = col / 3;  // TODO section check
//      int right = left + 1;
//      int top = row / 3;
//      int bottom = top + 1;
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
