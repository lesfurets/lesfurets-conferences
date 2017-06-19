public class FormuleMapper {

    public static String asString(Integer integer) {
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

}
