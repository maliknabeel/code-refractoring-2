package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.organizingdata.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizingDataTest {

    @Test
    void selfEncapsulateField_rangeIncludes() {
        SelfEncapsulateFieldExample.GoodExample.Range range = new SelfEncapsulateFieldExample.GoodExample.Range(1, 10);
        assertTrue(range.includes(5));
        assertFalse(range.includes(15));
    }

    @Test
    void selfEncapsulateField_cappedRangeOverridesHigh() {
        SelfEncapsulateFieldExample.GoodExample.CappedRange capped =
            new SelfEncapsulateFieldExample.GoodExample.CappedRange(1, 100, 50);
        assertFalse(capped.includes(75)); // 75 > cap(50)
        assertTrue(capped.includes(25));
    }

    @Test
    void replaceDataValueWithObject_phoneNumberFormat() {
        ReplaceDataValueWithObjectExample.GoodExample.PhoneNumber phone =
            new ReplaceDataValueWithObjectExample.GoodExample.PhoneNumber("0211234567");
        assertEquals("021", phone.getAreaCode());
        assertEquals("(021) 123-4567", phone.format());
    }

    @Test
    void replaceDataValueWithObject_invalidPhone_throws() {
        assertThrows(IllegalArgumentException.class,
            () -> new ReplaceDataValueWithObjectExample.GoodExample.PhoneNumber("abc"));
    }

    @Test
    void replaceArrayWithObject_summarise() {
        ReplaceArrayWithObjectExample.GoodExample.Performance p =
            new ReplaceArrayWithObjectExample.GoodExample.Performance("Liverpool", 15, 3);
        ReplaceArrayWithObjectExample.GoodExample good = new ReplaceArrayWithObjectExample.GoodExample();
        String summary = good.summarise(p);
        assertTrue(summary.contains("Liverpool"));
        assertTrue(summary.contains("15W"));
        assertEquals(18, p.getPlayed());
    }

    @Test
    void replaceMagicNumber_potentialEnergy() {
        ReplaceMagicNumberExample.GoodExample good = new ReplaceMagicNumberExample.GoodExample();
        assertEquals(9.81 * 10 * 5, good.potentialEnergy(10, 5), 0.001);
    }

    @Test
    void replaceMagicNumber_isAdult() {
        ReplaceMagicNumberExample.GoodExample good = new ReplaceMagicNumberExample.GoodExample();
        assertTrue(good.isAdult(18));
        assertFalse(good.isAdult(17));
    }

    @Test
    void encapsulateField_validAge() {
        EncapsulateFieldExample.GoodExample.Person p = new EncapsulateFieldExample.GoodExample.Person();
        p.setAge(25);
        assertEquals(25, p.getAge());
    }

    @Test
    void encapsulateField_invalidAge_throws() {
        EncapsulateFieldExample.GoodExample.Person p = new EncapsulateFieldExample.GoodExample.Person();
        assertThrows(IllegalArgumentException.class, () -> p.setAge(-1));
    }

    @Test
    void encapsulateCollection_addAndView() {
        EncapsulateCollectionExample.GoodExample.Person person = new EncapsulateCollectionExample.GoodExample.Person();
        EncapsulateCollectionExample.Course java = new EncapsulateCollectionExample.Course("Java");
        person.addCourse(java);
        assertEquals(1, person.getCourseCount());
    }

    @Test
    void encapsulateCollection_unmodifiableView_throws() {
        EncapsulateCollectionExample.GoodExample.Person person = new EncapsulateCollectionExample.GoodExample.Person();
        assertThrows(UnsupportedOperationException.class,
            () -> person.getCourses().add(new EncapsulateCollectionExample.Course("x")));
    }

    @Test
    void replaceTypeCodeWithClass_bloodGroupLabel() {
        ReplaceTypeCodeWithClassExample.GoodExample.Person person = new ReplaceTypeCodeWithClassExample.GoodExample.Person();
        person.setBloodGroup(ReplaceTypeCodeWithClassExample.GoodExample.BloodGroup.AB);
        assertEquals("AB", person.getBloodGroup().getLabel());
    }

    @Test
    void replaceTypeCodeWithSubclasses_payAmount() {
        assertEquals(5000, new ReplaceTypeCodeWithSubclassesExample.GoodExample.Engineer(5000).payAmount());
        assertEquals(7000, new ReplaceTypeCodeWithSubclassesExample.GoodExample.Salesperson(5000, 2000).payAmount());
        assertEquals(7000, new ReplaceTypeCodeWithSubclassesExample.GoodExample.Manager(5000, 2000).payAmount());
    }

    @Test
    void replaceTypeCodeWithStateStrategy_promote() {
        ReplaceTypeCodeWithStateStrategyExample.GoodExample.Employee emp =
            new ReplaceTypeCodeWithStateStrategyExample.GoodExample.Employee(
                new ReplaceTypeCodeWithStateStrategyExample.GoodExample.EngineerType(), 5000, 1000);
        assertEquals("Engineer", emp.getTypeName());
        emp.promote();
        assertEquals("Manager", emp.getTypeName());
    }

    @Test
    void replaceSubclassWithFields_genderFactory() {
        ReplaceSubclassWithFieldsExample.GoodExample.Person male = ReplaceSubclassWithFieldsExample.GoodExample.Person.createMale();
        ReplaceSubclassWithFieldsExample.GoodExample.Person female = ReplaceSubclassWithFieldsExample.GoodExample.Person.createFemale();
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
