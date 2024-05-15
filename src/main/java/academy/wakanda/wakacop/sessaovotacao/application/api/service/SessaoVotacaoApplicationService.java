package academy.wakanda.wakacop.sessaovotacao.application.api.service;

import academy.wakanda.wakacop.pauta.application.service.PautaService;
import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.sessaovotacao.application.api.repository.SessaoAberturaRepository;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.VotoResponse;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.domain.VotoPauta;
import academy.wakanda.wakacop.sessaovotacao.domain.request.VotoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaoVotacaoService {
    private final SessaoAberturaRepository sessaoAberturaRepository;
    private final PautaService pautaService;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest request) {
        log.info("[start] - SessaoVotacaoApplicationService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(request.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoAberturaRepository.salva(new SessaoVotacao(request, pauta));
        log.info("[finish] - SessaoVotacaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
        log.info("[start] - SessaoVotacaoApplicationService - recebeVoto");
        SessaoVotacao sessao = sessaoAberturaRepository.buscaPorId(idSessao);
        VotoPauta voto = sessao.recebeVoto(novoVoto);
        sessaoAberturaRepository.salva(sessao);
        log.info("[finish] - SessaoVotacaoApplicationService - recebeVoto");
        return new VotoResponse(voto);
    }
}
