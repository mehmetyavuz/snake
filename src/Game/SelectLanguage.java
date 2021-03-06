package Game;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author mehmetyavuz
 */
public class SelectLanguage extends JFrame {

    /**
     * Creates new form SelectLanguage
     */
    public SelectLanguage() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new JComboBox();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(new Point(450, 250));

        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "ENGLISH", "DEUTSCH", "FRANÇAIS", "ITALIANO", "TÜRKÇE" }));
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Select");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(GroupLayout.LEADING, false)
                    .add(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jButton1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.RELATED)
                .add(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Locale selected = Locale.UK;
        if(this.jComboBox1.getSelectedIndex() == 1)
            selected = Locale.GERMANY;
        else if(this.jComboBox1.getSelectedIndex() == 2)
            selected = Locale.FRANCE;
        else if(this.jComboBox1.getSelectedIndex() == 3)
            selected = Locale.ITALY;

        Properties prop = new Properties();

        try {
            String str = "src/DefaultLang.properties";

            prop.load(new FileInputStream(str));
            prop.setProperty("Language", selected.toString());
            prop.setProperty("check", "1");
            prop.store(new FileOutputStream(str), "storing");
            GlobalDataStore.rb = ResourceBundle.getBundle("Locale", selected);

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        dispose();

        GlobalDataStore.currentLang = selected;
        GlobalFunctionStore.snake.begin();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton1;
    private JComboBox jComboBox1;
    // End of variables declaration//GEN-END:variables
}
