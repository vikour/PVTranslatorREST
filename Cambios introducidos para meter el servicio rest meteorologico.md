-Han sido introducidas ciertas lineas de codigo debajo de la tabla de modulos en index.xhtml:

                Ciudad: #{servicioMeteorologicoBean.ciudad}<br/>
                Tiempo actual: #{servicioMeteorologicoBean.tiempo}<br/>
                Temperatura actual: #{servicioMeteorologicoBean.temperatura} ºC<br/>
                Humedad actual: #{servicioMeteorologicoBean.humedad} %<br/>
                Velocidad del viento actual: #{servicioMeteorologicoBean.velocidadViento} m/s<br/>
                Direccion del viento actual: #{servicioMeteorologicoBean.direccionViento} º<br/>
                Porcentaje de nubes actual: #{servicioMeteorologicoBean.nubesActual} %<br/>
                
-Ha sido creado un nuevo Bean que usara el servicio rest meteorologico y adaptara los datos 
para ser usados y representados en el index.xhtml
El nombre es ServicioMeteorologicoBean y esta en A6ClienteRest\Source Packages\es.uma.a6.beans en el proyecto, 
en github es la carpeta A6ClienteRest\src\java\es\uma\a6\beans

-Ha sido introducido un jar llamado org.jason.jar que es importado desde la carpeta A6ClienteRest\lib y usado en ServicioMeteorologicoBean

-Se ha actualizado el archivo de la configuracion del proyecto para tener la libreria importada por defecto