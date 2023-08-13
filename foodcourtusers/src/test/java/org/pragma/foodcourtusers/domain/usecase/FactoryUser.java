package org.pragma.foodcourtusers.domain.usecase;

import org.pragma.foodcourtusers.domain.model.User;

import java.time.LocalDate;

public class FactoryUser{

    public static final User mockObject = new User(1L,"Pedro","Perez", "14124",
                                  "431124",LocalDate.of(2001,4,13),
                "lopezpedro@hm.co", "pedroperez--",2L);
    public static final User mockObject1 = new User(1L,"Pedro","Perez", "1452",
                                   "431124", LocalDate.of(2001,4,13),
                "lopezpedro@hm.co", "pedroperez--",2L);

    public static final UserexpectedObject = new User(1L,"Pedro","Perez", "14124",
                                      "431124", LocalDate.of(2001,4,13),
                "lopezpedro@hm.co", "pedroperez--",2L);
    public static final UserexpectedUpdateObject = new User(1L,"Pedro","Perez", "14124",
                                            "431124", LocalDate.of(2001,4,13),
                "lopezpedro@hm.co", "pedroperez--",2L);
}
