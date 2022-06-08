import java.util.Scanner;



class work_text{
    void run(String[] text_split, String char_key) {
        for(int i = 0; i < text_split.length; i++){
            int l_index = 0;
            int count = 0;

            int f1_index = text_split[i].indexOf(char_key, l_index);
            int f2_index = text_split[i].indexOf(char_key, f1_index + char_key.length());

            int[][] mas_index = new int[text_split[i].length()/char_key.length()][2];


            while (f1_index != -1 && f2_index != -1){
                mas_index[count][0] = f1_index;
                mas_index[count][1] = f2_index - f1_index;

                l_index = f2_index + char_key.length();

                f1_index = text_split[i].indexOf(char_key, l_index);
                f2_index = text_split[i].indexOf(char_key, char_key.length() + f1_index);
                count += 1;
            }

            if (count > 0){
                int max_len = 0;
                int max_len_id = 0;

                for(int b = 0; b < count; b++){
                    if (max_len < mas_index[b][1]) {
                        max_len = mas_index[b][1];
                        max_len_id = mas_index[b][0];
                    }
                }
                text_split[i] = text_split[i].substring(0, max_len_id) + text_split[i].substring(max_len_id + max_len + char_key.length());
            }
            System.out.print(text_split[i] + ".");
        }
    }

}



public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        work_text wtxt = new work_text();

        System.out.println(" ");
        System.out.println("С3 = " + 1115 % 3);
        System.out.println("С17 = " + 1115 % 17);

        System.out.println(" \nТип текстових змінних - String");
        System.out.println("Дія з рядком - З кожного речення заданого тексту видалити підрядок найбільшої довжини, що починається та закінчується заданими літерами.\n ");

        System.out.print("Введіть текст: ");
        String text = scan.nextLine();

        if (text.isEmpty()){
            System.out.print("Помилка ! Текст не може бути порожнім");
            System.exit(0);
        }

        System.out.print("Введіть літери для пошуку підрядка: ");
        String char_key = scan.nextLine();

        if (char_key.isEmpty()){
            System.out.print("Помилка ! Некоректно введені літери для пошуку підрядка");
            System.exit(0);
        }

        System.out.print("\n _ Редагований текст _\n");

        String[] text_split = text.split("\\.");

        wtxt.run(text_split, char_key);



    }
}
