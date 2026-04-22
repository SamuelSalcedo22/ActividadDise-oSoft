package com.universidad.notificaciones.model;

import com.universidad.notificaciones.enums.EstadoNotificacion;
import com.universidad.notificaciones.enums.TipoNotificacion;

public class NotificacionEmail extends Notificacion {

    private String asunto;
    private String emailDestinatario;
    private String nombreRemitente;

    public NotificacionEmail(String codigo, String destinatario, String mensaje,
                             TipoNotificacion tipo, String asunto,
                             String emailDestinatario, String nombreRemitente) {
        super(codigo, destinatario, mensaje, tipo);
        this.asunto = asunto;
        this.emailDestinatario = emailDestinatario;
        this.nombreRemitente = nombreRemitente;
    }

    @Override
    public void enviar() {
        System.out.println("=== Enviando notificación por CORREO ELECTRÓNICO ===");
        mostrarInfoBase();
        System.out.println("  Asunto        : " + asunto);
        System.out.println("  Email destino : " + emailDestinatario);
        System.out.println("  Remitente     : " + nombreRemitente);
        System.out.println("  [Simulación] Correo enviado exitosamente a " + emailDestinatario);
        setEstado(EstadoNotificacion.ENVIADO);
        System.out.println("  Estado final  : " + getEstado());
        System.out.println("====================================================");
    }

    // Getters y Setters
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getEmailDestinatario() { return emailDestinatario; }
    public void setEmailDestinatario(String emailDestinatario) { this.emailDestinatario = emailDestinatario; }

    public String getNombreRemitente() { return nombreRemitente; }
    public void setNombreRemitente(String nombreRemitente) { this.nombreRemitente = nombreRemitente; }
}
