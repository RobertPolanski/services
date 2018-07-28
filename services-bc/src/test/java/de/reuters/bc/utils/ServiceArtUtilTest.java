package de.reuters.bc.utils;





import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ServiceArtUtilTest {


    @Test
    public void shouldAmAnfangDesWortesGrosseBuchstabenSetzen(){

        String stringMitGrossenBuchstaben1 = StringUtil.machAmAnfangDesWortesGrosseBuchstaben("bank pekao");
        Assert.assertEquals("Bank Pekao", stringMitGrossenBuchstaben1);

        String stringMitGrossenBuchstaben2 = StringUtil.machAmAnfangDesWortesGrosseBuchstaben("centralny dom maklerski");
        Assert.assertEquals("Centralny Dom Maklerski",stringMitGrossenBuchstaben2);

        String stringMitGrossenBuchstaben3 = StringUtil.machAmAnfangDesWortesGrosseBuchstaben(" ");
        Assert.assertEquals(" ",stringMitGrossenBuchstaben3);

        String stringMitGrossenBuchstaben4 = StringUtil.machAmAnfangDesWortesGrosseBuchstaben("  ");
        Assert.assertEquals("  ",stringMitGrossenBuchstaben4);

        String stringMitGrossenBuchstaben5 = StringUtil.machAmAnfangDesWortesGrosseBuchstaben(null);
        Assert.assertEquals(null, stringMitGrossenBuchstaben5);

    }


}
