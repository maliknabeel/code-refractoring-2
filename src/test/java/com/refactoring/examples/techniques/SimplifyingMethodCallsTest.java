package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyingMethodCallsTest {

    @Test
    void renameMethod_telephoneNumberFormat() {
        RenameMethodExample.GoodExample good = new RenameMethodExample.GoodExample();
        assertEquals("021-1234567", good.getTelephoneNumber());
    }

    @Test
    void addParameter_formatDateWithSeparator() {
        AddParameterExample.GoodExample good = new AddParameterExample.GoodExample();
        assertEquals("15-6-2024", good.formatDate(15, 6, 2024, "-"));
        assertEquals("15/6/2024", good.formatDate(15, 6, 2024, "/"));
    }

    @Test
    void removeParameter_calculateDiscount_quantity100() {
        RemoveParameterExample.GoodExample good = new RemoveParameterExample.GoodExample();
        assertEquals(90.0, good.calculateDiscount(100, 101), 0.001);
    }

    @Test
    void separateQueryFromModifier_queryHasNoSideEffect() {
        SeparateQueryFromModifierExample.GoodExample good = new SeparateQueryFromModifierExample.GoodExample();
        double balance = good.getBalance();
        assertEquals(0, good.isBillSent() ? 1 : 0); // query should not have sent bill
    }

    @Test
    void parameterizeMethod_raiseBy10Percent() {
        ParameterizeMethodExample.GoodExample good = new ParameterizeMethodExample.GoodExample();
        good.raise(10);
        assertEquals(55000, good.getSalary(), 0.001);
    }

    @Test
    void replaceParameterWithExplicitMethods_setHeight() {
        ReplaceParameterWithExplicitMethodsExample.GoodExample good = new ReplaceParameterWithExplicitMethodsExample.GoodExample();
        good.setHeight(180);
        good.setWidth(90);
        assertEquals(180, good.getHeight());
        assertEquals(90, good.getWidth());
    }

    @Test
    void replaceParameterWithExplicitMethods_badExample_unknownType_throws() {
        ReplaceParameterWithExplicitMethodsExample.BadExample bad = new ReplaceParameterWithExplicitMethodsExample.BadExample();
        assertThrows(IllegalArgumentException.class, () -> bad.setValue("depth", 10));
    }

    @Test
    void preserveWholeObject_withinRange() {
        PreserveWholeObjectExample.GoodExample.HeatingPlan plan = new PreserveWholeObjectExample.GoodExample.HeatingPlan(10, 30);
        PreserveWholeObjectExample.Room room = new PreserveWholeObjectExample.Room(15, 25);
        PreserveWholeObjectExample.GoodExample good = new PreserveWholeObjectExample.GoodExample();
        assertTrue(good.checkRange(room, plan));
    }

    @Test
    void replaceParameterWithMethodCall_priceCalculation() {
        ReplaceParameterWithMethodCallExample.BadExample bad = new ReplaceParameterWithMethodCallExample.BadExample();
        ReplaceParameterWithMethodCallExample.GoodExample good = new ReplaceParameterWithMethodCallExample.GoodExample();
        assertEquals(bad.getPrice(), good.getPrice());
    }

    @Test
    void introduceParameterObject_totalCalculation() {
        IntroduceParameterObjectExample.GoodExample.Customer customer =
            new IntroduceParameterObjectExample.GoodExample.Customer("Alice", "a@b.com", "123 St");
        IntroduceParameterObjectExample.GoodExample.OrderDetails order =
            new IntroduceParameterObjectExample.GoodExample.OrderDetails(100, 5, 10);
        IntroduceParameterObjectExample.GoodExample good = new IntroduceParameterObjectExample.GoodExample();
        assertEquals(550.0, good.calculateTotal(customer, order), 0.001); // 500 + 50 tax
    }

    @Test
    void removeSettingMethod_customerIdImmutable() {
        RemoveSettingMethodExample.GoodExample.Customer customer = new RemoveSettingMethodExample.GoodExample.Customer("CUST-001");
        assertEquals("CUST-001", customer.getCustomerId());
        // No setCustomerId() method exists — confirmed by compile-time constraint
    }

    @Test
    void replaceConstructorWithFactoryMethod_engineerCreation() {
        ReplaceConstructorWithFactoryMethodExample.GoodExample.Employee engineer =
            ReplaceConstructorWithFactoryMethodExample.GoodExample.Employee.createEngineer();
        assertEquals("Engineer", engineer.getTypeName());
    }

    @Test
    void replaceErrorCodeWithException_insufficientFunds_throws() {
        ReplaceErrorCodeWithExceptionExample.GoodExample account =
            new ReplaceErrorCodeWithExceptionExample.GoodExample(100.0);
        assertThrows(ReplaceErrorCodeWithExceptionExample.GoodExample.InsufficientFundsException.class,
            () -> account.withdraw(200.0));
    }

    @Test
    void replaceErrorCodeWithException_sufficientFunds_succeeds() throws Exception {
        ReplaceErrorCodeWithExceptionExample.GoodExample account =
            new ReplaceErrorCodeWithExceptionExample.GoodExample(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    void replaceExceptionWithTest_outOfBounds_returnsZero() {
        ReplaceExceptionWithTestExample.GoodExample good = new ReplaceExceptionWithTestExample.GoodExample();
        assertEquals(0, good.getValueForPeriod(10), 0.001);
    }

    @Test
    void replaceExceptionWithTest_inBounds_returnsValue() {
        ReplaceExceptionWithTestExample.GoodExample good = new ReplaceExceptionWithTestExample.GoodExample();
        assertEquals(20.0, good.getValueForPeriod(1), 0.001);
    }
}
