
/**
 * @author raido
 */
public class Main {
   
   public static void main(String args[]) {
      
      Cells cells = new Cells(9);
      
      cells.setCell(0, 0, 3);
      cells.setCell(0, 1, 4);
      cells.setCell(1, 0, 5);
      cells.output();
      
      Solver solver = new Solver(cells);
   }
   
   
}
