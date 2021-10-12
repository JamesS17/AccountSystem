package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountMember;


@Repository
@Component
public interface AccountMemberRepository extends JpaRepository<AccountMember, Long> {


}
