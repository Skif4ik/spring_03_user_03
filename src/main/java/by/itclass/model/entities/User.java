package by.itclass.model.entities;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor //конструктор по умолчанию
@RequiredArgsConstructor
@Data //гетеры сетеры
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private  int id;
    @NonNull
    private  String name;
    @NonNull
    private  int age;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

}