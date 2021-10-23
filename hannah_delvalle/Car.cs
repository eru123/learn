using System;

namespace Act3 {
    public interface IVehicle {
        void Drive();
        bool Refuel(int g);
    }
    class Car: IVehicle {
        public int gas;
        public Car(int g) {
            gas = g;
        }
        public void Drive() {
            if (gas > 0) {
                Console.WriteLine("Driving");
            } else {
                Console.WriteLine("No gas, refueling...");
                if (Refuel(gas)) {
                    Console.WriteLine("Refuel Complete!");   
                }
            }
        }
        public bool Refuel(int g) {
            gas++;
            return true;
        }
    }
    class Program {
        static void Main(string[] args) {
            Car c = new Car(0);
            c.Drive();
            c.Drive();
        }
    }
}
