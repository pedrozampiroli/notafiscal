package app.notafiscal;

import com.fincatto.documentofiscal.gnre200.webservice.configuf.ConfigUFApplication;
import com.fincatto.documentofiscal.gnre200.webservice.loterecepcao.LoteRecepcaoApplication;
import com.fincatto.documentofiscal.gnre200.webservice.loterecepcao.LoteRecepcaoModel;
import com.fincatto.documentofiscal.gnre200.webservice.resultadolote.ResultadoLoteApplication;

public class GnreAPI {

    String logs = "";

    public String configurar(String CertificadoSenha, String CadeiaCertificadoSenha, String CaminhoCertificado, String CaminhoCadeiaCertificado, String Estado, String Receita) throws Exception {
        GnreConfiguracao gConfig = new GnreConfiguracao();
        gConfig.configGnre(CaminhoCertificado, CertificadoSenha, CaminhoCadeiaCertificado, CadeiaCertificadoSenha);
        ConfigUFApplication cUf = new ConfigUFApplication();
        logs = cUf.configUf(Estado, Receita, "2.00");
        return logs;
    }

    public String transmitir(String setUfFavorecida, String setInscricaoEstadual, String setCodigoReceita, String setEmitenteCnpj, String setTipoDocumentoOrigem, String setDocumentoOrigem, String setValorPrincipal, String setDataVencimento, String setEmitenteRazaoSocial, String setEmitenteEndereco, String setEmitenteCodigoMunicipio, String setEmitenteUf, String setEmitenteCep, String setDataPagamento, String setEmitenteTelefone, String setConvenio, String setPeriodo, String setMes, String setAno, String setTipoValor, String setValorTotal, String setNumParcela, String setIncricaoEstadualContribuinte, String setCnpjContribuinte, String setCpfContribuinte, String setCodigoDetalhamentoReceita, String setCodigoProduto, String setDestinatarioRazaoSocial, String setDestinatarioCodMunicipio) {
        String versao = "2.00";
        LoteRecepcaoModel model = new LoteRecepcaoModel();
        model.setUfFavorecida(setUfFavorecida);
        model.setInscricaoEstadual(setInscricaoEstadual);
        model.setCodigoReceita(setCodigoReceita);
        model.setEmitenteCnpj(setEmitenteCnpj);
        model.setTipoDocumentoOrigem(setTipoDocumentoOrigem);
        model.setDocumentoOrigem(setDocumentoOrigem);
        model.setValorPrincipal(setValorPrincipal);
        model.setEmitenteRazaoSocial(setEmitenteRazaoSocial);
        model.setEmitenteEndereco(setEmitenteEndereco);
        model.setEmitenteCodigoMunicipio(setEmitenteCodigoMunicipio);
        model.setEmitenteUf(setEmitenteUf);
        model.setEmitenteCep(setEmitenteCep);
        model.setEmitenteTelefone(setEmitenteTelefone);
        model.setDataPagamento(setDataPagamento);
        model.setDataVencimento(setDataVencimento);
        model.setEmitenteTelefone(setEmitenteTelefone);
        model.setConvenio(setConvenio);
        model.setPeriodo(setPeriodo.isEmpty() ? "0" : setPeriodo);
        model.setTipoValor(setTipoValor.isEmpty() ? "11" : setTipoValor);
        model.setValorTotal(setValorTotal);
        model.setNumParcela(setNumParcela);
        model.setCnpjDestinatario(setCnpjContribuinte);
        model.setInscricaoEstadualDestinatario(setIncricaoEstadualContribuinte);
        model.setCpfDestinatario(setCpfContribuinte);
        model.setCodigoDetalhamentoReceita(setCodigoDetalhamentoReceita);
        model.setCodigoProduto(setCodigoProduto);
        model.setDestinatarioRazaoSocial(setDestinatarioRazaoSocial);
        model.setDestinatarioCodigoMunicipio(setDestinatarioCodMunicipio);
        model.setMes(setMes);
        model.setAno(setAno);
        try {
            logs = LoteRecepcaoApplication.transmitir(model, versao);
        } catch (Exception e) {
            logs = e.getMessage();
            e.getStackTrace();
        }

        return logs;
    }

    public String consultar(String numeroRecibo) {
        try {
            logs = ResultadoLoteApplication.consultaLote(numeroRecibo);
        } catch (Exception e) {
            logs = e.getMessage();
            e.getStackTrace();
        }

        return logs;
    }

}
