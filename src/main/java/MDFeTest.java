import app.notafiscal.NFeApi;
import com.fincatto.documentofiscal.DFModelo;

public class MDFeTest {


    public static void main(String[] args) {

        NFeApi api = new NFeApi();

        api.NfeConfigurar("@cafe@",
                            "changeit",
                            "D:\\Tmp\\xml\\1.pfx",
                            "D:\\Docker\\Linux\\srv\\apps\\cacerts\\homologacao.cacerts",
                            "PR",
                            "2",
                            "",
                            "", "4.00");

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">\n" +
                "\t<infNFe versao=\"4.00\" Id=\"NFe41201012272305000131550010000001301260000030\">\n" +
                "\t\t<ide>\n" +
                "\t\t\t<cUF>41</cUF>\n" +
                "\t\t\t<cNF>26000003</cNF>\n" +
                "\t\t\t<natOp>VENDAS DE PRODUTOS IND OU PROD - CSOSN 102</natOp>\n" +
                "\t\t\t<mod>55</mod>\n" +
                "\t\t\t<serie>1</serie>\n" +
                "\t\t\t<nNF>130</nNF>\n" +
                "\t\t\t<dhEmi>2020-10-26T16:23:11-03:00</dhEmi>\n" +
                "\t\t\t<dhSaiEnt>2020-10-26T16:23:11-03:00</dhSaiEnt>\n" +
                "\t\t\t<tpNF>1</tpNF>\n" +
                "\t\t\t<idDest>1</idDest>\n" +
                "\t\t\t<cMunFG>4101507</cMunFG>\n" +
                "\t\t\t<tpImp>1</tpImp>\n" +
                "\t\t\t<tpEmis>1</tpEmis>\n" +
                "\t\t\t<cDV>0</cDV>\n" +
                "\t\t\t<tpAmb>2</tpAmb>\n" +
                "\t\t\t<finNFe>1</finNFe>\n" +
                "\t\t\t<indFinal>1</indFinal>\n" +
                "\t\t\t<indPres>1</indPres>\n" +
                "\t\t\t<procEmi>0</procEmi>\n" +
                "\t\t\t<verProc>4.01</verProc>\n" +
                "\t\t</ide>\n" +
                "\t\t<emit>\n" +
                "\t\t\t<CNPJ>12272305000131</CNPJ>\n" +
                "\t\t\t<xNome>BIEMAC INDUSTRIA E COMERCIO DE MOVEIS E COLCHOES L</xNome>\n" +
                "\t\t\t<xFant>ESPUMAS BIEMAC</xFant>\n" +
                "\t\t\t<enderEmit>\n" +
                "\t\t\t\t<xLgr>R AZULINHO</xLgr>\n" +
                "\t\t\t\t<nro>241</nro>\n" +
                "\t\t\t\t<xBairro>VILA AYMORE</xBairro>\n" +
                "\t\t\t\t<cMun>4101507</cMun>\n" +
                "\t\t\t\t<xMun>ARAPONGAS</xMun>\n" +
                "\t\t\t\t<UF>PR</UF>\n" +
                "\t\t\t\t<CEP>86708400</CEP>\n" +
                "\t\t\t\t<cPais>1058</cPais>\n" +
                "\t\t\t\t<xPais>BRASIL</xPais>\n" +
                "\t\t\t</enderEmit>\n" +
                "\t\t\t<IE>9052713347</IE>\n" +
                "\t\t\t<CRT>1</CRT>\n" +
                "\t\t</emit>\n" +
                "\t\t<dest>\n" +
                "\t\t\t<CPF>07913759941</CPF>\n" +
                "\t\t\t<xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome>\n" +
                "\t\t\t<enderDest>\n" +
                "\t\t\t\t<xLgr>RUA GUIRACA</xLgr>\n" +
                "\t\t\t\t<nro>299</nro>\n" +
                "\t\t\t\t<xBairro>VILA ARAPONGUINHA</xBairro>\n" +
                "\t\t\t\t<cMun>4101507</cMun>\n" +
                "\t\t\t\t<xMun>ARAPONGAS</xMun>\n" +
                "\t\t\t\t<UF>PR</UF>\n" +
                "\t\t\t\t<CEP>86705610</CEP>\n" +
                "\t\t\t\t<cPais>1058</cPais>\n" +
                "\t\t\t\t<xPais>BRASIL</xPais>\n" +
                "\t\t\t</enderDest>\n" +
                "\t\t\t<indIEDest>9</indIEDest>\n" +
                "\t\t</dest>\n" +
                "\t\t<det nItem=\"1\">\n" +
                "\t\t\t<prod>\n" +
                "\t\t\t\t<cProd>58800</cProd>\n" +
                "\t\t\t\t<cEAN>SEM GTIN</cEAN>\n" +
                "\t\t\t\t<xProd>NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xProd>\n" +
                "\t\t\t\t<NCM>96081000</NCM>\n" +
                "\t\t\t\t<CFOP>5101</CFOP>\n" +
                "\t\t\t\t<uCom>KG</uCom>\n" +
                "\t\t\t\t<qCom>2.0000</qCom>\n" +
                "\t\t\t\t<vUnCom>2.0000000000</vUnCom>\n" +
                "\t\t\t\t<vProd>4.00</vProd>\n" +
                "\t\t\t\t<cEANTrib>SEM GTIN</cEANTrib>\n" +
                "\t\t\t\t<uTrib>KG</uTrib>\n" +
                "\t\t\t\t<qTrib>2.0000</qTrib>\n" +
                "\t\t\t\t<vUnTrib>2.0000000000</vUnTrib>\n" +
                "\t\t\t\t<indTot>1</indTot>\n" +
                "\t\t\t\t<nItemPed>1</nItemPed>\n" +
                "\t\t\t</prod>\n" +
                "\t\t\t<imposto>\n" +
                "\t\t\t\t<vTotTrib>1.55</vTotTrib>\n" +
                "\t\t\t\t<ICMS>\n" +
                "\t\t\t\t\t<ICMSSN102>\n" +
                "\t\t\t\t\t\t<orig>0</orig>\n" +
                "\t\t\t\t\t\t<CSOSN>102</CSOSN>\n" +
                "\t\t\t\t\t</ICMSSN102>\n" +
                "\t\t\t\t</ICMS>\n" +
                "\t\t\t\t<IPI>\n" +
                "\t\t\t\t\t<CNPJProd>00000000000000</CNPJProd>\n" +
                "\t\t\t\t\t<cSelo>N</cSelo>\n" +
                "\t\t\t\t\t<qSelo>0</qSelo>\n" +
                "\t\t\t\t\t<cEnq>999</cEnq>\n" +
                "\t\t\t\t\t<IPITrib>\n" +
                "\t\t\t\t\t\t<CST>99</CST>\n" +
                "\t\t\t\t\t\t<vBC>0.00</vBC>\n" +
                "\t\t\t\t\t\t<pIPI>0.00</pIPI>\n" +
                "\t\t\t\t\t\t<vIPI>0.00</vIPI>\n" +
                "\t\t\t\t\t</IPITrib>\n" +
                "\t\t\t\t</IPI>\n" +
                "\t\t\t\t<PIS>\n" +
                "\t\t\t\t\t<PISOutr>\n" +
                "\t\t\t\t\t\t<CST>99</CST>\n" +
                "\t\t\t\t\t\t<vBC>0.00</vBC>\n" +
                "\t\t\t\t\t\t<pPIS>0.00</pPIS>\n" +
                "\t\t\t\t\t\t<vPIS>0.00</vPIS>\n" +
                "\t\t\t\t\t</PISOutr>\n" +
                "\t\t\t\t</PIS>\n" +
                "\t\t\t\t<COFINS>\n" +
                "\t\t\t\t\t<COFINSOutr>\n" +
                "\t\t\t\t\t\t<CST>99</CST>\n" +
                "\t\t\t\t\t\t<vBC>0.00</vBC>\n" +
                "\t\t\t\t\t\t<pCOFINS>0.00</pCOFINS>\n" +
                "\t\t\t\t\t\t<vCOFINS>0.00</vCOFINS>\n" +
                "\t\t\t\t\t</COFINSOutr>\n" +
                "\t\t\t\t</COFINS>\n" +
                "\t\t\t</imposto>\n" +
                "\t\t</det>\n" +
                "\t\t<total>\n" +
                "\t\t\t<ICMSTot>\n" +
                "\t\t\t\t<vBC>0.00</vBC>\n" +
                "\t\t\t\t<vICMS>0.00</vICMS>\n" +
                "\t\t\t\t<vICMSDeson>0</vICMSDeson>\n" +
                "\t\t\t\t<vFCPUFDest>0</vFCPUFDest>\n" +
                "\t\t\t\t<vICMSUFDest>0</vICMSUFDest>\n" +
                "\t\t\t\t<vICMSUFRemet>0</vICMSUFRemet>\n" +
                "\t\t\t\t<vFCP>0</vFCP>\n" +
                "\t\t\t\t<vBCST>0.00</vBCST>\n" +
                "\t\t\t\t<vST>0.00</vST>\n" +
                "\t\t\t\t<vFCPST>0</vFCPST>\n" +
                "\t\t\t\t<vFCPSTRet>0</vFCPSTRet>\n" +
                "\t\t\t\t<vProd>4.00</vProd>\n" +
                "\t\t\t\t<vFrete>0.00</vFrete>\n" +
                "\t\t\t\t<vSeg>0.00</vSeg>\n" +
                "\t\t\t\t<vDesc>0.00</vDesc>\n" +
                "\t\t\t\t<vII>0.00</vII>\n" +
                "\t\t\t\t<vIPI>0.00</vIPI>\n" +
                "\t\t\t\t<vIPIDevol>0</vIPIDevol>\n" +
                "\t\t\t\t<vPIS>0.00</vPIS>\n" +
                "\t\t\t\t<vCOFINS>0.00</vCOFINS>\n" +
                "\t\t\t\t<vOutro>0.00</vOutro>\n" +
                "\t\t\t\t<vNF>4.00</vNF>\n" +
                "\t\t\t\t<vTotTrib>1.55</vTotTrib>\n" +
                "\t\t\t</ICMSTot>\n" +
                "\t\t</total>\n" +
                "\t\t<transp>\n" +
                "\t\t\t<modFrete>0</modFrete>\n" +
                "\t\t\t<vol>\n" +
                "\t\t\t\t<marca>ESPUMAS BIEMAC</marca>\n" +
                "\t\t\t</vol>\n" +
                "\t\t</transp>\n" +
                "\t\t<pag>\n" +
                "\t\t\t<detPag>\n" +
                "\t\t\t\t<tPag>14</tPag>\n" +
                "\t\t\t\t<vPag>4.00</vPag>\n" +
                "\t\t\t</detPag>\n" +
                "\t\t\t<vTroco>0.00</vTroco>\n" +
                "\t\t</pag>\n" +
                "\t\t<infAdic>\n" +
                "\t\t\t<infCpl>Documento Emitido para ME e EPP optante Simples Nacional treinamento Nao gera direito a credito fiscal de IPI e ICMS</infCpl>\n" +
                "\t\t</infAdic>\n" +
                "\t\t<infRespTec>\n" +
                "\t\t\t<CNPJ>04329365000115</CNPJ>\n" +
                "\t\t\t<xContato>Leandro Penha</xContato>\n" +
                "\t\t\t<email>leandropenha@wvetro.com.br</email>\n" +
                "\t\t\t<fone>4331724200</fone>\n" +
                "\t\t\t<idCSRT>99</idCSRT>\n" +
                "\t\t\t<hashCSRT>YWFhYWFhYWFhYWFhYWFhYWFhYWE=</hashCSRT>\n" +
                "\t\t</infRespTec>\n" +
                "\t</infNFe>\n" +
                "</NFe>\n";

        String retorno ;

        try {
            retorno = api.NFeEmitir(xml, "1", DFModelo.NFE.toString(), "1");
        } catch (Exception e) {
            retorno = "Error: " + e.getMessage();

        }

        System.out.println(retorno);

    }
}

