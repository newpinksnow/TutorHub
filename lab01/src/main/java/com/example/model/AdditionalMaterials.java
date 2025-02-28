package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "additional_materials")
public class AdditionalMaterials {
    @Id
    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Lob
    @Column(name = "add_materials")
    private byte[] additionalMaterials;

    public AdditionalMaterials() {}

    public AdditionalMaterials(User student, byte[] additionalMaterials) {
        this.student = student;
        this.additionalMaterials = additionalMaterials;
    }

    public User getStudent() { return student; }
    public byte[] getAdditionalMaterials() { return additionalMaterials; }

    public void setStudent(User student) { this.student = student; }
    public void setAdditionalMaterials(byte[] additionalMaterials) { this.additionalMaterials = additionalMaterials; }

    @Override
    public String toString() {
        return "AdditionalMaterials{" +
                "student=" + student +
                '}';
    }
}
