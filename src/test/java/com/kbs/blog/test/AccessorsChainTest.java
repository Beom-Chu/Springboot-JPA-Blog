package com.kbs.blog.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessorsChainTest {

    @Test
    public void test (){
        AccessorsChain accessorsChain = new AccessorsChain();
        accessorsChain.setId(10).setName("testName");
    }
}