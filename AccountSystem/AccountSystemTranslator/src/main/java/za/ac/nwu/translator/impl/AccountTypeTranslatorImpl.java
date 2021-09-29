package za.ac.nwu.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.repo.persistence.AccountTypeRepository;
import za.ac.nwu.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository)
    {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes()
    {
        List<AccountTypeDto>accountTypeDtos = new ArrayList<>();
        try
        {
            for(AccountType accountType : accountTypeRepository.findAll())
            {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to read form the DB", e);
        }

        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto)
    {
        try
        {
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public  AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic)
    {
        try
        {
            AccountType accountType = accountTypeRepository.getAccountByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public  AccountTypeDto getAccountTypeByMnemonic(String mnemonic)
    {
        try
        {
            AccountType accountType = accountTypeRepository.getAccountByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public  AccountTypeDto getAccountDtoByeMnemonic(String mnemonic)
    {
        try
        {
            return accountTypeRepository.getAccountDtoByeMnemonic(mnemonic);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
