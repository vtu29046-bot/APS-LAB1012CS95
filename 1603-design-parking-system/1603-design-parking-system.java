class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        int index = carType - 1;

        if (slots[index] > 0) {
            slots[index]--;
            return true;
        }

        return false;
    }
}
