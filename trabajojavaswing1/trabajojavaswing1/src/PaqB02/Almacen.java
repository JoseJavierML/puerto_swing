package PaqB02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Almacen extends JFrame {
    private JTextField numeroIdentificacion;
    private JTextField pesot;
    private JTextField empresaRemitente;
    private JTextField empresaReceptora;
    private JComboBox comboBox1;
    private JRadioButton a1RadioButton;
    private JCheckBox inspeccionadoEnAduanasCheckBox;
    private JTextArea Estado;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JTextField numeroColumna;
    private JButton mostrarDatosContenedorButton;
    private JButton cuantosButton;
    private JTextField cuantos;
    private JPanel panel;
    private JTextArea descripcionContenido;
    private JButton crearButton;
    private JTextField MostrarDatos;
    private JTextField PaisProcedencia;
    private JTextField PrioridaD;
    private JTextField CuantosPaisProcedencia;
    private Puerto p;

    public Almacen() {
        setContentPane(panel);
        setTitle("Gestion de contenedores");
        setSize(1080, 720);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                p = new Puerto();

            }
        });


        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int id = Integer.parseInt(numeroIdentificacion.getText());
                float peso = Float.parseFloat(pesot.getText());
                String pais = PaisProcedencia.getText();
                boolean aduana = Boolean.parseBoolean(inspeccionadoEnAduanasCheckBox.getText());
                int prioridad = Integer.parseInt(PrioridaD.getText());
                String descripcion = descripcionContenido.getText();
                String envia = empresaRemitente.getText();
                String recibe = empresaReceptora.getText();
                Contenedor c = new Contenedor(id, peso, pais, aduana, prioridad, descripcion, envia, recibe);
                p.apilarContenedor(c);
            }
        });

        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(p != null){
                    int columna = Integer.parseInt(numeroColumna.getText());
                    p.desapilarContenedor(columna);

                }
            }
        });


        mostrarDatosContenedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (p != null) {
                    int id = Integer.parseInt(numeroIdentificacion.getText());
                    MostrarDatos.setText(String.valueOf(p.mostrarDatos(id)));
                }
            }
        });


        cuantosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (p != null) {

                    String pais = PaisProcedencia.getText();
                    CuantosPaisProcedencia.setText(pais);
                    int contador=p.cuentaContenedores(pais);
                    cuantos.setText(String.valueOf(contador));
                }
            }
        });

    }

    public static void main(String[] args) {
        Almacen contenedor1 = new Almacen();
    }
}



