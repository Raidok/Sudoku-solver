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
      
      if (cells.getCell(row, col) == 0) { // is cell preset or not?
         for (int val = 1; val <= size; val++) { // loop through valid values
            if (isLegal(col, row, val)) { // can this value be put in current cell
               cells.setCell(row, col, val); // sets cell's value
               
               if (count < (size*size)) {
                  return solve(size, count);
               } else {
                  return true;
               }
            }
         } // end of loop through valid values
         return false;
      }
      
      count++;
      
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
