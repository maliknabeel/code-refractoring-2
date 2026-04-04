package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.bad.*;
import com.refactoring.examples.techniques.generalization.good.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealingWithGeneralizationTest {

    @Test
    void pullUpField_dogHasInheritedName() {
        PullUpFieldExampleGoodExample.Dog dog = new PullUpFieldExampleGoodExample.Dog("Rex", "Labrador");
        assertEquals("Rex", dog.getName());
        assertEquals("Labrador", dog.getBreed());
    }

    @Test
    void pullUpMethod_annualCostInheritedFromEmployee() {
        PullUpMethodExampleGoodExample.Salesperson salesperson = new PullUpMethodExampleGoodExample.Salesperson(60000);
        PullUpMethodExampleGoodExample.Engineer engineer = new PullUpMethodExampleGoodExample.Engineer(72000);
        assertEquals(60000, salesperson.getAnnualCost(), 0.001);
        assertEquals(72000, engineer.getAnnualCost(), 0.001);
    }

    @Test
    void pullUpConstructorBody_managersDescribe() {
        PullUpConstructorBodyExampleGoodExample.Manager manager =
            new PullUpConstructorBodyExampleGoodExample.Manager("Alice", "M001", 3);
        assertTrue(manager.describe().contains("Alice"));
        assertTrue(manager.describe().contains("M001"));
    }

    @Test
    void pushDownMethod_salespersonHasQuota() {
        PushDownMethodExampleGoodExample.Salesperson sp = new PushDownMethodExampleGoodExample.Salesperson("Bob", 5000);
        assertEquals(5000, sp.getQuota(), 0.001);
    }

    @Test
    void pushDownField_salespersonCommission() {
        PushDownFieldExampleGoodExample.Salesperson sp =
            new PushDownFieldExampleGoodExample.Salesperson("Alice", 10000, 0.1);
        assertEquals(500.0, sp.getCommission(5000), 0.001);
    }

    @Test
    void extractSubclass_laborItemUsesEmployeeRate() {
        ExtractSubclassExampleGoodExample.Employee emp = new ExtractSubclassExampleGoodExample.Employee(25);
        ExtractSubclassExampleGoodExample.LaborItem labor = new ExtractSubclassExampleGoodExample.LaborItem(8, emp);
        assertEquals(25, labor.getUnitPrice());
        assertEquals(200, labor.getTotalPrice());
    }

    @Test
    void extractSubclass_regularJobItemUsesUnitPrice() {
        ExtractSubclassExampleGoodExample.JobItem job = new ExtractSubclassExampleGoodExample.JobItem(50, 3);
        assertEquals(50, job.getUnitPrice());
        assertEquals(150, job.getTotalPrice());
    }

    @Test
    void extractSuperclass_partyAnnualCost() {
        ExtractSuperclassExampleGoodExample.Employee emp = new ExtractSuperclassExampleGoodExample.Employee("Alice", 50000);
        ExtractSuperclassExampleGoodExample.Department dept = new ExtractSuperclassExampleGoodExample.Department("Eng", 200000);
        assertEquals(50000, emp.getAnnualCost(), 0.001);
        assertEquals(200000, dept.getAnnualCost(), 0.001);
        assertEquals("Alice", emp.getName());
    }

    @Test
    void extractInterface_employeeAndContractorBothBillable() {
        ExtractInterfaceExampleGoodExample.Employee emp = new ExtractInterfaceExampleGoodExample.Employee(100, false);
        ExtractInterfaceExampleGoodExample.Contractor con = new ExtractInterfaceExampleGoodExample.Contractor(150);
        ExtractInterfaceExampleGoodExample.TimeSheet sheet = new ExtractInterfaceExampleGoodExample.TimeSheet();
        assertEquals(100 * 5, sheet.charge(emp, 5), 0.001);
        assertEquals(150 * 5 * 1.05, sheet.charge(con, 5), 0.001);
    }

    @Test
    void collapseHierarchy_employeeContainsAllData() {
        CollapseHierarchyExampleGoodExample.Employee emp = new CollapseHierarchyExampleGoodExample.Employee("John", 3);
        assertEquals("John", emp.getName());
        assertEquals(3, emp.getGrade());
    }

    @Test
    void formTemplateMethod_htmlAndTextUseSameSkeleton() {
        FormTemplateMethodExample.Customer customer = new FormTemplateMethodExample.Customer("Alice");
        FormTemplateMethodExampleGoodExample.HtmlStatement html = new FormTemplateMethodExampleGoodExample.HtmlStatement();
        FormTemplateMethodExampleGoodExample.TextStatement text = new FormTemplateMethodExampleGoodExample.TextStatement();
        assertTrue(html.value(customer).contains("Alice"));
        assertTrue(text.value(customer).contains("Alice"));
        assertTrue(html.value(customer).contains("<h1>"));
        assertFalse(text.value(customer).contains("<h1>"));
    }

    @Test
    void replaceInheritanceWithDelegation_stackOnlyExposesStackOps() {
        ReplaceInheritanceWithDelegationExampleGoodExample.MyStack<Integer> stack =
            new ReplaceInheritanceWithDelegationExampleGoodExample.MyStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void replaceDelegationWithInheritance_employeeInheritsPersonBehaviour() {
        ReplaceDelegationWithInheritanceExampleGoodExample.Employee emp =
            new ReplaceDelegationWithInheritanceExampleGoodExample.Employee("Alice", 30, 42);
        assertEquals("Alice", emp.getName());
        assertEquals(30, emp.getAge());
        assertEquals(42, emp.getEmployeeNumber());
    }

    @Test
    void allDescriptionsNonEmpty() {
        assertFalse(PullUpFieldExample.getDescription().isBlank());
        assertFalse(PullUpMethodExample.getDescription().isBlank());
        assertFalse(PushDownMethodExample.getDescription().isBlank());
        assertFalse(ExtractSubclassExample.getDescription().isBlank());
        assertFalse(ExtractInterfaceExample.getDescription().isBlank());
        assertFalse(FormTemplateMethodExample.getDescription().isBlank());
    }
}
