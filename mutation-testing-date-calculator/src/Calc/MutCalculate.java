package Calc;

public class MutCalculate {

    // ==========================
    // Código original
    // ==========================
    public int cal(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1) // mismo mes
            numDays = day2 - day1;
        else {
            int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int m4 = year % 4;
            int m100 = year % 100;
            int m400 = year % 400;

            if ((m4 != 0) || ((m100 == 0) && (m400 != 0)))
                daysIn[2] = 28;
            else
                daysIn[2] = 29;

            numDays = day2 + (daysIn[month1] - day1);

            for (int i = month1 + 1; i <= month2 - 1; i++)
                numDays = daysIn[i] + numDays;
        }

        return numDays;
    }

    // ==========================
    // Mutante 1 (Mt1): if (month2 == month1) -> if (month2 > month1)
    // ==========================
    public int calMt1(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 > month1) // mutante 1
            numDays = day2 - day1;
        else
            numDays = cal(month1, day1, month2, day2, year);

        return numDays;
    }

    // ==========================
    // Mutante 2 (Mt2): numDays = day2 - day1 -> numDays = day1 - day2
    // ==========================
    public int calMt2(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day1 - day2; // mutante 2
        else
            numDays = cal(month1, day1, month2, day2, year);

        return numDays;
    }

    // ==========================
    // Mutante 3 (Mt3): Cambia días por mes en el arreglo
    // ==========================
    public int calMt3(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day2 - day1;
        else {
            // mutante 3: arreglo modificado
            int daysIn[] = {0, 30, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int m4 = year % 4;
            int m100 = year % 100;
            int m400 = year % 400;

            if ((m4 != 0) || ((m100 == 0) && (m400 != 0)))
                daysIn[2] = 28;
            else
                daysIn[2] = 29;

            numDays = day2 + (daysIn[month1] - day1);

            for (int i = month1 + 1; i <= month2 - 1; i++)
                numDays = daysIn[i] + numDays;
        }

        return numDays;
    }

    // ==========================
    // Mutante 4 (Mt4): m4 = year % 4 -> m4 = year / 4
    // ==========================
    public int calMt4(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day2 - day1;
        else {
            int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int m4 = year / 4; // mutante 4
            int m100 = year % 100;
            int m400 = year % 400;

            if ((m4 != 0) || ((m100 == 0) && (m400 != 0)))
                daysIn[2] = 28;
            else
                daysIn[2] = 29;

            numDays = day2 + (daysIn[month1] - day1);

            for (int i = month1 + 1; i <= month2 - 1; i++)
                numDays = daysIn[i] + numDays;
        }

        return numDays;
    }

    // ==========================
    // Mutante 5 (Mt5): Cambia || por && en condición bisiesto
    // ==========================
    public int calMt5(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day2 - day1;
        else {
            int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int m4 = year % 4;
            int m100 = year % 100;
            int m400 = year % 400;

            if ((m4 != 0) && ((m100 == 0) && (m400 != 0))) // mutante 5
                daysIn[2] = 28;
            else
                daysIn[2] = 29;

            numDays = day2 + (daysIn[month1] - day1);

            for (int i = month1 + 1; i <= month2 - 1; i++)
                numDays = daysIn[i] + numDays;
        }

        return numDays;
    }

    // ==========================
    // Mutante 6 (Mt6): Cambia condición bisiesto !=0 -> ==0
    // ==========================
    public int calMt6(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day2 - day1;
        else {
            int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int m4 = year % 4;
            int m100 = year % 100;
            int m400 = year % 400;

            if ((m4 == 0) || ((m100 == 0) && (m400 != 0))) // mutante 6
                daysIn[2] = 28;
            else
                daysIn[2] = 29;

            numDays = day2 + (daysIn[month1] - day1);

            for (int i = month1 + 1; i <= month2 - 1; i++)
                numDays = daysIn[i] + numDays;
        }

        return numDays;
    }

    // ==========================
    // Mutante 7 (Mt7): daysIn[2] = 28 -> 29
    // ==========================
    public int calMt7(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day2 - day1;
        else {
            int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int m4 = year % 4;
            int m100 = year % 100;
            int m400 = year % 400;

            daysIn[2] = 29; // mutante 7

            numDays = day2 + (daysIn[month1] - day1);

            for (int i = month1 + 1; i <= month2 - 1; i++)
                numDays = daysIn[i] + numDays;
        }

        return numDays;
    }

    // ==========================
    // Mutante 8 (Mt8): numDays = day2 + (daysIn[month1] - day1) -> daysIn[month2]
    // ==========================
    public int calMt8(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day2 - day1;
        else {
            int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int m4 = year % 4;
            int m100 = year % 100;
            int m400 = year % 400;

            if ((m4 != 0) || ((m100 == 0) && (m400 != 0)))
                daysIn[2] = 28;
            else
                daysIn[2] = 29;

            numDays = day2 + (daysIn[month2] - day1); // mutante 8

            for (int i = month1 + 1; i <= month2 - 1; i++)
                numDays = daysIn[i] + numDays;
        }

        return numDays;
    }

    // ==========================
    // Mutante 9 (Mt9): for (i = month1 +1; ...) -> i = month1
    // ==========================
    public int calMt9(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day2 - day1;
        else {
            int daysIn[] = {0,31,0,31,30,31,30,31,31,30,31,30,31};

            int m4 = year %4;
            int m100 = year %100;
            int m400 = year %400;

            if ((m4 !=0) || ((m100==0)&&(m400!=0)))
                daysIn[2] =28;
            else
                daysIn[2] =29;

            numDays = day2 + (daysIn[month1] - day1);

            for (int i = month1; i <= month2 - 1; i++) // mutante 9
                numDays = daysIn[i] + numDays;
        }

        return numDays;
    }

    // ==========================
    // Mutante 10 (Mt10): for (i = month1 +1; ... month2 -1) -> month2 +1
    // ==========================
    public int calMt10(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day2 - day1;
        else {
            int daysIn[] = {0,31,0,31,30,31,30,31,31,30,31,30,31};

            int m4 = year %4;
            int m100 = year %100;
            int m400 = year %400;

            if ((m4 !=0) || ((m100==0)&&(m400!=0)))
                daysIn[2] =28;
            else
                daysIn[2] =29;

            numDays = day2 + (daysIn[month1] - day1);

            for (int i = month1 +1; i <= month2 +1; i++) // mutante 10
                numDays = daysIn[i] + numDays;
        }

        return numDays;
    }

    // ==========================
    // Mutante 11 (Mt11): numDays = daysIn[i] + numDays -> daysIn[i-1] + numDays
    // ==========================
    public int calMt11(int month1, int day1, int month2, int day2, int year) {
        int numDays;

        if (month2 == month1)
            numDays = day2 - day1;
        else {
            int daysIn[] = {0,31,0,31,30,31,30,31,31,30,31,30,31};

            int m4 = year %4;
            int m100 = year %100;
            int m400 = year %400;

            if ((m4 !=0) || ((m100==0)&&(m400!=0)))
                daysIn[2] =28;
            else
                daysIn[2] =29;

            numDays = day2 + (daysIn[month1] - day1);

            for (int i = month1 +1; i <= month2 -1; i++)
                numDays = daysIn[i-1] + numDays; // mutante 11
        }

        return numDays;
    }
}
