using System;

namespace Act
{
    abstract class Shape
    {
        
        
        public abstract double GetArea();
    }

    class Triangle : Shape {
        public double Base;
        public double Height;
        public Triangle(double b, double h)
        {
            Base = b;
            Height = h;
        }
        public override double GetArea()
        {
            return (0.5 * Base * Height);
        }
    }

    class Rectangle : Shape {
        public double Length;
        public double Width;
        public Rectangle(double l, double w)
        {   
            Length = l;
            Width = 2;
        }
        public override double GetArea()
        {
            return (Length * Width);
        }
    }

    class Program
    {
        public static void Main(string[] args)
        {
            double l = 4;
            double w = 2;
            Rectangle rectangle = new Rectangle(l, w);
            Console.WriteLine("Area of Reactangle = {0}", rectangle.GetArea());

            double b = 4;
            double h = 2;
            Triangle triangle = new Triangle(b, h);
            Console.WriteLine("Area of Triangle = {0}", triangle.GetArea());

        }
    }
}