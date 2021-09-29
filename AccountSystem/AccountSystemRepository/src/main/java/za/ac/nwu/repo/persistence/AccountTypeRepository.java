package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.domain.dto.AccountTypeDto;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT "+
            "       ACCOUNT_TYPE_ID,"+
            "       ACCOUNT_TYPE_NAME,"+
            "       CREATION_DATE,"+
            "       MNEMONIC,"+
            "       FROM "+
            "       CMPG323.DEMO_ACCOUNT_TYPE"+
            "       WHERE MNEMONIC = :mnemonic ",nativeQuery = true)
    AccountType getAccountByMnemonicNativeQuery(String mnemonic);

    @Query(value = "SELECT "+
            "       at"+
            "       FROM "+
            "       AccountType at"+
            "       WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.AccountTypeDto( "+
            "       at.mnemonic,"+
            "       at.accountTypeName,"+
            "       at.creationDate )"+
            "       FROM "+
            "       AccountType at"+
            "       WHERE at.mnemonic = :mnemonic ")
    AccountTypeDto getAccountDtoByeMnemonic(String mnemonic);
}
