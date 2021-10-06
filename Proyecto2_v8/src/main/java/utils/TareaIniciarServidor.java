package utils;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.InterruptibleChannel;
import java.nio.channels.Selector;

/**
 * En esta clase se crea una tarea para iniciar el servicio del servidor de parqueo
 * esto se hace para que halla una tarea independiente para el entorno grafico
 * y otra tarea para el servicio del servidor de parqueo
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */

public class TareaIniciarServidor extends Thread {

    private static ServidorParqueo servidor = new ServidorParqueo();

    public TareaIniciarServidor() {

    }

    public void run() {
        servidor.iniciar();

    }

    @Override
    public void interrupt() {
        servidor.setServir(false);
        super.interrupt();
    }
}
