<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>
                    <xsl:value-of select="/receta/@nombre" />
                </h1>
                <ul>
                    <xsl:for-each select="//ingrediente">  
                    <li>
                                      
                        <xsl:value-of select="@nombre"></xsl:value-of>

                    
                    </li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
