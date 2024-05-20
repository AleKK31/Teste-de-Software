package com.example.planningpoker;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PlanningPokerTest {
    /*
    Justificativa: Testa uma estimativa na lista, ver como lida com casos de entrada especiais e não gere exceções.
    Entrada: Uma estimativa.
    Saída Esperada: O nome com a estimativa mais baixa e mais alta devem ser iguais.
    Resultado: O teste falhou, gerou uma exceção pois a menor estimativa (lowestEstimate) foi dada como nula.
    */
    @Test
    public void estimativaUnica() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Alexandre", 6)
        );
        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Alexandre", "Alexandre"));
    }

    /*
    Justificativa: Testa diversas uma estimativa alta e uma baixa, deve identifique corretamente os extremos em um cenário padrão.
    Entrada: Duas estimativas, uma alta e outra baixa.
    Saída Esperada: Os nomes dos desenvolvedores com as estimativas mais alta e mais baixa.
    Resultado: O teste retornou a saída esperada.
    */
    @Test
    public void estimativasExtrema() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Mauricio", 10),
            new Estimate("Ariel", 1)
        );
        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Ariel", "Mauricio"));
    }

    /*
    Justificativa: Testatodas estimativas sendo iguais, verificar como o método trata quando não tem diferença entre as estimativas.
    Entrada: Estimativas iguais.
    Saída Esperada: O mesmo nome com a estimativa mais baixa e mais alta, já que todas as estimativas são iguais 
                    ou
                    Dois nomes diferentes para a estimativa mais baixa e mais alta, de acordo com a lista.
    Resultado: O método retorna "Mauricio" como mais baixa e "Alexandre" como mais alta.
    */
    @Test
    public void estimativasIguais() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Alexandre", 7),
            new Estimate("Mauricio", 7),
            new Estimate("Ariel", 7)
        );
        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Alexandre", "Alexandre"));
    }

    //da erro
    @Test
    public void estimativaCrescente() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Alexandre", 1),
            new Estimate("Mauricio", 3),
            new Estimate("Ariel", 5)
        );
        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Alexandre", "Ariel"));
    }

    /*
    Justificativa: Se houver duas ou mais estimativas iguais para a mais baixa ou mais alta, o método deve escolher aleatoriamente uma.
    Entrada: Uma lista com estimativas empatadas.
    Saída Esperada: O método deve retornar um dos nomes dos desenvolvedores que têm as estimativas iguais mais altas e iguais mais baixas.
    Resultado: Devolve de acordo com a ordem da lista.
    */
    @Test
    public void estimativasIguais2() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Mauricio", 1),
            new Estimate("Ariel", 10),
            new Estimate("Alexandre", 1),
            new Estimate("Maria", 10)
        );
        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

            
        assertThat(devs).isEqualTo(Arrays.asList("Alexandre", "Ariel"));
    }

    /*
    Justificativa: Testa estimativas são negativas.
    Entrada: Estimativas negativas.
    Saída Esperada: Os nomes dos desenvolvedores devem ser retornados corretamente, independentemente de serem negativas.
    Resultado: Retorna de acordo com o esperado, mesmo que teoricamente não existam estimativas negativas no planning poker.
    */
    @Test
    public void estimativaNegativa() {
        List<Estimate> list = Arrays.asList(
            new Estimate("Mauricio", -6),
            new Estimate("Ariel", -9),
            new Estimate("Alexandre", -1)
        );
        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Ariel", "Alexandre"));
    }

    /*
    Justificativa: Se a lista estiver vazia, não existe nenhum elemento para processar, é importante que o método saiba lidar com essa situação.
    Entrada: Uma lista vazia.
    Saída Esperada: O método deve retornar uma lista vazia.
    Resultado: Não lida corretamente. Ele tenta acessar um método em um objeto que não foi inicializado, assim "quebrando" o codigo.
    */
    @Test
    public void listaVazia() {
        List<Estimate> list = new ArrayList<>();
        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEmpty();
    }

    /*
    Justificativa: O código pode quebrar se uma das estimativas na lista for nula. O método deve ser capaz de lidar adequadamente com esses casos sem lançar exceções.
    Entrada: Uma lista com uma ou mais estimativas nulas.
    Saída Esperada: O método deve lidar com estimativas nulas e produzir os resultados corretos, considerando apenas estimativas válidas.
    Resultado: Ele quebra, pois tenta acessar um método em um objeto que não foi inicializado.
    */
    @Test
    public void listaNula() {
        List<Estimate> list = Arrays.asList(
            null,
            new Estimate("Mauricio", 6),
            new Estimate("Ariel", 9),
            null
        );
        List<String> devs = new PlanningPoker()
            .identifyExtremes(list);

        assertThat(devs).isEqualTo(Arrays.asList("Ariel", "Mauricio"));
    }

}
