package Challenge.Foro.controller;

import Challenge.Foro.domain.Usuario.LoginDTO;
import Challenge.Foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO request) {
        // Usuario hardcodeado
        if ("user".equals(request.username()) && "1234".equals(request.password())) {
            String token = tokenService.generarToken(request.username());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrecta");
        }
    }
}