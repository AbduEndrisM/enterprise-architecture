package com.concurrency.abdu.bank.dao;

import com.concurrency.abdu.bank.EntityManagerHelper;
import com.concurrency.abdu.bank.domain.Account;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;


public class JPAAcountDAO implements IAccountDAO {
    @Override
    public void saveAccount(Account account) {
        EntityManager entityManager=EntityManagerHelper.getCurrent();
        entityManager.persist(account);
    }

    @Override
    public void updateAccount(Account account) {
EntityManager entityManager=EntityManagerHelper.getCurrent();
entityManager.merge(account);
    }

    @Override
    public Account loadAccount(long accountnumber) {

        EntityManager entityManager= EntityManagerHelper.getCurrent();
        return entityManager.find(Account.class, accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {

        EntityManager entityManager=EntityManagerHelper.getCurrent();
        TypedQuery<Account>typedQuery=entityManager.createQuery("FROM Account", Account.class);

//        TypedQuery<Account>typedQuery=entityManager.createQuery("SELECT DISTINCT a FROM Account as a JOIN FETCH  " +
//                "a.entryList", Account.class);  //if it is MAP

        Collection<Account>accountCollection=typedQuery.getResultList();
        return accountCollection;
    }

}
