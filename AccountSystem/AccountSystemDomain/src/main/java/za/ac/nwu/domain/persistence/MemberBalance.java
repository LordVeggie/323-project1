package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_BALANCE", schema = "CMPG323")
//this is used to record all members different balances of the different account
public class MemberBalance implements Serializable
{
    private Long balanceId;

    private AccountType accountType;

    private Member member;

    private Long balance;

    private LocalDate dateOfLastTransaction;
    //DATE_OF_LAST_TRANSACTON

    public MemberBalance()
    {
    }

    public MemberBalance(Long balanceId, AccountType accountType, Member member, Long balance, LocalDate dateOfLastTransaction)
    {
        this.balanceId = balanceId;
        this.accountType = accountType;
        this.member = member;
        this.balance = balance;
        this.dateOfLastTransaction = dateOfLastTransaction;
    }

    @Id
    @SequenceGenerator(name = "MEMBER_BALANCE_SEQ", sequenceName = "CMPG323.MEMBER_BALANCE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_BALANCE_SEQ")
    @Column(name = "BALANCE_ID")
    public Long getBalanceId()
    {
        return balanceId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType()
    {
        return accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "MEMBER_ID")
    public Member getMember()
    {
        return member;
    }

    @Column (name = "BALANCE")
    public Long getBalance()
    {
        return balance;
    }

    @Column (name = "DATE_OF_LAST_TRANSACTON")
    public LocalDate getDateOfLastTransaction()
    {
        return dateOfLastTransaction;
    }

    public void setBalanceId(Long balanceId)
    {
        this.balanceId = balanceId;
    }

    public void setAccountType(AccountType accountType)
    {
        this.accountType = accountType;
    }

    public void setMember(Member member)
    {
        this.member = member;
    }

    public void setBalance(Long balance)
    {
        this.balance = balance;
    }

    public void setDateOfLastTransaction(LocalDate dateOfLastTransaction) {
        this.dateOfLastTransaction = dateOfLastTransaction;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberBalance that = (MemberBalance) o;
        return Objects.equals(balanceId, that.balanceId) && Objects.equals(accountType, that.accountType) && Objects.equals(member, that.member) && Objects.equals(balance, that.balance) && Objects.equals(dateOfLastTransaction, that.dateOfLastTransaction);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(balanceId, accountType, member, balance, dateOfLastTransaction);
    }

    @Override
    public String toString()
    {
        return "Member balance{" +
                "accountTxId=" + balanceId +
                ", accountType=" + accountType +
                ", member=" + member +
                ", amount=" + balance +
                ", transactionDate=" + dateOfLastTransaction +
                '}';
    }
}