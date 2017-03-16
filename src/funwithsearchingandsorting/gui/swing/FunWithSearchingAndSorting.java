/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.swing;

import funwithsearchingandsorting.gui.swing.SearchPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author stegg_000
 */
public class FunWithSearchingAndSorting
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {

            @Override
            public void run()
            {
                JFrame frame = new JFrame("Searching Algorithms");
                frame.add(new SearchPanel());
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

}
