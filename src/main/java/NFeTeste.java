import app.notafiscal.NfeApi;

public class NFeTeste {


    public static void main(String[] args) {

        NfeApi api = new NfeApi();

        /*api.NfeConfigurar("123456",
                "changeit",
                "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\gniweb16Prototipo\\1\\1.p12",
                "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\gniweb16Prototipo\\certificados\\homologacao.cacerts",
                "PR",
                "2",
                "1",
                "1",
                "4.00"
        );*/

        api.NfeConfigurar("1234",
                "changeit",
                "D:\\Certificado\\grapa1234.pfx",
                "D:\\Certificado\\homologacao.cacerts",
                "PR",
                "2",
                "1",
                "1",
                "4.00"
        );

        String xml = "<enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"4.00\">\n" +
                "  <idLote>2369</idLote>\n" +
                "  <indSinc>1</indSinc>\n" +
                "  <NFe>\n" +
                "    <infNFe Id=\"NFe41210129728420000170550020000003721010003722\" versao=\"4.00\">\n" +
                "      <ide>\n" +
                "        <cUF>41</cUF>\n" +
                "        <cNF>01000372</cNF>\n" +
                "        <natOp>VENDA DENTRO DO ESTADO S/IPI</natOp>\n" +
                "        <mod>55</mod>\n" +
                "        <serie>2</serie>\n" +
                "        <nNF>372</nNF>\n" +
                "        <dhEmi>2021-01-05T15:08:03-03:00</dhEmi>\n" +
                "        <dhSaiEnt>2021-01-05T15:08:03-03:00</dhSaiEnt>\n" +
                "        <tpNF>1</tpNF>\n" +
                "        <idDest>1</idDest>\n" +
                "        <cMunFG>4101507</cMunFG>\n" +
                "        <tpImp>1</tpImp>\n" +
                "        <tpEmis>1</tpEmis>\n" +
                "        <cDV>2</cDV>\n" +
                "        <tpAmb>2</tpAmb>\n" +
                "        <finNFe>1</finNFe>\n" +
                "        <indFinal>1</indFinal>\n" +
                "        <indPres>1</indPres>\n" +
                "        <procEmi>0</procEmi>\n" +
                "        <verProc>4.01</verProc>\n" +
                "      </ide>\n" +
                "      <emit>\n" +
                "        <CNPJ>29728420000170</CNPJ>\n" +
                "        <xNome>FRADE MOVELARIA - EIRELI</xNome>\n" +
                "        <xFant>FRADE MOVELARIA</xFant>\n" +
                "        <enderEmit>\n" +
                "          <xLgr>JURITI (GALPAO/PORTAO 58 A 63)</xLgr>\n" +
                "          <nro>126</nro>\n" +
                "          <xBairro>PQ INDUSTRIAL</xBairro>\n" +
                "          <cMun>4101507</cMun>\n" +
                "          <xMun>ARAPONGAS</xMun>\n" +
                "          <UF>PR</UF>\n" +
                "          <CEP>86706010</CEP>\n" +
                "          <cPais>1058</cPais>\n" +
                "          <xPais>BRASIL</xPais>\n" +
                "          <fone>31728555</fone>\n" +
                "        </enderEmit>\n" +
                "        <IE>9077317233</IE>\n" +
                "        <CRT>1</CRT>\n" +
                "      </emit>\n" +
                "      <dest>\n" +
                "        <CNPJ>28206286000185</CNPJ>\n" +
                "        <xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome>\n" +
                "        <enderDest>\n" +
                "          <xLgr>RUA DONA ISABEL</xLgr>\n" +
                "          <nro>979</nro>\n" +
                "          <xBairro>CENTRO</xBairro>\n" +
                "          <cMun>4124608</cMun>\n" +
                "          <xMun>SAO CARLOS DO ivai</xMun>\n" +
                "          <uf>pr</uf>\n" +
                "          <cep>87770000</cep>\n" +
                "          <cpais>1058</cpais>\n" +
                "          <xpais>brasil</xpais>\n" +
                "          <fone>34381871</fone>\n" +
                "        </enderDest>\n" +
                "        <indiedest>1</indiedest>\n" +
                "        <ie>9075588949</ie>\n" +
                "        <email>moveis.menezes@hotmail.com</email>\n" +
                "      </dest>\n" +
                "      <det nItem=\"1\">\n" +
                "        <prod>\n" +
                "          <cProd>10.00423152</cProd>\n" +
                "          <cEAN>7899578816204</cEAN>\n" +
                "          <xProd>NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xProd>\n" +
                "          <NCM>94036000</NCM>\n" +
                "          <CFOP>5101</CFOP>\n" +
                "          <uCom>UN</uCom>\n" +
                "          <qCom>1.0000</qCom>\n" +
                "          <vUnCom>195.8040000000</vUnCom>\n" +
                "          <vProd>195.80</vProd>\n" +
                "          <cEANTrib>7899578816204</cEANTrib>\n" +
                "          <uTrib>UN</uTrib>\n" +
                "          <qTrib>1.0000</qTrib>\n" +
                "          <vUnTrib>195.8040000000</vUnTrib>\n" +
                "          <indTot>1</indTot>\n" +
                "          <nItemPed>1</nItemPed>\n" +
                "        </prod>\n" +
                "        <imposto>\n" +
                "          <ICMS>\n" +
                "            <ICMSSN101>\n" +
                "              <orig>0</orig>\n" +
                "              <CSOSN>101</CSOSN>\n" +
                "              <pCredSN>1.60</pCredSN>\n" +
                "              <vCredICMSSN>3.12</vCredICMSSN>\n" +
                "            </ICMSSN101>\n" +
                "          </ICMS>\n" +
                "          <IPI>\n" +
                "            <CNPJProd>00000000000000</CNPJProd>\n" +
                "            <cSelo>N</cSelo>\n" +
                "            <qSelo>0</qSelo>\n" +
                "            <cEnq>999</cEnq>\n" +
                "            <IPITrib>\n" +
                "              <CST>99</CST>\n" +
                "              <vBC>0.00</vBC>\n" +
                "              <pIPI>0.00</pIPI>\n" +
                "              <vIPI>0.00</vIPI>\n" +
                "            </IPITrib>\n" +
                "          </IPI>\n" +
                "          <PIS>\n" +
                "            <PISNT>\n" +
                "              <CST>08</CST>\n" +
                "            </PISNT>\n" +
                "          </PIS>\n" +
                "          <COFINS>\n" +
                "            <COFINSNT>\n" +
                "              <CST>08</CST>\n" +
                "            </COFINSNT>\n" +
                "          </COFINS>\n" +
                "        </imposto>\n" +
                "      </det>\n" +
                "      <det nItem=\"2\">\n" +
                "        <prod>\n" +
                "          <cProd>10.00394124</cProd>\n" +
                "          <cEAN>7899578816167</cEAN>\n" +
                "          <xProd>NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xProd>\n" +
                "          <NCM>94036000</NCM>\n" +
                "          <CFOP>5101</CFOP>\n" +
                "          <uCom>UN</uCom>\n" +
                "          <qCom>1.0000</qCom>\n" +
                "          <vUnCom>238.9176000000</vUnCom>\n" +
                "          <vProd>238.92</vProd>\n" +
                "          <cEANTrib>7899578816167</cEANTrib>\n" +
                "          <uTrib>UN</uTrib>\n" +
                "          <qTrib>1.0000</qTrib>\n" +
                "          <vUnTrib>238.9176000000</vUnTrib>\n" +
                "          <indTot>1</indTot>\n" +
                "          <nItemPed>2</nItemPed>\n" +
                "        </prod>\n" +
                "        <imposto>\n" +
                "          <ICMS>\n" +
                "            <ICMSSN101>\n" +
                "              <orig>0</orig>\n" +
                "              <CSOSN>101</CSOSN>\n" +
                "              <pCredSN>1.60</pCredSN>\n" +
                "              <vCredICMSSN>3.81</vCredICMSSN>\n" +
                "            </ICMSSN101>\n" +
                "          </ICMS>\n" +
                "          <IPI>\n" +
                "            <CNPJProd>00000000000000</CNPJProd>\n" +
                "            <cSelo>N</cSelo>\n" +
                "            <qSelo>0</qSelo>\n" +
                "            <cEnq>999</cEnq>\n" +
                "            <IPITrib>\n" +
                "              <CST>99</CST>\n" +
                "              <vBC>0.00</vBC>\n" +
                "              <pIPI>0.00</pIPI>\n" +
                "              <vIPI>0.00</vIPI>\n" +
                "            </IPITrib>\n" +
                "          </IPI>\n" +
                "          <PIS>\n" +
                "            <PISNT>\n" +
                "              <CST>08</CST>\n" +
                "            </PISNT>\n" +
                "          </PIS>\n" +
                "          <COFINS>\n" +
                "            <COFINSNT>\n" +
                "              <CST>08</CST>\n" +
                "            </COFINSNT>\n" +
                "          </COFINS>\n" +
                "        </imposto>\n" +
                "      </det>\n" +
                "      <det nItem=\"3\">\n" +
                "        <prod>\n" +
                "          <cProd>10.00431124</cProd>\n" +
                "          <cEAN>7899578816327</cEAN>\n" +
                "          <xProd>NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xProd>\n" +
                "          <NCM>94036000</NCM>\n" +
                "          <CFOP>5101</CFOP>\n" +
                "          <uCom>UN</uCom>\n" +
                "          <qCom>1.0000</qCom>\n" +
                "          <vUnCom>161.5248000000</vUnCom>\n" +
                "          <vProd>161.52</vProd>\n" +
                "          <cEANTrib>7899578816327</cEANTrib>\n" +
                "          <uTrib>UN</uTrib>\n" +
                "          <qTrib>1.0000</qTrib>\n" +
                "          <vUnTrib>161.5248000000</vUnTrib>\n" +
                "          <indTot>1</indTot>\n" +
                "          <nItemPed>3</nItemPed>\n" +
                "        </prod>\n" +
                "        <imposto>\n" +
                "          <ICMS>\n" +
                "            <ICMSSN101>\n" +
                "              <orig>0</orig>\n" +
                "              <CSOSN>101</CSOSN>\n" +
                "              <pCredSN>1.60</pCredSN>\n" +
                "              <vCredICMSSN>2.58</vCredICMSSN>\n" +
                "            </ICMSSN101>\n" +
                "          </ICMS>\n" +
                "          <IPI>\n" +
                "            <CNPJProd>00000000000000</CNPJProd>\n" +
                "            <cSelo>N</cSelo>\n" +
                "            <qSelo>0</qSelo>\n" +
                "            <cEnq>999</cEnq>\n" +
                "            <IPITrib>\n" +
                "              <CST>99</CST>\n" +
                "              <vBC>0.00</vBC>\n" +
                "              <pIPI>0.00</pIPI>\n" +
                "              <vIPI>0.00</vIPI>\n" +
                "            </IPITrib>\n" +
                "          </IPI>\n" +
                "          <PIS>\n" +
                "            <PISNT>\n" +
                "              <CST>08</CST>\n" +
                "            </PISNT>\n" +
                "          </PIS>\n" +
                "          <COFINS>\n" +
                "            <COFINSNT>\n" +
                "              <CST>08</CST>\n" +
                "            </COFINSNT>\n" +
                "          </COFINS>\n" +
                "        </imposto>\n" +
                "      </det>\n" +
                "      <det nItem=\"4\">\n" +
                "        <prod>\n" +
                "          <cProd>10.00428124</cProd>\n" +
                "          <cEAN>7899578815849</cEAN>\n" +
                "          <xProd>NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xProd>\n" +
                "          <NCM>94036000</NCM>\n" +
                "          <CFOP>5101</CFOP>\n" +
                "          <uCom>UN</uCom>\n" +
                "          <qCom>2.0000</qCom>\n" +
                "          <vUnCom>342.4572000000</vUnCom>\n" +
                "          <vProd>684.91</vProd>\n" +
                "          <cEANTrib>7899578815849</cEANTrib>\n" +
                "          <uTrib>UN</uTrib>\n" +
                "          <qTrib>2.0000</qTrib>\n" +
                "          <vUnTrib>342.4572000000</vUnTrib>\n" +
                "          <indTot>1</indTot>\n" +
                "          <nItemPed>4</nItemPed>\n" +
                "        </prod>\n" +
                "        <imposto>\n" +
                "          <ICMS>\n" +
                "            <ICMSSN101>\n" +
                "              <orig>0</orig>\n" +
                "              <CSOSN>101</CSOSN>\n" +
                "              <pCredSN>1.60</pCredSN>\n" +
                "              <vCredICMSSN>10.93</vCredICMSSN>\n" +
                "            </ICMSSN101>\n" +
                "          </ICMS>\n" +
                "          <IPI>\n" +
                "            <CNPJProd>00000000000000</CNPJProd>\n" +
                "            <cSelo>N</cSelo>\n" +
                "            <qSelo>0</qSelo>\n" +
                "            <cEnq>999</cEnq>\n" +
                "            <IPITrib>\n" +
                "              <CST>99</CST>\n" +
                "              <vBC>0.00</vBC>\n" +
                "              <pIPI>0.00</pIPI>\n" +
                "              <vIPI>0.00</vIPI>\n" +
                "            </IPITrib>\n" +
                "          </IPI>\n" +
                "          <PIS>\n" +
                "            <PISNT>\n" +
                "              <CST>08</CST>\n" +
                "            </PISNT>\n" +
                "          </PIS>\n" +
                "          <COFINS>\n" +
                "            <COFINSNT>\n" +
                "              <CST>08</CST>\n" +
                "            </COFINSNT>\n" +
                "          </COFINS>\n" +
                "        </imposto>\n" +
                "      </det>\n" +
                "      <det nItem=\"5\">\n" +
                "        <prod>\n" +
                "          <cProd>10.00424124</cProd>\n" +
                "          <cEAN>7899578815825</cEAN>\n" +
                "          <xProd>NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xProd>\n" +
                "          <NCM>94036000</NCM>\n" +
                "          <CFOP>5101</CFOP>\n" +
                "          <uCom>UN</uCom>\n" +
                "          <qCom>1.0000</qCom>\n" +
                "          <vUnCom>422.0748000000</vUnCom>\n" +
                "          <vProd>422.07</vProd>\n" +
                "          <cEANTrib>7899578815825</cEANTrib>\n" +
                "          <uTrib>UN</uTrib>\n" +
                "          <qTrib>1.0000</qTrib>\n" +
                "          <vUnTrib>422.0748000000</vUnTrib>\n" +
                "          <indTot>1</indTot>\n" +
                "          <nItemPed>5</nItemPed>\n" +
                "        </prod>\n" +
                "        <imposto>\n" +
                "          <ICMS>\n" +
                "            <ICMSSN101>\n" +
                "              <orig>0</orig>\n" +
                "              <CSOSN>101</CSOSN>\n" +
                "              <pCredSN>1.60</pCredSN>\n" +
                "              <vCredICMSSN>6.74</vCredICMSSN>\n" +
                "            </ICMSSN101>\n" +
                "          </ICMS>\n" +
                "          <IPI>\n" +
                "            <CNPJProd>00000000000000</CNPJProd>\n" +
                "            <cSelo>N</cSelo>\n" +
                "            <qSelo>0</qSelo>\n" +
                "            <cEnq>999</cEnq>\n" +
                "            <IPITrib>\n" +
                "              <CST>99</CST>\n" +
                "              <vBC>0.00</vBC>\n" +
                "              <pIPI>0.00</pIPI>\n" +
                "              <vIPI>0.00</vIPI>\n" +
                "            </IPITrib>\n" +
                "          </IPI>\n" +
                "          <PIS>\n" +
                "            <PISNT>\n" +
                "              <CST>08</CST>\n" +
                "            </PISNT>\n" +
                "          </PIS>\n" +
                "          <COFINS>\n" +
                "            <COFINSNT>\n" +
                "              <CST>08</CST>\n" +
                "            </COFINSNT>\n" +
                "          </COFINS>\n" +
                "        </imposto>\n" +
                "      </det>\n" +
                "      <total>\n" +
                "        <ICMSTot>\n" +
                "          <vBC>0.00</vBC>\n" +
                "          <vICMS>0.00</vICMS>\n" +
                "          <vICMSDeson>0</vICMSDeson>\n" +
                "          <vFCPUFDest>0</vFCPUFDest>\n" +
                "          <vICMSUFDest>0</vICMSUFDest>\n" +
                "          <vICMSUFRemet>0</vICMSUFRemet>\n" +
                "          <vFCP>0</vFCP>\n" +
                "          <vBCST>0.00</vBCST>\n" +
                "          <vST>0.00</vST>\n" +
                "          <vFCPST>0</vFCPST>\n" +
                "          <vFCPSTRet>0</vFCPSTRet>\n" +
                "          <vProd>1703.22</vProd>\n" +
                "          <vFrete>0.00</vFrete>\n" +
                "          <vSeg>0.00</vSeg>\n" +
                "          <vDesc>0.00</vDesc>\n" +
                "          <vII>0.00</vII>\n" +
                "          <vIPI>0.00</vIPI>\n" +
                "          <vIPIDevol>0</vIPIDevol>\n" +
                "          <vPIS>0.00</vPIS>\n" +
                "          <vCOFINS>0.00</vCOFINS>\n" +
                "          <vOutro>0.00</vOutro>\n" +
                "          <vNF>1703.22</vNF>\n" +
                "        </ICMSTot>\n" +
                "      </total>\n" +
                "      <transp>\n" +
                "        <modFrete>1</modFrete>\n" +
                "        <vol>\n" +
                "          <qVol>9</qVol>\n" +
                "          <esp>VOLUME</esp>\n" +
                "          <marca>FRADE</marca>\n" +
                "          <pesoL>277.400</pesoL>\n" +
                "          <pesoB>282.400</pesoB>\n" +
                "        </vol>\n" +
                "      </transp>\n" +
                "      <cobr>\n" +
                "        <fat>\n" +
                "          <nFat>372</nFat>\n" +
                "          <vOrig>1703.22</vOrig>\n" +
                "          <vLiq>1703.22</vLiq>\n" +
                "        </fat>\n" +
                "        <dup>\n" +
                "          <nDup>001</nDup>\n" +
                "          <dVenc>2021-02-04</dVenc>\n" +
                "          <vDup>567.74</vDup>\n" +
                "        </dup>\n" +
                "        <dup>\n" +
                "          <nDup>002</nDup>\n" +
                "          <dVenc>2021-03-08</dVenc>\n" +
                "          <vDup>567.74</vDup>\n" +
                "        </dup>\n" +
                "        <dup>\n" +
                "          <nDup>003</nDup>\n" +
                "          <dVenc>2021-04-05</dVenc>\n" +
                "          <vDup>567.74</vDup>\n" +
                "        </dup>\n" +
                "      </cobr>\n" +
                "      <pag>\n" +
                "        <detPag>\n" +
                "          <tPag>90</tPag>\n" +
                "          <vPag>0.00</vPag>\n" +
                "        </detPag>\n" +
                "      </pag>\n" +
                "      <infAdic>\n" +
                "        <infCpl>CONFERIR AS MERCADORIAS NO MOMENTO DA ENTREGA, RECLAMACOES P OSTERIORES NAO SERAO ACEITAS. NAO SERAO ACEITAS DEVOLUCOES S EM AUTORIZACAO PREVIA E FORMAL Permite aproveitamento do credito de ICMS no valor de R$:27. 18, correspondente a aliquota de: 1.59600. Nos termos do Ar t.: 23 da LC 123/2006. REPRES. 3528FROES CONSULTORIA EM VENDAS LTDA CARGA 936 ENTREGA 1A PEDIDO 1432 M3: 0.59160 Celular: (44).</infCpl>\n" +
                "      </infAdic>\n" +
                "      <infRespTec>\n" +
                "        <CNPJ>04329365000115</CNPJ>\n" +
                "        <xContato>\n" +
                "          Leandro penha\n" +
                "          </xcontato>\n" +
                "          <email>leandropenha@wvetro.com.br</email>\n" +
                "          <fone>4331724200</fone>\n" +
                "          <idCSRT>99</idCSRT>\n" +
                "          <hashCSRT>YWFhYWFhYWFhYWFhYWFhYWFhYWE=</hashCSRT>\n" +
                "      </infRespTec>\n" +
                "    </infNFe>\n" +
                "    <Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
                "      <SignedInfo>\n" +
                "        <CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" />\n" +
                "        <SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\" />\n" +
                "        <Reference URI=\"#NFe41210129728420000170550020000003721010003722\">\n" +
                "          <Transforms>\n" +
                "            <Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" />\n" +
                "            <Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" />\n" +
                "          </Transforms>\n" +
                "          <DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\" />\n" +
                "          <DigestValue>c7Msac0RjWI3P2DdF4iyi5wqJGM=</DigestValue>\n" +
                "        </Reference>\n" +
                "      </SignedInfo>\n" +
                "      <SignatureValue>oMPRCxpDZ7ZfSUQ2CHCZ75JYjS0T7fq3XRRCpeLL1kQBR1GinL+P6dL/2YtE049hpWk+k4yOWYqa&#13;\n" +
                "+6kTdIVhCx0ThON6ugJLLmGRX/0sHIq3ic5Kz/9E+WeanwGVjlHIzYJmaF0EHm1q/Wi1IGfTNxtn&#13;\n" +
                "SBiaQRTyb7qn3rQYaqZ2Ec57//ZvdGhJ2N+P0yBOljEQP82kS8zz+MgazZrYf1WS0LngODhLehdQ&#13;\n" +
                "jbL59VMDuYQeg/esiikJpynyQAzhSH3W7++fZgSVLB5A0JHkPQ2Rft5KnUP2tet8MRar0/AtlvEy&#13;\n" +
                "Rg9n21Bjq/tL68gG4gIF+dzwYqzwPAwBbyHYJQ==</SignatureValue>\n" +
                "      <KeyInfo>\n" +
                "        <X509Data>\n" +
                "          <X509Certificate>MIIIHzCCBgegAwIBAgIIf9lEzJUXSb0wDQYJKoZIhvcNAQELBQAwdTELMAkGA1UEBhMCQlIxEzAR&#13;\n" +
                "BgNVBAoMCklDUC1CcmFzaWwxNjA0BgNVBAsMLVNlY3JldGFyaWEgZGEgUmVjZWl0YSBGZWRlcmFs&#13;\n" +
                "IGRvIEJyYXNpbCAtIFJGQjEZMBcGA1UEAwwQQUMgU0VSQVNBIFJGQiB2NTAeFw0yMDA0MjAxODAx&#13;\n" +
                "MDBaFw0yMTA0MjAxODAxMDBaMIIBLDELMAkGA1UEBhMCQlIxCzAJBgNVBAgMAlBSMRIwEAYDVQQH&#13;\n" +
                "DAlBUkFQT05HQVMxEzARBgNVBAoMCklDUC1CcmFzaWwxGDAWBgNVBAsMDzAwMDAwMTAwOTU5Mjk5&#13;\n" +
                "NjE2MDQGA1UECwwtU2VjcmV0YXJpYSBkYSBSZWNlaXRhIEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZC&#13;\n" +
                "MRYwFAYDVQQLDA1SRkIgZS1DTlBKIEExMRkwFwYDVQQLDBBBQyBTRVJBU0EgUkZCIHY1MRcwFQYD&#13;\n" +
                "VQQLDA4yNzA4MzM2NTAwMDE4MzEZMBcGA1UECwwQQVIgTU1FWFBSRVNTQ0VSVDEuMCwGA1UEAwwl&#13;\n" +
                "RlJBREUgTU9WRUxBUklBIEVJUkVMSToyOTcyODQyMDAwMDE3MDCCASIwDQYJKoZIhvcNAQEBBQAD&#13;\n" +
                "ggEPADCCAQoCggEBALcDgUmY7xkL2v7UV7IGmYBxpuNbWR6k0Hot4sgHIsZkNVQXcGY0fqucjHi3&#13;\n" +
                "D9cvXZ+/pk0GDKlGH5hoAgJOUFf9UhtvSOEN8DKwyjrU1+vuINmx6rdyYES9mLgG7w2hFzN7gtak&#13;\n" +
                "XlgqCnigZ5DonGMecRLa7VOs+ahduazOcFNCp2mca1375KwGBnqfq99L4S7oG8LEyAgup8v8s6kd&#13;\n" +
                "GysPPvkVSxgSmzpTTkRMs9Bj5cM9OigwU8dbBQIJSrMYQbfDX98BMr7zGDCK7w18F6Df/SQ3iN9z&#13;\n" +
                "6LthK3MIwixoanN1BP0kaGF4LKiGehpviCGV3ysQujirM0QpbIy5/dsCAwEAAaOCAvgwggL0MAkG&#13;\n" +
                "A1UdEwQCMAAwHwYDVR0jBBgwFoAU7PFBUVeo5jrpXrOgIvkIirU6h48wgZkGCCsGAQUFBwEBBIGM&#13;\n" +
                "MIGJMEgGCCsGAQUFBzAChjxodHRwOi8vd3d3LmNlcnRpZmljYWRvZGlnaXRhbC5jb20uYnIvY2Fk&#13;\n" +
                "ZWlhcy9zZXJhc2FyZmJ2NS5wN2IwPQYIKwYBBQUHMAGGMWh0dHA6Ly9vY3NwLmNlcnRpZmljYWRv&#13;\n" +
                "ZGlnaXRhbC5jb20uYnIvc2VyYXNhcmZidjUwgcgGA1UdEQSBwDCBvYEYRVNDUklULk1BUlFVRVNA&#13;\n" +
                "R01BSUwuQ09NoC0GBWBMAQMCoCQTIkNBTUlMQSBTQU5UT1MgUEVORExPV1NLSSBCVVNTQURPUkmg&#13;\n" +
                "GQYFYEwBAwOgEBMOMjk3Mjg0MjAwMDAxNzCgPgYFYEwBAwSgNRMzMjAwMjE5ODEwMDc0ODgyMzky&#13;\n" +
                "MTAwMDAwMDAwMDAwMDAwMDAwMDcyMTY1NTUxU0VTUFBSoBcGBWBMAQMHoA4TDDAwMDAwMDAwMDAw&#13;\n" +
                "MDBxBgNVHSAEajBoMGYGBmBMAQIBDTBcMFoGCCsGAQUFBwIBFk5odHRwOi8vcHVibGljYWNhby5j&#13;\n" +
                "ZXJ0aWZpY2Fkb2RpZ2l0YWwuY29tLmJyL3JlcG9zaXRvcmlvL2RwYy9kZWNsYXJhY2FvLXJmYi5w&#13;\n" +
                "ZGYwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMIGdBgNVHR8EgZUwgZIwSqBIoEaGRGh0&#13;\n" +
                "dHA6Ly93d3cuY2VydGlmaWNhZG9kaWdpdGFsLmNvbS5ici9yZXBvc2l0b3Jpby9sY3Ivc2VyYXNh&#13;\n" +
                "cmZidjUuY3JsMESgQqBAhj5odHRwOi8vbGNyLmNlcnRpZmljYWRvcy5jb20uYnIvcmVwb3NpdG9y&#13;\n" +
                "aW8vbGNyL3NlcmFzYXJmYnY1LmNybDAdBgNVHQ4EFgQUjsRfZtYuGh3rLaCbEBuo0Ez1FGAwDgYD&#13;\n" +
                "VR0PAQH/BAQDAgXgMA0GCSqGSIb3DQEBCwUAA4ICAQABnfKIY06eIFhTVuuIJvDLpKPBwPw91AmA&#13;\n" +
                "0KdSWx8S8Yry53hZuK7VWLsJSPZknsoVht2mTQqN2x/+Y9SfHc81tTsJTBwRoUDuCC4AD7m/xrmR&#13;\n" +
                "i9csiEfp2cJjk7YaONZKz0j2x8cUky35dhnsBuw1EdaJ1SHxwkTOg0v1XnqeZSx9iP6bZ3RBIGE9&#13;\n" +
                "/UqdHOIbnxeCQ3E2rPKz0Ec9S1VitaxNFokM7wQdnUU3FEHF7R/NgZ042CYwLQB/ViQQCxDyclUw&#13;\n" +
                "JjCFg36alYZC3KL56AiMefd0yBYcW+7v00GY5/3qxDZXweIDPGPPq3B+Qdh64IWzAjmSWI6iCD8r&#13;\n" +
                "OXebWM4g0+rm2iXa3BKc7AIg8gW6bCuBzXrzv/Y7yKBBZY+/W9JLju8q1QqjvZslfjzJF8TEbB8L&#13;\n" +
                "J4KdlGZ702jBgnCDqWNhTEC4A3zRd5q4La6Cmwi6jMSsA47TOH5zJS0MItUaVlSSz8oMRYHq4aOo&#13;\n" +
                "6l3r5SGTuhktm/Q1Bc9ysDYJxAs6A19aD9dWhzTULG8gTHqb7heY6Oo1SANuWkCxoKWx1Xi3iLqh&#13;\n" +
                "0JWu0/SD2I32L2Of2rjCGpXyeDxuy7sA/br4IiTOVDpmgb42zVXW7O66610+7x01y0TMAsvQgWwF&#13;\n" +
                "hkfU/R1mGuXq+YjNw7kdvNJMQrpQpCfjJ6X4UNEbfw==</X509Certificate>\n" +
                "        </X509Data>\n" +
                "      </KeyInfo>\n" +
                "    </Signature>\n" +
                "  </NFe>\n" +
                "</enviNFe>";

        String response;

        try {
            //String xmlAssinado = api.NfeAssinar(xml);
            //ok
            //response = api.NFeEmitir(xml, "10", "1", "1");
            //response = api.NFeEmitirLote(xml, "55", "1");
            response = api.NfSituacaoNotaXfd("41210129728420000170550020000003721010003722", xml);
            //response = api.NfeWebServiceStatus("PR","55");
            //ok
            //response = api.geraChaveCTe(xml);
            //ok
            //response = api.geraQrCode(xml);
            //ok
            //response = api.consultaStatusServicoCod("PR");
            //error
            //response = api.NFDateTime("PR");
            //error
            //response = api.cancelarCteAssinada("41201124476580000156570010000275021000375663", "154198419105185984");
        } catch (Exception e) {
            response = "Error: " + e.getMessage();
        }
        System.out.println(response);
    }
}

