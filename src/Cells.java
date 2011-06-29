import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
   
   public void input() {
      for (int j=0; j<cells.length; j++) {
         System.out.println((j+1) + ". row");
         for (int i=0; i<cells.length; i++) {
            System.out.print(" "+(i+1)+". col: ");
            cells[j][i] = readCell(j, i);
         }
      }
      System.out.println("Thank you!");
   }
   
   private int readCell(int row, int col) {
      String line = "";
      int value = 0;
      try {
         BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
         line = is.readLine();
         value = parse(line);
      } catch (IOException e) {
         e.printStackTrace();
      } catch (Exception e) {
         System.out.print(" again : ");
         value = readCell(row, col);
      }
      return value;
   }
   
   public int parse(String line) throws Exception {
      int value = 0;
      if (!"".equals(line)) {
         try {
            value = Integer.parseInt(line);
         } catch (NumberFormatException e) {
            throw new Exception("Not a number!");
         }
         if (value < 1 || value > this.size) {
            throw new Exception("Out of range!");
         }
      }
      return value;
   }
   
   public void output() {
      for (int j=0; j<cells.length; j++) {
         if (j % 3 == 0) System.out.println(" +-------+-------+-------+ ");
         for (int i=0; i<cells.length; i++) {
            if (i % 3 == 0) System.out.print(" |");
            System.out.print(" ");
            if (cells[j][i] != 0) {
               System.out.print(cells[j][i]);
            } else {
               System.out.print(" ");
            }
         }
         System.out.println(" |");
      }
      System.out.println(" +-------+-------+-------+ ");
   }
}
