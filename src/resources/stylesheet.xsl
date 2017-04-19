<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output method="xml" indent="yes" />
	
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->

		<fo:root>
	
			<fo:layout-master-set>
				<fo:simple-page-master master-name="first"
					margin-right="1.5cm" margin-left="1.5cm" margin-bottom="2cm"
					margin-top="1cm" page-width="21cm" page-height="29.7cm">
					<fo:region-body margin-top="1.5cm" />
					<fo:region-before extent="3cm" />
					<fo:region-after extent="1.5cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
	
			<fo:page-sequence master-reference="first">
	
				<fo:static-content flow-name="xsl-region-before">
					<fo:block font-size="14pt" font-family="serif" text-align="left"
						font-weight="bold">
						Resume
					</fo:block>
				</fo:static-content>
			
			
				<fo:flow flow-name="xsl-region-body">
					<fo:block >
						Pulling it Together: Your Match Summary
						<fo:block space-after.optimum="10pt">
							_________________________________________________________________________
						</fo:block>
					</fo:block>
					
				</fo:flow>
			</fo:page-sequence>
			
		</fo:root>
	</xsl:template>
</xsl:stylesheet>