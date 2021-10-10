package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.MemberBalance;
import za.ac.nwu.domain.dto.MemberBalanceDto;

@Repository
public interface MemberBalanceRepository extends JpaRepository<MemberBalance, Long>
{
}
