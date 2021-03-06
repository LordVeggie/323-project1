package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DEMO_ACCOUNT_TX", schema = "CMPG323")
//this is used to record all transactions that accrue that affect the balances of the different account
//types of all users
public class AccountTransaction implements Serializable{

    private Long accountTxId;

    private AccountType accountType;

    private Member member;

    private Long amount;

    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(Long accountTxId, AccountType accountType, Member member, Long amount, LocalDate transactionDate) {
        this.accountTxId = accountTxId;
        this.accountType = accountType;
        this.member = member;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "DEMO_ACCOUNT_TX_GENERIC_SEQ", sequenceName = "CMPG323.DEMO_ACCOUNT_TX_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_ACCOUNT_TX_GENERIC_SEQ")
    @Column(name = "ACCOUNT_TX_ID")
    public Long getAccountTxId()
    {
        return accountTxId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType()
    {
        return accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    public Member getMember()
    {
        return member;
    }

    @Column (name = "AMOUNT")
    public Long getAmount()
    {
        return amount;
    }

    @Column (name = "TX_DATE")
    public LocalDate getTransactionDate()
    {
        return transactionDate;
    }

    public void setAccountTxId(Long accountTxId)
    {
        this.accountTxId = accountTxId;
    }

    public void setAccountType(AccountType accountType)
    {
        this.accountType = accountType;
    }

    public void setMember(Member member)
    {
        this.member = member;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate)
    {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountTxId, that.accountTxId) && Objects.equals(accountType, that.accountType) && Objects.equals(member, that.member) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(accountTxId, accountType, member, amount, transactionDate);
    }

    @Override
    public String toString()
    {
        return "AccountTransaction{" +
                "accountTxId=" + accountTxId +
                ", accountType=" + accountType +
                ", member=" + member +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }

}
