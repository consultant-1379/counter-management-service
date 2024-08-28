package com.ericsson.oss.services.countermanagement.impl;

import org.junit.Assert;
import org.junit.Test;

/* This is just a sample test for reference, feel free to delete it at any point */

public class DateResolverBeanTest {

    @Test
    public void testDateResolvedNotNull() {
        DateResolverBean date = new DateResolverBean();

        Assert.assertNotNull(date.resolveCurrentDate());
    }
}
