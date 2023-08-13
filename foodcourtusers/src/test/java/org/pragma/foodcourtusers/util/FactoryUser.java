package org.pragma.foodcourtusers.util;

import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.model.User;

import java.time.LocalDate;

public class FactoryUser{

    public static final User mockObject = new User(1L,"Pedro","Lopez", "16584",
                                  "3228754154",LocalDate.of(2001,4,13),
                "lopezpedro@hm.co", "pedroperez--",2L);
    public static final User expectedObject = new User(1L,"Pedro","Lopez", "16584",
            "3228754154",LocalDate.of(2001,4,13),
            "lopezpedro@hm.co", "pedroperez--",2L);
    public static final User mockObjectSets = new User(1L,"Pedro","Lopez", "16584",
            "3228754154",LocalDate.of(2001,4,13),
            "lopezpedro@hm.co", "pedroperez--",2L);

}
