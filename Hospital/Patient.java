package Hospital;

public class Patient {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String medicalHistory;

    public Patient(int id, String name, String address, String contact, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.medicalHistory = medicalHistory;
    }

    // Getters for each field
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContact() { return contact; }
    public String getMedicalHistory() { return medicalHistory; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Address: " + address +
               ", Contact: " + contact + ", Medical History: " + medicalHistory;
    }
}
