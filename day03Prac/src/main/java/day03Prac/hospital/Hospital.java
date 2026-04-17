package day03Prac.hospital;

public class Hospital {
    String recordId;
    String patientName;
    String doctorName;
    String diagnosisName;
    String treatmentContent;
    String prescriptionContent;
    String treatmentDate;

    public Hospital() {
    }

    public Hospital(String recordId, String patientName, String doctorName, String diagnosisName,
            String treatmentContent, String prescriptionContent, String treatmentDate) {
        super();
        this.recordId = recordId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.diagnosisName = diagnosisName;
        this.treatmentContent = treatmentContent;
        this.prescriptionContent = prescriptionContent;
        this.treatmentDate = treatmentDate;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public String getTreatmentContent() {
        return treatmentContent;
    }

    public void setTreatmentContent(String treatmentContent) {
        this.treatmentContent = treatmentContent;
    }

    public String getPrescriptionContent() {
        return prescriptionContent;
    }

    public void setPrescriptionContent(String prescriptionContent) {
        this.prescriptionContent = prescriptionContent;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(String treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    @Override
    public String toString() {
        return "Hospital [recordId=" + recordId + ", patientName=" + patientName + ", doctorName=" + doctorName
                + ", diagnosisName=" + diagnosisName + ", treatmentContent=" + treatmentContent
                + ", prescriptionContent=" + prescriptionContent + ", treatmentDate=" + treatmentDate + "]";
    }
}