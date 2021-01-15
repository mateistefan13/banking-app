package com.bankingproject.service;

import com.bankingproject.dto.BankAccount;
import com.bankingproject.dto.DebitBankAccountDTO;
import com.bankingproject.model.User;
import com.bankingproject.repository.AccountCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountService {

    AccountCache accountCache;
    TransactionService transactionService;

    @Autowired
    public AccountService(AccountCache accountCache, TransactionService transactionService) {

        this.accountCache = accountCache;
        this.transactionService = transactionService;
    }

    public boolean transferFunds(String transfererAccountIBAN, String transferToAccountIBAN, Double amount) {

        DebitBankAccountDTO transferer = this.getByIBAN(transfererAccountIBAN);
        DebitBankAccountDTO transferTo = this.getByIBAN(transferToAccountIBAN);

        if (transferer == null || transferTo == null) {
            System.out.println("IBAN code does not exist.");
            return false;
        }

        if (transferer.getAmount() < amount) {
            System.out.println(transferer.getIBAN() + " does not have enough funds.");
            return false;
        }

        transferer.setAmount(transferer.getAmount() - amount);
        transferTo.setAmount(transferTo.getAmount() + amount);

        transactionService.addTransaction(transferer, transferTo, amount);
        System.out.println("Transfer complete!");
        return true;
    }

    public boolean selfTransferFunds(String username, Double amount, String transferFromIBAN, String transferToIBAN) {

        User usr = this.getUser(username);

        if (usr == null) {
            System.out.println("The specified user does not exist.");
            return false;
        }

        if (personalAccount(usr, transferFromIBAN) == false || personalAccount(usr, transferToIBAN) == false) {
            return false;
        }

        return this.transferFunds(transferFromIBAN, transferToIBAN, amount);
    }

    public boolean withdraw(User user, String IBAN, Double amount) {

        DebitBankAccountDTO transferer = this.getByIBAN(IBAN);

        if (user == null) {
            System.out.println("User does not exist.");
            return false;
        }

        if (transferer == null) {
            System.out.println("IBAN code does not exist.");
            return false;
        }

        if (!personalAccount(user, IBAN)) {
            return false;
        }

        if (transferer.getAmount() < amount) {
            System.out.println(transferer.getIBAN() + " does not have enough funds.");
            return false;
        }

        transferer.setAmount(transferer.getAmount() - amount);
        transactionService.addTransaction(transferer, amount);
        System.out.println("Withdraw complete!");
        return true;
    }

    public boolean deposit(User user, String IBAN, Double amount) {

        DebitBankAccountDTO transferer = this.getByIBAN(IBAN);

        if (user == null) {
            System.out.println("User does not exist.");
            return false;
        }

        if (transferer == null) {
            System.out.println("IBAN code does not exist.");
            return false;
        }

        if (!personalAccount(user, IBAN)) {
            return false;
        }

        transferer.setAmount(transferer.getAmount() + amount);
        transactionService.addTransaction(transferer, amount);
        System.out.println("Deposit complete!");
        return true;
    }

    public List<BankAccount> getUserBankAccounts(User user) {

        return user.getBankAccounts();
    }

    public Double getUserBankAccountFunds(User user, long bankAccountId) {

        Optional<BankAccount> account = user.getBankAccounts().stream()
                .filter(bankAccount -> bankAccount.getId() == bankAccountId)
                .findAny();

        return account.map(BankAccount::getAmount).orElse(null);
    }

    public boolean addBankAccounts(List<BankAccount> bankAccounts) {

        return accountCache.addBankAccounts(bankAccounts);
    }

    public boolean addUsers(List<User> users) {

        return accountCache.addUsers(users);
    }

    public boolean addUser(User user) {

        return accountCache.addUser(user);
    }

    public boolean addBankAccount(BankAccount bankAccount) {

        return accountCache.addBankAccount(bankAccount);
    }

    public boolean deleteUser(User user) {

        return accountCache.deleteUser(user);
    }

    public boolean deleteBankAccount(BankAccount bankAccount) {

        return accountCache.deleteBankAccount(bankAccount);
    }

    public DebitBankAccountDTO getByIBAN(String IBAN) {

        return accountCache.getByIBAN(IBAN);
    }

    public Long getUserId(String username) {

        return accountCache.getUserId(username);
    }

    public User getUser(String username) {

        return accountCache.getUser(username);
    }

    public List<User> getUsers() {

        return accountCache.getUsers();
    }

    private boolean personalAccount(User usr, String IBAN) {

        List<String> userIBANs = getUserBankAccounts(usr).stream()
                .map(BankAccount::getIBAN)
                .collect(Collectors.toList());

        if (userIBANs.contains(IBAN) == false) {
            System.out.println("The provided IBAN codes are not belonging to the user " + usr.getUsername());
            return false;
        }

        return true;
    }
}
