package za.ac.nwu.ac.repo.presistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountMiles;

@Repository
public interface AccountMilesRepository extends JpaRepository<AccountMiles,
        Long> {
}

