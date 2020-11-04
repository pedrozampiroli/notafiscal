package app.notafiscal;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTTipoEmissao;
import com.fincatto.documentofiscal.cte300.classes.consultastatusservico.CTeConsStatServRet;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLote;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLoteRetornoDados;
import com.fincatto.documentofiscal.cte300.classes.evento.cancelamento.CTeRetornoCancelamento;
import com.fincatto.documentofiscal.cte300.classes.nota.CTeNota;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fincatto.documentofiscal.cte300.classes.nota.consulta.CTeNotaConsultaRetorno;
import com.fincatto.documentofiscal.cte300.webservices.WSFacade;
import com.fincatto.documentofiscal.utils.DFPersister;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class CTeAPI {
    private DFUnidadeFederativa sEstado;
    private DFAmbiente sAmbiente;
    private String sCadeiaCertificadoSenha;
    private String sCadeiaCertificadoCaminho;
    private String sCaminhoCertificado;
    private String sCertificadoSenha;
    private String logs;
    private final CTeConfig config = new CTeConfig() {
        private KeyStore keyStoreCertificado = null;
        private KeyStore keyStoreCadeia = null;

        @Override
        public String getCertificadoSenha() {
            return sCertificadoSenha;
        }

        @Override
        public KeyStore getCertificadoKeyStore() throws KeyStoreException {
            if (this.keyStoreCertificado == null) {
                this.keyStoreCertificado = KeyStore.getInstance("PKCS12");
                try (InputStream certificadoStream = new FileInputStream(sCaminhoCertificado)) {
                    this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());
                } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                    this.keyStoreCadeia = null;
                    throw new KeyStoreException("Nao foi possivel montar o KeyStore com a cadeia de certificados", e);
                }
            }
            return this.keyStoreCertificado;
        }

        @Override
        public String getCadeiaCertificadosSenha() {
            return sCadeiaCertificadoSenha;
        }

        @Override
        public KeyStore getCadeiaCertificadosKeyStore() throws KeyStoreException {
            if (this.keyStoreCadeia == null) {
                this.keyStoreCadeia = KeyStore.getInstance("JKS");
                try (InputStream cadeia = new FileInputStream(sCadeiaCertificadoCaminho)) {
                    this.keyStoreCadeia.load(cadeia, sCadeiaCertificadoSenha.toCharArray());
                } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                    this.keyStoreCadeia = null;
                    throw new KeyStoreException("Nao foi possibel montar o KeyStore com o certificado", e);
                }
            }
            return this.keyStoreCadeia;
        }

        @Override
        public DFUnidadeFederativa getCUF() {
            return sEstado;
        }

        @Override
        public DFAmbiente getAmbiente() {
            return sAmbiente;
        }

        @Override
        public CTTipoEmissao getTipoEmissao() {
            return CTTipoEmissao.EMISSAO_NORMAL;
        }

    };

    public void configurar(String CertificadoSenha, String CadeiaCertificadoSenha, String CaminhoCertificado, String CaminhoCadeiaCertificado, String Estado, String Ambiente) {
        CTeConfiguracao sconfiguracao = new CTeConfiguracao();
        sconfiguracao.getCertificadoKeyStore = CaminhoCertificado;
        sconfiguracao.getCertificadoSenha = CertificadoSenha;
        sconfiguracao.getCadeiaCertificadosKeyStore = CaminhoCadeiaCertificado;
        sconfiguracao.getCadeiaCertificadosSenha = CadeiaCertificadoSenha;
        sconfiguracao.DFUnidadeFederativa = BuscaUnidadeFederativa(Estado);
        sconfiguracao.DFAmbiente = buscaAmbiente(Ambiente);
        sAmbiente = buscaAmbiente(Ambiente);
        sEstado = BuscaUnidadeFederativa(Estado);
        sCadeiaCertificadoCaminho = CaminhoCadeiaCertificado;
        sCadeiaCertificadoSenha = CadeiaCertificadoSenha;
        sCaminhoCertificado = CaminhoCertificado;
        sCertificadoSenha = CertificadoSenha;
    }

    private DFUnidadeFederativa BuscaUnidadeFederativa(String UF) {

        DFUnidadeFederativa unidadefederativa;

        switch (UF) {
            case "RR":
                unidadefederativa = DFUnidadeFederativa.RR;
                break;
            case "AM":
                unidadefederativa = DFUnidadeFederativa.AM;
                break;
            case "AC":
                unidadefederativa = DFUnidadeFederativa.AC;
                break;
            case "RO":
                unidadefederativa = DFUnidadeFederativa.RO;
                break;
            case "AP":
                unidadefederativa = DFUnidadeFederativa.AP;
                break;
            case "PA":
                unidadefederativa = DFUnidadeFederativa.PA;
                break;
            case "MT":
                unidadefederativa = DFUnidadeFederativa.MT;
                break;
            case "TO":
                unidadefederativa = DFUnidadeFederativa.TO;
                break;
            case "MA":
                unidadefederativa = DFUnidadeFederativa.MA;
                break;
            case "PI":
                unidadefederativa = DFUnidadeFederativa.PI;
                break;
            case "MS":
                unidadefederativa = DFUnidadeFederativa.MS;
                break;
            case "GO":
                unidadefederativa = DFUnidadeFederativa.GO;
                break;
            case "DF":
                unidadefederativa = DFUnidadeFederativa.DF;
                break;
            case "MG":
                unidadefederativa = DFUnidadeFederativa.MG;
                break;
            case "RJ":
                unidadefederativa = DFUnidadeFederativa.RJ;
                break;
            case "SP":
                unidadefederativa = DFUnidadeFederativa.SP;
                break;
            case "SC":
                unidadefederativa = DFUnidadeFederativa.SC;
                break;
            case "RS":
                unidadefederativa = DFUnidadeFederativa.RS;
                break;
            case "ES":
                unidadefederativa = DFUnidadeFederativa.ES;
                break;
            case "BA":
                unidadefederativa = DFUnidadeFederativa.BA;
                break;
            case "RN":
                unidadefederativa = DFUnidadeFederativa.RN;
                break;
            case "CE":
                unidadefederativa = DFUnidadeFederativa.CE;
                break;
            case "AL":
                unidadefederativa = DFUnidadeFederativa.AL;
                break;
            case "PE":
                unidadefederativa = DFUnidadeFederativa.PE;
                break;
            case "PB":
                unidadefederativa = DFUnidadeFederativa.PB;
                break;
            case "SE":
                unidadefederativa = DFUnidadeFederativa.SE;
                break;
            case "PR":
            default:
                unidadefederativa = DFUnidadeFederativa.PR;
                break;
        }

        return unidadefederativa;
    }

    private DFAmbiente buscaAmbiente(String Ambiente) {
        DFAmbiente dfambiente;
        switch (Ambiente) {
            case "1":
                dfambiente = DFAmbiente.PRODUCAO;
                break;
            case "2":
            default:
                dfambiente = DFAmbiente.HOMOLOGACAO;
                break;
        }
        return dfambiente;
    }

    public String transmitir(String loteid, String ver, String xmlRec) {
        //Cria uma lista de XML
        List<String> xml = new ArrayList<>();
        //Trata o xml para remover cáracteres e espaços que impeçam a transmissão do cód.
        xmlRec = xmlRec.replaceAll("\r", "");
        xmlRec = xmlRec.replaceAll("\t", "");
        xmlRec = xmlRec.replaceAll("\\s{2,}", "");
        xmlRec = xmlRec.replaceAll("\n", "");
        xmlRec = xmlRec.replaceAll("&gt;", ">");
        xmlRec = xmlRec.replaceAll("&lt;", "<");
        //Adiciona o XML tratado para a lista de XML citada
        xml.add(xmlRec);
        //Cria uma lista de string chamada value
        List<String> value = new ArrayList<>();
        //Varre a lista de 'xml' para realizar a conversão de todos os XML da lista para UTF-8
        for (String s : xml) {
            //converte para UTF-8 e adiciona a lista 'value'
            value.add(new String(s.getBytes(StandardCharsets.UTF_8)));
        }
        //Cria uma lista do objeto CTeNota e define como um novo Array
        List<CTeNota> cte = new ArrayList<>();
        try {
            //Tenta criar um objeto CTeNota e atribuir o valor do xml no index 0 da lista 'value'
            CTeNota c = new DFPersister().read(CTeNota.class, value.get(0));
            //Adiciona o objeto criado acima na lista de cte
            cte.add(c);
        } catch (Exception e) {
            logs = "Erro na conversão de CTe para objeto: " + e.getMessage();
        }
        //Instancia um objeto de lote de CTe para envio
        CTeEnvioLote LoteEnvio = new CTeEnvioLote();
        try {
            //Tenta criar o lote de CTe utilizando as informações passadas ao metodo e a lista 'cte' criada acima
            LoteEnvio.setIdLote(loteid);
            LoteEnvio.setVersao(ver);
            LoteEnvio.setNota(cte);
        } catch (Exception e) {
            logs = "Erro na criação de lote: " + e.getMessage();
        }
        try {
            //Tenta realizar a transmissão do objeto de lote a receita
            CTeEnvioLoteRetornoDados cteEnvioLoteRetornoDados = new WSFacade(config).envioRecepcaoLote(LoteEnvio);
            //Grava em 'logs' os dados a serem informados ao usuário (Lote Assinado e Retorno da receita)
            logs = cteEnvioLoteRetornoDados.getLoteAssinado().toString() + "," + cteEnvioLoteRetornoDados.getRetorno().toString();
        } catch (Exception e) {
            logs = "error na transmissão do lote de CTe: " + e.getMessage();
        }
        return logs;
    }

    public String consultaStatusServico() {
        try {
            CTeConsStatServRet cteStatusServiceRetorno = new WSFacade(config).consultaStatus(DFUnidadeFederativa.DF);
            logs = cteStatusServiceRetorno.getMotivo() + " " + cteStatusServiceRetorno.getObservacao();
        } catch (Exception e) {
            logs = e.getMessage();
        }
        return logs;
    }

    public String consultar(String chave) {
        try {
            //TODO alterar o retorno;
            CTeNotaConsultaRetorno cteEnvioLoteRetornoDados = new WSFacade(config).consultaNota(chave);
            logs = cteEnvioLoteRetornoDados.getMotivo();
        } catch (Exception e) {
            logs = e.getMessage();
        }
        return logs;
    }

    public String cancelar(String chave, String protocolo, String justificativa) {
        try {
            CTeRetornoCancelamento cTeNotaConsultaRetorno = new WSFacade(config).cancelaNota(chave, protocolo, justificativa);
            logs = cTeNotaConsultaRetorno.getInfoCancelamento().toString();
        } catch (Exception e) {
            logs = e.getMessage();
        }
        return logs;
    }
    /*
    public String cancelarCteAssinada(String chave, String protocolo) {
        CTeRetornoCancelamento cteRetornoCancelamento;
        try {
            cteRetornoCancelamento = new WSFacade(config).cancelaNotaAssinada(chave, protocolo);
            logs = cteRetornoCancelamento.getInfoCancelamento().toString();
        } catch (Exception e) {
            logs = "Error" + e.getMessage();
        }
        return logs;
    }
    */
}