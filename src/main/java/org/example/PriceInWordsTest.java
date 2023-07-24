package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PriceInWordsTest {
    @Test
    public void testConvertToWordsRubles() {
        Assertions.assertEquals("три рубля", PriceInWordsRUS.convertToWords(3)+ " "+PriceInWordsRUS.Curency(3));
        Assertions.assertEquals("пять рублей", PriceInWordsRUS.convertToWords(5)+ " "+PriceInWordsRUS.Curency(5));
        Assertions.assertEquals("сорок пять рублей", PriceInWordsRUS.convertToWords(45)+ " "+PriceInWordsRUS.Curency(45));
        Assertions.assertEquals("одна тысяча рублей", PriceInWordsRUS.convertToWords(1000)+ " "+PriceInWordsRUS.Curency(1000));
        Assertions.assertEquals("сто пятьдесят одна тысяча сто пятьдесят один рубль", PriceInWordsRUS.convertToWords(151151)+ " "+PriceInWordsRUS.Curency(151151));
        Assertions.assertEquals("сто одиннадцать рублей", PriceInWordsRUS.convertToWords(111)+ " "+PriceInWordsRUS.Curency(111));
        Assertions.assertEquals("одна тысяча рублей", PriceInWordsRUS.convertToWords(1000)+ " "+PriceInWordsRUS.Curency(1000));
        Assertions.assertEquals("сто одиннадцать милионов сто одиннадцать тысяч сто одиннадцать рублей", PriceInWordsRUS.convertToWords(111111111)+ " "+PriceInWordsRUS.Curency(111111111));
    }
    }
