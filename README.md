# Simulador de Billetera Auxiliar

> ⚠️ Este proyecto está en desarrollo activo. Algunas funcionalidades, nombres o estructuras pueden cambiar conforme avance la implementación y mejora del mismo.

Este repositorio contiene un sistema distribuido en tres aplicaciones Java independientes, que simulan una billetera virtual y su mecanismo de respaldo en caso de caída de servicios, como podría ocurrir con plataformas de billeteras virtuales.

Este proyecto fue desarrollado como parte del curso de Programación y Computación II, respetando sus restricciones (sin bases de datos, ni tecnologías externas), y usando Java con Swing (JFrame) en NetBeans.

---

## 🧠 Objetivo

Simular un sistema donde, si los "servidores" del programa principal colapsan debido a una sobrecarga de procesos (simulada), se active un programa auxiliar capaz de continuar con las operaciones de transacción virtual, y que registre estos movimientos para ser restaurados luego en el programa principal.

---

## 📆 Estructura del Repositorio

```
simulador-billetera-auxiliar/
├── programa-principal/       → Simula una billetera virtual (Añadido en futuras actualizaciones) 
├── programa-auxiliar/        → Actúa como respaldo para realizar transacciones
├── simulador-procesos/       → Simula la sobrecarga del sistema principal
└── README.md
```

Cada carpeta contiene un proyecto Java independiente hecho en NetBeans.

---

## 💡 Funcionamiento General

1. **Simulador de Procesos**:

   - Genera múltiples procesos hasta alcanzar un umbral.
   - Si el número de procesos excede el límite, se simula la caída del sistema principal.

2. **Programa Principal**:

   - Simula una billetera funcional.
   - Si detecta que el sistema está colapsado, no permite operaciones.

3. **Programa Auxiliar**:

   - Se activa si el archivo `activador.txt` contiene un "1".
   - Permite ingresar mediante PIN, y hacer transacciones simuladas.
   - Guarda todas las transacciones en un archivo `.txt` (monto, tipo, saldo, etc.).

4. **Restauración**:

   - Cuando el sistema principal se restablece, puede leer el archivo del auxiliar.
   - Se sincroniza la información: número de transacciones, saldos, etc.

---

## 🔐 Seguridad Simulada

- Acceso al programa auxiliar mediante **PIN de 4 dígitos**.
- El archivo `activador.txt` actúa como llave de activación.

---

## 🛠️ Tecnologías Utilizadas

- Lenguaje: **Java 8+**
- Interfaz: **Swing (JFrame)**
- IDE: **NetBeans 12+**
- Persistencia: **Archivos de texto (.txt)**

---

## 🎓 Consideraciones de Arquitectura (MVC)

El proyecto sigue parcialmente una estructura inspirada en el patrón **Modelo-Vista-Controlador (MVC)**:

- **Vista**: Interfaces gráficas desarrolladas con `JFrame` (Swing).
- **Controlador**: Clases que validan datos, gestionan flujos y excepciones.
- **Modelo**: Implementado de forma sencilla mediante clases que acceden a archivos `.txt`.

> ⚠️ Nota: Dado que es un proyecto educativo limitado por el temario del curso, **no se implementó MVC al 100%**, pero se respetaron sus principios fundamentales siempre que fue posible.

---

## 📃 Notas adicionales

- Cada subcarpeta es un proyecto NetBeans independiente.
- El programa evita el uso de bases de datos y mantiene toda la lógica y persistencia dentro del entorno permitido por el curso.
- Se emplearon **excepciones personalizadas** para manejar errores comunes (como PIN inválido o problemas con archivos).

---

## 👤 Autor

**A-Dryan**\
Estudiante de Ingeniería de Sistemas\
Universidad Nacional Mayor de San Marcos

> Este proyecto fue desarrollado en equipo como parte del curso de Programación y Computación II.

---

## 📍 Futuras mejoras (opcional)

- Refactorizar para seguir MVC completo.
- Agregar pruebas unitarias.
- Implementar base de datos local una vez permitida.
- Mejorar la interfaz gráfica para mayor usabilidad.


