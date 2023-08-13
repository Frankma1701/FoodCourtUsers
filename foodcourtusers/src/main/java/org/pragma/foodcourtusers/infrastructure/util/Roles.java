package org.pragma.foodcourtusers.infrastructure.util;

public enum Roles{

    ADMIN(1L, "ADMIN"), OWNER(2L, "OWNER"), EMPLOYEE(3L, "EMPLOYEE"), CUSTOMER(4L, "CUSTOMER");

    private Long id;
    private String name;

    private Roles (Long id, String name){
        this.id = id;
        this.name = name;
    }

    public static String getNameById (Long id){
        for (Roles role : Roles.values()) {
            if (role.id.equals(id)) {
                return role.name;
            }
        }
        return "Cliente";
    }

    public Long getId(){
        return this.id;
    }
}
