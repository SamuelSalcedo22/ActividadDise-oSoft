package com.universidad.notificaciones.factory;

import com.universidad.notificaciones.enums.TipoNotificacion;
import com.universidad.notificaciones.model.Notificacion;
import com.universidad.notificaciones.model.NotificacionEmail;
import com.universidad.notificaciones.model.NotificacionMovil;
import com.universidad.notificaciones.model.NotificacionSMS;

/**
 * Factory que centraliza la creación de notificaciones.
 * Para agregar un nuevo canal, solo se añade un nuevo case aquí,
 * sin modificar el resto del sistema (principio Open/Closed).
 */
public class NotificacionFactory {

    public static Notificacion crear(String canal, String codigo,
                                     String destinatario, String mensaje,
                                     TipoNotificacion tipo) {
        return switch (canal.toUpperCase()) {
            case "EMAIL" -> new NotificacionEmail(
                    codigo, destinatario, mensaje, tipo,
                    "Notificación: " + tipo.getDescripcion(),
                    destinatario.toLowerCase().replace(" ", ".") + "@universidad.edu.co",
                    "Universidad - Sistema de Notificaciones"
            );
            case "SMS" -> new NotificacionSMS(
                    codigo, destinatario, mensaje, tipo,
                    "+57 300 000 0000", "Claro", 160
            );
            case "MOVIL" -> new NotificacionMovil(
                    codigo, destinatario, mensaje, tipo,
                    "TOKEN-" + codigo, "Android", "ic_universidad"
            );
            default -> throw new IllegalArgumentException("Canal no soportado: " + canal);
        };
    }
}
