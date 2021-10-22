using System;

namespace Act {
    abstract class Shape {
        public abstract double GetArea();
    }
    class Circle : Shape {
        public double radius;
        public Circle(double r) {
            radius = r;
        }
        public override double GetArea() {
            return Math.PI * radius * radius;
        }
    }
    class Triangle : Shape {
        public double Base;
        public double Height;
        public Triangle(double b, double h) {
            Base = b;
            Height = h;
        }
        public override double GetArea()
        {
            return (0.5 * Base * Height);
        }
    }
    class Square : Shape {
        private double side;
        public Square(double s) {
            side = s;
        }
        public override double GetArea() {
            return (side * side);
        }
    }
    class Program {
        public static void Main(string[] args) {
            Circle c = new Circle(5.0);
            Console.WriteLine("Area of Circle = {0}", c.GetArea());
            Square s = new Square(2.5);
            Console.WriteLine("Area of Square = {0}", s.GetArea());
            Triangle t = new Triangle(2.0, 5.0);
            Console.WriteLine("Area of Triangle = {0}", t.GetArea());
        }
    }
}