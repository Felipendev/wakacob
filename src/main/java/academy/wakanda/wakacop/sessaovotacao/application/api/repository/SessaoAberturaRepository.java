package academy.wakanda.wakacop.sessaovotacao.application.api.repository;

import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;

public interface SessaoAberturaRepository {
    SessaoVotacao salva(SessaoVotacao sessaoVotacao);
}