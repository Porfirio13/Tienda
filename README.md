![image](https://github.com/user-attachments/assets/62b496dc-05ee-40ff-b16c-3aff46689439)

La clase MenuGeneral es la ventana principal de la aplicación "Chocolatería La Guelaguetza". 
Su objetivo es proporcionar una interfaz de bienvenida que permita a los usuarios seleccionar su rol (Encargado o Trabajador) para acceder a las funcionalidades específicas de cada perfil, 
además de ofrecer la opción de salir de la aplicación.

Descripción General
La ventana está diseñada utilizando componentes de Swing para asegurar una experiencia gráfica interactiva. Incluye paneles, etiquetas, botones y elementos visuales, como imágenes y colores, para mejorar la estética y la funcionalidad.

Funciones Principales
Interfaz de bienvenida:

Muestra un saludo personalizado con las frases "¡¡Hola!!" y "Bienvenido".
Integra el nombre y logo de la chocolatería: "Chocolatería La Guelaguetza".
Selección de roles:

Dos botones permiten al usuario elegir su rol:
Encargado: Redirige a la ventana de inicio de sesión del encargado.
Trabajador: Redirige a la ventana de inicio de sesión del trabajador.
Opción de salir:

Un botón que cierra la ventana principal y finaliza la ejecución de la aplicación.
Estética visual:

Uso de colores diferenciados en paneles para secciones específicas.
Inclusión de imágenes representativas, como una muñeca oaxaqueña y el logo de la chocolatería.
Detalles de Implementación
Paneles
jPanel1: Panel principal que organiza los demás componentes mediante un diseño de tipo AbsoluteLayout.
jPanel2: Cabecera que incluye el título y el subtítulo de la chocolatería.
jPanel3: Panel derecho que muestra imágenes decorativas.
Botones
Botón "Encargado": Redirige a la ventana LoginEncargado mediante el método BtnLoginE1ActionPerformed.
Botón "Trabajador": Redirige a la ventana LoginTrabajador mediante el método BtnLoginT1ActionPerformed.
Botón "Salir": Cierra la ventana actual y finaliza la ejecución de la aplicación mediante el método BtnLoginTActionPerformed.
Imágenes
Decoración visual: Se cargan imágenes locales para mejorar la interfaz, como una muñeca representativa de Oaxaca y el logo de la chocolatería.
Manejo de Eventos
Cada botón incluye un ActionListener que ejecuta la acción correspondiente al ser presionado:

Encargado: Abre la ventana de inicio de sesión para encargados y cierra el menú general.
Trabajador: Abre la ventana de inicio de sesión para trabajadores y cierra el menú general.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------


![image](https://github.com/user-attachments/assets/ea47ecf5-7ac7-4b53-a4b5-ab0f13b07dc5)


Clase LoginEncargado
Esta clase implementa un formulario de inicio de sesión para los encargados de la chocolatería "La Guelaguetza".
Proporciona validación de credenciales contra una base de datos y redirige al menú principal en caso de éxito.

Funciones principales:
Componentes gráficos (initComponents):

Campos de texto para correo y contraseña.
Botones:
Iniciar sesión: Verifica credenciales.
Salir: Cierra la ventana.
Regresar: Vuelve al menú general.
Manejo de eventos:

BtnIniciarTActionPerformed:
Obtiene las credenciales ingresadas.
Conecta con la base de datos MySQL (guelaguetza).
Valida los datos contra la tabla datos_encargado.
Si son correctos:
Muestra un mensaje de bienvenida con el nombre del encargado.
Abre el MenuEncargado.
Cierra la ventana de login.
Si son incorrectos:
Muestra un mensaje de error.
BtnSalirActionPerformed:
Cierra la ventana actual.
BtnRegresarMActionPerformed:
Abre el menú general y cierra el formulario.
Conexión a la base de datos:

URL: jdbc:mysql://localhost:3306/guelaguetza.
Usuario: root.
Contraseña: 12345678.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Prueba de escritorio
 
![image](https://github.com/user-attachments/assets/5fb6ec3c-1e34-4bab-ab10-427f525fbc72)

![image](https://github.com/user-attachments/assets/f53ab03e-0c1d-4f04-ae83-e8cf71f897a2)

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
![image](https://github.com/user-attachments/assets/77e098c0-4505-4b2a-8908-eed45974ee4f)


Este código define un JFrame llamado MenuEncargado, que representa el menú principal para un encargado en una chocolatería. Este menú incluye botones y elementos visuales para navegar a otras funcionalidades como la gestión de inventario, ventas, trabajadores y proveedores. Aquí hay un desglose general del diseño y funcionalidad:

Componentes Visuales
Panel Principal (jPanel1)

Color de fondo gris claro.
Diseñado con AbsoluteLayout para posicionar los componentes en coordenadas específicas.
Encabezado (jPanel3)

Color de fondo azul.
Incluye:
Etiqueta "Chocolatería" con fuente grande y negrita.
Subtítulo "La Guelaguetza".
Botones

btnVentas: Lleva a la sección de ventas (VentaE).
btnCProducto: Lleva a la sección de inventario (Inventario).
btnAdTrabajador: Lleva a la gestión de trabajadores (AdTrabajador).
btnProveedores: Lleva a la sección de proveedores (VerProveedor).
Todos los botones incluyen:

Iconos (que cargan desde rutas locales en tu sistema: D:\\Descargas).
Bordes decorativos.
Acción definida que abre un nuevo JFrame y cierra el actual.
Etiquetas

Describen los botones, como "Trabajadores", "Inventario", "Ventas", y "Proveedores".
Colocadas cerca de los botones para identificar su función.


Salir: Termina la ejecución de la ventana actual.
Puntos Destacados
La estructura modular y el uso de paneles hacen que la interfaz sea flexible y fácil de modificar.
Se utilizan herramientas de diseño visual en NetBeans para mantener el código organizado y estandarizado.
La integración de imágenes y colores refuerza la identidad de la chocolatería y mejora la experiencia del usuario.
Esta clase representa el punto de partida de la aplicación, asegurando que los usuarios puedan navegar fácilmente a las funcionalidades específicas de su rol en un entorno intuitivo y visualmente atractivo.


Lógica del Programa
Eventos de Botones: Cada botón usa un ActionListener para abrir otro JFrame. Ejemplo:

java
Copiar código
private void btnAdTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {                                                
    AdTrabajador adtrabajador = new AdTrabajador();
    adtrabajador.setVisible(true);
    this.dispose();
}
Esto crea una nueva instancia de la clase correspondiente y cierra la ventana actual con dispose().

Clases Vinculadas:

Inventario: Maneja la gestión del inventario.
VentaE: Maneja las ventas.
AdTrabajador: Gestión de perfiles de trabajadores.
VerProveedor: Gestión de proveedores.
Estructura del Código
Constructor

java
Copiar código
public MenuEncargado() {
    initComponents();
}
Llama al método initComponents() que organiza y coloca los elementos visuales.

Método initComponents()

Usa el editor gráfico de NetBeans para inicializar todos los componentes (paneles, botones, etiquetas, etc.).
Configura atributos visuales como colores, fuentes, bordes, y acciones.
Método main()

Configura el estilo de la interfaz gráfica (Nimbus) y lanza la aplicación.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


![image](https://github.com/user-attachments/assets/85bd5d58-b353-4c85-9d1a-8f5b04d45851)

El propósito del código es implementar una interfaz gráfica en Java Swing que permita visualizar y gestionar las ventas realizadas en una chocolatería. Este sistema pertenece a la funcionalidad de empleados en el sistema de administración.

Funciones principales:
Cargar Ventas:

El método cargarVenta() obtiene las ventas desde la base de datos, mostrando información como ID de la venta, ID del trabajador, fecha, producto, cantidad, total y método de pago en una tabla (JTable).
Interfaz gráfica:

La tabla TablaVenta permite visualizar las ventas cargadas desde la base de datos.
Dos botones principales:
"Ver ventas": Llama al método cargarVenta() para actualizar la tabla.
"Menú encargado": Redirige a la ventana principal del encargado (MenuEncargado).
Gestión de conexión a la base de datos:

Usa un objeto de conexión (dbConnection.getConnection()) para ejecutar consultas SQL que integran datos de las tablas ventas y datos_trabajador.
Modularidad:

La clase sigue una estructura limpia que separa el diseño de la funcionalidad, utilizando initComponents() para construir la interfaz gráfica y métodos adicionales para las operaciones específicas.




--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
![image](https://github.com/user-attachments/assets/241f1006-e4a7-41c0-a908-fd9a1ec29c1c)


Estructura y Funcionalidades
Interfaz de Usuario (UI)

Panel Principal (jPanel1): Contiene todos los elementos de la UI. Tiene un fondo gris claro y bordes elevados.
Panel Superior (jPanel2): Un panel azul con título "Chocolateria" y sub-título "La Guelaguetza".
Etiquetas (jLabel1, jLabel2, jLabel5, jLabel7, jLabel8): Muestran textos para identificar la aplicación y las secciones disponibles.
Botones (btnHorario, btnCTrabajador, BtnRegresar, BtnSalir, btnCTrabajador1):
btnHorario: Inicia la ventana Horario.
btnCTrabajador: Inicia la ventana DesempeñoT.
BtnRegresar: Regresa al menú de encargado MenuEncargado.
BtnSalir: Cierra la aplicación.
btnCTrabajador1: Crea y modifica trabajadores, aunque su funcionalidad no está implementada aún.
Eventos de Botón:

btnHorarioActionPerformed(): Al hacer clic, se abre la ventana Horario.
btnCTrabajadorActionPerformed(): Al hacer clic, se abre la ventana DesempeñoT y se cierra la ventana actual.
BtnRegresarActionPerformed(): Regresa a la ventana MenuEncargado.
BtnSalirActionPerformed(): Cierra la aplicación.
btnCTrabajador1ActionPerformed(): Esta función está vacía y se puede completar para manejar la creación y modificación de trabajadores.
Funciones de Inicialización y Ejecución:

En el método main(), se establece el look and feel de la interfaz de usuario (Nimbus) y se crea la instancia de la clase AdTrabajador.
Las ventanas nuevas se inician y la ventana actual se cierra usando dispose().
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/e04aa246-7416-4f70-896e-c88b8553ef2d)

Descripción del Código
Interface del Usuario:

ComboBox (CmbTrabajador): Muestra una lista de nombres de trabajadores. Se cargan desde la base de datos (datos_trabajador).
Calificación de Estrellas (calestrella1): Permite al usuario asignar una calificación al empleado.
Campo de Observaciones (txtObservaciones): Permite ingresar observaciones sobre el desempeño.
Botones:
btnGuardarPDF: Guarda el desempeño como un archivo PDF.
btnEnviarPDF: Envía el PDF por correo electrónico.
Funciones Clave:

cargarTrabajadores(): Carga los nombres de los trabajadores desde la base de datos (datos_trabajador).
guardarComoPDF(): Genera un PDF con la evaluación del empleado, incluyendo su nombre, observaciones y calificación.
enviarPDF(): Envía el PDF por correo electrónico usando SMTP.
Configuración SMTP:

Utiliza Gmail para enviar correos electrónicos.
Se autentica con un correo y una clave específica.
Permite adjuntar el PDF al correo.

![image](https://github.com/user-attachments/assets/2e2aeee2-cdd1-4933-8643-53a58850de80)

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


El código CTrabajador representa una ventana gráfica en Java (JFrame) que permite al usuario registrar un nuevo trabajador en una aplicación de gestión de una chocolatería.

Componentes Principales:
Campos de Entrada:

txtIdT: Campo para el ID del trabajador.
txtNombreT: Campo para el nombre del trabajador.
txtApellidoT: Campo para el apellido del trabajador.
txtTelefono: Campo para el número de teléfono.
txtCorreoT: Campo para el correo electrónico.
txtContrasenaT: Campo para la contraseña (utiliza un JPasswordField para seguridad).
txtFecha: Selector de fecha para la fecha de nacimiento.
cmbGenero: ComboBox para seleccionar el género del trabajador.
txtDireccion: Campo para la dirección del trabajador.
Botones:

btnGuardar: Guarda los datos del trabajador en la base de datos cuando se hace clic. Realiza validaciones básicas y guarda los datos utilizando una conexión a la base de datos.
btnMenu: Redirige al usuario a un menú principal (MenuGeneral) y cierra la ventana actual.
Funcionalidad del Botón Guardar:

Validación de Datos: Antes de intentar guardar los datos, el sistema verifica que todos los campos obligatorios estén llenos y que se haya seleccionado una fecha de nacimiento válida.
Conversión de Fecha: La fecha seleccionada por el usuario se convierte de un objeto java.util.Date a un java.sql.Date para ser compatible con las operaciones de la base de datos.
Inserción en Base de Datos: Se realiza una conexión con la base de datos (dbConnection.getConnection()) y se inserta un nuevo registro en la tabla datos_trabajador utilizando un PreparedStatement.
Mensajes de Confirmación: Después de intentar guardar los datos, se muestra un mensaje al usuario indicando si la operación fue exitosa o falló.
Diseño de la Interfaz:

El diseño utiliza GridBagLayout para organizar los componentes.
Los textos de las etiquetas y los campos de entrada están alineados de manera clara y estructurada.
Los botones están ubicados estratégicamente para permitir la navegación y la interacción con el usuario.
Este código proporciona una manera sencilla y estructurada para registrar trabajadores en la aplicación de la chocolatería, asegurando que se capture toda la información necesaria de manera eficiente.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/e2c9df74-08c4-477a-a6ff-328ca7e2d919)


![image](https://github.com/user-attachments/assets/0695150d-7e21-4614-a68b-504c20ed98e5)


Funcionalidades:
Campos de entrada:

Id_trabajador: Campo de texto para el ID del trabajador.
Nombre: Campo de texto para el nombre del trabajador.
Apellido: Campo de texto para el apellido del trabajador.
Correo: Campo de texto para el correo electrónico del trabajador.
Contraseña: Campo de contraseña para ingresar una contraseña segura.
Fecha de nacimiento: Un selector de fecha para ingresar la fecha de nacimiento del trabajador.
Teléfono: Campo de texto para el número de teléfono del trabajador.
Genero: Un JComboBox para seleccionar el género (Masculino o Femenino).
Dirección: Campo de texto para ingresar la dirección del trabajador.
Botones:

"Guardar": Al hacer clic, se capturan los datos del formulario y se insertan en la base de datos utilizando un PreparedStatement.
"Menu": Permite volver al menú principal.
Validaciones:

Se verifica que todos los campos obligatorios estén completos antes de intentar guardar.
Se valida que la fecha de nacimiento seleccionada no sea nula.
Conexión a la base de datos:

Utiliza la conexión proporcionada por dbConnection.getConnection().
Se inserta un nuevo registro en la tabla datos_trabajador con los datos proporcionados por el usuario.
Mensajes de confirmación:

Se muestra un mensaje de confirmación al usuario si el registro se realizó exitosamente o si hubo un error.



-----------------------------------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/9d676922-9ac6-4753-881a-0dbd6094e77e)


Descripción de la Funcionalidad:
Cargar Trabajadores: Se carga una lista de trabajadores desde la base de datos en un JComboBox.
Cargar Horarios: Se muestra una tabla con los horarios asignados a los trabajadores.
Asignar Horario: Permite asignar un horario de entrada y salida a un trabajador seleccionado. Los datos se insertan en la base de datos y la tabla se actualiza.
Interfaz:
Campos de Entrada:
JComboBox para seleccionar un trabajador.
JDateChooser para seleccionar la fecha.
Campos de texto para ingresar la hora de entrada (txtHoraE) y salida (txtHoraS).
Botones:
btnAsignarH para asignar un horario.
btnSalir para salir de la interfaz.
jButton1 para regresar (aunque no se ha implementado ninguna funcionalidad específica en el código).
Tabla de Horarios: TablaHorario muestra los horarios existentes.




--------------------------------------------------------------------------------------------------------------------------------------------------------------


![image](https://github.com/user-attachments/assets/65f3cc38-7df1-423c-ba79-f423724b2fcf)


Método cargarTrabajadores:

Consulta la base de datos para recuperar los nombres de los trabajadores desde la tabla datos_trabajador.
Los nombres se cargan en un JComboBox llamado cmbTrabajador.
Método cargarHorarios:

Ejecuta una consulta para obtener los datos de los horarios relacionados con los trabajadores desde las tablas horario y datos_trabajador.
Los resultados se muestran en un JTable (TablaHorario) usando un modelo de tabla (DefaultTableModel).
Formulario y componentes GUI:

Incluye varios componentes:
JComboBox para seleccionar un trabajador.
Campos de texto (txtHoraE y txtHoraS) para ingresar la hora de entrada y salida.
Un calendario (HorarioF) para seleccionar la fecha.
Un botón (btnAsignarH) para asignar horarios a trabajadores.
Acción del botón btnAsignarH:

Valida los datos ingresados (fecha, hora de entrada y salida).
Obtiene el Id_trabajador del trabajador seleccionado desde la base de datos.
Inserta un nuevo registro en la tabla horario con los datos proporcionados.
Gestión de excepciones:

Usa bloques try-catch para manejar errores de conexión y operaciones SQL, mostrando mensajes de error con JOptionPane.
![image](https://github.com/user-attachments/assets/97940153-6511-4f98-8490-1e8290063bd8)

--------------


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
![image](https://github.com/user-attachments/assets/2af42d34-ae59-464a-a733-25cedf39104b)



Carga de datos desde la base de datos:

La consulta SQL selecciona todas las columnas necesarias desde la tabla proveedor. El método cargarDatosProveedor se encarga de ejecutar esta consulta y rellenar el modelo de la tabla (DefaultTableModel).
Interacción con la base de datos:

Estás utilizando un bloque try-with-resources que es una buena práctica para manejar recursos como conexiones (Connection), declaraciones (PreparedStatement) y conjuntos de resultados (ResultSet).
Sin embargo, asegúrate de manejar adecuadamente excepciones específicas de la base de datos para dar mensajes más descriptivos al usuario.
Integración gráfica:

La tabla TablaProveedor se actualiza dinámicamente al presionar el botón "Ver proveedores" (jButton1).
Proporcionas navegación hacia otras ventanas (por ejemplo, el menú del encargado y la creación de proveedores) con los botones respectivos.
Modelo de la tabla:

Usas un DefaultTableModel para gestionar la tabla de proveedores. Esto funciona, pero puedes considerar implementar un modelo más robusto si se requiere mayor funcionalidad, como edición.

![image](https://github.com/user-attachments/assets/2fa88883-a739-47a8-aa08-eff3bb98067c)



![image](https://github.com/user-attachments/assets/7d04411d-756d-4755-b938-207faa25a295)

![image](https://github.com/user-attachments/assets/7a5a2fd4-8921-4872-bb5f-36a29ed43937)


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/fa5feb99-3aaf-4c1c-9c52-5b046163f4b7)

Carga de datos desde la base de datos:

La consulta SQL selecciona todas las columnas necesarias desde la tabla proveedor. El método cargarDatosProveedor se encarga de ejecutar esta consulta y rellenar el modelo de la tabla (DefaultTableModel).
Interacción con la base de datos:

Estás utilizando un bloque try-with-resources que es una buena práctica para manejar recursos como conexiones (Connection), declaraciones (PreparedStatement) y conjuntos de resultados (ResultSet).
Sin embargo, asegúrate de manejar adecuadamente excepciones específicas de la base de datos para dar mensajes más descriptivos al usuario.
Integración gráfica:

La tabla TablaProveedor se actualiza dinámicamente al presionar el botón "Ver proveedores" (jButton1).
Proporcionas navegación hacia otras ventanas (por ejemplo, el menú del encargado y la creación de proveedores) con los botones respectivos.
Modelo de la tabla:

Usas un DefaultTableModel para gestionar la tabla de proveedores. Esto funciona, pero puedes considerar implementar un modelo más robusto si se requiere mayor funcionalidad, como edición.




![image](https://github.com/user-attachments/assets/c223be45-15d6-4849-9a24-ba6d13492c87)
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/009178e4-86c8-4c40-ad5f-2d37072d080a)


![image](https://github.com/user-attachments/assets/61dc91b3-6dde-4599-bb3a-89a306d7ff25)


