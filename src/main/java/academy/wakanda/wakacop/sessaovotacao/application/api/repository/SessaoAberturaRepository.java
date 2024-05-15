package academy.wakanda.wakacop.sessaovotacao.application.api.repository;

import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;

import java.util.UUID;

public interface SessaoAberturaRepository {
    SessaoVotacao salva(SessaoVotacao sessaoVotacao);
    SessaoVotacao buscaPorId(UUID idSessao);
}