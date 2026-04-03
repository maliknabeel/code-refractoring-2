package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyingConditionalsTest {

    @Test
    void decomposeConditional_summerCharge() {
        DecomposeConditionalExample.Plan plan = new DecomposeConditionalExample.Plan(6, 8);
        DecomposeConditionalExample.GoodExample good = new DecomposeConditionalExample.GoodExample();
        LocalDate summer = LocalDate.of(LocalDate.now().getYear(), 7, 1);
        double charge = good.getCharge(summer, 10, plan);
        assertEquals(10 * 1.5, charge, 0.001);
    }

    @Test
    void decomposeConditional_winterCharge() {
        DecomposeConditionalExample.Plan plan = new DecomposeConditionalExample.Plan(6, 8);
        DecomposeConditionalExample.GoodExample good = new DecomposeConditionalExample.GoodExample();
        LocalDate winter = LocalDate.of(LocalDate.now().getYear(), 1, 15);
        double charge = good.getCharge(winter, 10, plan);
        assertEquals(10 * 2.0 + 10.0, charge, 0.001);
    }

    @Test
    void consolidateConditional_ineligibleEmployee_returnsZero() {
        ConsolidateConditionalExample.Employee emp = new ConsolidateConditionalExample.Employee(1, 5, false, 3000);
        assertEquals(0, new ConsolidateConditionalExample.GoodExample().disabilityAmount(emp), 0.001);
    }

    @Test
    void consolidateConditional_eligibleEmployee_getsDisability() {
        ConsolidateConditionalExample.Employee emp = new ConsolidateConditionalExample.Employee(5, 5, false, 3000);
        assertEquals(3000 * 0.6, new ConsolidateConditionalExample.GoodExample().disabilityAmount(emp), 0.001);
    }

    @Test
    void consolidateDuplicateFragments_sendCalledOnce() {
        ConsolidateDuplicateFragmentsExample.GoodExample good = new ConsolidateDuplicateFragmentsExample.GoodExample();
        good.getPrice(true);
        assertEquals(1, good.getSendCount());
    }

    @Test
    void consolidateDuplicateFragments_specialDealPrice() {
        ConsolidateDuplicateFragmentsExample.GoodExample good = new ConsolidateDuplicateFragmentsExample.GoodExample();
        assertEquals(95.0, good.getPrice(true), 0.001);
    }

    @Test
    void removeControlFlag_alertSent() {
        RemoveControlFlagExample.GoodExample good = new RemoveControlFlagExample.GoodExample();
        assertTrue(good.checkSecurity(new String[]{"Alice", "Don", "Bob"}));
    }

    @Test
    void removeControlFlag_noAlert() {
        RemoveControlFlagExample.GoodExample good = new RemoveControlFlagExample.GoodExample();
        assertFalse(good.checkSecurity(new String[]{"Alice", "Bob"}));
    }

    @Test
    void replaceNestedConditional_guardClauses() {
        ReplaceNestedConditionalExample.GoodExample good = new ReplaceNestedConditionalExample.GoodExample();
        assertEquals(0,    good.getPayAmount(new ReplaceNestedConditionalExample.Employee(true,  false, false)));
        assertEquals(500,  good.getPayAmount(new ReplaceNestedConditionalExample.Employee(false, true,  false)));
        assertEquals(1000, good.getPayAmount(new ReplaceNestedConditionalExample.Employee(false, false, true)));
        assertEquals(3000, good.getPayAmount(new ReplaceNestedConditionalExample.Employee(false, false, false)));
    }

    @Test
    void replaceConditionalWithPolymorphism_birdSpeeds() {
        assertEquals(40.0, new ReplaceConditionalWithPolymorphismExample.GoodExample.EuropeanBird().getSpeed(), 0.001);
        assertEquals(0.0, new ReplaceConditionalWithPolymorphismExample.GoodExample.NorwegianBlueBird(true).getSpeed(), 0.001);
        assertEquals(40.0, new ReplaceConditionalWithPolymorphismExample.GoodExample.NorwegianBlueBird(false).getSpeed(), 0.001);
    }

    @Test
    void introduceNullObject_nullCustomerReturnsDefaults() {
        IntroduceNullObjectExample.GoodExample good = new IntroduceNullObjectExample.GoodExample();
        IntroduceNullObjectExample.Customer nullCustomer = IntroduceNullObjectExample.GoodExample.getCustomer(false);
        assertEquals("occupant", good.getCustomerName(nullCustomer));
        assertEquals("BASIC", good.getCustomerPlan(nullCustomer));
    }

    @Test
    void introduceNullObject_realCustomerReturnsData() {
        IntroduceNullObjectExample.GoodExample good = new IntroduceNullObjectExample.GoodExample();
        IntroduceNullObjectExample.Customer realCustomer = IntroduceNullObjectExample.GoodExample.getCustomer(true);
        assertEquals("John", good.getCustomerName(realCustomer));
        assertEquals("PREMIUM", good.getCustomerPlan(realCustomer));
    }

    @Test
    void introduceAssertion_validState_returnsLimit() {
        IntroduceAssertionExample.GoodExample.Project project = new IntroduceAssertionExample.GoodExample.Project();
        IntroduceAssertionExample.GoodExample good = new IntroduceAssertionExample.GoodExample(500.0, project);
        assertEquals(500.0, good.getExpenseLimit(), 0.001);
    }

    @Test
    void introduceAssertion_bothNull_throwsAssertion() {
        IntroduceAssertionExample.GoodExample good = new IntroduceAssertionExample.GoodExample(-1.0, null);
        assertThrows(AssertionError.class, good::getExpenseLimit);
    }
}
