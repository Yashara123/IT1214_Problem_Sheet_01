class Vehicle{
    String licensePlate;
    String ownnerName;
    int hoursParked;
    
    Vehicle(String licensePlate, String ownnerName, int hoursParked){
        this.licensePlate = licensePlate;
        this.ownnerName = ownnerName;
        this.hoursParked = hoursParked;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public String getOwnnerName() {
        return ownnerName;
    }
    public int getHoursParked() {
        return hoursParked;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public void setOwnnerName(String ownnerName) {
        this.ownnerName = ownnerName;
    }
    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }

}
class ParkingLot{
    Vehicle[] vehicles=new Vehicle[5];
    int vehicleCount=0;
    public void addVehicle(Vehicle vehicle){
        if(vehicleCount<vehicles.length){
            vehicles[vehicleCount]=vehicle;
            vehicleCount++;
        }else{
            System.out.println(" No Parking");
        }
    }
    public void removeVehicle(String licensePlate){
        for(int i=0;i<vehicleCount;i++){
            if(vehicles[i].getLicensePlate().equals(licensePlate)){
                vehicles[i]=vehicles[vehicleCount-1];
                vehicles[vehicleCount-1]=null;
                vehicleCount--;
                return;
            }
        }
        System.out.println("Vehicle not found");
    }
    public void displayVehicles(){
        for(int i=0;i<vehicleCount;i++){
            System.out.println("License Plate: "+vehicles[i].getLicensePlate());
            System.out.println("Owner Name: "+vehicles[i].getOwnnerName());
            System.out.println("Hours Parked: "+vehicles[i].getHoursParked());
            System.out.println();
        }
    }
}
class VehicleDemo{
    public static void main(String[] args) {
        ParkingLot parkingLot=new ParkingLot();
        Vehicle vehicle1=new Vehicle("ABC123", "John Doe", 2);
        Vehicle vehicle2=new Vehicle("XYZ456", "Jane Smith", 4);
        Vehicle vehicle3=new Vehicle("LMN789", "Bob Brown", 1);
        
        parkingLot.addVehicle(vehicle1);
        parkingLot.addVehicle(vehicle2);
        parkingLot.addVehicle(vehicle3);
        parkingLot.removeVehicle("XYZ456");
        parkingLot.displayVehicles();
    }
}