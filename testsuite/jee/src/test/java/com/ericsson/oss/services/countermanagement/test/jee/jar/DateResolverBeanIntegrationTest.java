package com.ericsson.oss.services.countermanagement.test.jee.jar;

import com.ericsson.oss.services.countermanagement.impl.DateResolverBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/* This is just a sample test for reference, feel free to delete it at any point */

@RunWith(Arquillian.class)
public class DateResolverBeanIntegrationTest {

    @Inject
    private DateResolverBean dateResolver;

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "counter-management-service-jar.jar")
                .addClass(DateResolverBean.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void notNullTest(){
        Assert.assertNotNull(dateResolver.resolveCurrentDate());
    }
}
