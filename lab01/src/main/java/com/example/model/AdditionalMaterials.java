package com.example.model;
import java.util.Objects;
import java.util.Arrays;
import jakarta.persistence.*;

@Entity
@Table(name = "additional_materials")
public class AdditionalMaterials {
    @Id
    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @Lob
    @Column(name = "add_materials", columnDefinition = "LONGBLOB")
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalMaterials that = (AdditionalMaterials) o;
        return Objects.equals(student, that.student) && Arrays.equals(additionalMaterials, that.additionalMaterials);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(student);
        result = 31 * result + Arrays.hashCode(additionalMaterials);
        return result;
    }
}
