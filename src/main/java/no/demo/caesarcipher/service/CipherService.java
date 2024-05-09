package no.demo.caesarcipher.service;

public interface CipherService {

    String encrypt(String encryptedText, int shiftKey);

    String decrypt(String encryptedText, int shiftKey);
}
