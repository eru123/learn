Module VBModule
    Sub Main()
        Console.Clear()
        While true
            ' show the menu
            Console.WriteLine("=====================================")
            Console.WriteLine("           Converter App")
            Console.WriteLine("=====================================")
            Console.WriteLine("Choose what to convert...")
            Console.WriteLine("    1 = Money")
            Console.WriteLine("    2 = Measurement")

            ' get the user's choice
            Dim choice As Integer = GetInt("Enter your conversion: ")
            
            Select Case choice
                Case 1
                    ConvertMoney()
                Case 2
                    ConvertMeasurement()
                Case Else
                    Console.WriteLine("=====================================")
                    Console.WriteLine("Invalid Input! Try again")
            End Select
        End While
    End Sub
    Public Function GetInt(ByVal msg as String)
        Dim i as Integer
        Dim valid As Boolean = False
        Console.Write(msg)

        While Not valid
            Try
                i = Console.ReadLine()
                valid = True
            Catch ex As Exception
                Console.Write("Invalid Input." & msg)
            End Try
        End While
        return i
    End Function
    Public Function GetDouble(ByVal msg as String)
        Dim d as Double
        Dim valid As Boolean = False
        Console.Write(msg)

        While Not valid
            Try
                d = Console.ReadLine()
                valid = True
            Catch ex As Exception
                Console.Write("Invalid Input." & msg)
            End Try
        End While
        return d
    End Function
    Sub ConvertMoney()
        Dim isValidCurrency As Boolean = False
        While Not isValidCurrency
            Console.WriteLine("=====================================")
            Console.WriteLine("You chose Money")
            Console.WriteLine("Choose what curency...")
            Console.WriteLine("    1 = USD to PHP")
            Console.WriteLine("    2 = HKD to PHP")

            ' get the user's choice with error handling
            Dim choice2 As Integer = GetInt("Enter your conversion: ")

            If choice2 = 1 Then
                isValidCurrency = True
                Console.WriteLine("=====================================")
                Console.WriteLine("You chose USD to PHP")
                Dim usd As Double = GetDouble("Enter a value: ")
                Console.WriteLine("The converted value is: " & usd * 50)
                Console.WriteLine("=====================================")
            Else If choice2 = 2 Then
                isValidCurrency = True
                Console.WriteLine("=====================================")
                Console.WriteLine("You chose HKD to PHP")
                Dim hkd As Double = GetDouble("Enter a value: ")
                Console.WriteLine("The converted value is: " & hkd * 6.48)
                Console.WriteLine("=====================================")
            Else
                Console.WriteLine("=====================================")
                Console.WriteLine("Invalid Input! Try again")
            End If
        End While
    End Sub
    Sub ConvertMeasurement()
        Dim isValidMeasurement As Boolean = False
        While Not isValidMeasurement
            Console.WriteLine("=====================================")
            Console.WriteLine("You chose Measurement")
            Console.WriteLine("Choose what measurement...")
            Console.WriteLine("    1 = Centimeter to Inches")
            Console.WriteLine("    2 = Inches to Centimeter")

            ' get the user's choice with error handling
            Dim choice3 As Integer = GetInt("Enter your conversion: ")

            If choice3 = 1 Then
                isValidMeasurement = True
                Console.WriteLine("=====================================")
                Console.WriteLine("You chose Centimeter to Inches")
                Dim cm As Double = GetDouble("Enter a value: ")
                Console.WriteLine("The converted value is: " & cm / 2.54)
                Console.WriteLine("=====================================")
            Else If choice3 = 2 Then
                isValidMeasurement = True
                Console.WriteLine("=====================================")
                Console.WriteLine("You chose Inches to Centimeter")
                Dim inches As Double = GetDouble("Enter a value: ")
                Console.WriteLine("The converted value is: " & inches * 2.54)
                Console.WriteLine("=====================================")
            Else
                Console.WriteLine("=====================================")
                Console.WriteLine("Invalid Input! Try again")
            End If
        End While
    End Sub
End Module  