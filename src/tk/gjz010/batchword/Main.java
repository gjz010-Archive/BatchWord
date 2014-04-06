/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.gjz010.batchword;

import java.applet.Applet;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class Main extends JFrame{
    BatchWordApplet m;
    public Main(){
        super();
        this.setIconImage(MainFrame.getIcon());
        m=new BatchWordApplet();
        m.setBounds(0,0,500,500);
        this.setContentPane(m);
        m.init();
m.start();
        //this.setBounds(0,0,m.getPreferredSize().width,m.getPreferredSize().height);
this.pack();
        this.setLocationRelativeTo(null);
        this.setTitle(m.getVer());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        Main m=new Main();
        m.setVisible(true);
    }
}
