package com.universidad.notificaciones.model;

import com.universidad.notificaciones.enums.EstadoNotificacion;
import com.universidad.notificaciones.enums.TipoNotificacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Notificacion {

    private String codigo;
    private String destinatario;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private EstadoNotificacion estado;
    private TipoNotificacion tipo;

    public Notificacion(String codigo, String destinatario, String mensaje, TipoNotificacion tipo) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fechaEnvio = LocalDateTime.now();
        this.estado = EstadoNotificacion.PENDIENTE;
    }

    // Método abstracto: cada subclase implementa su propio envío
    public abstract void enviar();

    // Método auxiliar para mostrar información base
    protected void mostrarInfoBase() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("  Código        : " + codigo);
        System.out.println("  Tipo          : " + tipo.getDescripcion());
        System.out.println("  Destinatario  : " + destinatario);
        System.out.println("  Mensaje       : " + mensaje);
        System.out.println("  Fecha de envío: " + fechaEnvio.format(fmt));
        System.out.println("  Estado        : " + estado);
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public EstadoNotificacion getEstado() { return estado; }
    public void setEstado(EstadoNotificacion estado) { this.estado = estado; }

    public TipoNotificacion getTipo() { return tipo; }
    public void setTipo(TipoNotificacion tipo) { this.tipo = tipo; }
}
