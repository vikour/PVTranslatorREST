-Han sido introducidas ciertas lineas de codigo debajo de los botones nuevo e importar en index.xhtml para redirigir a la pagina con la tabla del servicio meteorologico:

                <h:form>
                    <h:commandLink   class="btn btn-primary"
                                     id="botonTiempo"
                                     value="Ver el tiempo"
                                     action="#{servMeteo5Dias3HorasBean.verTiempo()}">
                    </h:commandLink>
                </h:form>
                
-Ha sido creado un nuevo Bean que usara el servicio rest meteorologico y adaptara los datos 
para ser usados y representados en el verTiempo.xhtml
El nombre es ServicioMeteorologico5Dias3HorasBean y esta en "A6ClienteRest\Source Packages\es.uma.a6.beans" en el proyecto, 
en github es la carpeta A6ClienteRest\src\java\es\uma\a6\beans

-Ha sido introducido un jar llamado org.jason.jar que es importado desde la carpeta A6ClienteRest\lib y usado en ServicioMeteorologico5Dias3HorasBean
