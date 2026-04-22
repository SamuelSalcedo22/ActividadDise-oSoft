# Sistema de Notificaciones - Universidad

Sistema Java que demuestra el patrón de diseño **Herencia + Factory Method** para gestionar múltiples canales y tipos de notificaciones universitarias.

## Requisitos

- Java 17 o superior (se usa `switch` con expresión de Java 14+)
- VS Code con extensión **Extension Pack for Java** (de Microsoft)

## Estructura del proyecto

```
notificaciones/
└── src/main/java/com/universidad/notificaciones/
    ├── Main.java                          ← Punto de entrada
    ├── enums/
    │   ├── TipoNotificacion.java          ← 4 tipos de situación
    │   └── EstadoNotificacion.java        ← PENDIENTE / ENVIADO / FALLIDO
    ├── model/
    │   ├── Notificacion.java              ← Clase abstracta base
    │   ├── NotificacionEmail.java         ← Canal: correo electrónico
    │   ├── NotificacionSMS.java           ← Canal: mensaje de texto
    │   └── NotificacionMovil.java         ← Canal: app móvil
    ├── service/
    │   └── ServicioNotificacion.java      ← Orquesta el envío y registro
    └── factory/
        └── NotificacionFactory.java       ← Crea notificaciones por canal
```

## Cómo ejecutar en VS Code

1. Abre la carpeta `notificaciones/` en VS Code.
2. Instala la extensión **Extension Pack for Java** si aún no la tienes.
3. VS Code detecta automáticamente las clases Java.
4. Abre `Main.java` y haz clic en **▷ Run** que aparece sobre el método `main`.

## Cómo agregar un nuevo canal (extensibilidad)

El sistema sigue el principio **Open/Closed**: para agregar, por ejemplo, notificaciones por WhatsApp:

1. Crea `NotificacionWhatsApp.java` extendiendo `Notificacion`.
2. Implementa el método `enviar()`.
3. Agrega `case "WHATSAPP"` en `NotificacionFactory.java`.

No necesitas modificar ninguna otra clase.

## Patrones aplicados

| Patrón | Dónde |
|--------|-------|
| Herencia + Polimorfismo | `Notificacion` → `Email / SMS / Movil` |
| Factory Method | `NotificacionFactory.crear(...)` |
| Encapsulamiento | Todos los campos privados con getters/setters |
