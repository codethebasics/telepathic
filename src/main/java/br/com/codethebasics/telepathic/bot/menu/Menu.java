package br.com.codethebasics.telepathic.bot.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    private Menu parentMenu;

    @OneToMany(
        mappedBy = "parentMenu",
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private List<Menu> childMenus = new ArrayList<>();

}
