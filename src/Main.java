
/**
 * @author raido
 */
public class Main {
   
   public static void main(String args[]) {
      
      Cells cells = new Cells(9);
      
      cells.setCell(0, 0, 9);
      cells.setCell(0, 1, 6);
      cells.setCell(0, 2, 3);
      cells.setCell(0, 3, 6);
      cells.setCell(0, 4, 5);
      cells.setCell(0, 5, 2);
      cells.setCell(0, 6, 4);
      cells.setCell(0, 7, 1);
      cells.setCell(0, 8, 8);
      
      cells.setCell(1, 0, 2);
      cells.setCell(1, 1, 4);
      cells.setCell(1, 2, 6);
      System.out.println("SISESTATUD:");
      cells.output();
      
      Solution solution = new Solution(cells);
      System.out.println("LAHENDUS:");
      solution.output();
      
   }
   
   
}
