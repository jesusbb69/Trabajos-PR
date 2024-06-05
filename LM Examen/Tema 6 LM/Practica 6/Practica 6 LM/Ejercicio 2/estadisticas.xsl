<?xml version="1.0" encoding="UTF-8"?>

 <!-- Ejercicio teorico a. Si es posible prescindir de esa linea ya que esta especifica la hoja de estilos XSLT que se aplicara al xml cuando se abra en un navegador pero como estamos usando apache FOP no e necesario-->
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="page" page-height="29.7cm" page-width="21cm" margin-top="1cm" margin-bottom="1cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="16pt" font-family="sans-serif" line-height="30pt" space-after="15pt" background-color="burlywood" color="black" text-align="center" padding-top="2pt">
                    Estadísticas del concurso
                    </fo:block>
                    <fo:block font-size="16pt" font-family="sans-serif" line-height="15pt" space-after="3pt">
                    Número total de participantes: <xsl:value-of select="count(//participante)"/>
                    </fo:block>
                    <fo:block font-size="16pt" font-family="sans-serif" line-height="15pt" space-after="3pt">
                    Puntuación media: <xsl:value-of select="format-number(sum(//participante/puntos) div count(//participante), '#.##')"/>
                    </fo:block>
                    <fo:block font-size="16pt" font-family="sans-serif" line-height="15pt" space-after="3pt" margin-top="1cm">    
                    Participantes de 18 a 30 años: 
                    <xsl:value-of select="count(//participante[edad &gt;= 18 and edad &lt;= 30])"/>
                    (<xsl:value-of select="format-number((count(//participante[edad &gt;= 18 and edad &lt;= 30]) div count(//participante)) * 100, '#.##')"/>%)
                    </fo:block>
                    <fo:block font-size="16pt" font-family="sans-serif" line-height="15pt" space-after="3pt">
                    Participantes de 31 a 45 años: 
                    <xsl:value-of select="count(//participante[edad &gt;= 31 and edad &lt;= 45])"/>
                    (<xsl:value-of select="format-number((count(//participante[edad &gt;= 31 and edad &lt;= 45]) div count(//participante)) * 100, '#.##')"/>%)
                    </fo:block>
                    <fo:block font-size="16pt" font-family="sans-serif" line-height="15pt" space-after="3pt">
                     Participantes de 46 a 65 años: 
                    <xsl:value-of select="count(//participante[edad &gt;= 46 and edad &lt;= 65])"/>
                    (<xsl:value-of select="format-number((count(//participante[edad &gt;= 46 and edad &lt;= 65]) div count(//participante)) * 100, '#.##')"/>%)
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
