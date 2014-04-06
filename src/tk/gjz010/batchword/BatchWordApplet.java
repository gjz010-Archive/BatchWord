/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.gjz010.batchword;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.InputStream;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FontUIResource;
//import static tk.gjz010.batchword.MainFrame.opt;

/**
 *
 * @author Administrator
 */
public class BatchWordApplet extends javax.swing.JApplet {
    public static Map<String,String> map;
    /**
     * Initializes the applet BatchWordApplet
     */
    @Override
    public void init() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BatchWordApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatchWordApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatchWordApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatchWordApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the applet */
        try {
            map=Unsolver.getstrs();

            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    
                    initComponents();
                    DefaultListModel wds = new DefaultListModel();
//for(Map.Entry<String, String> entry: map.entrySet()) {
// wds.addElement(entry.getKey());
//}
            Comparator cmp = Collator.getInstance(java.util.Locale.CHINA); 
            TreeMap tree=new TreeMap(cmp);    
String[] arr=new String[map.size()];
map.keySet().toArray(arr);
Arrays.sort(arr, cmp);
//wds.clear();
for(String word: arr) {
 wds.addElement(word);
 //System.out.println(word);
}
                    texts.setModel(wds);
                    texts.addListSelectionListener(new ListSelectionListener()
              {
                    public void valueChanged(ListSelectionEvent e)
                     {
                         BatchWordApplet.singleexp.setText(map.get((String)(((JList)e.getSource()).getSelectedValue())));
                      }

               });
                    text.getDocument().addDocumentListener(new DocumentListener(){
public void changedUpdate(DocumentEvent e){ 
updatetext(e);
} 
public void removeUpdate(DocumentEvent e){
    updatetext(e); 
}
public void insertUpdate(DocumentEvent e){
    updatetext(e);
}
public void updatetext(DocumentEvent e){
    chooseWord();
    //System.out.println("STT "+text.getText()+"END");
}
                    });
                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public String getVer(){
        return "BatchWord Pre-release 1";
    }
  public static void initGlobalFontSetting(Font fnt)
{
    FontUIResource fontRes = new FontUIResource(fnt);
    for(Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();)
    {
        Object key = keys.nextElement();
        Object value = UIManager.get(key);
        if(value instanceof FontUIResource)
            UIManager.put(key, fontRes);
    }
}
private void chooseWord(){
    if(map.keySet().contains(text.getText())){
        texts.setSelectedValue(text.getText(),true);
    }
}
    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        maintps = new javax.swing.JTabbedPane();
        single = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texts = new javax.swing.JList();
        text = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        singleexp = new javax.swing.JTextArea();
        multi = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        maintps.setName("maintps"); // NOI18N

        single.setName("single"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        texts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        texts.setName("texts"); // NOI18N
        jScrollPane1.setViewportView(texts);

        text.setName("text"); // NOI18N
        text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textActionPerformed(evt);
            }
        });

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        singleexp.setEditable(false);
        singleexp.setColumns(20);
        singleexp.setLineWrap(true);
        singleexp.setRows(5);
        singleexp.setName("singleexp"); // NOI18N
        jScrollPane2.setViewportView(singleexp);

        javax.swing.GroupLayout singleLayout = new javax.swing.GroupLayout(single);
        single.setLayout(singleLayout);
        singleLayout.setHorizontalGroup(
            singleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(singleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(text)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addContainerGap())
        );
        singleLayout.setVerticalGroup(
            singleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(singleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(singleLayout.createSequentialGroup()
                        .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                .addContainerGap())
        );

        maintps.addTab("单个词语查询", single);

        multi.setName("multi"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane4.setViewportView(jTextArea1);

        jButton1.setText("批量查词");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout multiLayout = new javax.swing.GroupLayout(multi);
        multi.setLayout(multiLayout);
        multiLayout.setHorizontalGroup(
            multiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(multiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, multiLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        multiLayout.setVerticalGroup(
            multiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        maintps.addTab("批量查询", multi);

        jPanel3.setName("jPanel3"); // NOI18N

        jLabel1.setText(getVer());
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addContainerGap(443, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        maintps.addTab("关于", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(maintps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(maintps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        OutputFrame opt=new OutputFrame();
        String text=jTextArea1.getText();
        text=text.replaceAll("\n", " ");
        text=text.replaceAll("( )+", " ");
        if(text.isEmpty()){JOptionPane.showMessageDialog(this,"不得为空！","错误",JOptionPane.INFORMATION_MESSAGE);return;}
        opt.setLocationRelativeTo(null);
        String[] words=text.split(" ");
        for(String w:words){
            if(w.length()==1){JOptionPane.showMessageDialog(this,"不能查单字！","错误",JOptionPane.INFORMATION_MESSAGE);return;}
        }
        for(String w:words){
            int i=opt.addWord(w);
            //new SearchThread(i,w).start();
        }
        opt.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTabbedPane maintps;
    private javax.swing.JPanel multi;
    private javax.swing.JPanel single;
    public static javax.swing.JTextArea singleexp;
    private javax.swing.JTextField text;
    private javax.swing.JList texts;
    // End of variables declaration//GEN-END:variables
}
