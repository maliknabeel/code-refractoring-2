package edu.pafiast.refractoring.techniques;

import edu.pafiast.refractoring.techniques.simplifyingconditionals.*;
import edu.pafiast.refractoring.techniques.simplifyingconditionals.bad.*;
import edu.pafiast.refractoring.techniques.simplifyingconditionals.good.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyingConditionalsTest {

    @Test
    void decomposeConditional_summerCharge() {
        DecomposeConditionalExample.Plan plan = new DecomposeConditionalExample.Plan(6, 8);
        DecomposeConditionalExampleGoodExample good = new DecomposeConditionalExampleGoodExample();
        LocalDate summer = LocalDate.of(LocalDate.now().getYear(), 7, 1);
        double charge = good.getCharge(summer, 10, plan);
        assertEquals(10 * 1.5, charge, 0.001);
    }

    @Test
    void decomposeConditional_winterCharge() {
        DecomposeConditionalExample.Plan plan = new DecomposeConditionalExample.Plan(6, 8);
        DecomposeConditionalExampleGoodExample good = new DecomposeConditionalExampleGoodExample();
        LocalDate winter = LocalDate.of(LocalDate.now().getYear(), 1, 15);
        double charge = good.getCharge(winter, 10, plan);
        assertEquals(10 * 2.0 + 10.0, charge, 0.001);
    }

    @Test
    void consolidateConditional_ineligibleEmployee_returnsZero() {
        ConsolidateConditionalExample.Employee emp = new ConsolidateConditionalExample.Employee(1, 5, false, 3000);
        assertEquals(0, new ConsolidateConditionalExampleGoodExample().disabilityAmount(emp), 0.001);
    }

    @Test
    void consolidateConditional_eligibleEmployee_getsDisability() {
        ConsolidateConditionalExample.Employee emp = new ConsolidateConditionalExample.Employee(5, 5, false, 3000);
        assertEquals(3000 * 0.6, new ConsolidateConditionalExampleGoodExample().disabilityAmount(emp), 0.001);
    }

    @Test
    void consolidateDuplicateFragments_sendCalledOnce() {
        ConsolidateDuplicateFragmentsExampleGoodExample good = new ConsolidateDuplicateFragmentsExampleGoodExample();
        good.getPrice(true);
        assertEquals(1, good.getSendCount());
    }

    @Test
    void consolidateDuplicateFragments_specialDealPrice() {
        ConsolidateDuplicateFragmentsExampleGoodExample good = new ConsolidateDuplicateFragmentsExampleGoodExample();
        assertEquals(95.0, good.getPrice(true), 0.001);
    }

    @Test
    void removeControlFlag_alertSent() {
        RemoveControlFlagExampleGoodExample good = new RemoveControlFlagExampleGoodExample();
        assertTrue(good.checkSecurity(new String[]{"Alice", "Don", "Bob"}));
    }

    @Test
    void removeControlFlag_noAlert() {
        RemoveControlFlagExampleGoodExample good = new RemoveControlFlagExampleGoodExample();
        assertFalse(good.checkSecurity(new String[]{"Alice", "Bob"}));
    }

    @Test
    void replaceNestedConditional_guardClauses() {
        ReplaceNestedConditionalExampleGoodExample good = new ReplaceNestedConditionalExampleGoodExample();
        assertEquals(0,    good.getPayAmount(new ReplaceNestedConditionalExample.Employee(true,  false, false)));
        assertEquals(500,  good.getPayAmount(new ReplaceNestedConditionalExample.Employee(false, true,  false)));
        assertEquals(1000, good.getPayAmount(new ReplaceNestedConditionalExample.Employee(false, false, true)));
        assertEquals(3000, good.getPayAmount(new ReplaceNestedConditionalExample.Employee(false, false, false)));
    }

    @Test
    void replaceConditionalWithPolymorphism_birdSpeeds() {
        assertEquals(40.0, new ReplaceConditionalWithPolymorphismExampleGoodExample.EuropeanBird().getSpeed(), 0.001);
        assertEquals(0.0, new ReplaceConditionalWithPolymorphismExampleGoodExample.NorwegianBlueBird(true).getSpeed(), 0.001);
        assertEquals(40.0, new ReplaceConditionalWithPolymorphismExampleGoodExample.NorwegianBlueBird(false).getSpeed(), 0.001);
    }

    @Test
    void introduceNullObject_nullCustomerReturnsDefaults() {
        IntroduceNullObjectExampleGoodExample good = new IntroduceNullObjectExampleGoodExample();
        IntroduceNullObjectExample.Customer nullCustomer = IntroduceNullObjectExampleGoodExample.getCustomer(false);
        assertEquals("occupant", good.getCustomerName(nullCustomer));
        assertEquals("BASIC", good.getCustomerPlan(nullCustomer));
    }

    @Test
    void introduceNullObject_realCustomerReturnsData() {
        IntroduceNullObjectExampleGoodExample good = new IntroduceNullObjectExampleGoodExample();
        IntroduceNullObjectExample.Customer realCustomer = IntroduceNullObjectExampleGoodExample.getCustomer(true);
        assertEquals("John", good.getCustomerName(realCustomer));
        assertEquals("PREMIUM", good.getCustomerPlan(realCustomer));
    }

    @Test
    void introduceAssertion_validState_returnsLimit() {
        IntroduceAssertionExampleGoodExample.Project project = new IntroduceAssertionExampleGoodExample.Project();
        IntroduceAssertionExampleGoodExample good = new IntroduceAssertionExampleGoodExample(500.0, project);
        assertEquals(500.0, good.getExpenseLimit(), 0.001);
    }

    @Test
    void introduceAssertion_bothNull_throwsAssertion() {
        IntroduceAssertionExampleGoodExample good = new IntroduceAssertionExampleGoodExample(-1.0, null);
        assertThrows(AssertionError.class, good::getExpenseLimit);
    }
}
