/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.FrmVistaJuego;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author alvar
 */
public class DrawableCanvas extends JComponent implements Runnable {

    private JComponent temp;
    private CtlBola ctlBola;

    @Override
    public void run() {
        ctlBola.cuadrarNumeros();
        while (true) {
            try {
                Thread.sleep(5);

                
                if (!ctlBola.murio) {
                    ctlBola.movimientos(temp);
                    temp.repaint();
                } else {

                }
            } catch (InterruptedException ex) {

            }

        }

    }

    @Override
    public void paint(Graphics aGC) {
        super.paint(aGC);

        ctlBola.dibularBola(aGC, ctlBola.getBola());
    }

    public DrawableCanvas(JComponent jpAreaJuego) {
        super();

        this.setBounds(0, 0, jpAreaJuego.getWidth(), jpAreaJuego.getHeight());

        jpAreaJuego.add(this);

        temp = jpAreaJuego;

        ctlBola = new CtlBola();
    }

    public CtlBola getCtlBola() {
        return ctlBola;
    }

    public void setCtlBola(CtlBola ctlBola) {
        this.ctlBola = ctlBola;
    }


}
