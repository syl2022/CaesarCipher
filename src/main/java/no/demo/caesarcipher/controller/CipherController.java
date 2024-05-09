package no.demo.caesarcipher.controller;

import no.demo.caesarcipher.model.CipherRequest;
import no.demo.caesarcipher.model.CipherResponse;
import no.demo.caesarcipher.service.CipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cipher")
public class CipherController {

    @Autowired
    private CipherService service;

    @PostMapping("/encrypt")
    @ResponseBody
    public CipherResponse encrypt(@RequestBody CipherRequest request) {
        String inputText = request.getText();
        int shiftKey = request.getShiftKey();
        try {
            String result = service.encrypt(inputText, shiftKey);
            return new CipherResponse(result, null);
        } catch (Exception e) {
            return new CipherResponse(null, e.getMessage());
        }
    }

    @PostMapping("/decrypt")
    @ResponseBody
    public CipherResponse decrypt(@RequestBody CipherRequest request) {
        String encryptedText = request.getText();
        int shiftKey = request.getShiftKey();
        try {
            String result = service.decrypt(encryptedText, shiftKey);
            return new CipherResponse(result, null);
        } catch (Exception e) {
            return new CipherResponse(null, e.getMessage());
        }
    }
}
