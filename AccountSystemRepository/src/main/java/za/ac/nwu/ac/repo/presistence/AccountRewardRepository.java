package za.ac.nwu.ac.repo.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountReward;

@Repository
public interface AccountRewardRepository extends JpaRepository<AccountReward,
        Long> {
}


