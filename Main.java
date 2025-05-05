public class Main {
    public static void main(String[] args) {
    }

    public void readAndSetAddress(Person person, int addressId) {
        Address newAddress = findAddress(addressId);
        if (newAddress != null) {
            //if the address is known,
            //update the person's address and associations.
            person.setAddress(newAddress);
            updateAssociations(person);
        } else {
            //if the address is unknown,
            //remove any existing association.
            person.setAddress(null);
            removeAssociations(person);
        }
    }
}