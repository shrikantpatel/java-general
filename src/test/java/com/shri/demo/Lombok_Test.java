package com.shri.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lombok_Test {

    @Test
    public void test() {

        Person person = Person.builder()
                .givenName("Shrikant")
                .additionalName("Chintu")
                .familyName("Patel")
                .tags(Arrays.asList("shri", "happy"))
                .build();

        Assert.assertEquals("Shrikant", person.getGivenName());
        Assert.assertArrayEquals(new String[]{"shri", "happy"}, person.getTags().toArray());
    }

    @Test
    public void test2() {

        Person person = Person.builder()
                .givenName("Shrikant")
                .additionalName("Chintu")
                .familyName("Patel")
                .tags(Arrays.asList("shri", "happy"))
                .interest("sports")
                .interest("outdoors")
                .build();

        Assert.assertEquals("Shrikant", person.getGivenName());
        Assert.assertArrayEquals(new String[]{"shri", "happy"}, person.getTags().toArray());
        Assert.assertArrayEquals(new String[]{"sports", "outdoors"}, person.getInterests().toArray());
    }

    @Test
    public void test3() {

        Person person = Person.builder()
                .givenName("Shrikant")
                .additionalName("Chintu")
                .familyName("Patel")
                .tags(Arrays.asList("shri", "happy"))
                .interest("sports")
                .interest("outdoors")
                .attribute("smart")
                .attribute("hardworking")
                .attribute("smart")
                .build();

        Assert.assertEquals("Shrikant", person.getGivenName());
        Assert.assertArrayEquals(new String[]{"shri", "happy"}, person.getTags().toArray());
        Assert.assertArrayEquals(new String[]{"sports", "outdoors"}, person.getInterests().toArray());
        Assert.assertEquals(new HashSet<>(Arrays.asList("smart", "hardworking")), person.getAttribute());
    }
}

@Getter
@Builder
class Person {

    private final String givenName;
    private final String additionalName;
    private final String familyName;
    private final List<String> tags;

    @Singular("interest")
    private final List<String> interests;

    @Singular("attribute")
    private final Set<String> attribute;

}