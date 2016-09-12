package com.carlomatulessy.demobankapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by CarloMatulessy on 31/07/16.
 */
public class DataBuilder {

    private static User user;
    private static Account inputAccount;

    public static boolean recreateDashboard = false;
    public static boolean freshStart = true;

    private static List<Account> accounts = new ArrayList<>();
    private static String[] names = {"Evelien", "Laura", "Linda", "Bas", "Roger", "Lilian", "Channa", "Marlies", "Janna", "Anne"};
    private static String[] ibans = {
            "NL31ABNA0230087397", "NL12ABNA0984764035", "NL43INGB0684263824", "NL03INGB0652829948", "NL22ABNA0494273170",
            "NL88RABO0303959708", "NL08ABNA0886228985", "NL86AEGO0743452301", "NL45ABNA0494352296", "NL81ABNA0583647617"};
    private static boolean[] genders = {true, true, true, false, false, true, true, true, true, true};

    public static void createAccounts() {

        for(int i=0; i<names.length; i++) {
            Random random = new Random();
            int amount = random.nextInt(200) + 1;

            Account account = new Account();
            account.setName(names[i]);
            account.setIban(ibans[i]);
            account.setAmount(amount);
            account.setGender(genders[i]);

            accounts.add(account);
        }
    }

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static void addNewMutationToDashboardList(Account inputAccount) {
        accounts.add(0, inputAccount);
    }

    public static void createUser() {
        user = new User();
        user.setName("Carlo");
        user.setIban("NL55DLBK0286834075");
        user.setAmount(50000);
    }

    public static void updateUserAmount() {
        double userCurrentAmount = user.getAmount();
        double inputAccountAmount = inputAccount.getAmount();

        double userNewAmount = userCurrentAmount - inputAccountAmount;

        user.setAmount(userNewAmount);
    }

    public static User getUser() {
        return user;
    }

    public static void saveInputAccount(Account account) {
        inputAccount = account;
    }

    public static Account getInputAccount() {
        return inputAccount;
    }

}
