package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.bad.*;
import com.refactoring.examples.techniques.organizingdata.good.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizingDataTest {

    @Test
    void selfEncapsulateField_rangeIncludes() {
        SelfEncapsulateFieldExampleGoodExample.Range range = new SelfEncapsulateFieldExampleGoodExample.Range(1, 10);
        assertTrue(range.includes(5));
        assertFalse(range.includes(15));
    }

    @Test
    void selfEncapsulateField_cappedRangeOverridesHigh() {
        SelfEncapsulateFieldExampleGoodExample.CappedRange capped =
            new SelfEncapsulateFieldExampleGoodExample.CappedRange(1, 100, 50);
        assertFalse(capped.includes(75)); // 75 > cap(50)
        assertTrue(capped.includes(25));
    }

    @Test
    void replaceDataValueWithObject_phoneNumberFormat() {
        ReplaceDataValueWithObjectExampleGoodExample.PhoneNumber phone =
            new ReplaceDataValueWithObjectExampleGoodExample.PhoneNumber("0211234567");
        assertEquals("021", phone.getAreaCode());
        assertEquals("(021) 123-4567", phone.format());
    }

    @Test
    void replaceDataValueWithObject_invalidPhone_throws() {
        assertThrows(IllegalArgumentException.class,
            () -> new ReplaceDataValueWithObjectExampleGoodExample.PhoneNumber("abc"));
    }

    @Test
    void replaceArrayWithObject_summarise() {
        ReplaceArrayWithObjectExampleGoodExample.Performance p =
            new ReplaceArrayWithObjectExampleGoodExample.Performance("Liverpool", 15, 3);
        ReplaceArrayWithObjectExampleGoodExample good = new ReplaceArrayWithObjectExampleGoodExample();
        String summary = good.summarise(p);
        assertTrue(summary.contains("Liverpool"));
        assertTrue(summary.contains("15W"));
        assertEquals(18, p.getPlayed());
    }

    @Test
    void replaceMagicNumber_potentialEnergy() {
        ReplaceMagicNumberExampleGoodExample good = new ReplaceMagicNumberExampleGoodExample();
        assertEquals(9.81 * 10 * 5, good.potentialEnergy(10, 5), 0.001);
    }

    @Test
    void replaceMagicNumber_isAdult() {
        ReplaceMagicNumberExampleGoodExample good = new ReplaceMagicNumberExampleGoodExample();
        assertTrue(good.isAdult(18));
        assertFalse(good.isAdult(17));
    }

    @Test
    void encapsulateField_validAge() {
        EncapsulateFieldExampleGoodExample.Person p = new EncapsulateFieldExampleGoodExample.Person();
        p.setAge(25);
        assertEquals(25, p.getAge());
    }

    @Test
    void encapsulateField_invalidAge_throws() {
        EncapsulateFieldExampleGoodExample.Person p = new EncapsulateFieldExampleGoodExample.Person();
        assertThrows(IllegalArgumentException.class, () -> p.setAge(-1));
    }

    @Test
    void encapsulateCollection_addAndView() {
        EncapsulateCollectionExampleGoodExample.Person person = new EncapsulateCollectionExampleGoodExample.Person();
        EncapsulateCollectionExample.Course java = new EncapsulateCollectionExample.Course("Java");
        person.addCourse(java);
        assertEquals(1, person.getCourseCount());
    }

    @Test
    void encapsulateCollection_unmodifiableView_throws() {
        EncapsulateCollectionExampleGoodExample.Person person = new EncapsulateCollectionExampleGoodExample.Person();
        assertThrows(UnsupportedOperationException.class,
            () -> person.getCourses().add(new EncapsulateCollectionExample.Course("x")));
    }

    @Test
    void replaceTypeCodeWithClass_bloodGroupLabel() {
        ReplaceTypeCodeWithClassExampleGoodExample.Person person = new ReplaceTypeCodeWithClassExampleGoodExample.Person();
        person.setBloodGroup(ReplaceTypeCodeWithClassExampleGoodExample.BloodGroup.AB);
        assertEquals("AB", person.getBloodGroup().getLabel());
    }

    @Test
    void replaceTypeCodeWithSubclasses_payAmount() {
        assertEquals(5000, new ReplaceTypeCodeWithSubclassesExampleGoodExample.Engineer(5000).payAmount());
        assertEquals(7000, new ReplaceTypeCodeWithSubclassesExampleGoodExample.Salesperson(5000, 2000).payAmount());
        assertEquals(7000, new ReplaceTypeCodeWithSubclassesExampleGoodExample.Manager(5000, 2000).payAmount());
    }

    @Test
    void replaceTypeCodeWithStateStrategy_promote() {
        ReplaceTypeCodeWithStateStrategyExampleGoodExample.Employee emp =
            new ReplaceTypeCodeWithStateStrategyExampleGoodExample.Employee(
                new ReplaceTypeCodeWithStateStrategyExampleGoodExample.EngineerType(), 5000, 1000);
        assertEquals("Engineer", emp.getTypeName());
        emp.promote();
        assertEquals("Manager", emp.getTypeName());
    }

    @Test
    void replaceSubclassWithFields_genderFactory() {
        ReplaceSubclassWithFieldsExampleGoodExample.Person male = ReplaceSubclassWithFieldsExampleGoodExample.Person.createMale();
        ReplaceSubclassWithFieldsExampleGoodExample.Person female = ReplaceSubclassWithFieldsExampleGoodExample.Person.createFemale();
        assertTrue(male.isMale());
        assertFalse(female.isMale());
        assertEquals('M', male.getCode());
        assertEquals('F', female.getCode());
    }

    @Test
    void allDescriptionsNonEmpty() {
        assertFalse(SelfEncapsulateFieldExample.getDescription().isBlank());
        assertFalse(ReplaceDataValueWithObjectExample.getDescription().isBlank());
        assertFalse(ReplaceArrayWithObjectExample.getDescription().isBlank());
        assertFalse(ReplaceMagicNumberExample.getDescription().isBlank());
    }
}
