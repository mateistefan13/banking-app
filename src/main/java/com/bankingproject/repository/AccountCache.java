package com.bankingproject.repository;

import com.bankingproject.dto.BankAccount;
import com.bankingproject.dto.CreditBankAccountDTO;
import com.bankingproject.dto.DebitBankAccountDTO;
import com.bankingproject.model.PersoanaFizica;
import com.bankingproject.model.PersoanaJuridica;
import com.bankingproject.model.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class AccountCache {

    public static final Double creditAccountLimit = 1000000.0;

    @Getter
    public List<User> users = new ArrayList<>();

    @Getter
    public List<BankAccount> bankAccounts = new ArrayList<>();


    public boolean addBankAccounts(List<BankAccount> bankAccounts) {

        return this.bankAccounts.addAll(bankAccounts);
    }

    public boolean addUsers(List<User> users) {

        return this.users.addAll(users);
    }

    public boolean addUser(User user) {

        return this.users.add(user);
    }

    public boolean addBankAccount(BankAccount bankAccount) {

        return this.bankAccounts.add(bankAccount);
    }

    public boolean deleteUser(User user) {

        return this.users.remove(user);
    }

    public boolean deleteBankAccount(BankAccount bankAccount) {

        return this.bankAccounts.remove(bankAccount);
    }

    public DebitBankAccountDTO getByIBAN(String IBAN) {

        return (DebitBankAccountDTO) bankAccounts.stream()
                .filter(bankAccount -> bankAccount instanceof DebitBankAccountDTO && ((DebitBankAccountDTO) bankAccount).getIBAN().equalsIgnoreCase(IBAN))
                .findAny()
                .orElse(null);
    }

    public Long getUserId(String username) {

        if (users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username)).findAny().isEmpty()) {
            return null;
        }

        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .map(User::getUniqueId)
                .findFirst().get();
    }

    public User getUser(String username) {

        if (users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username)).findAny().isEmpty()) {
            return null;
        }

        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .get();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // For demo purposes ///////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void initializeUserList() {

        this.users.add(new PersoanaFizica(
                "Ranga", "Matei", "mateistefan",
                "1930324123990", 2500.0));
        this.users.add(new PersoanaFizica(
                "Gigel", "Costel", "gigelcostel",
                "1910324123990", 7500.0));
        this.users.add(new PersoanaJuridica(
                "CompanieSrl", "companieSrl", "00456", 22.0, 4000.0));
        this.users.add(new PersoanaJuridica(
                "CompanieSrl2", "companieSrl2", "88452", 22.0, 45030.0));
    }

    public void assignDebitAccounts() {

        for (User usr : users) {

            BankAccount bankAccount =
                    new DebitBankAccountDTO((double) Math.round(Math.random() * (50000 - 50 + 1)), usr.getUniqueId(),
                            "RODEBITROBU" + usr.getUniqueId());
            bankAccounts.add(bankAccount);
            usr.addBankAccount(bankAccount);
        }
    }

    public void assignCreditAccounts() {

        for (User usr : users) {

            BankAccount bankAccount =
                    new CreditBankAccountDTO(usr.getUniqueId(), (double) Math.round(Math.random() * (50000 - 50 + 1)),
                            creditAccountLimit, "ROCREDITROBU" + usr.getUniqueId());
            bankAccounts.add(bankAccount);
            usr.addBankAccount(bankAccount);
        }
    }

}
