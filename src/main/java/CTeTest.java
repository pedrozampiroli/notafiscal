import app.notafiscal.CTeAPI;

public class CTeTest {


    public static void main(String[] args) {

        CTeAPI api = new CTeAPI();

        api.configurar(
                "Marilda018",
                "",
                "D:\\Certificado\\j.pfx",
                "D:\\Certificado\\homologacao.cacerts",
                "PR",
                "2"
        );

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<CTe xmlns=\"http://www.portalfiscal.inf.br/cte\">\n" +
                "<infCte Id=\"CTe41201218374429000104570010000022141120022140\" versao=\"3.00\">\n" +
                "<ide>\n" +
                "<cUF>41</cUF>\n" +
                "<cCT>12002214</cCT>\n" +
                "<CFOP>5352</CFOP>\n" +
                "<natOp>PRESTACAO SERV TRANSPORTES A ESTAB INDUSTRIAL</natOp>\n" +
                "<mod>57</mod>\n" +
                "<serie>1</serie>\n" +
                "<nCT>2214</nCT>\n" +
                "<dhEmi>2020-12-08T14:02:44-03:00</dhEmi>\n" +
                "<tpImp>1</tpImp>\n" +
                "<tpEmis>1</tpEmis>\n" +
                "<cDV>0</cDV>\n" +
                "<tpAmb>2</tpAmb>\n" +
                "<tpCTe>0</tpCTe>\n" +
                "<procEmi>0</procEmi>\n" +
                "<verProc>1</verProc>\n" +
                "<cMunEnv>4101507</cMunEnv>\n" +
                "<xMunEnv>ARAPONGAS</xMunEnv>\n" +
                "<UFEnv>PR</UFEnv>\n" +
                "<modal>01</modal>\n" +
                "<tpServ>0</tpServ>\n" +
                "<cMunIni>4101507</cMunIni>\n" +
                "<xMunIni>ARAPONGAS</xMunIni>\n" +
                "<UFIni>PR</UFIni>\n" +
                "<cMunFim>4115200</cMunFim>\n" +
                "<xMunFim>MARINGA</xMunFim>\n" +
                "<UFFim>PR</UFFim>\n" +
                "<retira>0</retira>\n" +
                "<indIEToma>1</indIEToma>\n" +
                "<toma3>\n" +
                "<toma>0</toma>\n" +
                "</toma3>\n" +
                "</ide>\n" +
                "<compl>\n" +
                "<fluxo>\n" +
                "<xOrig>2</xOrig>\n" +
                "</fluxo>\n" +
                "<Entrega>\n" +
                "<semData>\n" +
                "<tpPer>0</tpPer>\n" +
                "</semData>\n" +
                "<semHora>\n" +
                "<tpHor>0</tpHor>\n" +
                "</semHora>\n" +
                "</Entrega>\n" +
                "<origCalc>MANDAGUARI</origCalc>\n" +
                "<destCalc>MARINGA</destCalc>\n" +
                "<xObs>000015742,</xObs>\n" +
                "</compl>\n" +
                "<emit>\n" +
                "<CNPJ>18374429000104</CNPJ>\n" +
                "<IE>9072252591</IE>\n" +
                "<xNome>J.M. TRANSPORTES LTDA ME</xNome>\n" +
                "<xFant>JM TRANSPORTES</xFant>\n" +
                "<enderEmit>\n" +
                "<xLgr>RUA SANA CASTANHA</xLgr>\n" +
                "<nro>241</nro>\n" +
                "<xBairro>JD SANTA ALICE</xBairro>\n" +
                "<cMun>4101507</cMun>\n" +
                "<xMun>ARAPONGAS</xMun>\n" +
                "<CEP>86701836</CEP>\n" +
                "<UF>PR</UF>\n" +
                "<fone>4332753810</fone>\n" +
                "</enderEmit>\n" +
                "</emit>\n" +
                "<rem>\n" +
                "<CNPJ>07038710000150</CNPJ>\n" +
                "<IE>9032296324</IE>\n" +
                "<xNome>CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome>\n" +
                "<xFant>CAFEEIRA BOA ESPERANCA</xFant>\n" +
                "<fone>32331561</fone>\n" +
                "<enderReme>\n" +
                "<xLgr>ROD PR 444</xLgr>\n" +
                "<nro>SN</nro>\n" +
                "<xBairro>GL PATR MANDAGUARI</xBairro>\n" +
                "<cMun>4114203</cMun>\n" +
                "<xMun>MANDAGUARI</xMun>\n" +
                "<CEP>86975000</CEP>\n" +
                "<UF>PR</UF>\n" +
                "<cPais>1058</cPais>\n" +
                "<xPais>BRASIL</xPais>\n" +
                "</enderReme>\n" +
                "<email>martinsbsi@gmail.com</email>\n" +
                "</rem>\n" +
                "<dest>\n" +
                "<CNPJ>29971780000107</CNPJ>\n" +
                "<IE>9078052128</IE>\n" +
                "<xNome>CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome>\n" +
                "<fone>4399999999</fone>\n" +
                "<enderDest>\n" +
                "<xLgr>PRACA DAS AMERICAS</xLgr>\n" +
                "<nro>202</nro>\n" +
                "<cMun>4115200</cMun>\n" +
                "<xMun>MARINGA</xMun>\n" +
                "<CEP>87050550</CEP>\n" +
                "<UF>PR</UF>\n" +
                "<cPais>1058</cPais>\n" +
                "<xPais>BRASIL</xPais>\n" +
                "</enderDest>\n" +
                "</dest>\n" +
                "<vPrest>\n" +
                "<vTPrest>75.00</vTPrest>\n" +
                "<vRec>75.00</vRec>\n" +
                "<Comp>\n" +
                "<xNome>FRETE</xNome>\n" +
                "<vComp>75.00</vComp>\n" +
                "</Comp>\n" +
                "</vPrest>\n" +
                "<imp>\n" +
                "<ICMS>\n" +
                "<ICMSSN>\n" +
                "<CST>90</CST>\n" +
                "<indSN>1</indSN>\n" +
                "</ICMSSN>\n" +
                "</ICMS>\n" +
                "<vTotTrib>0.00</vTotTrib>\n" +
                "</imp>\n" +
                "<infCTeNorm>\n" +
                "<infCarga>\n" +
                "<vCarga>6.50</vCarga>\n" +
                "<proPred>VOLUMES</proPred>\n" +
                "<infQ>\n" +
                "<cUnid>03</cUnid>\n" +
                "<tpMed>VOLUME</tpMed>\n" +
                "<qCarga>2.0000</qCarga>\n" +
                "</infQ>\n" +
                "<infQ>\n" +
                "<cUnid>03</cUnid>\n" +
                "<tpMed>PESO BRUTO</tpMed>\n" +
                "<qCarga>0.5080</qCarga>\n" +
                "</infQ>\n" +
                "</infCarga>\n" +
                "<infDoc>\n" +
                "<infNFe>\n" +
                "<chave>41200807038710000150550010000157421080157422</chave>\n" +
                "<dPrev>2020-12-08</dPrev>\n" +
                "</infNFe>\n" +
                "</infDoc>\n" +
                "<infModal versaoModal=\"3.00\">\n" +
                "<rodo>\n" +
                "<RNTRC>50119700</RNTRC>\n" +
                "</rodo>\n" +
                "</infModal>\n" +
                "<cobr>\n" +
                "<dup>\n" +
                "<nDup>19102-1/1</nDup>\n" +
                "<dVenc>2016-04-10</dVenc>\n" +
                "<vDup>50.00</vDup>\n" +
                "</dup>\n" +
                "<dup>\n" +
                "<nDup>2214-1/1</nDup>\n" +
                "<dVenc>2020-12-18</dVenc>\n" +
                "<vDup>75.00</vDup>\n" +
                "</dup>\n" +
                "</cobr>\n" +
                "</infCTeNorm>\n" +
                "<infRespTec>\n" +
                "<CNPJ>04329365000115</CNPJ>\n" +
                "<xContato>Leandro Penha</xContato>\n" +
                "<email>leandropenha@wvetro.com.br</email>\n" +
                "<fone>4331724200</fone>\n" +
                "<idCSRT>099</idCSRT>\n" +
                "<hashCSRT>YWFhYWFhYWFhYWFhYWFhYWFhYWE=</hashCSRT>\n" +
                "</infRespTec>\n" +
                "</infCte>\n" +
                "<infCTeSupl>\n" +
                "<qrCodCTe><![CDATA[http://www.fazenda.pr.gov.br/cte/qrcode?chCTe=41201218374429000104570010000022141120022140&tpAmb=2]]></qrCodCTe>\n" +
                "</infCTeSupl>\n" +
                "</CTe>";
        System.out.println(xml);
        String response;

        try {
            //ok
            response = api.transmitir("1", "3.00", xml);
            //ok
//            response = api.inutilizar("41201118374429000104570010000022121110022123","141200000056993","TESTE TESTE TESTE TESTE","20", "000002213","000002213", "57","001");
            //ok
            /*response = api.correcao(
                    "41201118374429000104570010000022131110022139",
                    "141200000056994",
                    "rem",
                    "xNome",
                    "TESTE CTE ALTERADA",
                    "10",
                    "A Carta de Correcao e disciplinada pelo Art. 58-B do CONVENIO/SINIEF 06/89: Fica permitida a utilizacao de carta de correcao, para regularizacao de erro ocorrido na emissao de documentos fiscais relativos a prestacao de servico de transporte, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da prestacao;II - a correcao de dados cadastrais que implique mudanca do emitente, tomador, remetente ou do destinatario;III - a data de emissao ou de saida."
            );*/
            //response = api.geraChaveCTe(xml);
            //ok
            //response = api.geraQrCode(xml);
            //ok
            //response = api.consultaStatusServicoCod("PR");
            //error
            //response = api.consultar("41201124476580000156570010000275041000375668");
            //error
            //response = api.cancelarCteAssinada("41201124476580000156570010000275021000375663", "154198419105185984");
//            response = api.consultaProcessamento("411000074572885");
            //response = api.cancelar("41201124476580000156570010000275041000375668", "141200000056994", "CANCELAMENTO TESTE");

            //response = api.inutilizar(2020,"19278207000150","1","132","321","TESTE");

        } catch (Exception e) {
            response = "Error: " + e.getMessage();
        }
        System.out.println(response);
    }
}

