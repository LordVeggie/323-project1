package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER", schema = "CMPG323")
//Used to record all the member accounts
public class Member implements Serializable
{
    private Long memberId;

    private String email;

    private String fName;

    private String lName;

    private LocalDate creationDate;

    private Set<MemberBalance> memberBalances;

    private Set<AccountTransaction> accountTransactions;

    public Member()
    {
    }

    public Member(Long memberId, String email, String fName, String lName, LocalDate creationDate)
    {
        this.memberId = memberId;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.creationDate = creationDate;
    }

    public Member(String email, String fName, String lName, LocalDate creationDate)
    {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.creationDate = creationDate;
    }

    @Id
    @SequenceGenerator(name = "MEMBER_GENERIC_SEQ", sequenceName = "CMPG323.MEMBER_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_GENERIC_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberId()
    {
        return memberId;
    }

    @Column(name = "EMAIL")
    public String getEmail()
    {
        return email;
    }

    @Column(name = "F_NAME")
    public String getfName()
    {
        return fName;
    }

    @Column(name = "L_NAME")
    public String getlName()
    {
        return lName;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate()
    {
        return creationDate;
    }

    public void setMemberId(Long memberId)
    {
        this.memberId = memberId;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }

    public void setCreationDate(LocalDate creationDate)
    {
        this.creationDate = creationDate;
    }


    @OneToMany(targetEntity = MemberBalance.class, fetch = FetchType.LAZY, mappedBy = "member", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<MemberBalance> getMemberBalances()
    {
        return memberBalances;
    }

    public void setMemberBalances(Set<MemberBalance> memberBalances)
    {
        this.memberBalances = memberBalances;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions()
    {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions)
    {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member that = (Member) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(email, that.email) && Objects.equals(fName, that.fName) && Objects.equals(lName, that.lName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(memberId, email, fName, lName, creationDate);
    }

    @Override
    public String toString()
    {
        return "Member{" +
                "memberId=" + memberId +
                ", email='" + email + '\'' +
                ", first name ='" + fName + '\'' +
                ", last name ='" + lName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
