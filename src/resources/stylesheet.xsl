<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output method="xml" indent="yes" />
	
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->

		<fo:root>
	
			<fo:layout-master-set>
				<fo:simple-page-master master-name="first"
					margin-bottom="2cm"
					margin-top="1cm" page-width="21cm" page-height="29.7cm">
					<fo:region-body margin-top="1.7cm" />
					<fo:region-before extent="3cm" />
					<fo:region-after extent="1.5cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
	
			<fo:page-sequence master-reference="first">
	
				<fo:static-content flow-name="xsl-region-before">
					<fo:block font-size="30pt" font-family="serif" text-align="center"
						font-weight="bold">
						Devaraj Gurikar
					</fo:block>
					<fo:block font-size="15pt" font-family="serif" 
						font-weight="bold" text-align ="center">
						
						<fo:inline border-right="solid 1px black" padding="2px">
          					+91-7204305688
        				</fo:inline>
        				
        				<fo:inline border-right="solid 1px black" padding="2px">
        					LinkedIn: 
							<fo:basic-link  external-destination="url('https://www.linkedin.com/in/devaraj-gurikar-1634a750/')" 
    							 text-decoration="underline">
     							 Devaraj Gurikar
   							</fo:basic-link>          					
        				</fo:inline>
        				
        				<fo:inline>
          					gurikar.devaraj@gmail.com
        				</fo:inline>
        				
					</fo:block>
					
					<fo:block>
						<fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="0.2pt"/>
					</fo:block>
					
				</fo:static-content>
			
				 
			
			
				<fo:flow flow-name="xsl-region-body">
					
					<fo:block margin-top="16.6pt" space-before.optimum="10pt" space-after.optimum="10pt">
						<fo:table>
							<fo:table-column column-width="100pt" border-right="solid 0.1pt" padding="1pt"/>
							<fo:table-column column-width="auto" />
							
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell >
										<fo:block padding-top="50pt">
										asdffffffffffffffffffffff
											
										</fo:block>
									</fo:table-cell>
										
									<fo:table-cell>
										<fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell >
										<fo:block padding-top="50pt">
										asdffffffffffffffffffffff
											
										</fo:block>
									</fo:table-cell>
										
									<fo:table-cell>
										<fo:block>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
							
						</fo:table>
					</fo:block>
					
				</fo:flow>
			</fo:page-sequence>
			
		</fo:root>
	</xsl:template>
</xsl:stylesheet>