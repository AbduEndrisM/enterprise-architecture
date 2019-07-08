package com.concurrency.abdu.bank.dao;

import java.util.Collection;

import com.concurrency.abdu.bank.domain.Account;

public interface IAccountDAO {
    public void saveAccount(Account account);

    public void updateAccount(Account account);

    public Account loadAccount(long accountnumber);

    public Collection<Account> getAccounts();
}
