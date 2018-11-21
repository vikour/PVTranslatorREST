# PVTranslatorREST

En esta práctica desarrollaremos servicios REST para el caso de estudio considerado por cada grupo (aplicación web para
dibujantes o sistemas fotovoltaicos). Para ello, de entre las entidades existentes en el modelo conceptual del caso de estudio, elegiremos dos, interrelacionadas con multiplicidad 1:* o *:*. Podéis elegir las mismas que para la práctica de SOA, u otras diferentes.

1. Representaremos las dos entidades y su relación mediante tablas, creando para ello nuestra propia base de datos Derby (Java DB) o MySQL. El nombre de la base de datos será iweb, y existirá en ella un usuario iweb, con privilegios de acceso completos, y con password también iweb (siempre en minúsculas).

2. Para el lado servidor, crearemos un proyecto NetBeans, con servicios REST a partir de ambas entidades. Extenderemos la funcionalidad CRUD generada por defecto con NetBeans con los siguientes servicios (de nuevo, pueden ser las mismas consultas que para la práctica de SOA, u otras diferentes):
	* al menos dos operaciones de consulta sobre cada una de las tablas, con la funcionalidad que se considere oportuna.
	* al menos una función de búsqueda parametrizada para cada una de las tablas, con los parámetros y la funcionalidad que se consideren oportunos.
	* al menos una operación de consulta que haga uso de la relación entre las dos entidades.

3. Para el lado cliente, desarrollaremos una aplicación utilizando las tecnologías que queramos (Java, Python, JSP, JSF, AJAX, AngularJS, Ionic, etc.). El cliente hará uso de los servicios CRUD, consultas y búsquedas desplegados como servicios REST para implementar parte de la funcionalidad básica del caso de estudio considerado. En esta práctica se valorarán en mayor medida que en la práctica de SOA tanto la funcionalidad como el diseño del cliente REST: estilos y tipos de letra,
colores, imágenes, layout, diseño adaptativo (responsive), etc.

4. Ya sea en el servidor o el cliente, integraremos en nuestra aplicación funcionalidad de al menos dos servicios REST externos (mapas, galerías de imágenes, redes sociales, etc.) y que tengan relación con los requisitos del caso de estudio.

5. Dotaremos a nuestra aplicación de acceso de usuarios autentificado mediante OAuth 2.0, por ejemplo, a partir de las cuentas de usuario de Google. Desde el lado cliente, el usuario podrá hacer login y logout en el sistema, y utilizar la aplicación con distintas funcionalidades, dependiendo de si el acceso es autentificado o anónimo y/o del nivel de privilegios del usuario. En este último caso, ofreceremos privilegios de acceso máximos al usuario pruebaparaingweb@gmail.com.

6. Por último, para facilitar la comprobación de los servicios web ofrecidos en el lado servidor, desarrollaremos un cliente de test (una aplicación web distinta de la anterior) que permita invocar cada una de las operaciones del servicio y muestre los resultados. Este cliente de test puede ser una simple página HTML con enlaces que llamen a cada una de las operaciones y muestren el resultado tabulado en el navegador. 

# Integrantes

	Víctor Manuel Ortiz Guardeño
	Carlos Gamero
	Alberto
	Sergio

# Hecho

	- [x] Servidor REST.
		- [ ] Creación de una interfaz REST cliente -> servidor.
			- [ ] Adaptación del Tester.
			- [ ] Adaptación del cliente.
	- [ ] Diseño gráfico de la interfaz del cliente.
	- [ ] Invesitación, diseño e implementación de Oauth.
	- [ ] Búsqueda de App REST de terceros y estudiar como integrarlas.
