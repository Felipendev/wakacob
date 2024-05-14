package academy.wakanda.wakacop.sessaovotacao.infra;

import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessaoAberturaSpringDataJPARepository extends JpaRepository<SessaoVotacao, UUID> {
}
