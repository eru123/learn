namespace ConsoleApp1Vehicle
{
    class Program
    {   
        abstract class Vehicle
        {   
            public abstract string Color { get; set; }
            public abstract decimal Price { get; set; }
            public bool isEngineStart { get; set; }
            public void startEngine()
            {
                isEngineStart = true;
            }
            public void stopEngine()
            {
                isEngineStart = false;
            }
            public abstract void Refuel(int liter);
            public abstract int SeatCapacity { get; set; }
            public abstract int GasTankCapacity { get; set; }
        }
        class WheeledVehicle : Vehicle
        {
            public override string Color { get; set; }
            public override decimal Price { get; set; }
            public override int SeatCapacity { get; set; }
            public override int GasTankCapacity { get; set; }
            public override void Refuel(int liter)
            {
                Console.WriteLine("Refueled " + liter + " liters");
                GasTankCapacity = GasTankCapacity + liter;
            }
            
            public string Engine = "automatic"; // automatic or manual
            public double Speed = 0;
            public double DistanceTraveled = 0;
            
            public void Drive(string direction, double distance)
            {
                if (isEngineStart == true)
                {
                    if (direction == "forward")
                    {
                        Speed = Speed + 10;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else if (direction == "backward")
                    {
                        Speed = Speed - 10;
                        GasTankCapacity--;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else if (direction == "left")
                    {
                        Speed = Speed - 10;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else if (direction == "right")
                    {
                        Speed = Speed + 10;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else
                    {
                        Console.WriteLine("Invalid direction");
                    }
                }
                else
                {
                    Console.WriteLine("Engine is not started");
                }
            }
        }

        class WaterVehicle : Vehicle
        {
            public override string Color { get; set; }
            public override decimal Price { get; set; }
            public override int SeatCapacity { get; set; }
            public override int GasTankCapacity { get; set; }
            public override void Refuel(int liter)
            {
                Console.WriteLine("Refueled " + liter + " liters");
                GasTankCapacity = GasTankCapacity + liter;
            }
            public int NumberOfEngines = 1;
            public double Speed = 0;
            public double DistanceTraveled = 0;
            public void Drive(string direction, double distance)
            {
                if (isEngineStart == true)
                {
                    if (direction == "forward")
                    {
                        Speed = Speed + 10;
                        GasTankCapacity--;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else if (direction == "backward")
                    {
                        Speed = Speed - 10;
                        GasTankCapacity--;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else if (direction == "left")
                    {
                        Speed = Speed - 10;
                        GasTankCapacity--;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else if (direction == "right")
                    {
                        Speed = Speed + 10;
                        GasTankCapacity--;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else
                    {
                        Console.WriteLine("Invalid direction");
                    }
                }
                else
                {
                    Console.WriteLine("Engine is not started");
                }
            }
        }

        class AerialVehicle : Vehicle
        {
            public override string Color { get; set; }
            public override decimal Price { get; set; }
            public override int SeatCapacity { get; set; }
            public override int GasTankCapacity { get; set; }
            public override void Refuel(int liter)
            {
                Console.WriteLine("Refueled " + liter + " liters");
                GasTankCapacity = GasTankCapacity + liter;
            }
            public int NumberOfEngines = 1;
            public double Speed = 0;
            public double DistanceTraveled = 0;
            public void Drive(string direction, double distance)
            {
                if (isEngineStart == true)
                {
                    if (direction == "forward")
                    {
                        Speed = Speed + 10;
                        GasTankCapacity--;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else if (direction == "left")
                    {
                        Speed = Speed - 10;
                        GasTankCapacity--;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else if (direction == "right")
                    {
                        Speed = Speed + 10;
                        GasTankCapacity--;
                        DistanceTraveled = DistanceTraveled + distance;
                        Console.WriteLine("Driving " + direction + " at " + Speed + " kph");
                        Console.WriteLine("Distance traveled " + DistanceTraveled + " kph");
                        Console.WriteLine("Gas remaining " + GasTankCapacity + " liters");
                    }
                    else
                    {
                        Console.WriteLine("Invalid direction");
                    }
                }
                else
                {
                    Console.WriteLine("Engine is not started");
                }
            }
        }

        class TwoWheeledVehicle : WheeledVehicle 
        {   
            public int NumberOfPersonRiding = 1;
            public TwoWheeledVehicle()
            {
                NumberOfPersonRiding = 1;

            }
            public void setNumberOfPersonRiding(int number)
            {   
                // max of 3 
                if (number <= 3)
                {
                    NumberOfPersonRiding = number;
                }
                else
                {
                    Console.WriteLine("Max of 3 people can ride");
                }
            }
            public double getSpeed()
            {
                return Speed;
            }
            public void setGasTankCapacity()
            {
                GasTankCapacity = GasTankCapacity - NumberOfPersonRiding;
            }

        }

        class FourWheeledVehicle : WheeledVehicle 
        {
            public int NumberOfPersonRiding = 1;
            public void setNumberOfPersonRiding(int number)
            {
                // max of 6
                if (number <= 6)
                {
                    NumberOfPersonRiding = number;
                }
                else
                {
                    Console.WriteLine("Max of 6 people can ride");
                }
            }
            public double getSpeed()
            {
                return Speed;
            }
            public void setGasTankCapacity()
            {
                GasTankCapacity = GasTankCapacity - NumberOfPersonRiding;
            }
        }

        

        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}