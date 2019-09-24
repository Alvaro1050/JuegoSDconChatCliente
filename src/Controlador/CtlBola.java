/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ball;
import Vista.FrmVistaJuego;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author alvar
 */
public class CtlBola extends javax.swing.JFrame {

    private Ball bola;

    /*
     movimientos
     1 = arribaIzquierda
     2 = abajoIzquierda
     3 = abajoDerecha
     4 = arribaDerecha
     */
    int movimientoActual = 0;
    int movimientoAnterior = 0;
    int velocidad2 = 1;

    boolean murio = false;

    public CtlBola() {
        bola = new Ball(10, 10, ((int) (Math.random() * (400 - 50 + 1)) + 50), ((int) (Math.random() * (400 - 50 + 1)) + 50));
    }

    public Ball getBola() {
        return bola;
    }

    public void setBola(Ball bola) {
        this.bola = bola;
    }

    public void movimientos(JComponent temp) {

        if (movimientoActual == 1 && movimientoAnterior == 4) {
            bajarIzquierdaArriba(temp);

        } else if (movimientoActual == 1 && movimientoAnterior == 2) {
            subirDerechaArriba(temp);

        } else if (movimientoActual == 2 && movimientoAnterior == 3) {
            subirIzquierdaAbajo(temp);

        } else if (movimientoActual == 2 && movimientoAnterior == 1) {
            bajarDerechaAbajo(temp);

        } else if (movimientoActual == 3 && movimientoAnterior == 4) {
            bajarIzquierdaAbajo(temp);

        } else if (movimientoActual == 3 && movimientoAnterior == 2) {
            subirDerechaAbajo(temp);

        } else if (movimientoActual == 4 && movimientoAnterior == 3) {
            subirIzquierdaArriba(temp);

        } else if (movimientoActual == 4 && movimientoAnterior == 1) {
            bajarDerechaArriba(temp);
        }
    }

    public void bajarIzquierdaArriba(JComponent temp) {
        if ((bola.getPosX() > 0)) {
            bola.setPosY(bola.getPosY() + getVelocidad2());
            bola.setPosX(bola.getPosX() - getVelocidad2());
        } else {
            movimientoActual = 2;
            movimientoAnterior = 1;
        }

        if (bola.getPosY() == temp.getHeight() - 25) {
            if (FrmVistaJuego.dw2.getCtlBarra().getBarra().getPosX() < bola.getPosX()
                    && bola.getPosX() < FrmVistaJuego.dw2.getCtlBarra().getBarra().getPosX() + 100) {
                movimientoActual = 2;
                movimientoAnterior = 3;
                FrmVistaJuego.puntaje = FrmVistaJuego.puntaje + 5;

            } else {
                bola.setPosY(bola.getPosY() + 35);
                bola.setPosX(bola.getPosX() - 35);
                setVelocidad2(velocidad2 + 1);
                setMurio(true);
                FrmVistaJuego.bolas = FrmVistaJuego.bolas - 1;
                FrmVistaJuego.puntaje = FrmVistaJuego.puntaje - 3;
                if (FrmVistaJuego.puntaje < 0) {
                    FrmVistaJuego.puntaje = 0;
                }

            }
        }
    }

    public void bajarIzquierdaAbajo(JComponent temp) {
        if ((bola.getPosY() < temp.getHeight() - 25)) {
            bola.setPosY(bola.getPosY() + getVelocidad2());
            bola.setPosX(bola.getPosX() - getVelocidad2());
        } else {
            if (FrmVistaJuego.dw2.getCtlBarra().getBarra().getPosX() < bola.getPosX()
                    && bola.getPosX() < FrmVistaJuego.dw2.getCtlBarra().getBarra().getPosX() + 100) {
                movimientoActual = 2;
                movimientoAnterior = 3;
                FrmVistaJuego.puntaje = FrmVistaJuego.puntaje + 3;

            } else {
                FrmVistaJuego.bolas = FrmVistaJuego.bolas - 1;
                setMurio(true);
                setVelocidad2(velocidad2 + 1);
                bola.setPosY(bola.getPosY() + 35);
                bola.setPosX(bola.getPosX() - 35);
                FrmVistaJuego.puntaje = FrmVistaJuego.puntaje - 3;
                if (FrmVistaJuego.puntaje < 0) {
                    FrmVistaJuego.puntaje = 0;
                }

            }
        }

        if (bola.getPosX() == 0) {
            movimientoActual = 2;
            movimientoAnterior = 1;
        }
    }

    public void bajarDerechaAbajo(JComponent temp) {
        if ((bola.getPosY() < temp.getHeight() - 25)) {
            bola.setPosY(bola.getPosY() + getVelocidad2());
            bola.setPosX(bola.getPosX() + getVelocidad2());
        } else {
            if (FrmVistaJuego.dw2.getCtlBarra().getBarra().getPosX() < bola.getPosX()
                    && bola.getPosX() < FrmVistaJuego.dw2.getCtlBarra().getBarra().getPosX() + 100) {
                movimientoActual = 3;
                movimientoAnterior = 2;
                FrmVistaJuego.puntaje = FrmVistaJuego.puntaje + 5;

            } else {
                bola.setPosY(bola.getPosY() + 35);
                bola.setPosX(bola.getPosX() + 35);
                setVelocidad2(velocidad2 + 1);

                setMurio(true);
                FrmVistaJuego.bolas = FrmVistaJuego.bolas - 1;
                FrmVistaJuego.puntaje = FrmVistaJuego.puntaje - 3;
                if (FrmVistaJuego.puntaje < 0) {
                    FrmVistaJuego.puntaje = 0;
                }

            }

        }

        if (bola.getPosX() == temp.getWidth() - 10) {
            movimientoActual = 3;
            movimientoAnterior = 4;
        }

    }

    public void bajarDerechaArriba(JComponent temp) {
        if ((bola.getPosX() <= temp.getWidth() - 10)) {
            bola.setPosY(bola.getPosY() + getVelocidad2());
            bola.setPosX(bola.getPosX() + getVelocidad2());
        } else {

            movimientoActual = 3;
            movimientoAnterior = 4;
        }
        if (bola.getPosY() == temp.getHeight() - 25) {
            if (FrmVistaJuego.dw2.getCtlBarra().getBarra().getPosX() < bola.getPosX()
                    && bola.getPosX() < FrmVistaJuego.dw2.getCtlBarra().getBarra().getPosX() + 100) {
                movimientoActual = 3;
                movimientoAnterior = 2;
                FrmVistaJuego.puntaje = FrmVistaJuego.puntaje + 5;

            } else {
                bola.setPosY(bola.getPosY() + 35);
                bola.setPosX(bola.getPosX() + 35);
                setMurio(true);
                setVelocidad2(velocidad2 + 1);

                FrmVistaJuego.bolas = FrmVistaJuego.bolas - 1;

                FrmVistaJuego.puntaje = FrmVistaJuego.puntaje - 3;
                if (FrmVistaJuego.puntaje < 0) {
                    FrmVistaJuego.puntaje = 0;
                }

            }
        }

    }

    public void subirDerechaArriba(JComponent temp) {
        if ((bola.getPosY() > 0)) {
            bola.setPosY(bola.getPosY() - getVelocidad2());
            bola.setPosX(bola.getPosX() + getVelocidad2());
        } else {
            movimientoActual = 4;
            movimientoAnterior = 1;
        }
        if (bola.getPosX() == temp.getWidth() - 10) {
            movimientoActual = 4;
            movimientoAnterior = 3;
        }
    }

    public void subirDerechaAbajo(JComponent temp) {
        if ((bola.getPosX() <= temp.getWidth() - 10)) {
            bola.setPosY(bola.getPosY() - getVelocidad2());
            bola.setPosX(bola.getPosX() + getVelocidad2());
        } else {
            movimientoActual = 4;
            movimientoAnterior = 3;
        }
        if (bola.getPosY() == 0) {
            movimientoActual = 1;
            movimientoAnterior = 2;
        }
    }

    public void subirIzquierdaAbajo(JComponent temp) {
        if (((bola.getPosX() > 0))) {
            bola.setPosY(bola.getPosY() - getVelocidad2());
            bola.setPosX(bola.getPosX() - getVelocidad2());
        } else {
            movimientoActual = 1;
            movimientoAnterior = 2;
        }

        if (bola.getPosY() == 0) {
            movimientoActual = 3;
            movimientoAnterior = 4;
        }
    }

    public void subirIzquierdaArriba(JComponent temp) {
        if (((bola.getPosY() > 0))) {
            bola.setPosY(bola.getPosY() - getVelocidad2());
            bola.setPosX(bola.getPosX() - getVelocidad2());
        } else {
            movimientoActual = 1;
            movimientoAnterior = 4;
        }

        if (bola.getPosX() == 0) {
            movimientoActual = 1;
            movimientoAnterior = 2;
        }
    }

    public void dibularBola(Graphics gui, Ball temp) {

        Random rand = new Random();
        float r = (float) (rand.nextFloat() / (2f + 0.5));
        float g = (float) (rand.nextFloat() / (2f + 0.5));
        float b = (float) (rand.nextFloat() / (2f + 0.5));

        gui.setColor(new Color(r, g, b));

        gui.fillOval(temp.getPosX(), temp.getPosY(), temp.getAncho(), temp.getAlto());
    }

    public void cuadrarNumeros() {
        int pos1 = (int) (Math.random() * 4) + 1;
        int pos2 = 0;
        if (pos1 == 1 || pos1 == 3) {
            pos2 = (int) (Math.random() * 2) + 1; // el 4 o el 2
            if (pos2 == 1) {
                pos2 = 4;
            } else {
                pos2 = 2;
            }
        } else if (pos1 == 2 || pos1 == 4) {
            pos2 = (int) (Math.random() * 2) + 1; // el 3 o el 1
            if (pos2 == 1) {
                pos2 = 3;
            } else {
                pos2 = 1;
            }
        }
        setMovimientoActual(pos1);
        setMovimientoAnterior(pos2);
    }

    public int getMovimientoActual() {
        return movimientoActual;
    }

    public void setMovimientoActual(int movimientoActual) {
        this.movimientoActual = movimientoActual;
    }

    public int getMovimientoAnterior() {
        return movimientoAnterior;
    }

    public void setMovimientoAnterior(int movimientoAnterior) {
        this.movimientoAnterior = movimientoAnterior;
    }

    public boolean isMurio() {
        return murio;
    }

    public void setMurio(boolean murio) {
        this.murio = murio;
    }

    public int getVelocidad2() {
        return velocidad2;
    }

    public void setVelocidad2(int velocidad2) {
        this.velocidad2 = velocidad2;
    }

}
