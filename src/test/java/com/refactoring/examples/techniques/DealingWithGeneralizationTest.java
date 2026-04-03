package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.generalization.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealingWithGeneralizationTest {

    @Test
    void pullUpField_dogHasInheritedName() {
        PullUpFieldExample.GoodExample.Dog dog = new PullUpFieldExample.GoodExample.Dog("Rex", "Labrador");
        assertEquals("Rex", dog.getName());
        assertEquals("Labrador", dog.getBreed());
    }

    @Test
    void pullUpMethod_annualCostInheritedFromEmployee() {
        PullUpMethodExample.GoodExample.Salesperson salesperson = new PullUpMethodExample.GoodExample.Salesperson(60000);
        PullUpMethodExample.GoodExample.Engineer engineer = new PullUpMethodExample.GoodExample.Engineer(72000);
        assertEquals(60000, salesperson.getAnnualCost(), 0.001);
        assertEquals(72000, engineer.getAnnualCost(), 0.001);
    }

    @Test
    void pullUpConstructorBody_managersDescribe() {
        PullUpConstructorBodyExample.GoodExample.Manager manager =
            new PullUpConstructorBodyExample.GoodExample.Manager("Alice", "M001", 3);
        assertTrue(manager.describe().contains("Alice"));
        assertTrue(manager.describe().contains("M001"));
    }

    @Test
    void pushDownMethod_salespersonHasQuota() {
        PushDownMethodExample.GoodExample.Salesperson sp = new PushDownMethodExample.GoodExample.Salesperson("Bob", 5000);
        assertEquals(5000, sp.getQuota(), 0.001);
    }

    @Test
    void pushDownField_salespersonCommission() {
        PushDownFieldExample.GoodExample.Salesperson sp =
            new PushDownFieldExample.GoodExample.Salesperson("Alice", 10000, 0.1);
        assertEquals(500.0, sp.getCommission(5000), 0.001);
    }

    @Test
    void extractSubclass_laborItemUsesEmployeeRate() {
        ExtractSubclassExample.GoodExample.Employee emp = new ExtractSubclassExample.GoodExample.Employee(25);
        ExtractSubclassExample.GoodExample.LaborItem labor = new ExtractSubclassExample.GoodExample.LaborItem(8, emp);
        assertEquals(25, labor.getUnitPrice());
        assertEquals(200, labor.getTotalPrice());
    }

    @Test
    void extractSubclass_regularJobItemUsesUnitPrice() {
        ExtractSubclassExample.GoodExample.JobItem job = new ExtractSubclassExample.GoodExample.JobItem(50, 3);
        assertEquals(50, job.getUnitPrice());
        assertEquals(150, job.getTotalPrice());
    }

    @Test
    void extractSuperclass_partyAnnualCost() {
        ExtractSuperclassExample.GoodExample.Employee emp = new ExtractSuperclassExample.GoodExample.Employee("Alice", 50000);
        ExtractSuperclassExample.GoodExample.Department dept = new ExtractSuperclassExample.GoodExample.Department("Eng", 200000);
        assertEquals(50000, emp.getAnnualCost(), 0.001);
        assertEquals(200000, dept.getAnnualCost(), 0.001);
        assertEquals("Alice", emp.getName());
    }

    @Test
    void extractInterface_employeeAndContractorBothBillable() {
        ExtractInterfaceExample.GoodExample.Employee emp = new ExtractInterfaceExample.GoodExample.Employee(100, false);
        ExtractInterfaceExample.GoodExample.Contractor con = new ExtractInterfaceExample.GoodExample.Contractor(150);
        ExtractInterfaceExample.GoodExample.TimeSheet sheet = new ExtractInterfaceExample.GoodExample.TimeSheet();
        assertEquals(100 * 5, sheet.charge(emp, 5), 0.001);
        assertEquals(150 * 5 * 1.05, sheet.charge(con, 5), 0.001);
    }

    @Test
    void collapseHierarchy_employeeContainsAllData() {
        CollapseHierarchyExample.GoodExample.Employee emp = new CollapseHierarchyExample.GoodExample.Employee("John", 3);
        assertEquals("John", emp.getName());
        assertEquals(3, emp.getGrade());
    }

    @Test
    void formTemplateMethod_htmlAndTextUseSameSkeleton() {
        FormTemplateMethodExample.Customer customer = new FormTemplateMethodExample.Customer("Alice");
        FormTemplateMethodExample.GoodExample.HtmlStatement html = new FormTemplateMethodExample.GoodExample.HtmlStatement();
        FormTemplateMethodExample.GoodExample.TextStatement text = new FormTemplateMethodExample.GoodExample.TextStatement();
        assertTrue(html.value(customer).contains("Alice"));
        assertTrue(text.value(customer).contains("Alice"));
        assertTrue(html.value(customer).contains("<h1>"));
        assertFalse(text.value(customer).contains("<h1>"));
    }

    @Test
    void replaceInheritanceWithDelegation_stackOnlyExposesStackOps() {
        ReplaceInheritanceWithDelegationExample.GoodExample.MyStack<Integer> stack =
            new ReplaceInheritanceWithDelegationExample.GoodExample.MyStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void replaceDelegationWithInheritance_employeeInheritsPersonBehaviour() {
        ReplaceDelegationWithInheritanceExample.GoodExample.Employee emp =
            new ReplaceDelegationWithInheritanceExample.GoodExample.Employee("Alice", 30, 42);
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
