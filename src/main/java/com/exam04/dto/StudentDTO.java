package com.exam04.dto;

import jakarta.validation.constraints.*;

public class StudentDTO {
    // 1. Validation Họ tên & chuyên ngành
    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 5, max = 100, message = "Họ tên phải từ 5 đến 100 ký tự")
    private String fullName;

    @NotBlank(message = "Chuyên ngành không được để trống")
    private String major;

    // 2. Validation số học (Điểm số & Tuổi)
    @Min(value = 18, message = "Sinh viên phải từ 18 tuổi trở lên")
    private Integer age;

    @Min(value = 0, message = "Điểm GPA phải nằm trong khoảng 0 - 10")
    @Max(value = 10, message = "Điểm GPA phải nằm trong khoảng 0 - 10")
    private Double gpa;

    // 3. Validation định dạng Mã Sinh viên (Regex)
    @Pattern(regexp = "^SV\\d{4}$", message = "Mã sinh viên phải có dạng SVxxxx (VD: SV1234)")
    private String studentCode;

    public StudentDTO() {}

    public StudentDTO(String fullName, String major, Integer age, Double gpa, String studentCode) {
        this.fullName = fullName;
        this.major = major;
        this.age = age;
        this.gpa = gpa;
        this.studentCode = studentCode;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public Double getGpa() { return gpa; }
    public void setGpa(Double gpa) { this.gpa = gpa; }
    public String getStudentCode() { return studentCode; }
    public void setStudentCode(String studentCode) { this.studentCode = studentCode; }
}
