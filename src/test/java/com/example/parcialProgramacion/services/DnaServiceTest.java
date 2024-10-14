package com.example.parcialProgramacion.services;

import com.example.parcialProgramacion.domain.dto.DnaAllDto;
import com.example.parcialProgramacion.repositories.DnaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class DnaServiceTest {

    @InjectMocks
    private DnaService dnaService;

    @Mock
    private DnaRepository dnaRepository;

    @Mock
    private StatsService statsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  //
    }

    // TEST PARA EL MANEJO DE ERRORES:
    //ARRAY VACIO:
    @Test
    void whenDnaArrayIsEmpty_thenThrowIllegalArgumentException() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{});

        assertThrows(IllegalArgumentException.class, () -> {
            dnaService.processAndSave(dnaAllDto);
        });
    }

    // ARRAY N X M
    @Test
    void whenDnaArrayIsNotNxN_thenThrowIllegalArgumentException() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{"ATCG", "CAGT", "TTGA"});

        assertThrows(IllegalArgumentException.class, () -> {
            dnaService.processAndSave(dnaAllDto);
        });
    }

    // ARRAY INCORRECTO
    @Test
    void whenDnaArrayContainsNumbers_thenThrowIllegalArgumentException() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{"1234", "5678", "9123", "4567"});

        assertThrows(IllegalArgumentException.class, () -> {
            dnaService.processAndSave(dnaAllDto);
        });
    }

    // NULL
    @Test
    void whenDnaArrayIsNull_thenThrowIllegalArgumentException() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(null);

        assertThrows(IllegalArgumentException.class, () -> {
            dnaService.processAndSave(dnaAllDto);
        });
    }

    // ARRAY DE NULLS
    @Test
    void whenDnaArrayContainsNulls_thenThrowIllegalArgumentException() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{null, null, null, null});

        assertThrows(IllegalArgumentException.class, () -> {
            dnaService.processAndSave(dnaAllDto);
        });
    }

    // ARRAY CON LETRAS NO PERMITIDAS
    @Test
    void whenDnaArrayContainsInvalidLetters_thenThrowIllegalArgumentException() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{"BXCG", "HYTC", "XWAV", "QCZG"});

        assertThrows(IllegalArgumentException.class, () -> {
            dnaService.processAndSave(dnaAllDto);
        });
    }

    // CASOS POSIBLES:
    @Test
    void IsMutant1() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{
                "AAAA",
                "CCCC",
                "TGAG",
                "GGTC"
        });

        boolean isMutant = dnaService.isMutant(dnaAllDto.getDna()).getIsADnaMutant();
        assertTrue(isMutant, "Se esperaba que el ADN fuera mutante.");
    }

    @Test
    void IsMutant2() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        });

        boolean isMutant = dnaService.isMutant(dnaAllDto.getDna()).getIsADnaMutant();
        assertTrue(isMutant, "Se esperaba que el ADN fuera mutante.");
    }

    @Test
    void IsMutant3() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        });

        boolean isMutant = dnaService.isMutant(dnaAllDto.getDna()).getIsADnaMutant();
        assertTrue(isMutant, "Se esperaba que el ADN fuera mutante.");
    }


    //Casos NO mutantes
    @Test
    void IsMutant4() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        });

        boolean isMutant = dnaService.isMutant(dnaAllDto.getDna()).getIsADnaMutant();
        assertFalse(isMutant, "Se esperaba que el ADN no fuera mutante.");
    }

    @Test
    void IsMutant5() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{
                "TGAC",
                "ATCC",
                "TAGA",
                "GGTC"
        });

        boolean isMutant = dnaService.isMutant(dnaAllDto.getDna()).getIsADnaMutant();
        assertFalse(isMutant, "Se esperaba que el ADN no fuera mutante.");
    }

    // Casos Largos
    @Test
    void IsMutant6() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        });

        boolean isMutant = dnaService.isMutant(dnaAllDto.getDna()).getIsADnaMutant();
        assertTrue(isMutant, "Se esperaba que el ADN no fuera mutante.");
    }

    @Test
    void IsMutant7() {
        DnaAllDto dnaAllDto = new DnaAllDto();
        dnaAllDto.setDna(new String[]{
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "CCGACCAGT",
                "GGCACTCCA",
                "AGGACACTA",
                "CAAAGGCAT",
                "GCAGTCCCC"
        });

        boolean isMutant = dnaService.isMutant(dnaAllDto.getDna()).getIsADnaMutant();
        assertTrue(isMutant, "Se esperaba que el ADN no fuera mutante.");
    }
}