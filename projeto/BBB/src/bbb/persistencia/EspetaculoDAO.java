package bbb.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bbb.apresentacao.dto.ConsultarProgramacaoDTO;
import bbb.apresentacao.dto.SessaoDTO;
import bbb.negocio.espetaculos.Espetaculo;
import bbb.negocio.espetaculos.TipoEspetaculo;
import bbb.negocio.locais.Local;
import bbb.negocio.sessoes.Sessao;

/**
 * DAO para a entidade Espetaculo.
 *
 */
public class EspetaculoDAO {

	List<Espetaculo> espetaculos = new ArrayList<Espetaculo>();

	/**
	 * Cria alguns espetáculos e sessões apenas para teste.
	 */
	public EspetaculoDAO() {
		criarEspetaculosMock();
		criarSessoesMock();
	}

	/**
	 * Insere um novo espetáculo na lista de espetáculos
	 * 
	 * @param espetaculo Dados do espetáculo a ser inserido.
	 */
	public void inserir(Espetaculo espetaculo) {
		espetaculos.add(espetaculo);
	}

	/**
	 * Busca os títulos dos espetáculos pertencentes ao tipo escolhido.
	 * 
	 * @param tipoEscolhido Tipo de espetáculo que se deseja buscar.
	 * @return
	 */
	public List<String> buscarTitulos(TipoEspetaculo tipoEscolhido) {
		List<String> titulos = new ArrayList<String>();
		for (Espetaculo espetaculo : espetaculos) {
			if (espetaculo.getTipoEspetaculo().equals(tipoEscolhido)) {
				titulos.add(espetaculo.getTitulo());
			}
		}
		return titulos;
	}

	/**
	 * Busca um espetáculo a partir de seu título
	 * 
	 * @param titulo Título do espetáculo que se deseja buscar.
	 * @return Espetáculo com o título buscado.
	 */
	public Espetaculo buscarEspetaculo(String titulo) {
		for (Espetaculo espetaculo : espetaculos) {
			if (espetaculo.getTitulo().equals(titulo)) {
				return espetaculo;
			}
		}
		return null;
	}

	/**
	 * Consulta a programação existente para um determinado espetáculo de um determinado tipo.
	 * 
	 * @param tipoEspetaculo Tipo de Espetáculo para o qual se deseja buscar a programação.
	 * @param titulo Título do espetáculo para o qual se deseja buscar a programação.
	 * @return DTO contendo os dados de programação do espetáculo desejado.
	 */
	public ConsultarProgramacaoDTO consultarProgramacao(TipoEspetaculo tipoEspetaculo, String titulo) {
		ConsultarProgramacaoDTO dto = new ConsultarProgramacaoDTO();
		dto.setTipo(tipoEspetaculo);
		dto.setTitulo(titulo);
		// Busca o espetáculo
		Espetaculo espetaculo = this.buscarEspetaculo(titulo);
		dto.setComentarios(espetaculo.getComentarios());
		// busca sessões
		List<SessaoDTO> sessoes = new ArrayList<SessaoDTO>();
		for (Sessao sessao : espetaculo.getSessoes()) {
			SessaoDTO sessaoDTO = new SessaoDTO();
			sessaoDTO.setDataSessao(sessao.getData());
			sessaoDTO.setDuracao(espetaculo.getDuracao());
			sessaoDTO.setInicio(sessao.getHoraInicio());
			sessaoDTO.setNomeLocal(sessao.getLocal().getNome());
			sessaoDTO.setValorInteira(sessao.getValorInteira());
			sessaoDTO.setValorMeia(sessao.getValorMeia());
			sessoes.add(sessaoDTO);
		}
		dto.setListaSessoes(sessoes);
		return dto;
	}

	private void criarEspetaculosMock() {
		Espetaculo espetaculo = new Espetaculo();

		espetaculo.setTipoEspetaculo(TipoEspetaculo.FILME);
		espetaculo.setTitulo("MIB Homens de Preto 3");
		espetaculo.setDuracao("180 min");
		espetaculo.setComentarios("3a. versão do homens de preto, 2012");
		espetaculos.add(espetaculo);

		Espetaculo espetaculo2 = new Espetaculo();

		espetaculo2.setTipoEspetaculo(TipoEspetaculo.FILME);
		espetaculo2.setTitulo("Branca de Neve");
		espetaculo2.setDuracao("125 min");
		espetaculo2.setComentarios("Os sete anões");
		espetaculos.add(espetaculo2);

		Espetaculo espetaculo3 = new Espetaculo();
		espetaculo3.setTipoEspetaculo(TipoEspetaculo.PECA_TEATRO);
		espetaculo3.setTitulo("Dona Flor e seus 2 Maridos");
		espetaculo3.setDuracao("180 min");
		espetaculo3.setComentarios("Adaptado da obra de Jorge Amado");
		espetaculos.add(espetaculo3);

		Espetaculo espetaculo4 = new Espetaculo();
		espetaculo4.setTipoEspetaculo(TipoEspetaculo.PECA_TEATRO);
		espetaculo4.setTitulo("O Mistério de Irma Vap");
		espetaculo4.setDuracao("18 min");
		espetaculo4.setComentarios("Também em filme para cinema");
		espetaculos.add(espetaculo4);

		Espetaculo espetaculo5 = new Espetaculo();
		espetaculo5.setTipoEspetaculo(TipoEspetaculo.SHOW);
		espetaculo5.setTitulo("Jeniffer Lopez");
		espetaculo5.setDuracao("180 min");
		espetaculo5.setComentarios("Inaugurando o Centro de Eventos");
		espetaculos.add(espetaculo5);

		Espetaculo espetaculo6 = new Espetaculo();
		espetaculo6.setTipoEspetaculo(TipoEspetaculo.SHOW);
		espetaculo6.setTitulo("Madonna ao vivo");
		espetaculo6.setDuracao("185 min");
		espetaculo6.setComentarios("Show com muita dança");
		espetaculos.add(espetaculo6);

	}

	private void criarSessoesMock() {
		// cria sessões para um espetáculo apenas
		Espetaculo espetaculo = buscarEspetaculo("MIB Homens de Preto 3");
		List<Sessao> sessoes = new ArrayList<Sessao>();
		Local local1 = new Local();
		local1.setNome("Shopping Iguatemi");
		local1.setEndereco("Washington Soares");
		local1.setTelefone("2222-2222");

		Local local2 = new Local();
		local2.setNome("North Shopping");
		local2.setEndereco("Bezerra de Menezes");
		local2.setTelefone("4444-4444");

		Sessao sessao1 = new Sessao();
		sessao1.setData(new Date());
		sessao1.setHoraInicio("18:30");
		sessao1.setValorInteira(30.0);
		sessao1.setValorMeia(15.0);
		sessao1.setLocal(local1);

		Sessao sessao2 = new Sessao();
		sessao2.setData(new Date());
		sessao2.setHoraInicio("21:30");
		sessao2.setValorInteira(18.0);
		sessao2.setValorMeia(9.0);
		sessao2.setLocal(local2);

		sessoes.add(sessao1);
		sessoes.add(sessao2);

		espetaculo.setSessoes(sessoes);

	}

}
