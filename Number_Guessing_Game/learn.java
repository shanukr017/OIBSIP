import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class learn {
    static int num = (int) Math.ceil(Math.random()*100);
    static int chance = 5;
    public static void main(String[] args) {
      window mk = new window();
      mk.createWindow();
      System.out.println(num);
   }

}

class window{
    void createWindow(){
        
        JFrame frame = new JFrame("learn.number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        JLabel label1 = new JLabel("Enter a number between 1 to 100");
        label1.setBounds(30, 20, 250, 30);
        JLabel label4 =  new JLabel("Remaining chances : "+learn.chance);
        label4.setBounds(30,200,250,30);
        JLabel label = new JLabel("Enter a number");
        label.setBounds(30, 50, 100, 30);
        JLabel label3 = new JLabel("Result :");
        label3.setBounds(30, 170, 500, 30);
        JTextField ans = new JTextField();
        ans.setBounds(30,80, 200, 30);
        JButton btn = new JButton("Submit");
        btn.setBounds(30, 120, 100, 30);
        JButton btn2 = new JButton("Play Again");
        btn2.setBounds(150, 120, 100, 30);
        btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if(learn.chance > 0){
                        learn.chance = learn.chance-1;
                    }
                    else{
                        frame.remove(btn);                        
                    }
                    label4.setText("Remaining chances : "+learn.chance);
                    int nums = Integer.parseInt(ans.getText());
                    if(learn.num == nums){
                        label3.setText("Game Over!!! Your Score : "+((learn.chance+1)*20));
                        frame.remove(btn);
                    }
                    else if(learn.num > nums){
                        label3.setText("Result : Try Guessing Larger number");
                    }
                    else{
                        label3.setText("Result : Try Guessing Smaller number");
                    }
                }            
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                learn.chance = 5;
                learn.num = (int) Math.ceil(Math.random()*100);
                System.out.println(learn.num);
                frame.add(btn);
                label3.setText("Result : ");
                label4.setText("Remaining chances : "+learn.chance);
                ans.setText(null);
            }
        });
        frame.add(label1);
        frame.add(label);
        frame.add(label3);
        frame.add(label4);
        frame.add(ans);
        frame.add(btn);
        frame.add(btn2);
        frame.setLayout(null);
        frame.setVisible(true);
   }
}