<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Tanulók</h2>
                <table border="1">
                    <tr bgcolor = "#ffcc00">
                        <th>ID</th>
                        <th>Vezetéknév</th>
                        <th>Keresztnév</th>
                        <th>Becenév</th>
                        <th>Fizetés</th>
                        <th>Fokozat</th>
                    </tr>

                    <xsl:for-each select = "class/student">

                        <tr>
                            <td><xsl:value-of select = "@id"/></td>
                            <td><xsl:value-of select = "firstname"/></td>
                            <td><xsl:value-of select = "lastname"/></td>
                            <td><xsl:value-of select = "nickname"/></td>
                            <td><xsl:value-of select = "salary"/></td>

                            <td>
                                <xsl:choose>
                                    <xsl:when test = "salary > 400000">
                                        High
                                    </xsl:when>

                                    <xsl:when test = "salary > 250000">
                                        Medium
                                    </xsl:when>

                                    <xsl:otherwise>
                                        Low
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>