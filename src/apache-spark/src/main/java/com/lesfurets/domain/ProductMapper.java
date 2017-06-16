package com.lesfurets.domain;

public class ProductMapper {

    public static String french(Integer integer) {
        switch (integer) {
            case 0:
                return "tiers";
            case 1:
                return "tiers bdg";
            case 2:
                return "intermediaire";
            case 3:
                return "intermediaire confort";
            case 4:
                return "tous risque";
            case 5:
                return "tous risque de luxe";
            default:
                throw new RuntimeException("formule " + integer + " inconnue");
        }
    }

    public static String english(Integer integer) {
        switch (integer) {
            case 0:
                return "third party";
            case 1:
                return "third party plus";
            case 2:
                return "third party plus fire";
            case 3:
                return "third party, fire and theft";
            case 4:
                return "comprehensive";
            case 5:
                return "comprehensive luxury";
            default:
                throw new RuntimeException("formule " + integer + " inconnue");
        }
    }

}
