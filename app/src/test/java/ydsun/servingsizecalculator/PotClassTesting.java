package ydsun.servingsizecalculator;

import org.junit.Assert;
import org.junit.Test;

// Test Class for Pot Class
public class PotClassTesting {
    @Test
    public void testing_get() throws Exception {
        Pot testing_pot = new Pot("test name", 0);
        Assert.assertEquals(testing_pot.getName(), "test name");
        Assert.assertEquals(testing_pot.getWeightInG(), 0);
    }

    @Test
    public void testing_set() throws Exception {
        Pot testing_pot_2 = new Pot("anther pot", 100);
        int new_weight = 150;
        String new_name = "changed name";
        testing_pot_2.setName(new_name);
        testing_pot_2.setWeightInG(new_weight);
        Assert.assertEquals(testing_pot_2.getName(), "changed name");
        Assert.assertEquals(testing_pot_2.getWeightInG(), 150);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testing_set_name_exp() throws Exception{
        Pot testing_pot_3 = new Pot("and another pot", 200);
        String empty_string = null;
        testing_pot_3.setName(empty_string);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testing_set_Weight_exp() throws Exception{
        Pot testing_pot_4 = new Pot("once again another pot", 300);
        int negative_number = -1;
        testing_pot_4.setWeightInG(negative_number);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testing_initiate_bad_name() throws Exception{
        Pot testing_pot_5 = new Pot(null, 400);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testing_initiate_bad_Weight() throws Exception{
        Pot testing_pot_5 = new Pot("bad weight", -1);
    }
}
