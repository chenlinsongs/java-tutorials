package com.mybatis.example;

import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.parsing.TokenHandler;

public class TokenTest {
    public static void main(String[] args) {

        GenericTokenParser genericTokenParser = new GenericTokenParser("${", "}",new TokenHandler(){
            @Override
            public String handleToken(String content) {
                return "dddd";
            }
        });
        System.out.println(genericTokenParser.parse("select from a where id = $\\{dd\\}"));
    }
}
