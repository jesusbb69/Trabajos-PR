<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>
<xsl:template match="/">
<html lang="es">
    <head>
        <meta charset="UTF-8"/>
        <title>Participantes</title>
        <link rel="stylesheet" href="estilos.css"/> 
    </head>
    <body>
        <div class="header">
            <h1>Información sobre el concurso</h1>
        </div>
    
        <main>
            <h2>Listado de participantes</h2>
            <ol class="participantes">
                <!-- Lista de participantes-->
                <xsl:for-each select="concurso/participante">
                    <xsl-sort select="apellidos" order="descending"/>
                <li>
                    <xsl:value-of select="apellidos"></xsl:value-of>
                    <xsl:text>,</xsl:text>
                    <xsl:value-of select="nombre"></xsl:value-of>
                    <xsl:text>. (</xsl:text>
                    <xsl:value-of select="@codigo"></xsl:value-of>
                    <xsl:text>) - </xsl:text>
                    <xsl:value-of select="puntos"> </xsl:value-of>
                    <xsl:text> puntos</xsl:text> 
                </li>                
                </xsl:for-each>
            </ol>
            <h2>Los 2 mejores participantes con más de 20 puntos</h2>
        <table class="participantes-t ancho">
            <thead>
                <tr>
                    <th>Posición</th>
                    <th>Participante</th>
                    <th>Puntos</th>
                </tr>
            </thead>
            <tbody>
                <!-- Tabla de participantes-->
                <xsl:for-each select="//participante[puntos > 20]">
                <xsl:sort select="puntos" order="descending"></xsl:sort>
                <xsl:if test="position() &lt;= 2">
                <tr>
                    <td>
                        <xsl:value-of select="position()"></xsl:value-of>
                    </td>
                    <td>
                        <xsl:value-of select="apellidos"></xsl:value-of>
                        <xsl:text>,</xsl:text>
                        <xsl:value-of select="nombre"></xsl:value-of>
                    </td>
                    <td>
                        <xsl:value-of select="puntos"></xsl:value-of>
                    </td>
                </tr>
                </xsl:if>
                </xsl:for-each>
            </tbody>
        </table>       
    </main>
    <footer>
        <p>Año 2024</p>
    </footer>       
    </body>   
</html>
</xsl:template>
</xsl:stylesheet>