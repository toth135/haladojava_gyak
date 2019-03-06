package hu.me;

import hu.me.logika.Calculator;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class KeresFeldolgozoTest {

    @Test
    public void feldolgoz_whenEmptyOperator_thenGiveErrorString() {

        Calculator calculator = Mockito.mock(Calculator.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("");

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.HibasMuveletiJel));
    }

    @Test
    public void feldolgoz_whenNullInput_thenGiveErrorString() {

        Calculator calculator = Mockito.mock(Calculator.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.HibasMuveletiJel));
    }

    @Test
    public void feldolgoz_whenOsszeadas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.add(3, 4)).thenReturn(7.0);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("+");
        inputValues.setOperandus1(3);
        inputValues.setOperandus2(4);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(7.0));
    }

    @Test
    public void feldolgoz_whenKivonas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.subtract(5, 2)).thenReturn(3.0);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("-");
        inputValues.setOperandus1(5);
        inputValues.setOperandus2(2);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(3.0));
    }

    @Test
    public void feldolgoz_whenSzorzas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.multiply(6, 8)).thenReturn(48.0);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("*");
        inputValues.setOperandus1(6);
        inputValues.setOperandus2(8);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(48.0));
    }

    @Test
    public void feldolgoz_whenOsztas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.divide(6, 3)).thenReturn(2.0);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("/");
        inputValues.setOperandus1(6);
        inputValues.setOperandus2(3);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(2.0));
    }

}