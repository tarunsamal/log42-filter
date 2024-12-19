package org.tarun.log4j2_filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Log4j2(topic = "logToFile")
public class Controller {

    @GetMapping(path = "/issue")
    public static String getSomething() {
        try{
            throw new IOException("java.io.IOException: Connection reset by peer");
        }catch (IOException e) {
            log.error(e.getMessage());
        }
        return "issue";
    }
}
