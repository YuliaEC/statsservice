
public class StatsService {

    //сумма всех продаж
    public int SumSales(int[] sales) {
        int sum = 0; //начальная сумма продаж
        for (int i = 0; i < sales.length; i++) {
            sum = sum + sales[i]; //начальная сумма продаж плюсуется с каждым значением из массива
        }
        return sum; //итоговая сумма продаж
    }

    //средняя сумма продаж в месяц
    public int averageAmount(int[] sales) {
        int result = SumSales(sales) / sales.length; //сумма всех продаж(из метода 1), поделенная на количество
        return result; //средняя сумма продаж
    }

    //номер месяца, в котором был пик продаж, то есть осуществлены продажи на максимальную сумму
    public int maxSales(int[] sales) {
        int maxMonth = 0; //номер месяца с максимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) { // значит, в рассматриваемом i-м месяце продаж больше
                maxMonth = i; // запомним его как максимальный
            }
        }
        return maxMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    //номер месяца, в котором был минимум продаж, то есть осуществлены продажи на минимальную сумму
    public int minSales(int[] sales) {
        int minMonth = 0; //номер месяца с минимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // значит, в рассматриваемом i-м месяце продаж меньше
                minMonth = i; // запомним его как минимальный
            }
        }
        return minMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    // количество месяцев, в которых продажи были ниже среднего
    public int countMonthMin(int[] sales) {
        int average = averageAmount(sales); //средняя сумма продаж
        int countMonth = 0; //количество  месяцев


        for (int i = 0; i < sales.length; i++) {
            if (sales[i] < average) { //продажи от каждого числа в массиве меньше среднего
                countMonth++; //количество месяцев
            }
        }
        return countMonth;
    }

    //количество месяцев, в которых продажи были выше среднего
    public int countMonthMax(int[] sales) {
        int average = averageAmount(sales); //средняя сумма продаж
        int countMonth = 0; //количество  месяцев

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > average) { //продажи от каждого числа в массиве меньше среднего
                countMonth++; //количество месяцев
            }
        }
        return countMonth;
    }
}
