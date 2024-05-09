package no.demo.caesarcipher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CipherServiceImpl implements CipherService {

    private final Logger log = LoggerFactory.getLogger(CipherServiceImpl.class);

    @Override
    public String encrypt(String inputText, int shiftKey) {
        int key = normalizeShift(shiftKey);
        if (inputText == null || inputText.isEmpty()) {
            String error="Input text cannot be null or empty !";
            log.error("Error occurred at CipherServiceImpl.encrypt : {}", error);
            throw new IllegalArgumentException(error);
        }

        StringBuilder cipherText = new StringBuilder();
        inputText.chars().forEach(currentChar -> {
            char encryptedChar = (char) currentChar;
            if (currentChar >= 32 && currentChar <= 126) { // Printable ASCII characters range
                encryptedChar = (char) (Math.floorMod((currentChar + key - 32), 95) + 32);
            }
            cipherText.append(encryptedChar);
        });
        log.info("Text encryption successful !");
        // You can call Dao or other services at this point to use the text or save it in database if needed
        return cipherText.toString();
    }

    @Override
    public String decrypt(String encryptedText, int shiftKey) {
        int key = normalizeShift(shiftKey);
        if (encryptedText == null || encryptedText.isEmpty()) {
            String error="Input text cannot be null or empty !";
            log.error("Error occurred at CipherServiceImpl.decrypt : {}", error);
            throw new IllegalArgumentException(error);
        }
        StringBuilder decryptedText = new StringBuilder();
        encryptedText.chars().forEach(currentChar -> {
            char decryptedChar = (char) currentChar;
            if (currentChar >= 32 && currentChar <= 126) { // Printable ASCII characters range
                decryptedChar = (char)(Math.floorMod((currentChar - key - 32), 95) + 32);
            }
            decryptedText.append(decryptedChar);
        });
        log.info("Text decryption successful !");
        // You can call Dao or other services at this point to use the text or save it if needed
        return decryptedText.toString();
    }

    private int normalizeShift(int shift) {
        return shift % 94; // Ensure shift value is within the range [-94, 93]
    }
}
