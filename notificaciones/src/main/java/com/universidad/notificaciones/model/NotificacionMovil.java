package com.universidad.notificaciones.model;

import com.universidad.notificaciones.enums.EstadoNotificacion;
import com.universidad.notificaciones.enums.TipoNotificacion;

public class NotificacionMovil extends Notificacion {

    private String tokenDispositivo;
    private String plataforma; // Android / iOS
    private String icono;

    public NotificacionMovil(String codigo, String destinatario, String mensaje,
                             TipoNotificacion tipo, String tokenDispositivo,
                             String plataforma, String icono) {
        super(codigo, destinatario, mensaje, tipo);
        this.tokenDispositivo = tokenDispositivo;
        this.plataforma = plataforma;
        this.icono = icono;
    }

    @Override
    public void enviar() {
        System.out.println("=== Enviando NOTIFICACIÓN EN APP MÓVIL ===");
        mostrarInfoBase();
        System.out.println("  Token dispositivo: " + tokenDispositivo);
        System.out.println("  Plataforma       : " + plataforma);
        System.out.println("  Ícono            : " + icono);
        System.out.println("  [Simulación] Push notification enviada a dispositivo " + plataforma);
        setEstado(EstadoNotificacion.ENVIADO);
        System.out.println("  Estado final     : " + getEstado());
        System.out.println("==========================================");
    }

    // Getters y Setters
    public String getTokenDispositivo() { return tokenDispositivo; }
    public void setTokenDispositivo(String tokenDispositivo) { this.tokenDispositivo = tokenDispositivo; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }
}
