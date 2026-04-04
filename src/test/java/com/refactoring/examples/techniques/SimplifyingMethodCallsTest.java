package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.bad.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.good.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyingMethodCallsTest {

    @Test
    void renameMethod_telephoneNumberFormat() {
        RenameMethodExampleGoodExample good = new RenameMethodExampleGoodExample();
        assertEquals("021-1234567", good.getTelephoneNumber());
    }

    @Test
    void addParameter_formatDateWithSeparator() {
        AddParameterExampleGoodExample good = new AddParameterExampleGoodExample();
        assertEquals("15-6-2024", good.formatDate(15, 6, 2024, "-"));
        assertEquals("15/6/2024", good.formatDate(15, 6, 2024, "/"));
    }

    @Test
    void removeParameter_calculateDiscount_quantity100() {
        RemoveParameterExampleGoodExample good = new RemoveParameterExampleGoodExample();
        assertEquals(90.0, good.calculateDiscount(100, 101), 0.001);
    }

    @Test
    void separateQueryFromModifier_queryHasNoSideEffect() {
        SeparateQueryFromModifierExampleGoodExample good = new SeparateQueryFromModifierExampleGoodExample();
        double balance = good.getBalance();
        assertEquals(0, good.isBillSent() ? 1 : 0); // query should not have sent bill
    }

    @Test
    void parameterizeMethod_raiseBy10Percent() {
        ParameterizeMethodExampleGoodExample good = new ParameterizeMethodExampleGoodExample();
        good.raise(10);
        assertEquals(55000, good.getSalary(), 0.001);
    }

    @Test
    void replaceParameterWithExplicitMethods_setHeight() {
        ReplaceParameterWithExplicitMethodsExampleGoodExample good = new ReplaceParameterWithExplicitMethodsExampleGoodExample();
        good.setHeight(180);
        good.setWidth(90);
        assertEquals(180, good.getHeight());
        assertEquals(90, good.getWidth());
    }

    @Test
    void replaceParameterWithExplicitMethods_badExample_unknownType_throws() {
        ReplaceParameterWithExplicitMethodsExampleBadExample bad = new ReplaceParameterWithExplicitMethodsExampleBadExample();
        assertThrows(IllegalArgumentException.class, () -> bad.setValue("depth", 10));
    }

    @Test
    void preserveWholeObject_withinRange() {
        PreserveWholeObjectExampleGoodExample.HeatingPlan plan = new PreserveWholeObjectExampleGoodExample.HeatingPlan(10, 30);
        PreserveWholeObjectExample.Room room = new PreserveWholeObjectExample.Room(15, 25);
        PreserveWholeObjectExampleGoodExample good = new PreserveWholeObjectExampleGoodExample();
        assertTrue(good.checkRange(room, plan));
    }

    @Test
    void replaceParameterWithMethodCall_priceCalculation() {
        ReplaceParameterWithMethodCallExampleBadExample bad = new ReplaceParameterWithMethodCallExampleBadExample();
        ReplaceParameterWithMethodCallExampleGoodExample good = new ReplaceParameterWithMethodCallExampleGoodExample();
        assertEquals(bad.getPrice(), good.getPrice());
    }

    @Test
    void introduceParameterObject_totalCalculation() {
        IntroduceParameterObjectExampleGoodExample.Customer customer =
            new IntroduceParameterObjectExampleGoodExample.Customer("Alice", "a@b.com", "123 St");
        IntroduceParameterObjectExampleGoodExample.OrderDetails order =
            new IntroduceParameterObjectExampleGoodExample.OrderDetails(100, 5, 10);
        IntroduceParameterObjectExampleGoodExample good = new IntroduceParameterObjectExampleGoodExample();
        assertEquals(550.0, good.calculateTotal(customer, order), 0.001); // 500 + 50 tax
    }

    @Test
    void removeSettingMethod_customerIdImmutable() {
        RemoveSettingMethodExampleGoodExample.Customer customer = new RemoveSettingMethodExampleGoodExample.Customer("CUST-001");
        assertEquals("CUST-001", customer.getCustomerId());
        // No setCustomerId() method exists — confirmed by compile-time constraint
    }

    @Test
    void replaceConstructorWithFactoryMethod_engineerCreation() {
        ReplaceConstructorWithFactoryMethodExampleGoodExample.Employee engineer =
            ReplaceConstructorWithFactoryMethodExampleGoodExample.Employee.createEngineer();
        assertEquals("Engineer", engineer.getTypeName());
    }

    @Test
    void replaceErrorCodeWithException_insufficientFunds_throws() {
        ReplaceErrorCodeWithExceptionExampleGoodExample account =
            new ReplaceErrorCodeWithExceptionExampleGoodExample(100.0);
        assertThrows(ReplaceErrorCodeWithExceptionExampleGoodExample.InsufficientFundsException.class,
            () -> account.withdraw(200.0));
    }

    @Test
    void replaceErrorCodeWithException_sufficientFunds_succeeds() throws Exception {
        ReplaceErrorCodeWithExceptionExampleGoodExample account =
            new ReplaceErrorCodeWithExceptionExampleGoodExample(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    void replaceExceptionWithTest_outOfBounds_returnsZero() {
        ReplaceExceptionWithTestExampleGoodExample good = new ReplaceExceptionWithTestExampleGoodExample();
        assertEquals(0, good.getValueForPeriod(10), 0.001);
    }

    @Test
    void replaceExceptionWithTest_inBounds_returnsValue() {
        ReplaceExceptionWithTestExampleGoodExample good = new ReplaceExceptionWithTestExampleGoodExample();
        assertEquals(20.0, good.getValueForPeriod(1), 0.001);
    }
}
