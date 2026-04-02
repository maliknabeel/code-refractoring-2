package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.movingfeatures.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingFeaturesTest {

    @Test
    void moveMethod_premiumAccount_chargesCorrectly() {
        MoveMethodExample.GoodExample.AccountType premium = new MoveMethodExample.GoodExample.AccountType(true);
        MoveMethodExample.GoodExample.Account account = new MoveMethodExample.GoodExample.Account(premium, 10);
        assertEquals(10 + (10 - 7) * 0.85, account.overdraftCharge(), 0.001);
    }

    @Test
    void moveMethod_standardAccount_chargesPerDay() {
        MoveMethodExample.GoodExample.AccountType standard = new MoveMethodExample.GoodExample.AccountType(false);
        MoveMethodExample.GoodExample.Account account = new MoveMethodExample.GoodExample.Account(standard, 5);
        assertEquals(5 * 1.75, account.overdraftCharge(), 0.001);
    }

    @Test
    void moveField_interestCalculation() {
        MoveFieldExample.GoodExample.AccountType type = new MoveFieldExample.GoodExample.AccountType("Savings", 0.05);
        MoveFieldExample.GoodExample.Account account = new MoveFieldExample.GoodExample.Account(type);
        assertEquals(0.05 * 1000 * 30 / 365.0, account.interestForAmount(1000, 30), 0.001);
    }

    @Test
    void extractClass_telephoneFormat() {
        ExtractClassExample.GoodExample.TelephoneNumber tel =
            new ExtractClassExample.GoodExample.TelephoneNumber("021", "1234567");
        assertEquals("(021) 1234567", tel.getTelephoneNumber());
    }

    @Test
    void extractClass_personDelegates() {
        ExtractClassExample.GoodExample.TelephoneNumber tel =
            new ExtractClassExample.GoodExample.TelephoneNumber("021", "1234567");
        ExtractClassExample.GoodExample.Person person =
            new ExtractClassExample.GoodExample.Person("Alice", tel);
        assertEquals("(021) 1234567", person.getTelephoneNumber());
    }

    @Test
    void inlineClass_formattedNumber() {
        InlineClassExample.GoodExample.Person person = new InlineClassExample.GoodExample.Person();
        person.setTelephoneAreaCode("021");
        person.setTelephoneNumber("1234567");
        assertEquals("(021) 1234567", person.getFormattedNumber());
    }

    @Test
    void hideDelegate_getManagerName() {
        HideDelegateExample.GoodExample.Manager manager = new HideDelegateExample.GoodExample.Manager("Bob");
        HideDelegateExample.GoodExample.Department dept = new HideDelegateExample.GoodExample.Department(manager);
        HideDelegateExample.GoodExample.Person person = new HideDelegateExample.GoodExample.Person(dept);
        HideDelegateExample.GoodExample good = new HideDelegateExample.GoodExample();
        assertEquals("Bob", good.getManagerName(person));
    }

    @Test
    void removeMiddleMan_directAccessToDepartment() {
        RemoveMiddleManExample.GoodExample.Department dept =
            new RemoveMiddleManExample.GoodExample.Department("Engineering", "Alice", 15);
        RemoveMiddleManExample.GoodExample.Person person = new RemoveMiddleManExample.GoodExample.Person(dept);
        assertEquals("Engineering", person.getDepartment().getName());
        assertEquals(15, person.getDepartment().getHeadCount());
    }

    @Test
    void introduceForeignMethod_scheduleNextDay() {
        IntroduceForeignMethodExample.GoodExample good = new IntroduceForeignMethodExample.GoodExample();
        String result = good.scheduleNextMeeting(2024, 0, 15); // Jan 15
        assertTrue(result.contains("16"));
    }

    @Test
    void introduceLocalExtension_nextWeek() {
        IntroduceLocalExtensionExample.GoodExample.MfDate date =
            new IntroduceLocalExtensionExample.GoodExample.MfDate(2024, 1, 10);
        IntroduceLocalExtensionExample.GoodExample.MfDate nextWeek = date.nextWeek();
        assertTrue(nextWeek.format().contains("17"));
    }

    @Test
    void allDescriptionsNonEmpty() {
        assertFalse(MoveMethodExample.getDescription().isBlank());
        assertFalse(MoveFieldExample.getDescription().isBlank());
        assertFalse(ExtractClassExample.getDescription().isBlank());
        assertFalse(InlineClassExample.getDescription().isBlank());
        assertFalse(HideDelegateExample.getDescription().isBlank());
        assertFalse(RemoveMiddleManExample.getDescription().isBlank());
        assertFalse(IntroduceForeignMethodExample.getDescription().isBlank());
        assertFalse(IntroduceLocalExtensionExample.getDescription().isBlank());
    }
}
