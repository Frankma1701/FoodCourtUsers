package org.pragma.foodcourtusers.util;

import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.model.User;

import java.time.LocalDate;

public class FactoryRole{


    public static final Role mockObject = new Role(1L,"ADMIN","Administrador del sistema");
    public static final Role expectedObject = new Role(1L,"ADMIN","Administrador del sistema");

}
