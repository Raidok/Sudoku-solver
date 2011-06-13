/**
 * @author raido
 */
public class Solver {

   private Cells cells;
   
   public Solver(Cells cells) {
      this.cells = cells;
   }
   
   public void solve() {
      int size = cells.getSize();
      
      int row = cells.getSize() / 9;
      int col = cells.getSize() % 9;
      
   }
   
   public boolean isLegal(int col, int row, int value) {
      for (int[] rowOfCells : cells.getCells()) {
         for (int cellValue : rowOfCells) {
            
         }
      }
      return false;
   }
   
   private boolean isLegalInRow(int row, int value) {
      for (int[] rowOfCells : cells.getCells()) {
         for (int cellValue : rowOfCells) {
            
         }
      }
      return false;
   }
   
}
