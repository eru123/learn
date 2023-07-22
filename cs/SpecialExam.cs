using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpecialExam
{
    class Program
    {   
        public static String names; // user name
        public static String ys;    // user year and section
        public static Double pay;   // amount pay
        public static Double tuition = 12500;
        public static Double down = 2300;
        public static Double monthly = 1700;
        public static Double FirstPre = 1700;
        public static Double SecondPre = 1700;
        public static Double Midterm = 1700;
        public static Double PreFinal = 1700;
        public static Double Final = 1700;
        public static Double balance = 12500;
        public static Boolean again = true;
    
        static void Main(string[] args)
        {
            Console.Write("ENTER FULLNAME: ");
            names = Convert.ToString(Console.ReadLine());
            Console.Write("ENTER YEAR AND SECTION: ");
            ys = Convert.ToString(Console.ReadLine());
            Console.Write("AMOUNT PAY: ");
            pay = Convert.ToDouble(Console.ReadLine());

            while(again) {
                formula();
                again = question();
            }

            Console.Write("\nPress any key to exit");
            Console.ReadKey();
        }

        public static void formula(){
            if (pay > balance) {
                Console.WriteLine("INVALID AMOUNT");
                return;
            }

            if(pay < 0) {
                Console.WriteLine("INVALID PAYMENT");
                return;
            }

            Double total = down - pay;
            balance = balance - pay;

            Console.WriteLine("DOWNPAYMENT: " + total);

            // MONTHLY EXAM
            if (total <= 0) {
                total = monthly + total;
                if (total <= 0) Console.WriteLine("MONTHLY EXAM: 0.00 - PERMIT");
                else if (total > 0) Console.WriteLine("MONTHLY EXAM: " + total + " NO PERMIT");
            } else Console.WriteLine("MONTHLY EXAM: " + monthly + " NO PERMIT");

            // FIRST PRELIM EXAM
            if (total <= 0) {
                total = FirstPre + total;
                if (total <= 0) Console.WriteLine("FIRST PRELIM EXAM: 0.00 - PERMIT");
                else if (total > 0) Console.WriteLine("FIRST PRELIM EXAM: " + total + " NO PERMIT");
            } else Console.WriteLine("FIRST PRELIM " + FirstPre + " NO PERMIT");


            // SECOND PRELIM EXAM
            if (total <= 0) {
                total = SecondPre + total;
                if (total <= 0)  Console.WriteLine("SECOND PRELIM EXAM: 0.00 - PERMIT");
                else if (total > 0) Console.WriteLine("SECOND PRELIM EXAM: " + total + " NO PERMIT");
            } else Console.WriteLine("SECOND PRELIM " + SecondPre + " NO PERMIT");


            // MIDTERM EXAM
            if (total <= 0) {
                total = Midterm + total;
                if (total <= 0)  Console.WriteLine("MIDTERM EXAM: 0.00 - PERMIT");
                else if (total > 0) Console.WriteLine("MIDTERM EXAM: " + total + " NO PERMIT");
            } else Console.WriteLine("MIDTERM PRELIM " + Midterm + " NO PERMIT");


            // PREFINAL EXAM
            if (total <= 0) {
                total = PreFinal + total;
                if (total <= 0)  Console.WriteLine("PREFINALS EXAM: 0.00 - PERMIT");
                else if (total > 0) Console.WriteLine("PREFINALS EXAM: " + total + " NO PERMIT");
            } else Console.WriteLine("PREFINALS PRELIM " + PreFinal + " NO PERMIT");

            // FINAL EXAM
            if (total <= 0) {
                total = Final + total;
                if (total <= 0) Console.WriteLine("FINALS EXAM: 0.00 - PERMIT");
                else if (total > 0) Console.WriteLine("FINALS EXAM: " + total + " NO PERMIT");
            } else Console.WriteLine("FINALS PRELIM " + Final + " NO PERMIT");

            Console.WriteLine("TOTAL BALANCE = " + balance);

            if (balance <= 0) {
                Console.WriteLine("REMARKS: FULLY PAID");
            } else {
                Console.WriteLine("REMARKS: WITH BALANCE");
                Console.WriteLine("DO YOU WANT TO REFUND IT?");
                String yesno = Convert.ToString(Console.ReadLine());

                yesno = yesno.ToLower();
                if (yesno == "y" || yesno == "yes") {
                    Console.WriteLine("REFUNDED BALANCE: " + balance);
                    balance = 0;
                } else Console.WriteLine("REMARKS: NO REFUND");

                Console.WriteLine("HAVE A NICE DAY!!!!!!!!");
            }
        }
        private static Boolean question()
        {
            Console.Write("Do you want to try again? ");
            String yesno = Convert.ToString(Console.ReadLine());

            yesno = yesno.ToLower();
            return yesno == "y" || yesno == "yes";
        }
    }

}