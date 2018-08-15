package org.seoul.kk.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_BOOKMARK")
public class BookMark {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "traveler_id" , foreignKey = @ForeignKey(name = "none"))
    private Traveler travelerId;

    @ManyToOne
    @JoinColumn(name = "playland_id", foreignKey = @ForeignKey(name = "none"))
    private PlayLand playLandId;

    @Column(name = "mark_at")
    private LocalDateTime markAt;

    @PrePersist
    public void onInitEntity() {
        this.markAt = LocalDateTime.now();
    }

}
