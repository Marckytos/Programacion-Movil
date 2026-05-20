import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Programa_edad extends JFrame implements ActionListener {

    JTextField edad1, edad2;
    JButton calcular;
    JPanel panel01;

    public Programa_edad(){
        setTitle("Calculadora de mayor de edad");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        edad1 = new JTextField(6);
        edad2 = new JTextField(6);
        calcular = new JButton("Calcular");
        panel01 = new JPanel();

        panel01.add(edad1);
        panel01.add(edad2);
        panel01.add(calcular);

        calcular.addActionListener(this);
        add(panel01);

    }

    public static void main(String[] args) {
        Programa_edad edad = new Programa_edad();
        edad.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String e1 = edad1.getText();
        String e2 = edad2.getText();

        int edad1 = Integer.parseInt(e1);
        int edad2 = Integer.parseInt(e2);

        if (edad1==edad2){
            JOptionPane.showMessageDialog(null,"Las 2 personas tienen la misma edad");
        } else {

            if (edad1>edad2){
                JOptionPane.showMessageDialog(null,"La persona 1 es mayor porque tiene "+edad1+ " años");
            } else {
                JOptionPane.showMessageDialog(null,"La persona 2 es mayor porque tiene "+edad2+ " años");
            }
        }


    }

}


