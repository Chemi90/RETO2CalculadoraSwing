package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalculadora extends JFrame implements ActionListener {
    private JPanel calculadora;
    private JTextField txtDisplay;
    private JButton btnAc, btnRestar, btnMultiplicar, btnDividir, btnIgual, btnRetroceso,
            btn7, btn4, btn1, btnSumar, btnDecimal, btnNegativo,  btn00, btn8, btn5, btn2, btn0, btn9, btn6, btn3;
    private String operator = "";
    private double firstOperand = 0;
    private double secondOperand = 0;

    public VentanaCalculadora() {
        // Inicializar la ventana
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear y configurar el panel
        calculadora = new JPanel();
        calculadora.setLayout(new GridLayout(5, 4, 5, 5));

        // Inicializar los componentes
        txtDisplay = new JTextField();
        txtDisplay.setPreferredSize(new Dimension(240, 60));
        txtDisplay.setFont(new Font("Arial", Font.PLAIN, 24));
        txtDisplay.setEditable(false);

        btnAc = new JButton("AC");
        btnRetroceso = new JButton("←");
        btnRestar = new JButton("-");
        btnMultiplicar = new JButton("*");
        btnDividir = new JButton("/");
        btnIgual = new JButton("=");
        btn7 = new JButton("7");
        btn4 = new JButton("4");
        btn1 = new JButton("1");
        btnSumar = new JButton("+");
        btn8 = new JButton("8");
        btn5 = new JButton("5");
        btn2 = new JButton("2");
        btn0 = new JButton("0");
        btn9 = new JButton("9");
        btn6 = new JButton("6");
        btn3 = new JButton("3");
        btnNegativo = new JButton("±");

        // Agregar ActionListener a los botones
        btnAc.addActionListener(this);
        btnRetroceso.addActionListener(this);
        btnRestar.addActionListener(this);
        btnMultiplicar.addActionListener(this);
        btnDividir.addActionListener(this);
        btnIgual.addActionListener(this);
        btn7.addActionListener(this);
        btn4.addActionListener(this);
        btn1.addActionListener(this);
        btnSumar.addActionListener(this);
        btn8.addActionListener(this);
        btn5.addActionListener(this);
        btn2.addActionListener(this);
        btn0.addActionListener(this);
        btn9.addActionListener(this);
        btn6.addActionListener(this);
        btn3.addActionListener(this);
        btnDecimal.addActionListener(this);
        btn00.addActionListener(this);
        btnNegativo.addActionListener(this);

        // Agregar componentes al panel
        calculadora.add(txtDisplay);
        calculadora.add(btnAc);
        calculadora.add(btnRestar);
        calculadora.add(btnMultiplicar);
        calculadora.add(btnDividir);
        calculadora.add(btn7);
        calculadora.add(btn8);
        calculadora.add(btn9);
        calculadora.add(btnSumar);
        calculadora.add(btn4);
        calculadora.add(btn5);
        calculadora.add(btn6);
        calculadora.add(btn1);
        calculadora.add(btn2);
        calculadora.add(btn3);
        calculadora.add(btn0);
        calculadora.add(btn00);
        calculadora.add(btnDecimal);
        calculadora.add(btnIgual);
        calculadora.add(btnRetroceso);
        calculadora.add(btnNegativo);

        // Agregar el panel a la ventana
        add(calculadora);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();

        switch (buttonText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                String currentText = txtDisplay.getText();
                txtDisplay.setText(currentText + buttonText);
                break;

            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonText;
                firstOperand = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText("");
                break;

            case "AC":
                txtDisplay.setText("0");
                operator = "";
                firstOperand = 0;
                secondOperand = 0;
                break;

            case "=":
                if (operator.isEmpty()) {
                    return;
                }

                secondOperand = Double.parseDouble(txtDisplay.getText());
                double result = performOperation(firstOperand, secondOperand, operator);
                txtDisplay.setText(Double.toString(result));
                operator = "";
                break;
            case "←":
                String retroceso = txtDisplay.getText();
                if (!retroceso.isEmpty()) {
                    txtDisplay.setText(retroceso.substring(0, retroceso.length() - 1));
                }
                break;

            case "+/-":
                String displayText = txtDisplay.getText();
                if (!displayText.isEmpty() && !displayText.equals("0")) {
                    double value = Double.parseDouble(displayText);
                    value = -value;
                    txtDisplay.setText(Double.toString(value));
                }
                break;

            case "00":
                String texto00 = txtDisplay.getText();
                if (!texto00.equals("0")) {
                    txtDisplay.setText(texto00 + "00");
                }
                break;

            case ".":
                String textoPunto = txtDisplay.getText();
                if (!textoPunto.contains(".")) {
                    txtDisplay.setText(textoPunto + ".");
                }
                break;
            case "±":
                String textoPosNeg = txtDisplay.getText();
                if (!textoPosNeg.isEmpty() && !textoPosNeg.equals("0")) {
                    double value = Double.parseDouble(textoPosNeg);
                    value = -value;
                    txtDisplay.setText(Double.toString(value));
                }
                break;
            default:
                break;
        }
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;

            case "-":
                return operand1 - operand2;

            case "*":
                return operand1 * operand2;

            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case "AC":
                txtDisplay.setText("");
                operator = "";
                firstOperand = 0;
                secondOperand = 0;
                return 0.0;
            case "+/-":
                return -operand2; // This negates the second operand

            case "00":
                return Double.parseDouble(operand1 + "00");
            case "±":
                return -operand2;

            case ".":
                return Double.parseDouble(operand1 + ".0");
            default:
                return 0.0;
        }
    }

    public void mostrar() {
        setVisible(true);
    }
}