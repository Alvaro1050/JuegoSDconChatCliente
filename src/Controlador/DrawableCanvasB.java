/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.FrmVistaJuego;
import com.google.gson.Gson;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class DrawableCanvasB extends JComponent implements Runnable {

    private final JComponent temp;
    private CtlBarra ctlBarra;
    public static boolean banderaFinalizado = false;
    boolean exists = false;

    @Override
    public void run() {

        while (true) {
            if (FrmVistaJuego.bolas == 0 && !banderaFinalizado) {
                FrmVistaJuego.crono.stop();
                banderaFinalizado = true;
                JOptionPane.showMessageDialog(this, "Juego finalizo");
                for (int i = 0; i < FrmVistaJuego.usuarios.size(); i++) {
                    if (FrmVistaJuego.usuarios.get(i).getNombreUsuario().equalsIgnoreCase(FrmVistaJuego.nombre)) {
                        exists = true;
                        if (FrmVistaJuego.usuarios.get(i).getTiempo() <= Integer.parseInt(FrmVistaJuego.lblTiempo.getText())) {
                            FrmVistaJuego.usuarios.get(i).setTiempo(Integer.parseInt(FrmVistaJuego.lblTiempo.getText()));
                        }
                        Usuario usu = new Usuario(FrmVistaJuego.nombre, Integer.parseInt(FrmVistaJuego.lblTiempo.getText()), "");
                        Gson gson = new Gson();
                        String json = gson.toJson(usu);
                        FrmVistaJuego.cliente.enviarMensaje(json);
                    }
                }
                if (!exists) {
                    Usuario usu = new Usuario(FrmVistaJuego.nombre, Integer.parseInt(FrmVistaJuego.lblTiempo.getText()), "");
                    Gson gson = new Gson();
                    String json = gson.toJson(usu);
                    FrmVistaJuego.cliente.enviarMensaje(json);
                }

            }
            temp.repaint();
        }

    }

    @Override
    public void paint(Graphics aGC) {
        super.paint(aGC);

        ctlBarra.dibularBarra(aGC, ctlBarra.getBarra());
    }

    public DrawableCanvasB(JComponent jpAreaJuego) {
        super();

        this.setBounds(0, 0, jpAreaJuego.getWidth(), jpAreaJuego.getHeight());

        jpAreaJuego.add(this);

        temp = jpAreaJuego;

        ctlBarra = new CtlBarra();
    }

    public CtlBarra getCtlBarra() {
        return ctlBarra;
    }

    public void setCtlBola(CtlBarra ctlbarra) {
        this.ctlBarra = ctlbarra;
    }
}
