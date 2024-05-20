package edu.utfpr;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class IdentifierTest {

    @Test
    void TesteSucesso(){
        assertThat(validateIdentifier("A1B2")).isEqualTo(true);
    }

    @Test
    void limiteCaracteres(){
        assertThat(validateIdentifier("W")).isEqualTo(true);
        assertThat(validateIdentifier("AB345f")).isEqualTo(true);
    }

    @Test
    void comecoNumero(){
        assertThat(validateIdentifier("1b3")).isEqualTo(false);
    }

}
