package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int pointRate;
    @Column(length = 255, nullable = false)
    private String nutrient;
    @Column(nullable = false)
    private Boolean cutting;
    @Column(nullable = false)
    private int quantity;
    @Column
    private Date regdate;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<Option> options;

    @OneToMany(mappedBy = "product")
    private Set<PurchaseProduct> purchaseProducts;
}
