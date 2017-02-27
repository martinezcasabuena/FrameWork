# FrameWork

La aplicación consiste en un menu CRUD orientado a la gestión de usuarios.


Tipos de usuarios
--------------------
+ Usuario normal.
+ Cliente.
+ Administrador.

Todos ellos comparten campos pero también tienen los suyos propios.

Funciones del crud
--------------------
+ **Crear:** Nos aparecerá un mensaje para introducir un DNI. Si el DNI existe no podremos crear el usuario, si no existe nos seguiran apareciendo cuadros de texto para rellenar los datos.

+ **Leer:** Podemos leer todos los usuarios creados o elegir solor uno. Si los leemos todos, se irán mostrando los usuarios. Si queremos leer solo uno, nos aparecerá un desplegable con el nombre y el DNI del usuario.

+ **Actualizar:** Podemos actualizar los usuarios. Para ello seleccionaremos uno en el desplegable que nos aparecerá.

+ **Eliminar:** Nos permite borrar los usuarios.

+ **Ordenar:** Podemos ordenar los usuarios por los distintos campos. La ordenación afecta a la hora de leer todos los usuarios.

+ **Guardar:** Guardamos los usuarios creados en un archivo .TXT, .XML o .JSON.

+ **Abrir:** Tenemos la opción de abrir usuarios que hayamos guardado previamente. Los formatos para poder abrir son los mismos que para guardar.

Ajustes
--------------------
Tenemos una serie de ajustes para personalizar la aplicación, que son:

+ **Formato de fecha:** dd/mm/yyyy, dd-mm-yyy, yyyy/mm/dd, yyyy-mm-dd.

+ **Formato de moneda:** Euros(€), Dolares($) y Libras(£).

+ **Decimales:** Elegimos entre 1, 2 o 3 decimales.

+ **Idioma:** Inglés, Castellano o Valenciano.

+ **Formato** de guardado: TXT, XML o JSON.

+ **Tema:** Metal, GTK, MOTIF, Ninbus, Windows95, Windows.

En los comboBox aparece seleccionada la configuración actual.