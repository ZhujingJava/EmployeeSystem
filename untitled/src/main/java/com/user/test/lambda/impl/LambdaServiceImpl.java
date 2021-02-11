package com.user.test.lambda.impl;

import com.user.test.lambda.LambdaService;

public class LambdaServiceImpl implements LambdaService {
    @Override
    public void testLambda(String s) {
        System.out.println("lambda表达式成功");
    }
}
