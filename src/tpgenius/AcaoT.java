/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgenius;

import static java.lang.Thread.sleep;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static tpgenius.Principal.vermelho;
import static tpgenius.Principal.amarelo;
import static tpgenius.Principal.azul;
import static tpgenius.Principal.verde;

/**
 *
 * @author lucas
 */
public class AcaoT extends Thread {

    private int idButton;

    AcaoT(int idButton) {
        this.idButton = idButton;
        start();
    }

    public void run() {
        //System.out.println("\tAcendendo");
        acende();
        try {
            sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        apaga();
        //System.out.println("\tApagando");
        try {
            sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void acende() {
        switch (this.idButton) {
            case 1:
                enableButton(verde);
                break;
            case 2:
                enableButton(vermelho);
                break;
            case 3:
                enableButton(amarelo);
                break;
            case 4:
                enableButton(azul);
                break;
            default:
                disableButtons();
                JOptionPane.showMessageDialog(null, "Botão inválido");
        }
    }

    private void apaga() {
        switch (this.idButton) {
            case 1:
                disableButton(verde);
                break;
            case 2:
                disableButton(vermelho);
                break;
            case 3:
                disableButton(amarelo);
                break;
            case 4:
                disableButton(azul);
                break;
            default:
                disableButtons();
                JOptionPane.showMessageDialog(null, "Botão inválido");
        }
    }

    private void disableButtons() {
        disableButton(verde);
        disableButton(vermelho);
        disableButton(amarelo);
        disableButton(azul);
    }

    private void disableButton(JButton button) {
        button.setEnabled(false);
    }

    private void enableButton(JButton button) {
        button.setEnabled(true);
    }
}
