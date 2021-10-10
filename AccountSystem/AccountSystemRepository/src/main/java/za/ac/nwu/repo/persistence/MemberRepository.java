package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.domain.dto.MemberDto;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>
{
    @Query(value = "SELECT "+
            "       at"+
            "       FROM "+
            "       Member at"+
            "       WHERE at.email = :email ")
    Member getMemberByEmail(String email);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.MemberDto( "+
            "       at.email,"+
            "       at.fName,"+
            "       at.lName,"+
            "       at.creationDate )"+
            "       FROM "+
            "       Member at"+
            "       WHERE at.email = :email ")
    MemberDto getMemberDtoByeEmail(String email);
}
