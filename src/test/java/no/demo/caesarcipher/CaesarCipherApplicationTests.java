package no.demo.caesarcipher;

import no.demo.caesarcipher.service.CipherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CaesarCipherApplicationTests {

    @Autowired
    private CipherService service;
    @Test
    void testEncrypt() {
        String inputText = "Hello";
        int shiftKey = 15;
        String expectedEncryptedText = "Wt{{~";
        String encryptedText = service.encrypt(inputText, shiftKey);
        assertEquals(expectedEncryptedText, encryptedText);
    }

    @Test
    void testDecrypt() {
        String encryptedText = "Wt{{~";
        int shiftKey = 15;
        String expectedDecryptedText = "Hello";
        String decryptedText = service.decrypt(encryptedText, shiftKey);
        assertEquals(expectedDecryptedText, decryptedText);
    }
}
