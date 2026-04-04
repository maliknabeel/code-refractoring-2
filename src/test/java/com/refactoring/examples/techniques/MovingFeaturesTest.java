package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.bad.*;
import com.refactoring.examples.techniques.movingfeatures.good.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingFeaturesTest {

    @Test
    void moveMethod_premiumAccount_chargesCorrectly() {
        MoveMethodExampleGoodExample.AccountType premium = new MoveMethodExampleGoodExample.AccountType(true);
        MoveMethodExampleGoodExample.Account account = new MoveMethodExampleGoodExample.Account(premium, 10);
        assertEquals(10 + (10 - 7) * 0.85, account.overdraftCharge(), 0.001);
    }

    @Test
    void moveMethod_standardAccount_chargesPerDay() {
        MoveMethodExampleGoodExample.AccountType standard = new MoveMethodExampleGoodExample.AccountType(false);
        MoveMethodExampleGoodExample.Account account = new MoveMethodExampleGoodExample.Account(standard, 5);
        assertEquals(5 * 1.75, account.overdraftCharge(), 0.001);
    }

    @Test
    void moveField_interestCalculation() {
        MoveFieldExampleGoodExample.AccountType type = new MoveFieldExampleGoodExample.AccountType("Savings", 0.05);
        MoveFieldExampleGoodExample.Account account = new MoveFieldExampleGoodExample.Account(type);
        assertEquals(0.05 * 1000 * 30 / 365.0, account.interestForAmount(1000, 30), 0.001);
    }

    @Test
    void extractClass_telephoneFormat() {
        ExtractClassExampleGoodExample.TelephoneNumber tel =
            new ExtractClassExampleGoodExample.TelephoneNumber("021", "1234567");
        assertEquals("(021) 1234567", tel.getTelephoneNumber());
    }

    @Test
    void extractClass_personDelegates() {
        ExtractClassExampleGoodExample.TelephoneNumber tel =
            new ExtractClassExampleGoodExample.TelephoneNumber("021", "1234567");
        ExtractClassExampleGoodExample.Person person =
            new ExtractClassExampleGoodExample.Person("Alice", tel);
        assertEquals("(021) 1234567", person.getTelephoneNumber());
    }

    @Test
    void inlineClass_formattedNumber() {
        InlineClassExampleGoodExample.Person person = new InlineClassExampleGoodExample.Person();
        person.setTelephoneAreaCode("021");
        person.setTelephoneNumber("1234567");
        assertEquals("(021) 1234567", person.getFormattedNumber());
    }

    @Test
    void hideDelegate_getManagerName() {
        HideDelegateExampleGoodExample.Manager manager = new HideDelegateExampleGoodExample.Manager("Bob");
        HideDelegateExampleGoodExample.Department dept = new HideDelegateExampleGoodExample.Department(manager);
        HideDelegateExampleGoodExample.Person person = new HideDelegateExampleGoodExample.Person(dept);
        HideDelegateExampleGoodExample good = new HideDelegateExampleGoodExample();
        assertEquals("Bob", good.getManagerName(person));
    }

    @Test
    void removeMiddleMan_directAccessToDepartment() {
        RemoveMiddleManExampleGoodExample.Department dept =
            new RemoveMiddleManExampleGoodExample.Department("Engineering", "Alice", 15);
        RemoveMiddleManExampleGoodExample.Person person = new RemoveMiddleManExampleGoodExample.Person(dept);
        assertEquals("Engineering", person.getDepartment().getName());
        assertEquals(15, person.getDepartment().getHeadCount());
    }

    @Test
    void introduceForeignMethod_scheduleNextDay() {
        IntroduceForeignMethodExampleGoodExample good = new IntroduceForeignMethodExampleGoodExample();
        String result = good.scheduleNextMeeting(2024, 0, 15); // Jan 15
        assertTrue(result.contains("16"));
    }

    @Test
    void introduceLocalExtension_nextWeek() {
        IntroduceLocalExtensionExampleGoodExample.MfDate date =
            new IntroduceLocalExtensionExampleGoodExample.MfDate(2024, 1, 10);
        IntroduceLocalExtensionExampleGoodExample.MfDate nextWeek = date.nextWeek();
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
