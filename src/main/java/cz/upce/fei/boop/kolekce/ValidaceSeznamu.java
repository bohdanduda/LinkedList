package cz.upce.fei.boop.kolekce;

public abstract class ValidaceSeznamu {
    private static final String NEGATIVE_COLLECTION_SIZE_MESSAGE = "Seznam je prázdný!";
    private static final String NEXT_NODE_DOESNT_EXIST_MESSAGE = "Další prvek neexistuje!";

    public static void zvalidujDelku(boolean jeSeznamPrazdny) throws KolekceException {
        if (!jeSeznamPrazdny){
            throw new KolekceException(NEGATIVE_COLLECTION_SIZE_MESSAGE);
        }
    }

    public static void zvalidujExistenciDalsihoPrvku(boolean existujeDalsiPrvek) throws KolekceException {
        if (!existujeDalsiPrvek){
            throw new KolekceException(NEXT_NODE_DOESNT_EXIST_MESSAGE);
        }
    }
}