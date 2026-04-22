package com.universidad.notificaciones.model;

import com.universidad.notificaciones.enums.EstadoNotificacion;
import com.universidad.notificaciones.enums.TipoNotificacion;

public class NotificacionSMS extends Notificacion {

    private String numeroTelefono;
    private String operador;
    private int maxCaracteres;

    public NotificacionSMS(String codigo, String destinatario, String mensaje,
                           TipoNotificacion tipo, String numeroTelefono,
                           String operador, int maxCaracteres) {
        super(codigo, destinatario, mensaje, tipo);
        this.numeroTelefono = numeroTelefono;
        this.operador = operador;
        this.maxCaracteres = maxCaracteres;
    }

    @Override
    public void enviar() {
        System.out.println("=== Enviando notificación por MENSAJE DE TEXTO (SMS) ===");
        mostrarInfoBase();
        System.out.println("  Teléfono      : " + numeroTelefono);
        System.out.println("  Operador      : " + operador);
        System.out.println("  Máx caracteres: " + maxCaracteres);

        if (getMensaje().length() > maxCaracteres) {
            System.out.println("  [ADVERTENCIA] El mensaje supera " + maxCaracteres + " caracteres, será truncado.");
            setEstado(EstadoNotificacion.FALLIDO);
        } else {
            System.out.println("  [Simulación] SMS enviado exitosamente al " + numeroTelefono);
            setEstado(EstadoNotificacion.ENVIADO);
        }
        System.out.println("  Estado final  : " + getEstado());
        System.out.println("========================================================");
    }

    // Getters y Setters
    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }

    public String getOperador() { return operador; }
    public void setOperador(String operador) { this.operador = operador; }

    public int getMaxCaracteres() { return maxCaracteres; }
    public void setMaxCaracteres(int maxCaracteres) { this.maxCaracteres = maxCaracteres; }
}
