package org.pragma.foodcourtusers.application.dto.response;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@Builder
public class JwtResponse{
    private String token;
}
