import app.notafiscal.NfeApi;

public class NFeTeste {


    public static void main(String[] args) {

        NfeApi api = new NfeApi();

        api.NfeConfigurar("123456",
                "changeit",
                "D:\\Certificado\\solar.pfx",
                "D:\\Certificado\\homologacao.cacerts",
                "PR",
                "2",
                "1",
                "1",
                "4.00"
        );

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"><infNFe versao=\"4.00\" Id=\"NFe41210213260345000207650010000915681030000146\"><ide><cUF>41</cUF><cNF>03000014</cNF><natOp>VENDA DE MERC. ADQ. OU REC DE TER - CSOSN 102</natOp><mod>65</mod><serie>1</serie><nNF>91568</nNF><dhEmi>2021-02-03T10:15:25-03:00</dhEmi><tpNF>1</tpNF><idDest>1</idDest><cMunFG>4101507</cMunFG><tpImp>4</tpImp><tpEmis>1</tpEmis><cDV>6</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>1</indPres><procEmi>0</procEmi><verProc>4.01</verProc></ide><emit><CNPJ>19278207000150</CNPJ><xNome>INDUSTRIA E COMERCIO DE EMBALAGENS VECHIART LTDA</xNome><xFant>INDUSTRIA E COMERCIO DE EMBALAGENS VECHIART LTDA -</xFant><enderEmit><xLgr>R CONDOR</xLgr><nro>1423</nro><xBairro>CENTRO</xBairro><cMun>4101507</cMun><xMun>ARAPONGAS</xMun><UF>PR</UF><CEP>86700135</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>4332524547</fone></enderEmit><IE>9056374288</IE><CRT>1</CRT></emit><det nItem=\"1\"><prod><cProd>62430</cProd><cEAN>SEM GTIN</cEAN><xProd>EMB. PLASTICA G78 M UN.</xProd><NCM>39239000</NCM><CFOP>5102</CFOP><uCom>CX</uCom><qCom>6.0000</qCom><vUnCom>9.9900000000</vUnCom><vProd>59.94</vProd><cEANTrib>SEM GTIN</cEANTrib><uTrib>CX</uTrib><qTrib>6.0000</qTrib><vUnTrib>9.9900000000</vUnTrib><indTot>1</indTot><nItemPed>1</nItemPed></prod><imposto><vTotTrib>13.69</vTotTrib><ICMS><ICMSSN102><orig>0</orig><CSOSN>102</CSOSN></ICMSSN102></ICMS></imposto></det><det nItem=\"2\"><prod><cProd>79860</cProd><cEAN>SEM GTIN</cEAN><xProd>MARMITA DE ALUMINIO M120 500ML C/ 10 UNID.</xProd><NCM>76071110</NCM><CFOP>5102</CFOP><uCom>CX</uCom><qCom>1.0000</qCom><vUnCom>4.9900000000</vUnCom><vProd>4.99</vProd><cEANTrib>SEM GTIN</cEANTrib><uTrib>CX</uTrib><qTrib>1.0000</qTrib><vUnTrib>4.9900000000</vUnTrib><indTot>1</indTot><nItemPed>2</nItemPed></prod><imposto><vTotTrib>1.17</vTotTrib><ICMS><ICMSSN102><orig>0</orig><CSOSN>102</CSOSN></ICMSSN102></ICMS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vICMSDeson>0</vICMSDeson><vFCPUFDest>0</vFCPUFDest><vICMSUFDest>0</vICMSUFDest><vICMSUFRemet>0</vICMSUFRemet><vFCP>0</vFCP><vBCST>0.00</vBCST><vST>0.00</vST><vFCPST>0</vFCPST><vFCPSTRet>0</vFCPSTRet><vProd>64.93</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vIPIDevol>0</vIPIDevol><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>64.93</vNF><vTotTrib>14.86</vTotTrib></ICMSTot></total><transp><modFrete>9</modFrete></transp><pag><detPag><tPag>99</tPag><vPag>64.93</vPag></detPag><vTroco>0.00</vTroco></pag><infAdic><infCpl>Pedido Nro. 48826 Documento Emitido para ME e EPP optante Simples Nacional Nao gera direito a credito fiscal de IPI e ICMS Valor Aproximado Tributos R$ 14.86 (22.89)FONTE: IBPT</infCpl></infAdic><infRespTec><CNPJ>04329365000115</CNPJ><xContato>Leandro Penha</xContato><email>leandropenha@wvetro.com.br</email><fone>4331724200</fone><idCSRT>99</idCSRT><hashCSRT>YWFhYWFhYWFhYWFhYWFhYWFhYWE=</hashCSRT></infRespTec></infNFe></NFe>";

        String response;

        try {
            //String xmlAssinado = api.NfeAssinar(xml);
            //ok
            response = api.NFeEmitir(xml, "10", "1", "1");
            //response = api.NFeEmitirLote(xml, "55", "1");
            //response = api.NFGeraURLString(xml);
            //response = api.NfSituacaoNota("41210129728420000170550020000003701010003701","");
            //ok
            //response = api.NFeEmitirLote(xml,"55","1");
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

