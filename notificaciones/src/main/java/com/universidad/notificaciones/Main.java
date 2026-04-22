package com.universidad.notificaciones;

import com.universidad.notificaciones.enums.TipoNotificacion;
import com.universidad.notificaciones.model.*;
import com.universidad.notificaciones.service.ServicioNotificacion;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ServicioNotificacion servicio = new ServicioNotificacion();
    static int contadorCodigo = 1;

    public static void main(String[] args) {
        int opcion = -1;
        do {
            System.out.println("\n╔══════════════════════════════════════════════╗");
            System.out.println("║   SISTEMA DE NOTIFICACIONES - UNIVERSIDAD    ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  1. Publicación de calificaciones            ║");
            System.out.println("║  2. Recordatorio de pago de matrícula        ║");
            System.out.println("║  3. Aviso de cancelación de clase            ║");
            System.out.println("║  4. Confirmación de inscripción a evento     ║");
            System.out.println("║  5. Ver historial de notificaciones          ║");
            System.out.println("║  0. Salir                                    ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("  Selecciona una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> flujoNotificacion(TipoNotificacion.PUBLICACION_CALIFICACIONES);
                case 2 -> flujoNotificacion(TipoNotificacion.RECORDATORIO_PAGO);
                case 3 -> flujoNotificacion(TipoNotificacion.AVISO_CANCELACION_CLASE);
                case 4 -> flujoNotificacion(TipoNotificacion.CONFIRMACION_INSCRIPCION);
                case 5 -> servicio.mostrarResumen();
                case 0 -> System.out.println("\n  Hasta luego.\n");
                default -> System.out.println("  Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    // ─── Flujo completo para cualquier tipo de notificación ───────────────────

    static void flujoNotificacion(TipoNotificacion tipo) {
        System.out.println("\n  ── " + tipo.getDescripcion() + " ──");

        System.out.print("  Nombre del destinatario: ");
        String destinatario = sc.nextLine().trim();
        if (destinatario.isEmpty()) {
            System.out.println("  El nombre no puede estar vacío.");
            return;
        }

        System.out.print("  Mensaje a enviar: ");
        String mensaje = sc.nextLine().trim();
        if (mensaje.isEmpty()) {
            System.out.println("  El mensaje no puede estar vacío.");
            return;
        }

        System.out.println("\n  ¿Por qué canal deseas enviar la notificación?");
        System.out.println("    1. Correo electrónico");
        System.out.println("    2. Mensaje de texto (SMS)");
        System.out.println("    3. Notificación en app móvil");
        System.out.print("  Canal: ");
        int canal = leerEntero();

        String codigo = String.format("NOT-%03d", contadorCodigo++);
        Notificacion notificacion = null;

        switch (canal) {
            case 1 -> {
                System.out.print("  Correo electrónico del destinatario: ");
                String email = sc.nextLine().trim();
                System.out.print("  Asunto del correo: ");
                String asunto = sc.nextLine().trim();
                notificacion = new NotificacionEmail(
                        codigo, destinatario, mensaje, tipo,
                        asunto, email, "Universidad - Sistema de Notificaciones"
                );
            }
            case 2 -> {
                System.out.print("  Número de teléfono (ej: +57 300 000 0000): ");
                String telefono = sc.nextLine().trim();
                System.out.print("  Operador (Claro / Movistar / Tigo): ");
                String operador = sc.nextLine().trim();
                notificacion = new NotificacionSMS(
                        codigo, destinatario, mensaje, tipo,
                        telefono, operador, 160
                );
            }
            case 3 -> {
                System.out.print("  Token del dispositivo: ");
                String token = sc.nextLine().trim();
                System.out.print("  Plataforma (Android / iOS): ");
                String plataforma = sc.nextLine().trim();
                notificacion = new NotificacionMovil(
                        codigo, destinatario, mensaje, tipo,
                        token, plataforma, "ic_universidad"
                );
            }
            default -> {
                System.out.println("  Canal no válido.");
                return;
            }
        }

        System.out.println();
        servicio.enviarNotificacion(notificacion);
    }

    // ─── Leer entero de forma segura ──────────────────────────────────────────

    static int leerEntero() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
