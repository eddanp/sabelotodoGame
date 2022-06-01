![alt text](https://gitlab.com/agendas_docentes_ufps/agendas_ft/-/raw/master/src/assets/img/readme/HEADER_BE.png)
# Título del proyecto: Gestión de asesorías académicas

#### Gestión de asesorías académicas
***

## Índice
1. [Características](#caracter-sticas-)
2. [Contenido del proyecto](#contenido-del-proyecto)
3. [Tecnologías](#tecnologías)
4. [IDE](#ide)
5. [Instalación](#instalación)
6. [Demo](#demo)
7. [Autor(es)](#autores)
8. [Institución Académica](#institución-académica)
***

#### Características:
 
- Administración de horarios de atención.
- Restricción a solicitud de asesoría.
- Establecimiento de datos básicos del formulario
- Creación de campos dinámicos.
- Visualización del formulario de asesoría 
- Generación de URL del formulario.
- Administración de formularios de asesoría.
- Administración de agenda de asesorías
- Administración de estudiantes
- Administración de autorizaciones para asesoría.
- Administración de docentes del plan de estudios.
- Administración de planes de estudio.
- Modificación de información académica del docente.
- Generación de reporte de asesorías
- Solicitud de asesoría académica.
- Calificación de asesoría académica
- Visualización de formularios de asesoría del plan de estudios.
- Generación de reporte de asesorías por docente.
- Inicio de sesión
 
***
#### Contenido del PROYECTO 
 
1. [accounts](): Módulo de cuentas de acceso a la aplicación
  - [models.py](): Modelamiento de clases para la autenticación de usuarios
  - [serializers.py](): Serializador de modelos para la autenticación de usuarios.
2. [app/api](): Módulo de funcionalidades de la aplicación
  - [models](): Sección de los modelos del proyecto
    - [director.py](): Modelo representativo de usuario director.
    - [docente.py](): Modelo representativo de usuario docente.
    - [docenteEstudiante.py](): Modelo representativo de la relación entre los docentes y estudiantes.
    - [docentePrograma.py](): Modelo representativo de la relación entre los docentes y programas.
    - [estudiante.py](): Modelo representativo de usuario estudiante.
    - [formulario.py](): Modelo representativo del formulario que el docente pública para la atención de asesorías.
    - [formularioHorario.py](): Modelo representativo de los horarios en que un formulario está disponible.
    - [formularioPregunta.py](): Modelo representativo de las preguntas de un formulario, serán respondidas por los usuarios al momento de solicitar la asesoría.
    - [formularioPrograma.py](): Modelo representativo de los programas en que un formulario está disponible.
    - [preguntaSeleccion.py](): Modelo representativo de las selecciones que tiene una pregunta, cuando la pregunta es de tipo SELECCIÓN.
    - [programa.py](): Modelo representativo de los programas que imparte la institución.
    - [solicitudAsesoria.py](): Modelo representativo de las solicitudes que realizan los estudiantes para asesorías.
    - [solicitudEstudiante.py](): Modelo representativo de los estudiantes que realizan la solicitud de una asesoría.
    - [seleccionPreguntaRespuesta.py](): Modelo representativo de las respuestas ingresadas por el estudiante en la solicitud de asesorías.
 
  - [entradaFormSerializers](): Sección de los serializadores de los datos de entrada del proyecto
    - [entradaFormEstudiantesDocenteSerializer.py](): Clase serializadora para el cargue masivo de estudiantes por docente y programa.
    - [entradaFormEstudianteSerializer.py](): Clase serializadora para el registro de estudiante de una solicitud.
    - [entradaFormHorarioSerializer.py](): Clase serializadora para el registro de horarios de un formulario.
    - [entradaFormPreguntaSerializer.py](): Clase serializadora para el registro de preguntas de un formulario.
    - [entradaFormProgramasDocenteSerializer.py](): Clase serializadora para el cargue masivo de docentes por programa.
    - [entradaFormProgramasSerializer.py](): Clase serializadora para el cargue masivo de programas.
    - [entradaFormRecuperarSerializer.py](): Clase serializadora para la solicitud de restablecer contraseña.
    - [entradaFormReporteSerializer.py](): Clase serializadora para la generación de reporte dinámicos de las asesorías.
    - [entradaFormRespuestaSerializer.py](): Clase serializadora para el registro de la respuesta de las preguntas del formulario.
    - [entradaFormSolicitud.py](): Clase serializadora para el registro de la solicitud de una asesoría.
    - [entradaFormSolicitudAuditarSerializer.py](): Clase serializadora para la actualización del estado de una solicitud de asesoría.
    - [entradaFormSolicitudCalificarSerializer.py](): Clase serializadora para el registro de la calificación de la asesoría por parte del estudiante.
    - [entradaFormTurnosGeneralSerializer.py](): Clase serializadora para listar los turnos de un formulario.
    - [entradaFormTurnosSerializer.py](): Clase serializadora para listar los turnos de un formulario por fecha.
 
  - [serializers](): Sección de los serializadores de los modelos del proyecto
    - [directorSerializer.py](): Clase serializadora del modelo Director para consultar y administrar la información.
    - [docenteEstudianteMasivoSerializer.py](): Clase serializadora para la entrada del cargue masivo de estudiantes por docente y programa.
    - [docenteEstudianteSerializer.py](): Clase serializadora del modelo de DocenteEstudiante para consultar y administrar la información.
    - [docenteEstudiantesSerializer.py](): Clase serializadora del modelo de DocenteEstudiante para consultar y registrar la información.
    - [docenteProgramaSerializer.py](): Clase serializadora del modelo de DocentePrograma para consultar y registrar la información
    - [docenteProgramasSerializer.py](): Clase serializadora del modelo de DocentePrograma para consultar y administrar la información.
    - [docenteSerializer.py](): Clase serializadora del modelo de Docente para consultar y administrar la información.
    - [estudianteSerializer.py](): Clase serializadora del modelo de Estudiante para consultar y administrar la información.
    - [formularioHorarioSerializer.py](): Clase serializadora del modelo de FormularioHorario para consultar y administrar la información.
    - [formularioPreguntaSerializer.py](): Clase serializadora del modelo de FormularioPregunta para consultar y administrar la información.
    - [formularioProgramaSerializer.py](): Clase serializadora del modelo de FormularioPrograma para consultar y administrar la información.
    - [formularioSerializer.py](): Clase serializadora del modelo de Formulario para consultar y administrar la información.
    - [preguntaSeleccionSerializer.py](): Clase serializadora del modelo de PreguntaSeleccion para consultar y administrar la información.
    - [ProgramaSerializer.py](): Clase serializadora del modelo de Programa para consultar y administrar la información.
    - [ProgramaSimpleSerializer.py](): Clase serializadora del modelo de Programa para consultar la información básica.
    - [SolicitudEstudianteSerializer.py](): Clase serializadora del modelo de SolicitudEstudiante para consultar y administrar la información.
    - [SolicitudRespuestaSerializer.py](): Clase serializadora del modelo de SolicitudRespuesta para consultar y administrar la información.
    - [SolicitudSerializer.py](): Clase serializadora del modelo de Solicitud para consultar y administrar la información.
 
  - [utils](): Sección de los serializadores de los modelos del proyecto
    - [formatter.py](): Métodos para formatear y transformar datos.
    - [notifications.py](): Métodos para el envío de notificaciones vía correo electronico.
 
  - [views](): Sección de los serializadores de los modelos del proyecto
    - [viewCuenta.py](): Controlador para la administración de las cuentas de los usuarios.
    - [viewDirector.py](): Controlador para la administración de los usuarios de los directores.
    - [viewDocente.py](): Controlador para la administración de los usuarios de los docentes, los estudiantes y programas vinculados al docente.
    - [viewEstudiante.py](): Controlador para la administración de los estudiantes.
    - [viewFormulario.py](): Controlador para la administración de los formularios, los programas, preguntas y selecciones de los formularios.
    - [viewPrograma.py](): Controlador para la administración de los programas, los docentes, estudiantes y formularios de los programas.
    - [viewSolicitud.py](): Controlador para la administración de las solicitudes de asesorías, la generación de reportes, los turnos de las asesorías.
  - [admin.py](): Administración de los modelos que van a ser administrados por el framework.
  - [apps.py](): Configuración de la aplicación api.
  - [test.py](): Pruebas unitarias.
  - [urls.py](): Listado de las urls del módulo api del proyecto.
 
3. [backendAgendasApiRest](): Módulo de configuración del proyecto.
  - [settings]():Sección de configuración del proyecto.
    - [base.py](): Contenedor de controladores, directivas y servicios utilizados para la configuración.
    - [dev.py](): Importación de configuración en el proyecto cuando se encuentra en desarrollo.
    - [local.py](): Configuración en el proyecto cuando se encuentra en prueba en local.
    - [prod.py](): Importación de configuración en el proyecto cuando se encuentra en producción.
    - [server.py](): Configuración en el proyecto cuando se encuentra en prueba en el servidor.
  - [asgi.py](): Contenedor para importar la configuración del Framework Django y define toda la aplicación.
  - [wsgi.py](): Contenedor para importar la configuración estándar del Framework Python para aplicaciones y servidores web.
  - [url.py](): Contenedor de la lista de las URL de ejecución principal de la aplicación.
   
4. [security](): Seccción  de seguridad del sistema
  - [login](): Módulo para el inicio de sesión de docentes/directores/super usuario
***

#### Tecnologías
 
 - Python 3.8
 - Django 3.12
 - MySql
***

#### IDE
 
- Pycharm 2020.2.4
***

### Instalación
 
1.  Instalar [Python 3.8](https://www.python.org/downloads/)
2.  Instalar [VirtualEnv](pip install virtualenv)
3.  Crear entorno virtual (virtualenv env_agendas)
4.  Instalar [MySql](https://dev.mysql.com/downloads/)
5.  Crear la base de datos con nombre **agendas**
6.  Activar entorno virtual (activate env_agendas/bin/activate)
7.  Clonar el proyecto “backed-agendas-apirest" desde el [repositorio del proyecto](https://gitlab.com/agendas_docentes_ufps/agendas_bk.git)
8.  Instalar las dependencias requeridas por la aplicación ejecutando pip install, se crea en la carpeta requirements el archivo requirements donde se tiene el listado de estas dependencias, se puede ejecutar **pip install -r requirements** para instalar todas las dependencias de forma simultaneas (esto se realizar sobre la carpeta root del proyecto).
9. Crear en la carpeta base del proyecto un archivo **.env**, en el cual se deben agregar estas configuraciones:
  **Ejemplo**
        DEBUG=True
        SECRET_KEY=tp9t_+x%xe^-&xa9-4w&m_t_ev1p2*npmgi1kr27*e#3cn6#%3
        ALLOWED_HOSTS= ['*']
        DATABASE_HOST=localhost
        DATABASE_NAME=agendas
        DATABASE_USER=root
        DATABASE_PASSWORD=root
        DATABASE_PORT=3306
        EMAIL_HOST_USER=ufps.profundizacion@gmail.com
        EMAIL_HOST_PASSWORD=ufps1234
        DJANGO_SETTINGS_MODULE=backendAgendasApiRest.settings.dev
10. Crear la carpeta para migrar los modelos de python a tablas en MySQL con el comando **python manage.py makemigrations**
11. Hacer la migración a la base de datos con el comando **python manage.py migrate**
12. Inicia la aplicación corriendo el servicio con el comando **python manage.py runserver**
***

### Demo
 
Para ver el demo de la aplicación puede dirigirse a: [Gestión de asesorías académicas](http://agendadoc.cpsw.ingsistemasufps.co/#/).
***

### Autor(es)
Proyecto desarrollado por:
 
1. Alvaro Arlex Perez Moncada (<alvaroarlexpm@ufps.edu.co>).
2. Yhuver Andrey Quintero niño (<yhuverandreyqn@ufps.edu.co>).
3. Diego Alejandro Chavez Parra (<diegoalejandrocp@ufps.edu.co>).
***

### Institución Académica  
Proyecto desarrollado en el curso de profundización en Desarrollo de Software del  [Programa de Ingeniería de Sistemas] de la [Universidad Francisco de Paula Santander]
 
  [Programa de Ingeniería de Sistemas]:<https://ingsistemas.cloud.ufps.edu.co/>
  [Universidad Francisco de Paula Santander]:<https://ww2.ufps.edu.co/>

