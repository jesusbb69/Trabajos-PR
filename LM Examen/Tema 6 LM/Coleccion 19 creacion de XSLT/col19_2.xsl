<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    th { 
                        background-color:#0000FF;
                        color:white;
                    }

                </style>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <th> marca</th>
                        <th> web</th>
                        <th> modelo</th>
                        <th> precio</th>
                        <th> financiado</th>
                    </tr>
                    <xsl:for-each select="//vehiculo"> 
                    <tr>
                    <td><xsl:value-of select="marca"/></td>
                    <td><xsl:value-of select="web"/></td>
                    <td><xsl:value-of select="modelo"/></td>
                    <td><xsl:value-of select="precio"/></td>
                    <xsl:for-each select="precio">
                    <td><xsl:value-of select="@financiado"/></td>
                    </xsl:for-each>
                    </tr>
                </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>