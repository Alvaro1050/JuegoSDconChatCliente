/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Modelo.Usuario;
import Modelo.listaUsuarios;
import Vista.FrmVistaJuego;
import static Vista.FrmVistaJuego.nombre;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvar
 */
public class Client implements Runnable {

    Socket cliente;
    Socket servidor;
    static int port = 8000;
    String ip;
    ServerSocket cliente2;
    ObjectInputStream flujoEntrada;
    FrmVistaJuego gui;
    String mensaje = "";
    boolean status = true;
    ObjectOutputStream flujosalida;

    public Client(FrmVistaJuego gui, String ip) {
        this.gui = gui;
        this.ip = ip;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (status) {
            try {
                cliente = new Socket(ip, port);//se crea el socket de tipo cliente                
                flujosalida = new ObjectOutputStream(cliente.getOutputStream());

                Usuario usu = new Usuario("", 0, "");
                Gson gson = new Gson();
                String json = gson.toJson(usu);
                flujosalida.writeObject(json);

                flujoEntrada = new ObjectInputStream(cliente.getInputStream());;
                mensaje = (String) flujoEntrada.readObject();

                listaUsuarios ls = gson.fromJson(mensaje, listaUsuarios.class);
                gui.lblCantidad.setText(ls.getCantidad()+"");
                gui.txaChar.setText(ls.getChat());
                FrmVistaJuego.usuarios = ls.getUsuarios();

                FrmVistaJuego.listar(FrmVistaJuego.modelo);

                Thread.sleep(250);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void enviarMensaje(Object mensaje) {
        try {
            cliente = new Socket(ip, port);
            flujosalida = new ObjectOutputStream(cliente.getOutputStream());
            flujosalida.writeObject(mensaje);
        } catch (IOException e) {
            System.out.println("No se pudo conectar con el servidor");
        }
    }

    public void descoenctar() {
        try {
            if (flujosalida != null) {
                flujosalida.close();
            }
            if (cliente != null) {
                cliente.close();
            }
        } catch (IOException e) {
            System.out.println("error" + e);
        }
    }

}
