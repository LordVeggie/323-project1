package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.AccountTransaction;
import za.ac.nwu.domain.dto.AccountTransactionDto;
@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
}
