import app.notafiscal.CTeAPI;

public class CTeTest {


    public static void main(String[] args) {

        CTeAPI api = new CTeAPI();

        api.configurar(
                "Marilda018",
                "changeit",
                "D:\\Certificado\\j.pfx",
                "D:\\Certificado\\homologacao.cacerts",
                "PR",
                "2"
        );

        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<CTe xmlns=\"http://www.portalfiscal.inf.br/cte\">\n" +
                "<infCte Id=\"CTe41201124476580000156570010000275041000375668\" versao=\"3.00\">\n" +
                "<ide>\n" +
                "<cUF>41</cUF>\n" +
                "<cCT>00037566</cCT>\n" +
                "<CFOP>6932</CFOP>\n" +
                "<natOp>PRESTACAO DE SERVICO DE TRANSP INIC EM UF DIVERSA</natOp>\n" +
                "<mod>57</mod>\n" +
                "            <serie>1</serie>\n" +
                "            <nCT>27504</nCT>\n" +
                "            <dhEmi>2020-11-03T19:38:24-03:00</dhEmi>\n" +
                "            <tpImp>1</tpImp>\n" +
                "            <tpEmis>1</tpEmis>\n" +
                "            <cDV>8</cDV>\n" +
                "            <tpAmb>1</tpAmb>\n" +
                "            <tpCTe>0</tpCTe>\n" +
                "            <procEmi>0</procEmi>\n" +
                "            <verProc>1</verProc>\n" +
                "            <cMunEnv>4101507</cMunEnv>\n" +
                "            <xMunEnv>ARAPONGAS</xMunEnv>\n" +
                "            <UFEnv>PR</UFEnv>\n" +
                "            <modal>01</modal>\n" +
                "            <tpServ>0</tpServ>\n" +
                "            <cMunIni>3554003</cMunIni>\n" +
                "            <xMunIni>TATUI</xMunIni>\n" +
                "            <UFIni>SP</UFIni>\n" +
                "            <cMunFim>3201308</cMunFim>\n" +
                "            <xMunFim>CARIACICA</xMunFim>\n" +
                "            <UFFim>ES</UFFim>\n" +
                "            <retira>0</retira>\n" +
                "            <indIEToma>1</indIEToma>\n" +
                "            <toma3>\n" +
                "                <toma>3</toma>\n" +
                "            </toma3>\n" +
                "        </ide>\n" +
                "        <compl>\n" +
                "            <fluxo>\n" +
                "                <xOrig>100</xOrig>\n" +
                "            </fluxo>\n" +
                "            <Entrega>\n" +
                "                <semData>\n" +
                "                    <tpPer>0</tpPer>\n" +
                "                </semData>\n" +
                "                <semHora>\n" +
                "                    <tpHor>0</tpHor>\n" +
                "                </semHora>\n" +
                "            </Entrega>\n" +
                "            <origCalc>TATUI</origCalc>\n" +
                "            <destCalc>CARIACICA</destCalc>\n" +
                "            <xObs>NF-e: 000105752 Mot: SIDINEI GARCIA DUARTE Placa: AJL-2699 CPF: 91796288934 URUTAU 368 Carga:   149104 Vencto Frete: 30/11/2020 27504-1/1 7.800,00ICMS DEVIDO AO TOMADOR DA PRESTACAO, DE ACORDO COM O ART. 316CAP. II, SECAO II DO DEC. 45.490/2000 DO RICMS/SP</xObs>\n" +
                "        </compl>\n" +
                "        <emit>\n" +
                "            <CNPJ>24476580000156</CNPJ>\n" +
                "            <IE>9071805813</IE>\n" +
                "            <xNome>ENTREGA RAPIDA TRANSPORTES LTDA</xNome>\n" +
                "            <xFant>ENTREGA RAPIDA TRANSPORTES LTDA</xFant>\n" +
                "            <enderEmit>\n" +
                "                <xLgr>CAMBACICA</xLgr>\n" +
                "                <nro>726</nro>\n" +
                "                <xCpl>LOTE 21 QUADRA 23</xCpl>\n" +
                "                <xBairro>JARDIM BANDEIRANTES</xBairro>\n" +
                "                <cMun>4101507</cMun>\n" +
                "                <xMun>ARAPONGAS</xMun>\n" +
                "                <CEP>86703100</CEP>\n" +
                "                <UF>PR</UF>\n" +
                "                <fone>4331524769</fone>\n" +
                "            </enderEmit>\n" +
                "        </emit>\n" +
                "        <rem>\n" +
                "            <CNPJ>19278207000150</CNPJ>\n" +
                "            <IE>687099668111</IE>\n" +
                "            <xNome>20 - SOLAR MOVEIS EIRELI</xNome>\n" +
                "            <xFant>SOLAR MOVEIS EIRELI</xFant>\n" +
                "            <fone>1532057300</fone>\n" +
                "            <enderReme>\n" +
                "                <xLgr>V MUNICIPAL MOISES MARTINS</xLgr>\n" +
                "                <nro>1005</nro>\n" +
                "                <xBairro>BENFICA</xBairro>\n" +
                "                <cMun>3554003</cMun>\n" +
                "                <xMun>TATUI</xMun>\n" +
                "                <CEP>18270000</CEP>\n" +
                "                <UF>SP</UF>\n" +
                "                <cPais>1058</cPais>\n" +
                "                <xPais>BRASIL</xPais>\n" +
                "            </enderReme>\n" +
                "            <email>nfe@solarmoveis.ind.br</email>\n" +
                "        </rem>\n" +
                "        <dest>\n" +
                "            <CNPJ>30689848000130</CNPJ>\n" +
                "            <IE>081779836</IE>\n" +
                "            <xNome>45935 - LOJAS SIPOLATTI COMERCIO E SERVICOS LTDA</xNome>\n" +
                "            <fone>02730892100</fone>\n" +
                "            <enderDest>\n" +
                "                <xLgr>AVENIDA TUCANO</xLgr>\n" +
                "                <nro>1</nro>\n" +
                "                <xBairro>SAO CONRADO</xBairro>\n" +
                "                <cMun>3201308</cMun>\n" +
                "                <xMun>CARIACICA</xMun>\n" +
                "                <CEP>29141180</CEP>\n" +
                "                <UF>ES</UF>\n" +
                "                <cPais>1058</cPais>\n" +
                "                <xPais>BRASIL</xPais>\n" +
                "            </enderDest>\n" +
                "            <email>nfe@sipolatti.com.br</email>\n" +
                "        </dest>\n" +
                "        <vPrest>\n" +
                "            <vTPrest>7800.00</vTPrest>\n" +
                "            <vRec>7800.00</vRec>\n" +
                "            <Comp>\n" +
                "                <xNome>Frete</xNome>\n" +
                "                <vComp>7800.00</vComp>\n" +
                "            </Comp>\n" +
                "        </vPrest>\n" +
                "        <imp>\n" +
                "            <ICMS>\n" +
                "                <ICMS60>\n" +
                "                    <CST>60</CST>\n" +
                "                    <vBCSTRet>7800.00</vBCSTRet>\n" +
                "                    <vICMSSTRet>546.00</vICMSSTRet>\n" +
                "                    <pICMSSTRet>7.00</pICMSSTRet>\n" +
                "                    <vCred>0.00</vCred>\n" +
                "                </ICMS60>\n" +
                "            </ICMS>\n" +
                "        </imp>\n" +
                "        <infCTeNorm>\n" +
                "            <infCarga>\n" +
                "                <vCarga>62616.51</vCarga>\n" +
                "                <proPred>ESTOFADOS</proPred>\n" +
                "                <infQ>\n" +
                "                    <cUnid>03</cUnid>\n" +
                "                    <tpMed>VOLUME</tpMed>\n" +
                "                    <qCarga>88.0000</qCarga>\n" +
                "                </infQ>\n" +
                "                <infQ>\n" +
                "                    <cUnid>01</cUnid>\n" +
                "                    <tpMed>PESO BRUTO</tpMed>\n" +
                "                    <qCarga>4844.0000</qCarga>\n" +
                "                </infQ>\n" +
                "            </infCarga>\n" +
                "            <infDoc>\n" +
                "                <infNFe>\n" +
                "                    <chave>35201119278207000150550010001057521031057521</chave>\n" +
                "                </infNFe>\n" +
                "            </infDoc>\n" +
                "            <infModal versaoModal=\"3.00\">\n" +
                "                <rodo>\n" +
                "                    <RNTRC>49343555</RNTRC>\n" +
                "                </rodo>\n" +
                "            </infModal>\n" +
                "            <cobr>\n" +
                "                <dup>\n" +
                "                    <nDup>27504-1/1</nDup>\n" +
                "                    <dVenc>2020-11-30</dVenc>\n" +
                "                    <vDup>7800.00</vDup>\n" +
                "                </dup>\n" +
                "            </cobr>\n" +
                "        </infCTeNorm>\n" +
                "        <infRespTec>\n" +
                "            <CNPJ>10588050000195</CNPJ>\n" +
                "            <xContato>CLAUDIO ROBERTO SILVA BASTOS</xContato>\n" +
                "            <email>claudio@tegasistemas.com.br</email>\n" +
                "            <fone>4331724200</fone>\n" +
                "            <idCSRT>099</idCSRT>\n" +
                "            <hashCSRT>YWFhYWFhYWFhYWFhYWFhYWFhYWE=</hashCSRT>\n" +
                "        </infRespTec>\n" +
                "    </infCte>\n" +
                "    <infCTeSupl>\n" +
                "        <qrCodCTe>\n" +
                "            <![CDATA[http://www.fazenda.pr.gov.br/cte/qrcode?chCTe=41201124476580000156570010000275041000375668&tpAmb=1]]>\n" +
                "        </qrCodCTe>\n" +
                "    </infCTeSupl>\n" +
                "</CTe>\n";

        String response;

        try {
            //ok
            //response = api.transmitir("1", "3.00", xml);
            //ok
            response = api.inutilizar("41201118374429000104570010000022121110022123","141200000056993","TESTE TESTE TESTE TESTE","20", "000002213","000002213", "57","001");
            //ok
            //response = api.geraChaveCTe(xml);
            //ok
            //response = api.geraQrCode(xml);
            //ok
            //response = api.consultaStatusServicoCod("PR");
            //error
            //response = api.consultar("41201124476580000156570010000275041000375668");
            //error
            //response = api.cancelarCteAssinada("41201124476580000156570010000275021000375663", "154198419105185984");
            //response = api.consultaProcessamento("411000074572885");
            //response = api.cancelar("41201124476580000156570010000275041000375668", "141200000056994", "CANCELAMENTO TESTE");

            //response = api.inutilizar(2020,"19278207000150","1","132","321","TESTE");

        } catch (Exception e) {
            response = "Error: " + e.getMessage();
        }
        System.out.println(response);
    }
}

