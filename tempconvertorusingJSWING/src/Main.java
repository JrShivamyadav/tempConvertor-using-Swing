import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JRadioButton CtoF,FtoC;
    JTextField tftemp;
    int result;
JButton convert;
    Main() {


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tempconv.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(200, 100, 700, 200);
         add(image);

        JLabel heading = new JLabel("TEMPERATURE CONVERTOR");
        heading.setBounds(100,30,1300,60);
        heading.setFont(new Font("serif",Font.BOLD,25));
        heading.setForeground(Color.red);
        image.add(heading);

         JLabel lbltemp = new JLabel("Enter value(°C/°F):");
         lbltemp.setBounds(50,100,300,30);
         lbltemp.setFont(new Font("serif",Font.BOLD,20));
         lbltemp.setBackground(Color.white);
         lbltemp.setForeground(Color.black);
         image.add(lbltemp);

         tftemp = new JTextField();
         tftemp.setBounds(250,100,250,30);
        tftemp.setFont(new Font("serif",Font.BOLD,20));
        tftemp.setBackground(Color.white);
        tftemp.setForeground(Color.black);
         image.add(tftemp);

         CtoF = new JRadioButton("Convert C to F");
         CtoF.setBounds(150,150,150,30);
         image.add(CtoF);

         FtoC = new JRadioButton("Convert F to C");
        FtoC.setBounds(300,150,150,30);
        image.add(FtoC);


        ButtonGroup btn = new ButtonGroup();
        btn.add(CtoF);
        btn.add(FtoC);



        convert = new JButton("Convert");
        convert.setBounds(230,250,100,30);
        convert.setBackground(Color.black);
        convert.setForeground(Color.WHITE);
        convert.addActionListener(this);
        image.add(convert);

       setSize(550,400);
       setLocation(300,50);
       setVisible(true);
       setLayout(null);
    }

    public static void main(String[] args) {
new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Integer value = Integer.valueOf(tftemp.getText());
        try {
            if (value.equals("")) {
                JOptionPane.showMessageDialog(null, "Value is required");
            } else if(e.getSource()==convert ){
                if (CtoF.isSelected()){
                    result=(value*9/5)+32;
                    JOptionPane.showMessageDialog(null,"Your output is "+"\n"+result+"F");
                }
                else if (FtoC.isSelected()) {
                    result=((value-32)*5)/9;
                    JOptionPane.showMessageDialog(null,"Your output is "+"\n"+result+"C");
                }

            }
        }
    catch (Exception ae){
            System.out.println(ae);
        }

    }
}
