package com.kjb.dongbu.Repository.Jpo;

import com.kjb.dongbu.Model.Debts;
import com.kjb.dongbu.Model.History;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="debts")
public class DebtsJpo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long d_code;
    @Column(nullable = false)
    private long m_code;
    @Column(nullable = true)
    private long payback_date;
    @Column(nullable = false)
    private int price;

    public DebtsJpo(Debts debts) {
        BeanUtils.copyProperties(debts, this);
    }

    public Debts toDomain() {
        Debts debts = new Debts();
        BeanUtils.copyProperties(this, debts);
        return debts;
    }

    public static List<Debts> toDomains(List<DebtsJpo> debtsJpos) {
        return debtsJpos.stream().map(DebtsJpo::toDomain).collect(Collectors.toList());
    }
}
