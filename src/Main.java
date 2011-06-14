
/**
 * @author raido
 */
public class Main {
   
   public static void main(String args[]) {
      
      Cells cells = new Cells(9);
      
      cells.setCell(0, 0, 9);
      cells.setCell(0, 1, 6);
      cells.setCell(0, 2, 3);
      cells.setCell(1, 0, 1);
      System.out.println("SISESTATUD:");
      cells.output();
      
      Solution solution = new Solution(cells);
      System.out.println("LAHENDUS:");
      solution.output();
      
   }
   
   
}
