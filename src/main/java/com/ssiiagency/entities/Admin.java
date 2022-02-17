package com.ssiiagency.entities;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "Admin")
@PrimaryKeyJoinColumn(foreignKey=@ForeignKey(name = "id_user_adm"))
@Component
public class Admin extends User {

    public Admin() {
    }
}
