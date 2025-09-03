package com.portfolio.elearning.entity;

import com.portfolio.elearning.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories",
        indexes = {
                @Index(name = "idx_category_name", columnList = "name", unique = true),
                @Index(name = "idx_category_slug", columnList = "slug", unique = true)
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "courses")
@EqualsAndHashCode(callSuper = true, exclude = "courses")
public class Category extends BaseEntity {

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "display_order")
    private Integer displayOrder = 0;

    // Relationships
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>();

    // Helper method to generate slug
    @PrePersist
    @PreUpdate
    public void generateSlug() {
        if (this.slug == null || this.slug.isEmpty()) {
            this.slug = this.name.toLowerCase()
                    .replaceAll("[^a-z0-9]+", "-")
                    .replaceAll("^-|-$", "");
        }
    }
}