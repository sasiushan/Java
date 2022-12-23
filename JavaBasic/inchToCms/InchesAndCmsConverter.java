import java.util.*;
public class InchesAndCmsConverter
{
        public static void main(String[] args)
        {
                double inches,cms;
                Scanner sc = new Scanner(System.in);
                System.out.println(" Enter a choice: (I)nches OR (C)entimeters? ");

                char choice;
                choice = sc.next().charAt(0);
                if (choice == 'I')
                {
                        System.out.println(" Enter Inches to convert to cms: ");
                        inches = sc.nextInt();
                        cms =convertInchesToCms(inches);

                        System.out.println(" cm are: " + cms );
                }
                else if (choice == 'C')
                {
                        System.out.println( "Enter Cms to convert to Inches: ");
                        cms = sc.nextInt();
                        inches = convertCmsToInches(cms);

                        System.out.println(" Inches are: " + inches );
                }
                sc.close();
        }
        private static double convertInchesToCms(double inch)
        {

                double cms = inch * 2.45;
                return cms;
        }
        private static double convertCmsToInches(double cm)
        {
                double inches = cm / 2.45;
                return inches;
        }
}









