import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author raido
 */
@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener {

   private int dimensions;
   private Container contentPane;
   private JPanel cellPanel;
   private Cells undoCells;
   
   public Window(int dimensions) {
      this.dimensions = dimensions;
      undoCells = new Cells(dimensions);
      setTitle("Sudoku solver");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      initUI();
      setVisible(true);
      setSize(500, 500);
   }
   
   private void initUI() {
      contentPane = getContentPane();
      contentPane.setLayout(new BorderLayout(2, 1));
      cellPanel = new JPanel(new GridLayout(this.dimensions, this.dimensions));
      
      JTextField field = null;
      for (int i = 0; i < dimensions; i++) {
         for (int j = 0; j < dimensions; j++) {
            field = new JTextField(2);
            field.setHorizontalAlignment(JTextField.CENTER);
            cellPanel.add(field, j);
         }
      }
      contentPane.add(cellPanel, BorderLayout.CENTER);
      
      JPanel Btns = new JPanel(new GridLayout(1, 3));
      
      JButton cleanBtn = new JButton("Clean");
      cleanBtn.setActionCommand("clean");
      cleanBtn.addActionListener(this);
      Btns.add(cleanBtn);
      
      JButton undoBtn = new JButton("<- Undo ->");
      undoBtn.setActionCommand("undo");
      undoBtn.addActionListener(this);
      Btns.add(undoBtn);
      
      JButton goBtn = new JButton("Solve");
      goBtn.setActionCommand("solve");
      goBtn.addActionListener(this);
      Btns.add(goBtn);
      
      contentPane.add(Btns, BorderLayout.SOUTH);
      
   }
   
   public Cells getCells(boolean ignore) throws Exception {
      boolean ok = true;
      Cells cells = new Cells(dimensions);
      JTextField field = null;
      
      for (int i = 0; i<dimensions*dimensions; i++) {
         field = (JTextField)cellPanel.getComponent(i);
         try {
            cells.setCell(i/dimensions, i%dimensions, cells.parse(field.getText()));
//            field.setBackground(new Color(255, 255, 255));
            field.setToolTipText("");
         } catch (Exception e) {
            field.setBackground(new Color(255, 180, 190)); // errorous cells get red background
            field.setToolTipText(e.getMessage()); // thrown message gets added as a tooltip to the errorous cell
            ok = false;
         }
         
      }
      cells.output();
      if (!ok && !ignore) throw new Exception("Errors!");
      return cells;
   }
   
   public void setCells(Cells cells, boolean update) {
      JTextField field = null;
      boolean wasNotSet = false;
      int row = 0, col = 0;
      for (int i = 0; i<dimensions*dimensions; i++) {
         row = i/dimensions;
         col = i%dimensions;
         field = (JTextField)cellPanel.getComponent(i);
         wasNotSet = field.getText().equals("");
         field.setText(toCellString(cells.getCell(row, col)));
         if (undoCells.getCell(row, col) == 0 && update) {
            if (update && wasNotSet) {
               field.setBackground(new Color(190, 255, 190)); // updated cells are coloured green
            } else {
               field.setBackground(new Color(255, 255, 255)); // colors get reset back to white when cleaning
            }
         }
      }
   }

   private String toCellString(int value) {
      return value == 0 ? "" : Integer.toString(value);
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      if ("solve".equals(event.getActionCommand())) {
         try {
            System.out.println("SOLVING");
            Cells cells = this.getCells(false);
            Solution sol = new Solution(cells);
            setCells(sol.getCells(), true);
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
         
      } else if ("undo".equals(event.getActionCommand())) {
         System.out.println("UNDOING");
         setCells(undoCells, false);
         
      } else if ("clean".equals(event.getActionCommand())) {
         try {
            System.out.println("CLEANING");
            undoCells = this.getCells(true);
         } catch (Exception ee) {
         } finally {
            setCells(new Cells(dimensions), false);
         }
      }
   }
}
