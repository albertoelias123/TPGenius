/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgenius;

import static java.lang.Thread.sleep;
import static tpgenius.Principal.verde;
import static tpgenius.Principal.vermelho;
import static tpgenius.Principal.amarelo;
import static tpgenius.Principal.azul;

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
        this.acende(this.idButton);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("\tApagando");
        this.apaga(idButton);
    }

    public void acende(int idButton) {
        switch (idButton) {
            case 1:
                verde.setBackground(new java.awt.Color(0, 255, 0));
                break;
            case 2:
                vermelho.setBackground(new java.awt.Color(255, 0, 0));
                break;
            case 3:
                amarelo.setBackground(new java.awt.Color(255, 255, 0));
                break;
            case 4:
                azul.setBackground(new java.awt.Color(0, 0, 255));
                break;
            default:
                System.out.println("Botão Invalido!");
        }
    }

    public void apaga(int idButton) {
        switch (idButton) {
            case 1:
                verde.setBackground(new java.awt.Color(145, 255, 145));
                break;
            case 2:
                vermelho.setBackground(new java.awt.Color(251, 130, 130));
                break;
            case 3:
                amarelo.setBackground(new java.awt.Color(242, 242, 155));
                break;
            case 4:
                azul.setBackground(new java.awt.Color(140, 161, 248));
                break;
            default:
                System.out.println("Botão Invalido!");
        }
    }

    public void pisca(int idButton) {
        Thread t1 = new Thread() {
            public void run() {
                switch (idButton) {
                    case 1:
                        acende(1);
                        break;
                    case 2:
                        acende(2);
                        break;
                    case 3:
                        acende(3);
                        break;
                    case 4:
                        acende(4);
                        break;
                    default:
                        System.out.println("Botão Invalido!");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switch (idButton) {
                    case 1:
                        apaga(1);
                        break;
                    case 2:
                        apaga(2);
                        break;
                    case 3:
                        apaga(3);
                        break;
                    case 4:
                        apaga(4);
                        break;
                    default:
                        System.out.println("Botão Invalido!");
                }
            }
        };
        t1.start();
    }

    public void acendeTodos() {
        this.acende(1);
        this.acende(2);
        this.acende(3);
        this.acende(4);
    }

    public void apagaTodos() {
        apaga(1);
        apaga(2);
        apaga(3);
        apaga(4);
    }

       public void piscaTodos() {
        pisca(1);
        pisca(2);
        pisca(3);
        pisca(4);
    }

}
