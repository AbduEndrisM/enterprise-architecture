package com.concurrency.abdu.bank.dao;

import java.util.*;

import com.concurrency.abdu.bank.EntityManagerHelper;
import com.concurrency.abdu.bank.domain.Account;

import javax.persistence.EntityManager;

public class AccountDAO implements IAccountDAO {
    Collection<Account> accountlist = new ArrayList<Account>();

    public void saveAccount(Account account) {
        EntityManager entityManager = EntityManagerHelper.getCurrent();
        entityManager.persist(account);  //added  useing EntityManagerHelper

//        System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
//        accountlist.add(account); // add the new

    }

    public void updateAccount(Account account) {

        EntityManager  entityManager = EntityManagerHelper.getCurrent();

        entityManager.merge(account);

//        Account accountexist = loadAccount(account.getAccountnumber());
//        if (accountexist != null) {
//           entityManager.remove(accountexist); // remove the old
//            entityManager.persist(account);// add the new
//        }


//         System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
//        Account accountexist = loadAccount(account.getAccountnumber());
//        if (accountexist != null) {
//            accountlist.remove(accountexist); // remove the old
//            accountlist.add(account); // add the new
//        }

    }

    public Account loadAccount(long accountnumber) {
        // System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
        for (Account account : accountlist) {
            if (account.getAccountnumber() == accountnumber) {
                return account;
            }
        }
        return null;
    }

    public Collection<Account> getAccounts() {

        return accountlist;
    }

}
