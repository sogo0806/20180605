import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame2 extends JFrame {
    private JLabel jlb = new JLabel();
    private JLabel jlb2 = new JLabel();
    private JLabel jlb3 = new JLabel();
    private ImageIcon imag = new ImageIcon("12.png");
    private ImageIcon imag2 = new ImageIcon("13.png");
    private ImageIcon imag3 = new ImageIcon("11.jpg");
    private Container cp;
    private Timer t1;

    public MainFrame2(){
        init();
    }
    private void init (){
        this.setBounds(0,0,500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(null);

        Image img = imag.getImage();
        Image img2 = img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        imag.setImage(img2);
        jlb.setBounds(200,250,150,80);
        jlb.setIcon(imag);
        cp.add(jlb);


        img = imag3.getImage();
        img2 = img.getScaledInstance(30,60,Image.SCALE_SMOOTH);
        imag3.setImage(img2);
        jlb3.setBounds(jlb.getX()+30,jlb.getY(),30,60);

        Image img5 = imag2.getImage();
        Image img6 = img5.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        imag2.setImage(img6);

        t1 = new Timer(200, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jlb3.getY()<0){
                    t1.stop();
                }
                jlb3.setLocation(jlb3.getX(),jlb3.getY()-5);
            }
        });



        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               switch (e.getKeyCode()){
                   case KeyEvent.VK_LEFT:
                       jlb.setIcon(imag);
                       jlb.setLocation(jlb.getX()-5,jlb.getY());
                       break;

                   case KeyEvent.VK_RIGHT:

                       jlb.setIcon(imag2);
                       jlb.setLocation(jlb.getX()+5,jlb.getY());
                       break;

                   case KeyEvent.VK_SPACE:
                       jlb3.setIcon(imag3);
                       cp.add(jlb3);
                       jlb3.setLocation(jlb.getX()+30,jlb.getY()-5);
                       t1.start();
               }
            }
        });
    }

}
