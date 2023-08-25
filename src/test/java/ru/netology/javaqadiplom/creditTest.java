package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class creditTest {

    @Test// amount > 0 BAG
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.add(3_000);
        Assertions.assertEquals(3_300, account.getBalance());
    }

    @Test// amount < 0
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.add(-3_000);
        Assertions.assertEquals(300, account.getBalance());
    }

    @Test//amount = 0
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.add(0);
        Assertions.assertEquals(300, account.getBalance());
    }

    @Test// initialBalance < 0
    public void shouldAddToNegativeInitialBalance() {
        CreditAccount account = new CreditAccount(
                -300,
                5_000,
                15
        );
        account.add(3000);
        Assertions.assertEquals(2700, account.getBalance());
    }

    @Test// initialBalance = 0
    public void shouldAddToZeroInitialBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.add(3000);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test// creditLimit < 0
    public void shouldAddToNegativeCreditLimit() {
        CreditAccount account = new CreditAccount(

                300,
                -5_000,
                15
        );
        account.add(3000);
        Assertions.assertEquals(3300, account.getBalance());
    }

    @Test// creditLimit = 0
    public void shouldAddToZeroCreditLimit() {
        CreditAccount account = new CreditAccount(
                300,
                0,
                15
        );
        account.add(3000);
        Assertions.assertEquals(3300, account.getBalance());
    }

    @Test// amount > 0 BAG
    public void shouldAddToPositivePay() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.pay(200);
        Assertions.assertEquals(100, account.getBalance());
    }

    @Test// amount = 0
    public void shouldAddToZeroPay() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.pay(0);
        Assertions.assertEquals(300, account.getBalance());
    }

    @Test// amount < 0
    public void shouldAddToNegativePay() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.pay(-3_000);
        Assertions.assertEquals(300, account.getBalance());

    }

    @Test// на выброс исключения в конструкторе
    public void illegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            CreditAccount account = new CreditAccount(300, 5_000, -10);
        });
    }

    @Test// BAG
    public void yearChangeTest() {

        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15);
        account.yearChange();
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test//
    public void yearChangeTest2() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );
        account.yearChange();
        Assertions.assertEquals(-30, account.yearChange());
    }
}
