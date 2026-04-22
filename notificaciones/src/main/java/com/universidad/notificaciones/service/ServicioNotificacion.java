package com.universidad.notificaciones.service;

import com.universidad.notificaciones.model.Notificacion;

import java.util.ArrayList;
import java.util.List;

public class ServicioNotificacion {

    private final List<Notificacion> notificaciones = new ArrayList<>();

    public void enviarNotificacion(Notificacion notificacion) {
        notificacion.enviar();
        notificaciones.add(notificacion);
    }

    public List<Notificacion> listar() {
        return new ArrayList<>(notificaciones);
    }

    public void mostrarResumen() {
        System.out.println("\n============= RESUMEN DE NOTIFICACIONES =============");
        System.out.printf("  Total enviadas: %d%n", notificaciones.size());
        for (Notificacion n : notificaciones) {
            System.out.printf("  [%s] %-42s -> %s%n",
                    n.getCodigo(),
                    n.getTipo().getDescripcion(),
                    n.getEstado());
        }
        System.out.println("=====================================================\n");
    }
}
