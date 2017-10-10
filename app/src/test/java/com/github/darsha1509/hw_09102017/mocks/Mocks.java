package com.github.darsha1509.hw_09102017.mocks;

import junit.framework.Assert;

import java.io.InputStream;

public class Mocks {

    public static InputStream stream(final String pName){
        final InputStream resourseAsStream = Mocks.class.getClassLoader().getResourceAsStream(pName);
        Assert.assertNotNull("resource not found, maybe you forget add .json", resourseAsStream);
        return  resourseAsStream;
    }

}
