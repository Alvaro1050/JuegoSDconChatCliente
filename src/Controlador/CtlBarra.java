/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Barra;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author alvar
 */
public class CtlBarra {
    
    private Barra barra;

    public CtlBarra() {
        barra = new Barra(100, 20);
    }

    public Barra getBarra() {
        return barra;
    }

    public void setBarra(Barra barra) {
        this.barra = barra;
    }
    
    public void moverDerecha(JComponent temp) {
        if (barra.getPosX() < temp.getWidth() - 100) {
            barra.setPosX(barra.getPosX() + 50);
        }
    }


    public void moverIzquierda() {
        if (barra.getPosX() > 0) {
            barra.setPosX(barra.getPosX() - 50);
        }
    }


    public void dibularBarra(Graphics gui, Barra temp) {
        gui.setColor(Color.BLACK);

        gui.fillRect(temp.getPosX(), temp.getPosY(), temp.getAncho(), temp.getAlto());
    }
}
