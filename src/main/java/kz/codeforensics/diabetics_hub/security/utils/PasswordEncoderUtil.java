package kz.codeforensics.diabetics_hub.security.utils;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderUtil {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Named("encodePassword")
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}

