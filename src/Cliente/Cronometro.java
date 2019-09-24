/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Vista.FrmVistaJuego;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import static java.lang.Thread.sleep;

/**
 *
 * @author alvar
 */
public class Cronometro extends Thread {

    int segu = 0;

    public Cronometro(String name) {
        super(name);
    }

    @Override
    public void run() {

        FrmVistaJuego.lblTiempo.setText(segu + "");

        while (true) {

            try {

                sleep(1000);
                segu++;
                FrmVistaJuego.lblTiempo.setText(segu + "");

                
            } catch (InterruptedException ex) {
            }

        }

    }

}
